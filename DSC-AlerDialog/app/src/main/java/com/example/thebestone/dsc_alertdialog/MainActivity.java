package com.example.thebestone.dsc_alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickAlert (View v) {
        showAlert("Pesan Lapar", "Kode Buat Inisial ZAKI");
    }

    public void showAlert(String title, String message) {

        final AlertDialog.Builder pesan = new AlertDialog.Builder(this);

        ImageView imgClose;
        LayoutInflater getInflater = getLayoutInflater();
        View v = getInflater.inflate(R.layout.view_untuk_alert, null, false);

        imgClose = v.findViewById(R.id.imgClose);
        Button btnOke = v.findViewById(R.id.btnOke);
        pesan
                .setCancelable(false)
                .setView(v)
                .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNeutralButton("Info", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        final Dialog dialog = pesan.create();
        dialog.show();

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnOke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pencet Oke", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}
