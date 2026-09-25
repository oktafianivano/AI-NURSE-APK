package com.project.ainurse.controller;

import com.project.ainurse.utils.pagemanager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class menuutamacontroller {
    @FXML
    public void bukaPortalPasien(ActionEvent event) {
        pagemanager.pindahHalaman("portalpasien.fxml");
    }

    @FXML
    public void bukaLoginPerawat(ActionEvent event) {
        pagemanager.pindahHalaman("login.fxml");
    }
}
