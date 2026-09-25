package com.project.ainurse.controller;

import com.project.ainurse.dao.daopasien;
import com.project.ainurse.model.Pasien;
import com.project.ainurse.utils.UserSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class riwayatselesaicontroller {

    @FXML private TableView<Pasien> tabelRiwayat;
    @FXML private TableColumn<Pasien, String> colRm;
    @FXML private TableColumn<Pasien, String> colNama;
    @FXML private TableColumn<Pasien, Integer> colUsia;
    @FXML private TableColumn<Pasien, Double> colSuhu;
    @FXML private TableColumn<Pasien, String> colKeluhan;
    @FXML private TableColumn<Pasien, String> colTriase;
    @FXML private TableColumn<Pasien, String> colStatus;
    @FXML private Label lblNamaPerawat;

    @FXML
    public void initialize() {
        lblNamaPerawat.setText("👤 " + UserSession.getNamaLengkap());

        colRm.setCellValueFactory(new PropertyValueFactory<>("noRm"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colUsia.setCellValueFactory(new PropertyValueFactory<>("usia"));
        colSuhu.setCellValueFactory(new PropertyValueFactory<>("suhu"));
        colKeluhan.setCellValueFactory(new PropertyValueFactory<>("keluhan"));
        colTriase.setCellValueFactory(new PropertyValueFactory<>("hasilTriase"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("statusPasien"));

        tabelRiwayat.setRowFactory(tv -> new TableRow<Pasien>() {
            @Override
            protected void updateItem(Pasien item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setStyle("");
                } else {
                    String triase = item.getHasilTriase().toUpperCase();
                    if (triase.contains("MERAH")) {
                        setStyle("-fx-background-color: #ffcdd2;");
                    } else if (triase.contains("KUNING")) {
                        setStyle("-fx-background-color: #fff9c4;");
                    } else if (triase.contains("HIJAU")) {
                        setStyle("-fx-background-color: #c8e6c9;");
                    } else {
                        setStyle("");
                    }
                }
            }
        });




        ObservableList<Pasien> semuaData = daopasien.getAllPasien();
        ObservableList<Pasien> dataRiwayat = FXCollections.observableArrayList();

        for (Pasien p : semuaData) {
            if (p.getStatusPasien() != null && p.getStatusPasien().equalsIgnoreCase("Riwayat Selesai")) {
                dataRiwayat.add(p);
            }
        }

        tabelRiwayat.setItems(dataRiwayat);
    }
}
