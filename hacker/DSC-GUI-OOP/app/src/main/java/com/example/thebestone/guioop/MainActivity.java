package com.example.thebestone.guioop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    membuat object dari view
    TextView txtResult;
    EditText editName, editAge;
    Button btnSet, btnGet;
    ListView mListMahasiswa;

//    Buat ArrayList sesuai model yang sudah dibuat
    ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fungsi inisialisasi
        initial();

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                membuat tampungan dari editText
                    String nama = editName.getText().toString();
                    String umur = editAge.getText().toString();

//                    menambahkan data baru kedalam ArrayList menggunakan konstruktor
                    mahasiswa.add(new Mahasiswa(nama, umur));
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                membuat Array baru berdasarkan panjang data yang ada di arraylist
                String[] hasil = new String[mahasiswa.size()];

//                looping untung memasukkan data ke array dari arraylist berdasarkan index i
                for (int i=0; i<mahasiswa.size(); i++) {
                    hasil[i] = mahasiswa.get(i).getNama();
                }

//                mengeset adapter untukListView
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_1, hasil);

                mListMahasiswa.setAdapter(adapter);

            }
        });

    }

//    menginisialisasi
    private void initial() {
        txtResult = findViewById(R.id.txtResult);
        editName = findViewById(R.id.editNama);
        editAge = findViewById(R.id.editUmur);
        btnSet = findViewById(R.id.btnSetData);
        btnGet = findViewById(R.id.btnGetData);
        mListMahasiswa = findViewById(R.id.mListMahasiswa);
    }
}
