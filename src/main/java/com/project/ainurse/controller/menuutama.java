package com.project.ainurse.controller;

import com.project.ainurse.utils.pagemanager;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class menuutama {
    @FXML
    private StackPane areaTengah;

    @FXML
    public void initialize() {

        pagemanager.setAreaTengah(areaTengah);

        pagemanager.pindahHalaman("menuutama.fxml");
    }
}
