package com.project.ainurse.controller;

import com.project.ainurse.utils.UserSession;
import com.project.ainurse.utils.geminiservice;
import com.project.ainurse.utils.pagemanager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class chatkliniscontroller {

    @FXML private TextArea txtAreaChat;
    @FXML private TextField txtInputPesan;
    @FXML private Label lblStatus;

    @FXML
    public void kirimPesan() {
        String pesan = txtInputPesan.getText().trim();
        if (pesan.isEmpty()) return;


        String namaPerawat = UserSession.getNamaLengkap();
        txtAreaChat.appendText("👤 " + namaPerawat + ":\n" + pesan + "\n\n");
        txtInputPesan.clear();


        lblStatus.setText("🟡 AI sedang mengetik jawaban...");
        lblStatus.setStyle("-fx-text-fill: #f39c12;");
        txtInputPesan.setDisable(true);


        new Thread(() -> {
            String balasanAI = geminiservice.chatKlinis(pesan);


            Platform.runLater(() -> {
                txtAreaChat.appendText("🤖 AI Klinis:\n" + balasanAI + "\n\n==================================\n\n");


                lblStatus.setText("🟢 AI Siap Membantu");
                lblStatus.setStyle("-fx-text-fill: #27ae60;");
                txtInputPesan.setDisable(false);
                txtInputPesan.requestFocus();
            });
        }).start();
    }
}
