package com.example.thebestone.realmdatabase;

import io.realm.RealmObject;

/**
 * Created by thebestone on 05/04/18.
 */

public class Mahasiswa extends RealmObject {

    private String name;
    private String semester;
    private String age;

    public Mahasiswa() {
    }

    public Mahasiswa(String name, String semester, String age) {
        this.name = name;
        this.semester = semester;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public String getAge() {
        return age;
    }
}
