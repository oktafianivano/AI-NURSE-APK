package com.project.ainurse.controller;

import com.project.ainurse.utils.pagemanager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class sidebarcontroller {

    @FXML private Button btnDashboard;
    @FXML private Button btnAskep;
    @FXML private Button btnRiwayat;
    @FXML private Button btnStatistik;
    @FXML private Button btnChat;

    @FXML
    public void initialize() {

        String aktif = pagemanager.halamanAktif;


        String styleAktif = "-fx-background-color: rgba(252, 228, 236, 0.7); -fx-text-fill: #d81b60; -fx-alignment: BASELINE_LEFT; -fx-font-weight: bold; -fx-border-color: #d81b60; -fx-border-width: 0 0 0 5;";


        if (aktif != null) {
            if (aktif.equals("dashboardperawat.fxml")) {
                btnDashboard.setStyle(styleAktif);
            } else if (aktif.equals("antreanaskep.fxml")) {
                btnAskep.setStyle(styleAktif);
            } else if (aktif.equals("riwayatselesai.fxml")) {
                btnRiwayat.setStyle(styleAktif);
            } else if (aktif.equals("statistik.fxml")) {
                btnStatistik.setStyle(styleAktif);
            } else if (aktif.equals("chatklinis.fxml")) {
                btnChat.setStyle(styleAktif);
            }
        }
    }


    @FXML void keDashboard(ActionEvent event) { pagemanager.pindahHalaman("dashboardperawat.fxml"); }
    @FXML void keAntreanAskep(ActionEvent event) { pagemanager.pindahHalaman("antreanaskep.fxml"); }
    @FXML void keRiwayat(ActionEvent event) { pagemanager.pindahHalaman("riwayatselesai.fxml"); }
    @FXML void keStatistik(ActionEvent event) { pagemanager.pindahHalaman("statistik.fxml"); }
    @FXML void keChat(ActionEvent event) { pagemanager.pindahHalaman("chatklinis.fxml"); }
    @FXML
    public void logout(ActionEvent event) {

        String namaPerawat = com.project.ainurse.utils.UserSession.getNamaLengkap();
        if (namaPerawat != null && !namaPerawat.isEmpty()) {
            com.project.ainurse.dao.daopasien.catatAuditLog(namaPerawat, "Melakukan Logout (Mengakhiri Shift)");
        }



        com.project.ainurse.utils.UserSession.bersihkanSession();
        com.project.ainurse.utils.pagemanager.pindahHalaman("menuutama.fxml");
    }


}
