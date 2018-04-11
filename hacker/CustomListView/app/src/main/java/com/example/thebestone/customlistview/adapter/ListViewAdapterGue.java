package com.example.thebestone.customlistview.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thebestone.customlistview.R;
import com.example.thebestone.customlistview.models.Mahasiswa;

import java.util.List;

public class ListViewAdapterGue extends ArrayAdapter<Mahasiswa> {

    List<Mahasiswa> listMahasiswa;
    Activity context;
    int listGambar[] = {R.drawable.carroot, R.drawable.salad};

    public ListViewAdapterGue(Activity context, List<Mahasiswa> listMahasiswa) {
        super(context, R.layout.custom_list_item, listMahasiswa);

        this.listMahasiswa = listMahasiswa;
        this.context = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_list_item, null);

        TextView txtNama, txtAsal, txtSemester;
        ImageView imgMahasiswa;

        txtNama = view.findViewById(R.id.txtNama);
        txtAsal = view.findViewById(R.id.txtAsal);
        txtSemester = view.findViewById(R.id.txtSemester);
        imgMahasiswa = view.findViewById(R.id.imgMahasiswa);

        txtNama.setText(listMahasiswa.get(position).getName());
        txtAsal.setText(listMahasiswa.get(position).getAsal());
        txtSemester.setText(listMahasiswa.get(position).getSemester());

        if (position % 2 == 0) {
            imgMahasiswa.setImageResource(listGambar[0]);
        } else if (position % 2 == 1) {
            imgMahasiswa.setImageResource(listGambar[1]);
        }

        return view;
    }
}
