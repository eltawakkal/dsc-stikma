package com.example.thebestone.realmdatabase.sqlite;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by thebestone on 07/04/18.
 */

public class SqliteConfig extends SQLiteOpenHelper {

    Activity context;

    private static String DATABASE_NAME = "dbMaster";
    private static int DATABASE_VERSION = 1;
    private static String CREATE_TB_MAHASISWA = "create table tbMahasiswa (name varchar(225), semester varchar(225), age varchar(225))";

    public SqliteConfig(Activity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TB_MAHASISWA);
        } catch (SQLiteException e) {
            Toast.makeText(context, "Error : " + e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
