package com.example.thebestone.customlistview.models;

public class Mahasiswa {

    private String name;
    private String semester;
    private String asal;

    public Mahasiswa(String name, String semester, String asal) {
        this.name = name;
        this.semester = semester;
        this.asal = asal;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public String getAsal() {
        return asal;
    }
}
