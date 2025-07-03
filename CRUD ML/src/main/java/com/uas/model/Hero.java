package com.uas.model;

public class Hero {
    private int id;
    private String nama;
    private String kategori;
    private String gender;

    public Hero(int id, String nama, String kategori, String gender) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.gender = gender;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getKategori() { return kategori; }
    public String getGender() { return gender; }

    public void setId(int id) { this.id = id; }
    public void setNama(String nama) { this.nama = nama; }
    public void setKategori(String kategori) { this.kategori = kategori; }
    public void setGender(String gender) { this.gender = gender; }
}
