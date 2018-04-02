package com.example.thebestone.guioop;

/**
 * Created by thebestone on 02/04/18.
 */

//Model
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
