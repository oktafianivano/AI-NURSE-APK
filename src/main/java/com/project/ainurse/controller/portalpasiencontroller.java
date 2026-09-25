package com.project.ainurse.controller;

import com.project.ainurse.utils.pagemanager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class portalpasiencontroller {
    @FXML
    public void bukaFormDaftar(ActionEvent event) {
        pagemanager.pindahHalaman("formdaftar.fxml");
    }

    @FXML
    public void bukaCekStatus(ActionEvent event) {
        pagemanager.pindahHalaman("cekstatus.fxml");
    }

    @FXML
    public void bukaChatAI(ActionEvent event) {
        pagemanager.pindahHalaman("chatpasien.fxml");
    }

    @FXML
    public void kembaliKeMenuUtama(ActionEvent event) {
        pagemanager.pindahHalaman("menuutama.fxml");
    }
}
