package com.project.ainurse.controller;

import com.project.ainurse.dao.daopasien;
import com.project.ainurse.model.Pasien;
import com.project.ainurse.utils.pagemanager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class antreanaskepcontroller {

    @FXML private Label lblNamaPerawat;


    @FXML private TableView<Pasien> tabelPerluAskep;
    @FXML private TableColumn<Pasien, String> colRm;
    @FXML private TableColumn<Pasien, String> colNama;
    @FXML private TableColumn<Pasien, String> colKeluhan;
    @FXML private TableColumn<Pasien, String> colTriase;
    @FXML private TableColumn<Pasien, String> colStatus;

    private ObservableList<Pasien> daftarPasienAskep;

    @FXML
    public void initialize() {

        lblNamaPerawat.setText("👤 " + com.project.ainurse.utils.UserSession.getNamaLengkap());


        colRm.setCellValueFactory(new PropertyValueFactory<>("noRm"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colKeluhan.setCellValueFactory(new PropertyValueFactory<>("keluhan"));
        colTriase.setCellValueFactory(new PropertyValueFactory<>("hasilTriase"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("statusPasien"));

        muatData();
    }

    private void muatData() {
        ObservableList<Pasien> semuaData = daopasien.getAllPasien();
        daftarPasienAskep = FXCollections.observableArrayList();


        for (Pasien p : semuaData) {
            if (p.getStatusPasien() != null && p.getStatusPasien().equalsIgnoreCase("Perlu Askep")) {
                daftarPasienAskep.add(p);
            }
        }

        tabelPerluAskep.setItems(daftarPasienAskep);
    }

    @FXML
    void bukaFormAskep(ActionEvent event) {
        Pasien terpilih = tabelPerluAskep.getSelectionModel().getSelectedItem();


        if (terpilih == null) {
            System.out.println("GAGAL: Pilih pasien dulu di tabel sebelum membuat Askep!");
            return;
        }

        com.project.ainurse.utils.UserSession.setPasienTerpilih(terpilih);





        pagemanager.pindahHalaman("formaskep.fxml");
    }
}
