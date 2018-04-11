package com.example.thebestone.realmdatabase.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.thebestone.realmdatabase.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thebestone on 07/04/18.
 */

public class SqliteHelper {

    Activity context;

    SqliteConfig sqlconfig;
    SQLiteDatabase db;
    Cursor cursor;

    public SqliteHelper(Activity context) {
        this.context = context;

        sqlconfig = new SqliteConfig(context);
    }

    public List<Mahasiswa> getAllMahasiswa() {

        List<Mahasiswa> mahasiswa = new ArrayList<>();

        try {
            db = sqlconfig.getReadableDatabase();
            cursor = db.rawQuery("select * from tbMahasiswa", null);
        } catch (SQLiteException e) {
            Toast.makeText(context, "Error : " + e, Toast.LENGTH_SHORT).show();
        }

        cursor.moveToFirst();

        for (int i=0; i<cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            mahasiswa.add(new Mahasiswa(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        }

        return mahasiswa;
    }

    public void addMahasiswa(String name, String semester, String age) {
        try {
            db = sqlconfig.getWritableDatabase();
            db.execSQL("insert into tbMahasiswa (name, semester, age) values ('" + name +"', '"+ semester +"', '"+ age +"')");
        } catch (SQLiteException e) {
            Toast.makeText(context, "Error : " + e, Toast.LENGTH_SHORT).show();
        }
    }
}
