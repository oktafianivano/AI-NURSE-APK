package com.project.ainurse.controller;

import com.project.ainurse.dao.daopasien;
import com.project.ainurse.model.Pasien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;

public class dashboardperawatcontroller {

    @FXML private TableView<Pasien> tabelPasien;
    @FXML private TableColumn<Pasien, String> colRm;
    @FXML private TableColumn<Pasien, String> colNama;
    @FXML private TableColumn<Pasien, Integer> colUsia;
    @FXML private TableColumn<Pasien, Double> colSuhu;
    @FXML private TableColumn<Pasien, String> colKeluhan;
    @FXML private TableColumn<Pasien, String> colTriase;
    @FXML private TableColumn<Pasien, String> colStatus;

    @FXML private Label lblCountMenunggu;
    @FXML private Label lblCountDitangani;
    @FXML private Label lblCountGawat;
    @FXML private Label lblNamaPerawat;

    @FXML private ComboBox<String> cbStatusUpdate;
    @FXML private Label lblNotifSukses;

    @FXML private TextField txtNamaBaru;
    @FXML private TextField txtUsiaBaru;
    @FXML private TextField txtSuhuBaru;
    @FXML private TextField txtKeluhanBaru;

    @FXML private VBox kontenUtama;

    private ObservableList<Pasien> daftarPasien;

    @FXML
    public void initialize() {
        FadeTransition fade = new FadeTransition(Duration.millis(800), kontenUtama);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);

        TranslateTransition move = new TranslateTransition(Duration.millis(800), kontenUtama);
        move.setFromY(40);
        move.setToY(0);

        ParallelTransition entranceAnimation = new ParallelTransition(fade, move);
        entranceAnimation.play();

        lblNamaPerawat.setText("👤 " + com.project.ainurse.utils.UserSession.getNamaLengkap());
        colRm.setCellValueFactory(new PropertyValueFactory<>("noRm"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colUsia.setCellValueFactory(new PropertyValueFactory<>("usia"));
        colSuhu.setCellValueFactory(new PropertyValueFactory<>("suhu"));
        colKeluhan.setCellValueFactory(new PropertyValueFactory<>("keluhan"));
        colTriase.setCellValueFactory(new PropertyValueFactory<>("hasilTriase"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("statusPasien"));

        cbStatusUpdate.setItems(FXCollections.observableArrayList(
                "Sedang Ditangani",
                "Perlu Askep"
        ));

        tabelPasien.setRowFactory(tv -> new TableRow<Pasien>() {
            @Override
            protected void updateItem(Pasien item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setStyle("");
                } else {
                    String triase = item.getHasilTriase().toUpperCase();
                    if (triase.contains("MERAH")) {
                        setStyle("-fx-background-color: #ffcdd2;");
                    } else if (triase.contains("KUNING")) {
                        setStyle("-fx-background-color: #fff9c4;");
                    } else if (triase.contains("HIJAU")) {
                        setStyle("-fx-background-color: #c8e6c9;");
                    } else {
                        setStyle("");
                    }
                }
            }
        });

        muatData(null);
    }

    @FXML
    public void muatData(ActionEvent event) {
        ObservableList<Pasien> semuaData = daopasien.getAllPasien();
        daftarPasien = FXCollections.observableArrayList();

        int antrean = 0;
        int ditangani = 0;
        int darurat = 0;

        for (Pasien p : semuaData) {
            String status = p.getStatusPasien();
            String triase = p.getHasilTriase() != null ? p.getHasilTriase().toUpperCase() : "";

            if (status.equalsIgnoreCase("Menunggu Antrean") || status.equalsIgnoreCase("Sedang Ditangani")) {
                daftarPasien.add(p);

                if (status.equalsIgnoreCase("Menunggu Antrean")) antrean++;
                if (status.equalsIgnoreCase("Sedang Ditangani")) ditangani++;
                if (triase.contains("MERAH")) darurat++;
            }
        }

        daftarPasien.sort((p1, p2) -> {
            int skor1 = skorPrioritas(p1.getHasilTriase());
            int skor2 = skorPrioritas(p2.getHasilTriase());
            return Integer.compare(skor1, skor2);
        });

        tabelPasien.setItems(daftarPasien);

        lblCountMenunggu.setText(String.valueOf(antrean));
        lblCountDitangani.setText(String.valueOf(ditangani));
        lblCountGawat.setText(String.valueOf(darurat));
    }

    private int skorPrioritas(String triase) {
        if (triase == null) return 4;
        String t = triase.toUpperCase();
        if (t.contains("MERAH")) return 1;
        if (t.contains("KUNING")) return 2;
        if (t.contains("HIJAU")) return 3;
        return 4;
    }

    @FXML
    public void prosesUpdateStatus(ActionEvent event) {
        Pasien pasienTerpilih = tabelPasien.getSelectionModel().getSelectedItem();
        String statusBaru = cbStatusUpdate.getValue();

        if (pasienTerpilih == null || statusBaru == null) {
            tampilkanAlertSOP("Data Belum Lengkap", "Pilih nama pasien di tabel dan pilih status barunya terlebih dahulu!");
            return;
        }

        String statusLama = pasienTerpilih.getStatusPasien();

        if (statusLama.equalsIgnoreCase("Menunggu Antrean") && !statusBaru.equalsIgnoreCase("Sedang Ditangani")) {
            tampilkanAlertSOP("🚨 PELANGGARAN SOP!", "Pasien masih 'Menunggu Antrean'.\nWajib diubah ke 'Sedang Ditangani' dahulu sebelum bisa masuk ke tahap Askep!");
            return;
        }

        if (statusLama.equalsIgnoreCase("Sedang Ditangani") && !statusBaru.equalsIgnoreCase("Perlu Askep")) {
            tampilkanAlertSOP("🚨 PELANGGARAN SOP!", "Pasien yang sedang ditangani hanya boleh dipindah ke tahap 'Perlu Askep'!");
            return;
        }

        boolean sukses = daopasien.updateStatusPasien(pasienTerpilih.getNoRm(), statusBaru);

        if (sukses) {
            String namaPerawat = com.project.ainurse.utils.UserSession.getNamaLengkap();
            String detailAksi = "Mengubah status pasien " + pasienTerpilih.getNama() + " menjadi " + statusBaru;
            daopasien.catatAuditLog(namaPerawat, pasienTerpilih.getNoRm(), detailAksi);

            lblNotifSukses.setText("SOP Berhasil Diupdate!");
            lblNotifSukses.setVisible(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e -> lblNotifSukses.setVisible(false));
            pause.play();

            muatData(null);
        }
    }

    private void tampilkanAlertSOP(String judul, String pesan) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Sistem Keamanan AI-NURSE");
        alert.setHeaderText(judul);
        alert.setContentText(pesan);
        alert.showAndWait();
    }

    @FXML
    public void tambahPasienBaru(ActionEvent event) {
        String nama = txtNamaBaru.getText();
        String usiaStr = txtUsiaBaru.getText();
        String suhuStr = txtSuhuBaru.getText();
        String keluhan = txtKeluhanBaru.getText();

        if (nama.isEmpty() || usiaStr.isEmpty() || suhuStr.isEmpty() || keluhan.isEmpty()) {
            System.out.println("GAGAL: Harap isi semua data pendaftaran!");
            return;
        }

        try {
            int usia = Integer.parseInt(usiaStr);
            double suhu = Double.parseDouble(suhuStr);
            String noRm = "RM-" + (int)(Math.random() * 9000 + 1000);

            System.out.println("AI sedang menganalisis gejala...");

            String promptAI = "Kamu adalah sistem triase IGD. Pasien usia " + usia + " tahun, suhu badan " + suhu +
                    " C. Keluhan: " + keluhan + ". Tentukan apakah ini KODE MERAH (Darurat), KODE KUNING (Mendesak), atau KODE HIJAU (Tidak Mendesak). " +
                    "Balas dengan format: KODE [WARNA] - [Analisis Singkat].";

            String hasilTriase = com.project.ainurse.utils.geminiservice.tanyaAI(promptAI);

            Pasien pBaru = new Pasien(noRm, nama, usia, suhu, keluhan, hasilTriase, "Menunggu Antrean");
            boolean sukses = daopasien.insertPasien(pBaru);

            if (sukses) {
                String namaPerawat = com.project.ainurse.utils.UserSession.getNamaLengkap();
                String detailAksi = "Mendaftarkan pasien baru: " + nama + " (Triase: " + hasilTriase.substring(0, Math.min(hasilTriase.length(), 20)) + "...)";
                daopasien.catatAuditLog(namaPerawat, noRm, detailAksi);

                txtNamaBaru.clear();
                txtUsiaBaru.clear();
                txtSuhuBaru.clear();
                txtKeluhanBaru.clear();
                muatData(null);
                System.out.println("SUKSES: Pasien " + nama + " berhasil dianalisis AI dan didaftarkan!");
            }
        } catch (NumberFormatException e) {
            System.out.println("GAGAL: Usia dan Suhu wajib diisi dengan angka!");
        } catch (Exception e) {
            System.out.println("Gagal memanggil AI: " + e.getMessage());
        }
    }
}
