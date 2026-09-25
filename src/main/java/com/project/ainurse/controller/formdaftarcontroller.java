package com.project.ainurse.controller;

import com.project.ainurse.dao.daopasien;
import com.project.ainurse.model.Pasien;
import com.project.ainurse.utils.geminiservice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Random;

public class formdaftarcontroller {

    @FXML private TextField txtNama;
    @FXML private TextField txtUsia;
    @FXML private TextArea txtKeluhan;
    @FXML private Label lblNotif;

    private daopasien pasienDAO = new daopasien();

    @FXML
    public void prosesDaftar(ActionEvent event) {
        String nama = txtNama.getText();
        String usiaStr = txtUsia.getText();
        String keluhan = txtKeluhan.getText();

        if (nama.isEmpty() || usiaStr.isEmpty() || keluhan.isEmpty()) {
            lblNotif.setStyle("-fx-text-fill: red;");
            lblNotif.setText("⚠️ Lengkapi semua kolom!");
            return;
        }

        try {
            int usia = Integer.parseInt(usiaStr);


            Random rand = new Random();
            String noRm = "RM-" + (1000 + rand.nextInt(9000));


            lblNotif.setStyle("-fx-text-fill: #f39c12;");
            lblNotif.setText("⏳ AI sedang menganalisis tingkat keparahan...");


            String jawabanAI = geminiservice.tanyaAI(keluhan);


            String hasilTriaseAIAkhir = "KODE HIJAU (Tidak Mendesak)";

            if (jawabanAI.contains("Error API") || jawabanAI.contains("Maaf")) {
                hasilTriaseAIAkhir = "KODE HIJAU (Sistem Error, Menunggu Cek Manual)";
            } else if (jawabanAI.contains("[STATUS: MERAH]")) {
                hasilTriaseAIAkhir = "KODE MERAH (GAWAT DARURAT TERTINGGI!)\nAnalisis: " + jawabanAI.replace("[STATUS: MERAH]", "").trim();
            } else if (jawabanAI.contains("[STATUS: KUNING]")) {
                hasilTriaseAIAkhir = "KODE KUNING (Darurat & Butuh Pantauan)\nAnalisis: " + jawabanAI.replace("[STATUS: KUNING]", "").trim();
            } else {

                hasilTriaseAIAkhir = "KODE HIJAU (Tidak Mendesak)\nAnalisis: " + jawabanAI.replace("[STATUS: HIJAU]", "").trim();
            }

            Pasien pasienBaru = new Pasien(noRm, nama, usia, 0.0, keluhan, hasilTriaseAIAkhir, "Menunggu Antrean");


            boolean sukses = pasienDAO.insertPasienBaru(pasienBaru);

            if (sukses) {
                lblNotif.setStyle("-fx-text-fill: #00cc66; -fx-font-weight: bold;");
                lblNotif.setText("🎉 Berhasil! RM Anda: " + noRm);
                kosongkanForm();
            } else {
                lblNotif.setStyle("-fx-text-fill: red;");
                lblNotif.setText("❌ Gagal menyimpan ke Database!");
            }
        } catch (NumberFormatException e) {
            lblNotif.setStyle("-fx-text-fill: red;");
            lblNotif.setText("⚠️ Usia harus berupa angka!");
        }
    }

    private void kosongkanForm() {
        txtNama.clear();
        txtUsia.clear();
        txtKeluhan.clear();
    }

    @FXML
    public void kembaliKeMenu(ActionEvent event) {
        com.project.ainurse.utils.pagemanager.pindahHalaman("portalpasien.fxml");
    }
}
