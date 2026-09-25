package com.project.ainurse.model;

public class Pasien {
    private int id;
    private String noRm;
    private String nama;
    private int usia;
    private double suhu;
    private String keluhan;
    private String hasilTriase;
    private String statusPasien;


    public Pasien(int id, String noRm, String nama, int usia, double suhu, String keluhan, String hasilTriase, String statusPasien) {
        this.id = id;
        this.noRm = noRm;
        this.nama = nama;
        this.usia = usia;
        this.suhu = suhu;
        this.keluhan = keluhan;
        this.hasilTriase = hasilTriase;
        this.statusPasien = statusPasien;
    }


    public Pasien(String noRm, String nama, int usia, double suhu, String keluhan, String hasilTriase, String statusPasien) {
        this.noRm = noRm;
        this.nama = nama;
        this.usia = usia;
        this.suhu = suhu;
        this.keluhan = keluhan;
        this.hasilTriase = hasilTriase;
        this.statusPasien = statusPasien;
    }


    public int getId() { return id; }
    public String getNoRm() { return noRm; }
    public String getNama() { return nama; }
    public int getUsia() { return usia; }
    public double getSuhu() { return suhu; }
    public String getKeluhan() { return keluhan; }
    public String getHasilTriase() { return hasilTriase; }
    public String getStatusPasien() { return statusPasien; }
}
