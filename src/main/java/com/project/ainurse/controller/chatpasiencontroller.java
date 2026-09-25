package com.project.ainurse.controller;

import com.project.ainurse.utils.geminiservice;
import com.project.ainurse.utils.pagemanager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class chatpasiencontroller {

    @FXML private TextArea txtRiwayatChat;
    @FXML private TextField txtPesan;

    @FXML
    public void initialize() {
        txtRiwayatChat.setText("AI: Halo! Keluhan apa yang Anda rasakan hari ini?\n\n");
    }

    @FXML
    public void kirimPesan(ActionEvent event) {
        String input = txtPesan.getText().trim();
        if (input.isEmpty()) return;


        txtRiwayatChat.appendText("Anda: " + input + "\nAI sedang mengetik...\n");
        txtPesan.clear();


        String promptPersona = "Anda adalah AI-Nurse, asisten perawat virtual rumah sakit yang ramah, hangat, dan berempati. " +
                "Tugas Anda adalah merespons pesan pasien secara langsung (sebagai orang pertama). " +
                "Berikan jawaban yang menenangkan, berikan edukasi dasar, dan ingatkan pasien untuk menunggu jadwal periksa dokter. " +
                "Pesan dari pasien: '" + input + "'";


        new Thread(() -> {
            String jawabanAI = geminiservice.tanyaAI(promptPersona);


            jawabanAI = jawabanAI.replace("[STATUS: MERAH]", "")
                    .replace("[STATUS: KUNING]", "")
                    .replace("[STATUS: HIJAU]", "")
                    .trim();


            final String jawabanBersih = jawabanAI;


            Platform.runLater(() -> {
                String riwayatSekarang = txtRiwayatChat.getText().replace("AI sedang mengetik...\n", "");
                txtRiwayatChat.setText(riwayatSekarang + "AI: " + jawabanBersih + "\n\n");

                txtRiwayatChat.positionCaret(txtRiwayatChat.getLength());
            });
        }).start();
    }

    @FXML
    public void kembali(ActionEvent event) {
        pagemanager.pindahHalaman("PortalPasien.fxml");
    }
}
