package com.example.thebestone.quis;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mahasiswa.add(new Mahasiswa("Zacky","50"));
        mahasiswa.add(new Mahasiswa("Hasrul", "17"));

        String Nama = mahasiswa.get(0).getNama();
        String Umur = mahasiswa.get(0).getUmur();

        String Nama1 = mahasiswa.get(1).getNama();
        String Umur1 = mahasiswa.get(1).getUmur();

        Toast.makeText(this, Nama + Umur + Nama1 + Umur1, Toast.LENGTH_SHORT).show();

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
