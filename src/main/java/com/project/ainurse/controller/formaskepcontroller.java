package com.project.ainurse.controller;

import com.project.ainurse.dao.daopasien;
import com.project.ainurse.model.Pasien;
import com.project.ainurse.utils.UserSession;
import com.project.ainurse.utils.pagemanager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class formaskepcontroller {

    @FXML private Label lblNamaRm;
    @FXML private Label lblKeluhan;
    @FXML private Label lblTriase;

    @FXML private ComboBox<String> cbDiagnosis;
    @FXML private Label lblIntervensiUtama;

    @FXML private CheckBox chkObservasi;
    @FXML private CheckBox chkTerapeutik;
    @FXML private CheckBox chkEdukasi;
    @FXML private CheckBox chkKolaborasi;
    @FXML private TextArea txtEvaluasi;

    private Pasien pasienSekarang;

    @FXML
    public void initialize() {
        pasienSekarang = UserSession.getPasienTerpilih();

        if (pasienSekarang != null) {
            lblNamaRm.setText("Nama: " + pasienSekarang.getNama() + " | No. RM: " + pasienSekarang.getNoRm() + " | Usia: " + pasienSekarang.getUsia() + " Tahun");
            lblKeluhan.setText("Keluhan Utama: " + pasienSekarang.getKeluhan());
            lblTriase.setText("Triase AI: " + pasienSekarang.getHasilTriase());
        }

        cbDiagnosis.setItems(FXCollections.observableArrayList(
                "Hipertermia b.d proses infeksi virus campak",
                "Bersihan Jalan Napas Tidak Efektif b.d penumpukan sekret",
                "Risiko Defisit Nutrisi b.d anoreksia",
                "Gangguan Integritas Kulit/Jaringan b.d ruam kemerahan"
        ));

        cbDiagnosis.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue.contains("Hipertermia")) {
                    lblIntervensiUtama.setText("Manajemen Hipertermia / Infeksi");
                } else if (newValue.contains("Napas")) {
                    lblIntervensiUtama.setText("Manajemen Jalan Napas");
                } else if (newValue.contains("Nutrisi")) {
                    lblIntervensiUtama.setText("Manajemen Nutrisi");
                } else if (newValue.contains("Integritas Kulit")) {
                    lblIntervensiUtama.setText("Perawatan Integritas Kulit");
                }
            }
        });
    }

    @FXML
    public void simpanAskep(ActionEvent event) {
        String diagnosis = cbDiagnosis.getValue();
        String evaluasi = txtEvaluasi.getText();

        if (diagnosis == null || evaluasi.isEmpty()) {
            System.out.println("GAGAL: Diagnosis dan Evaluasi harus diisi!");
            return;
        }

        StringBuilder otekBuilder = new StringBuilder();
        if (chkObservasi.isSelected()) otekBuilder.append("Observasi, ");
        if (chkTerapeutik.isSelected()) otekBuilder.append("Terapeutik, ");
        if (chkEdukasi.isSelected()) otekBuilder.append("Edukasi, ");
        if (chkKolaborasi.isSelected()) otekBuilder.append("Kolaborasi, ");

        String otek = otekBuilder.toString();
        if (otek.endsWith(", ")) {
            otek = otek.substring(0, otek.length() - 2);
        }
        if (otek.isEmpty()) otek = "-";

        String isiLengkap = "SDKI: " + diagnosis + "\n" +
                "SIKI: " + lblIntervensiUtama.getText() + "\n" +
                "OTEK: " + otek + "\n" +
                "EVALUASI: " + evaluasi;

        String namaPerawat = UserSession.getNamaLengkap();

        boolean suksesInsert = daopasien.insertRekamMedis(
                pasienSekarang.getNoRm(),
                namaPerawat,
                isiLengkap
        );

        boolean suksesUpdate = daopasien.updateStatusPasien(pasienSekarang.getNoRm(), "Riwayat Selesai");

        if (suksesInsert && suksesUpdate) {
            String detailAksi = "Menyimpan Asuhan Keperawatan (Askep) untuk pasien: " + pasienSekarang.getNama();
            daopasien.catatAuditLog(namaPerawat, pasienSekarang.getNoRm(), detailAksi);

            tampilkanPopupEstetik("Asuhan Keperawatan Berhasil Disimpan!", true);
        } else {
            tampilkanPopupEstetik("Gagal menyimpan data ke database!", false);
        }
    }

    private void tampilkanPopupEstetik(String pesan, boolean isSukses) {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initStyle(StageStyle.TRANSPARENT);

        VBox box = new VBox(15);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(35, 50, 35, 50));

        box.setStyle("-fx-background-color: white; " +
                "-fx-background-radius: 15; " +
                "-fx-border-radius: 15; " +
                "-fx-border-color: #FCE4EC; " +
                "-fx-border-width: 2; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 20, 0, 0, 5);");

        Label lblIcon = new Label(isSukses ? "✨ ✅ ✨" : "❌");
        lblIcon.setStyle("-fx-font-size: 35px; -fx-text-fill: " + (isSukses ? "#d81b60" : "#c0392b") + ";");

        Label lblPesan = new Label(pesan);
        lblPesan.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        javafx.scene.control.Button btnOk = new javafx.scene.control.Button("Selesai");
        btnOk.setStyle("-fx-background-color: " + (isSukses ? "#d81b60" : "#c0392b") +
                "; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-padding: 8 35 8 35; -fx-cursor: hand;");

        btnOk.setOnAction(e -> {
            popupStage.close();
            if (isSukses) {
                UserSession.setPasienTerpilih(null);
                pagemanager.pindahHalaman("riwayatselesai.fxml");
            }
        });

        box.getChildren().addAll(lblIcon, lblPesan, btnOk);

        Scene scene = new Scene(box);
        scene.setFill(Color.TRANSPARENT);
        popupStage.setScene(scene);

        popupStage.showAndWait();
    }

    @FXML
    public void kembaliKeRiwayat(ActionEvent event) {
        pagemanager.pindahHalaman("antreanaskep.fxml");
    }
}
