package com.project.ainurse.controller;

import com.project.ainurse.dao.daopasien;
import com.project.ainurse.utils.UserSession;
import com.project.ainurse.utils.pagemanager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

public class statistikcontroller {

    @FXML private Label lblMerah;
    @FXML private Label lblKuning;
    @FXML private Label lblHijau;
    @FXML private PieChart chartTriase;

    @FXML
    public void initialize() {

        int jumlahMerah = daopasien.hitungTriase("MERAH");
        int jumlahKuning = daopasien.hitungTriase("KUNING");
        int jumlahHijau = daopasien.hitungTriase("HIJAU");


        lblMerah.setText(String.valueOf(jumlahMerah));
        lblKuning.setText(String.valueOf(jumlahKuning));
        lblHijau.setText(String.valueOf(jumlahHijau));


        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("KODE MERAH (" + jumlahMerah + ")", jumlahMerah),
                new PieChart.Data("KODE KUNING (" + jumlahKuning + ")", jumlahKuning),
                new PieChart.Data("KODE HIJAU (" + jumlahHijau + ")", jumlahHijau)
        );

        chartTriase.setData(pieChartData);
    }
}
