package com.example.thebestone.sqlitedatabase.sqlite;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SqliteOpenHelperQ extends SQLiteOpenHelper{

    Activity context;
    static String DATABASE_NAME = "db_dsc";
    static int DATABASE_VERSION = 1;
    String CREATE_TB_MAHASISWA = "CREATE TABLE tb_mahasiswa (id integer primary key autoincrement, " +
            "nama varchar(16), asal varchar(50))";

    public SqliteOpenHelperQ(Activity context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TB_MAHASISWA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
