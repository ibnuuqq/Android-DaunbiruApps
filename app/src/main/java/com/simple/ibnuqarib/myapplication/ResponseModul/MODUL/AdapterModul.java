package com.simple.ibnuqarib.myapplication.ResponseModul.MODUL;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseModul.ModulItem;


import java.util.List;

class AdapterModul extends RecyclerView.Adapter<AdapterModul.MyViewHolder>{

   Context context;
   List<ModulItem> modul;
   public AdapterModul(Context context,List<ModulItem> data_modul){
       this.context = context;
       this.modul = data_modul;
   }

    @NonNull
    @Override
    public AdapterModul.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.isi_modul,parent,false);
        return new AdapterModul.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterModul.MyViewHolder holder, final int position) {
        holder.tvNama.setText(modul.get(position).getNamaDokumen());
        holder.tvVersii.setText("Version "+modul.get(position).getVersi());
        holder.tvWaktu.setText(modul.get(position).getWaktuUpdate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varIntent = new Intent(context, DetailModul.class);
                varIntent.putExtra("NAMA",modul.get(position).getNamaDokumen());
                varIntent.putExtra("VERSI",modul.get(position).getVersi());
                varIntent.putExtra("WAKTU",modul.get(position).getWaktuUpdate());
                varIntent.putExtra("KET",modul.get(position).getKeterangan());
                varIntent.putExtra("LINK",modul.get(position).getLink());
                context.startActivity(varIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return modul.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView tvNama,tvVersii,tvWaktu,tvKett;
       Button button;
       public MyViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.namaa_dokumen);
            tvVersii = itemView.findViewById(R.id.versi_dokumen);
            tvWaktu = itemView.findViewById(R.id.tanggal_dokumen);
            tvKett = itemView.findViewById(R.id.keterangan_dokumen);
            button = itemView.findViewById(R.id.download);
        }
    }
}
