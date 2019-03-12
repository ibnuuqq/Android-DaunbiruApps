package com.simple.ibnuqarib.myapplication.ResponseSoftware.SOFTWARE;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseSoftware.SoftwareItem;

import java.util.List;

class AdapterSoftware extends RecyclerView.Adapter<AdapterSoftware.MyViewHolder>{

  Context context;
  List<SoftwareItem> software;
    public AdapterSoftware(Context context,List<SoftwareItem> data_soft){
        this.context = context;
        this.software = data_soft;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Layout Inflater
        View view = LayoutInflater.from(context).inflate(R.layout.isi_software, parent,false);
        //Hubungkan dengan MyViewHolder
        return new AdapterSoftware.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tvNamaS.setText(software.get(position).getNamaSoftware());
        holder.tvVersi.setText("Version "+software.get(position).getVersi());
        holder.tvTgl.setText(software.get(position).getWaktuUpdate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varIntent = new Intent(context,DetailSoftware.class);
                varIntent.putExtra("NAMA_S",software.get(position).getNamaSoftware());
                varIntent.putExtra("VERSI_S",software.get(position).getVersi());
                varIntent.putExtra("TGL",software.get(position).getWaktuUpdate());
                varIntent.putExtra("KET",software.get(position).getKeterangan());
                varIntent.putExtra("LINK",software.get(position).getLink());
                context.startActivity(varIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return software.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaS,tvVersi,tvTgl,tvket;
        MyViewHolder(View itemView) {
            super(itemView);
            tvNamaS = itemView.findViewById(R.id.nama_software);
            tvVersi = itemView.findViewById(R.id.versi);
            tvTgl = itemView.findViewById(R.id.tanggal_software);
            tvket = itemView.findViewById(R.id.keterangan);
        }
    }
}
