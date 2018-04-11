package com.example.thebestone.realmdatabase.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thebestone.realmdatabase.Mahasiswa;
import com.example.thebestone.realmdatabase.R;
import com.example.thebestone.realmdatabase.sqlite.SqliteHelper;

import java.util.List;

/**
 * Created by thebestone on 07/04/18.
 */

public class RecyclerAdapterQ extends RecyclerView.Adapter<RecyclerAdapterQ.ViewHolder> {

    Activity context;
    List<Mahasiswa> mahasiswa;

    SqliteHelper dbHelper;

    public RecyclerAdapterQ(Activity context, List<Mahasiswa> mahasiswa) {
        this.context = context;
        this.mahasiswa = mahasiswa;

        dbHelper = new SqliteHelper(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row, parent);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(mahasiswa.get(position).getName());
        holder.txtSemester.setText(mahasiswa.get(position).getSemester());
        holder.txtAge.setText(mahasiswa.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return mahasiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtSemester, txtAge;
        public ViewHolder(View v) {
            super(v);

            txtName = v.findViewById(R.id.txtName);
            txtName = v.findViewById(R.id.txtSemester);
            txtName = v.findViewById(R.id.txtAge);
        }
    }
}
