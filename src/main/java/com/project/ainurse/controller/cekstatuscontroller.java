package com.project.ainurse.controller;

import com.project.ainurse.utils.pagemanager;
import com.project.ainurse.dao.daopasien;
import com.project.ainurse.model.Pasien;


import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class cekstatuscontroller {

    @FXML private TextField txtCari;
    @FXML private Label lblHasil;
    @FXML private Button btnPdf;

    private daopasien pasienDAO = new daopasien();
    private Pasien pasienDitemukan = null;


    private String tipsUntukPdf = "";

    @FXML
    public void cariStatus(ActionEvent event) {
        String keyword = txtCari.getText().trim();
        if (keyword.isEmpty()) {
            lblHasil.setStyle("-fx-text-fill: #c0392b;");
            lblHasil.setText("⚠️ Silakan ketik Nama Lengkap atau Nomor RM terlebih dahulu.");
            btnPdf.setVisible(false);
            return;
        }

        pasienDitemukan = pasienDAO.cariDataPasien(keyword);

        if (pasienDitemukan != null) {
            String triase = pasienDitemukan.getHasilTriase().toUpperCase();
            String warnaTriase;


            if (triase.contains("MERAH")) {
                warnaTriase = "-fx-text-fill: #B71C1C;";
                tipsUntukPdf = "🚨 TINDAKAN DARURAT:\nMohon segera melapor ke perawat IGD fisik terdekat. Pastikan Anda tetap berada di area terbuka dengan sirkulasi udara baik dan hindari kerumunan.";
            } else if (triase.contains("KUNING")) {
                warnaTriase = "-fx-text-fill: #E65100;";
                tipsUntukPdf = "⏳ PANDUAN OBSERVASI:\nSilakan duduk di ruang tunggu observasi/isolasi. Wajib menggunakan masker medis yang benar dan perbanyak minum air putih hangat sambil menunggu giliran.";
            } else {
                warnaTriase = "-fx-text-fill: #1B5E20;";
                tipsUntukPdf = "✅ SARAN KESEHATAN:\nKondisi Anda terpantau stabil. Silakan bersantai di ruang tunggu antrean reguler. Tetap patuhi protokol kesehatan dan gunakan hand-sanitizer.";
            }

            String teksTampil = "";
            if (pasienDitemukan.getStatusPasien().equals("Menunggu Antrean")) {
                int antreanDiDepan = pasienDAO.hitungAntreanDiDepan(pasienDitemukan.getId());
                int estimasi = antreanDiDepan * 15;
                teksTampil = "👤 Pasien: " + pasienDitemukan.getNama() + " (" + pasienDitemukan.getNoRm() + ")\n\n" +
                        "STATUS: MENUNGGU ANTREAN\nTerdapat " + antreanDiDepan + " pasien di depan Anda.\nEstimasi waktu tunggu: " + estimasi + " Menit.\n\n" +
                        "Hasil Rekomendasi AI:\n" + pasienDitemukan.getHasilTriase() + "\n\n" + tipsUntukPdf;
            } else if (pasienDitemukan.getStatusPasien().equals("Sedang Ditangani")) {
                teksTampil = "👤 Pasien: " + pasienDitemukan.getNama() + " (" + pasienDitemukan.getNoRm() + ")\n\n" +
                        "🟢 STATUS: SEDANG DITANGANI\nAnda saat ini sedang berada di dalam ruang pemeriksaan.";
            } else {
                teksTampil = "👤 Pasien: " + pasienDitemukan.getNama() + " (" + pasienDitemukan.getNoRm() + ")\n\n" +
                        "✅ STATUS: SELESAI DIPERIKSA\nPemeriksaan Anda telah selesai. Silakan menuju LOKET APOTEK.";
            }

            lblHasil.setStyle(warnaTriase);
            lblHasil.setText(teksTampil);
            btnPdf.setVisible(true);
        } else {
            lblHasil.setStyle("-fx-text-fill: #c0392b;");
            lblHasil.setText("❌ Data pasien tidak ditemukan. Pastikan Nama/RM benar.");
            btnPdf.setVisible(false);
        }
    }



    @FXML
    public void cetakPDF(ActionEvent event) {
        if (pasienDitemukan == null) return;


        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String namaFile = "Triase_" + pasienDitemukan.getNoRm() + "_" + timeStamp + ".pdf";




        String namaFolder = "D:\\FILE PACARKU\\Project AI Nurse\\APK JAVA\\pdfpasien";
        File direktori = new File(namaFolder);


        if (!direktori.exists()) {
            direktori.mkdirs();
        }


        String pathLengkap = namaFolder + "/" + namaFile;


        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pathLengkap));
            document.open();


            Font fontJudul = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font fontIsi = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Font fontSubJudul = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);


            Paragraph judul = new Paragraph("RINGKASAN REKAM MEDIS & TRIASE MANDIRI", fontJudul);
            judul.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(judul);
            document.add(new Paragraph("\n"));


            document.add(new Paragraph("Nomor Rekam Medis : " + pasienDitemukan.getNoRm(), fontIsi));
            document.add(new Paragraph("Nama Lengkap      : " + pasienDitemukan.getNama(), fontIsi));
            document.add(new Paragraph("Usia Pasien       : " + pasienDitemukan.getUsia() + " Tahun", fontIsi));
            document.add(new Paragraph("Status Layanan    : " + pasienDitemukan.getStatusPasien(), fontIsi));
            document.add(new Paragraph("\n"));


            document.add(new Paragraph("Keluhan Pasien:", fontSubJudul));
            document.add(new Paragraph(pasienDitemukan.getKeluhan(), fontIsi));
            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Hasil Klasifikasi Triase AI:", fontSubJudul));
            document.add(new Paragraph(pasienDitemukan.getHasilTriase(), fontIsi));
            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Panduan Tindakan & Tips:", fontSubJudul));
            document.add(new Paragraph(tipsUntukPdf, fontIsi));

            document.close();




            javafx.scene.control.Label toast = new javafx.scene.control.Label("✅ PDF Berhasil Dicetak & Disimpan!");

            toast.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-padding: 12px 25px; " +
                    "-fx-background-radius: 25px; -fx-font-size: 14px; -fx-font-weight: bold; " +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 5);");


            javafx.scene.layout.StackPane root = (javafx.scene.layout.StackPane) btnPdf.getScene().getRoot();
            javafx.scene.layout.StackPane.setAlignment(toast, javafx.geometry.Pos.BOTTOM_CENTER);
            javafx.scene.layout.StackPane.setMargin(toast, new javafx.geometry.Insets(0, 0, 40, 0));
            root.getChildren().add(toast);


            javafx.animation.FadeTransition fade = new javafx.animation.FadeTransition(javafx.util.Duration.seconds(1.5), toast);
            fade.setDelay(javafx.util.Duration.seconds(2));
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            fade.setOnFinished(e -> root.getChildren().remove(toast));
            fade.play();

        } catch (Exception e) {




            javafx.scene.control.Label toastErr = new javafx.scene.control.Label("❌ Gagal mencetak PDF: " + e.getMessage());
            toastErr.setStyle("-fx-background-color: #c0392b; -fx-text-fill: white; -fx-padding: 12px 25px; " +
                    "-fx-background-radius: 25px; -fx-font-size: 14px; -fx-font-weight: bold; " +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 5);");

            javafx.scene.layout.StackPane root = (javafx.scene.layout.StackPane) btnPdf.getScene().getRoot();
            javafx.scene.layout.StackPane.setAlignment(toastErr, javafx.geometry.Pos.BOTTOM_CENTER);
            javafx.scene.layout.StackPane.setMargin(toastErr, new javafx.geometry.Insets(0, 0, 40, 0));
            root.getChildren().add(toastErr);

            javafx.animation.FadeTransition fade = new javafx.animation.FadeTransition(javafx.util.Duration.seconds(1.5), toastErr);
            fade.setDelay(javafx.util.Duration.seconds(3));
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            fade.setOnFinished(ev -> root.getChildren().remove(toastErr));
            fade.play();

            e.printStackTrace();
        }
    }

    @FXML
    public void kembali(ActionEvent event) {
        pagemanager.pindahHalaman("PortalPasien.fxml");
    }
}
