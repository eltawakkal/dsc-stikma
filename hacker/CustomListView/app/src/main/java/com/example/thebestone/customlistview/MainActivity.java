package com.example.thebestone.customlistview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thebestone.customlistview.adapter.ListViewAdapterGue;
import com.example.thebestone.customlistview.models.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listData;
    List<Mahasiswa> listMahasiswa;
    ListViewAdapterGue adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListViewItems();

        listData.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteData(i);
                return true;
            }
        });
    }

    public void deleteData(final int position) {
        AlertDialog.Builder delete = new AlertDialog.Builder(this);
        delete
                .setTitle("Delete")
                .setMessage("Yakin Delete Data ini?")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listMahasiswa.remove(position);
                        setListViewItems();
                    }
                })
                .setNegativeButton("Batal", null)
                .setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        updateData(listMahasiswa.get(position).getName(), listMahasiswa.get(position).getAsal(),
                                listMahasiswa.get(position).getSemester(), position);
                    }
                })
                .create().show();
    }

    public void init() {
        listData = findViewById(R.id.listData);
        listMahasiswa = new ArrayList<>();
    }

    public void setListViewItems() {
        adapter = new ListViewAdapterGue(this, listMahasiswa);
        listData.setAdapter(adapter);
    }

    public void addData() {
        View v = getLayoutInflater().inflate(R.layout.custom_alert_add, null);

        final EditText editNama, editSemester, editAsal;

        editNama = v.findViewById(R.id.editNama);
        editSemester = v.findViewById(R.id.editSemester);
        editAsal = v.findViewById(R.id.editAsal);

        AlertDialog.Builder alertAdd = new AlertDialog.Builder(this);
        alertAdd
                .setTitle("Tambahkan Data")
                .setView(v)
                .setCancelable(false)
                .setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nama = editNama.getText().toString();
                        String semester = editSemester.getText().toString();
                        String asal = editAsal.getText().toString();

                        listMahasiswa.add(new Mahasiswa(nama, semester, asal));
                        setListViewItems();
                    }
                })
                .setNegativeButton("Batal", null);
        Dialog dialog = alertAdd.create();
        dialog.show();
    }

    public void updateData(String nama, String asal, String semester, final int position) {
        View v = getLayoutInflater().inflate(R.layout.custom_alert_add, null);

        final EditText editNama, editSemester, editAsal;

        editNama = v.findViewById(R.id.editNama);
        editSemester = v.findViewById(R.id.editSemester);
        editAsal = v.findViewById(R.id.editAsal);

        editNama.setText(nama);
        editAsal.setText(asal);
        editSemester.setText(semester);

        AlertDialog.Builder alertAdd = new AlertDialog.Builder(this);
        alertAdd
                .setTitle("Tambahkan Data")
                .setView(v)
                .setCancelable(false)
                .setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nama = editNama.getText().toString();
                        String semester = editSemester.getText().toString();
                        String asal = editAsal.getText().toString();

                        listMahasiswa.set(position, new Mahasiswa(nama, semester, asal));
                        setListViewItems();
                    }
                })
                .setNegativeButton("Batal", null);
        Dialog dialog = alertAdd.create();
        dialog.show();
    }

    public void onClickButton(View v) {
        addData();
    }
}
