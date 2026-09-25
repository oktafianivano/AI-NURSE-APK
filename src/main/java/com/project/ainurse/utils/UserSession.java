package com.project.ainurse.utils;

import com.project.ainurse.model.Pasien;

public class UserSession {
    private static String namaLengkap;
    private static Pasien pasienTerpilih;

    public static String getNamaLengkap() {
        return namaLengkap == null ? "Perawat" : namaLengkap;
    }

    public static void setNamaLengkap(String nama) {
        namaLengkap = nama;
    }

    public static Pasien getPasienTerpilih() {
        return pasienTerpilih;
    }

    public static void setPasienTerpilih(Pasien p) {
        pasienTerpilih = p;
    }

    public static void bersihkanSession() {
        namaLengkap = null;
        pasienTerpilih = null;
    }
}
