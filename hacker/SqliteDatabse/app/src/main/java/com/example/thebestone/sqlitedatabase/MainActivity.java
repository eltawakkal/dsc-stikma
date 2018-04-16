package com.example.thebestone.sqlitedatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thebestone.sqlitedatabase.sqlite.SqliteOpenHelperQ;

public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper dbConfig;
    SQLiteDatabase db;
    Cursor cursor;

    FloatingActionButton fabAdd;
    ListView listMahaiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        selectAllData();

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData("Zaki", "Penajam");
            }
        });
    }

    private void init() {
        dbConfig = new SqliteOpenHelperQ(this);
        fabAdd = findViewById(R.id.fabAdd);
        listMahaiswa = findViewById(R.id.listMahasiswa);
    }

    public void addData(String nama, String asal) {
        db = dbConfig.getWritableDatabase();
        db.execSQL("insert into tb_mahasiswa (nama, asal) values ('" + nama + "', '" + asal + "')");
        Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
        selectAllData();
    }

    public void selectAllData() {
        db = dbConfig.getReadableDatabase();
        cursor = db.rawQuery("SELECT * from tb_mahasiswa", null);
        String[] nama = new String[cursor.getCount()];

        if (cursor.getCount() != 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                nama[i] = cursor.getString(1);
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nama);
            listMahaiswa.setAdapter(adapter);
        } else {
            Toast.makeText(this, "data kosong kaka", Toast.LENGTH_SHORT).show();
        }
    }

}
