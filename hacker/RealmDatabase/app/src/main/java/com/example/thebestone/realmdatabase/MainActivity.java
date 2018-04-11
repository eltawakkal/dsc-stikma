package com.example.thebestone.realmdatabase;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thebestone.realmdatabase.adapter.RecyclerAdapterQ;
import com.example.thebestone.realmdatabase.sqlite.SqliteHelper;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    List<com.example.thebestone.realmdatabase.Mahasiswa> mahasiswa = new ArrayList<>();
    SqliteHelper dbHelper;

    RecyclerView mRecycler;
    RecyclerAdapterQ adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.mListData);
        dbHelper = new SqliteHelper(this);
        mRecycler = findViewById(R.id.mRecycler);

        setListViewItems();
    }

    public void onClickAdd(View v) {
        alertAddData();
    }

    public void alertAddData() {

        final EditText editText = new EditText(this);
        AlertDialog.Builder addData = new AlertDialog.Builder(this);
        addData
                .setTitle("Add New Data")
                .setView(editText)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbHelper.addMahasiswa(editText.getText().toString(), "2", "18");
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false)
                .create().show();

        setListViewItems();
    }

    public void setListViewItems() {
        mahasiswa = dbHelper.getAllMahasiswa();
        String[] getMahasiswa = new String[mahasiswa.size()];

        if (mahasiswa.size() == 0) {
            Toast.makeText(this, "No Data registered", Toast.LENGTH_SHORT).show();
        } else {
            for (int i=0; i<mahasiswa.size(); i++) {
                getMahasiswa[i] = mahasiswa.get(i).getName();
            }
            Toast.makeText(this, getMahasiswa[0], Toast.LENGTH_SHORT).show();
        }
    }
}
