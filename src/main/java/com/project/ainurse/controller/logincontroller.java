package com.project.ainurse.controller;

import com.project.ainurse.utils.DatabaseConfig;
import com.project.ainurse.utils.UserSession;
import com.project.ainurse.utils.pagemanager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class logincontroller {

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private TextField txtPasswordVisible;
    @FXML private CheckBox chkShowPassword;
    @FXML private Label lblError;

    @FXML
    public void initialize() {


        txtPasswordVisible.textProperty().bindBidirectional(txtPassword.textProperty());
    }


    @FXML
    public void togglePassword(ActionEvent event) {
        if (chkShowPassword.isSelected()) {

            txtPasswordVisible.setVisible(true);
            txtPassword.setVisible(false);
        } else {

            txtPasswordVisible.setVisible(false);
            txtPassword.setVisible(true);
        }
    }

    @FXML
    public void prosesLogin(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            tampilkanError("Username dan Password wajib diisi!");
            return;
        }

        String sql = "SELECT * FROM perawat WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String namaAsli = rs.getString("nama_lengkap");


                UserSession.setNamaLengkap(namaAsli);


                com.project.ainurse.dao.daopasien.catatAuditLog(namaAsli, "Berhasil Login (Memulai Shift)");


                pagemanager.pindahHalaman("dashboardperawat.fxml");
            } else {
                tampilkanError("Username atau Password salah!");
            }

        } catch (Exception e) {
            tampilkanError("Gagal terhubung ke database!");
            e.printStackTrace();
        }
    }

    private void tampilkanError(String pesan) {
        lblError.setText(pesan);
        lblError.setVisible(true);
    }

    @FXML
    public void kembaliKeMenu(ActionEvent event) {
        pagemanager.pindahHalaman("menuutama.fxml");
    }
}
