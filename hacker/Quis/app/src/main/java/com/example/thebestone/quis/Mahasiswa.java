package com.example.thebestone.quis;

/**
 * Created by thebestone on 04/04/18.
 */

public class Mahasiswa {
    private String nama;
    private String umur;

    public Mahasiswa(String nama, String umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public String getUmur() {
        return umur;
    }
}
