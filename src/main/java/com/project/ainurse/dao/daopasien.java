package com.project.ainurse.dao;

import com.project.ainurse.model.Pasien;
import com.project.ainurse.utils.DatabaseConfig;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daopasien {

    public boolean insertPasienBaru(Pasien p) {
        String sql = "INSERT INTO pasien (no_rm, nama, usia, suhu, keluhan, hasil_triase, status_pasien) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNoRm());
            stmt.setString(2, p.getNama());
            stmt.setInt(3, p.getUsia());
            stmt.setDouble(4, p.getSuhu());
            stmt.setString(5, p.getKeluhan());
            stmt.setString(6, p.getHasilTriase());
            stmt.setString(7, p.getStatusPasien());

            int barisTerpengaruh = stmt.executeUpdate();
            return barisTerpengaruh > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pasien cariDataPasien(String keyword) {
        String sql = "SELECT * FROM pasien WHERE no_rm = ? OR nama LIKE ? ORDER BY id DESC LIMIT 1";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, keyword);
            stmt.setString(2, "%" + keyword + "%");

            var rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pasien(
                        rs.getInt("id"), rs.getString("no_rm"), rs.getString("nama"),
                        rs.getInt("usia"), rs.getDouble("suhu"), rs.getString("keluhan"),
                        rs.getString("hasil_triase"), rs.getString("status_pasien")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public int hitungAntreanDiDepan(int idPasien) {
        String sql = "SELECT COUNT(*) FROM pasien WHERE status_pasien = 'Menunggu Antrean' AND id < ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPasien);
            var rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }

    public static ObservableList<Pasien> getAllPasien() {
        ObservableList<Pasien> daftar = FXCollections.observableArrayList();
        String sql = "SELECT * FROM pasien " +
                "WHERE status_pasien != 'Selesai Ditangani' " +
                "ORDER BY " +
                "  CASE " +
                "    WHEN UPPER(hasil_triase) LIKE '%MERAH%' THEN 1 " +
                "    WHEN UPPER(hasil_triase) LIKE '%KUNING%' THEN 2 " +
                "    WHEN UPPER(hasil_triase) LIKE '%HIJAU%' THEN 3 " +
                "    ELSE 4 " +
                "  END ASC";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pasien p = new Pasien(
                        rs.getString("no_rm"),
                        rs.getString("nama"),
                        rs.getInt("usia"),
                        rs.getDouble("suhu"),
                        rs.getString("keluhan"),
                        rs.getString("hasil_triase"),
                        rs.getString("status_pasien")
                );
                daftar.add(p);
            }
        } catch (Exception e) {
            System.out.println("Gagal menarik data: " + e.getMessage());
            e.printStackTrace();
        }
        return daftar;
    }

    public static boolean updateStatusPasien(String noRm, String statusBaru) {
        String sql = "UPDATE pasien SET status_pasien = ? WHERE no_rm = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, statusBaru);
            stmt.setString(2, noRm);

            int barisBerubah = stmt.executeUpdate();
            return barisBerubah > 0;

        } catch (Exception e) {
            System.out.println("Gagal update status: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    public static boolean insertPasien(Pasien p) {
        String sql = "INSERT INTO pasien (no_rm, nama, usia, suhu, keluhan, hasil_triase, status_pasien) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNoRm());
            stmt.setString(2, p.getNama());
            stmt.setInt(3, p.getUsia());
            stmt.setDouble(4, p.getSuhu());
            stmt.setString(5, p.getKeluhan());
            stmt.setString(6, p.getHasilTriase());
            stmt.setString(7, p.getStatusPasien());

            int barisBerubah = stmt.executeUpdate();
            return barisBerubah > 0;

        } catch (Exception e) {
            System.out.println("Gagal insert pasien baru: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static ObservableList<Pasien> getRiwayatPasien() {
        ObservableList<Pasien> listPasien = FXCollections.observableArrayList();
        String sql = "SELECT * FROM pasien WHERE status_pasien = 'Selesai Ditangani'";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pasien p = new Pasien(
                        rs.getString("no_rm"),
                        rs.getString("nama"),
                        rs.getInt("usia"),
                        rs.getDouble("suhu"),
                        rs.getString("keluhan"),
                        rs.getString("hasil_triase"),
                        rs.getString("status_pasien")
                );
                listPasien.add(p);
            }
        } catch (Exception e) {
            System.out.println("Gagal memuat riwayat: " + e.getMessage());
            e.printStackTrace();
        }
        return listPasien;
    }

    public static boolean insertRekamMedis(String noRm, String namaPerawat, String isiRekamMedis) {
        String sql = "INSERT INTO riwayat_rekam_medis (id_pasien, nama_perawat, isi_rekam_medis) " +
                "VALUES ((SELECT id FROM pasien WHERE no_rm = ? LIMIT 1), ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, noRm);
            stmt.setString(2, namaPerawat);
            stmt.setString(3, isiRekamMedis);

            int barisBerubah = stmt.executeUpdate();
            return barisBerubah > 0;

        } catch (Exception e) {
            System.out.println("Gagal menyimpan rekam medis: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static int hitungTriase(String keywordTriase) {
        String sql = "SELECT COUNT(*) AS total FROM pasien WHERE hasil_triase LIKE ?";
        int total = 0;
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keywordTriase + "%");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("Gagal menghitung statistik: " + e.getMessage());
        }
        return total;
    }

    public static void catatAuditLog(String namaPerawat, String aksi) {
        catatAuditLog(namaPerawat, "-", aksi);
    }

    public static void catatAuditLog(String namaPerawat, String noRm, String aksi) {
        String sql = "INSERT INTO audit_log_perawat (nama_perawat, no_rm, aksi) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, namaPerawat);
            pstmt.setString(2, noRm);
            pstmt.setString(3, aksi);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Gagal mencatat audit log: " + e.getMessage());
        }
    }
}
