package com.simple.ibnuqarib.myapplication.LihatOnline.Monitoring;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.LihatOnline.OnlineItem;
import com.simple.ibnuqarib.myapplication.R;


import java.util.List;

public class AdapterOnline extends RecyclerView.Adapter<AdapterOnline.MyViewHolder>{

    Context context;
    List<OnlineItem> online;
    public AdapterOnline(Context context,List<OnlineItem> data_online){
        this.context = context;
        this.online = data_online;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.isi_online,parent,false);
        return new AdapterOnline.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tvNama.setText(online.get(position).getNamaSubCategory());
        holder.tvDeskk.setText(online.get(position).getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varIntent = new Intent(context,LihatMediaOnline.class);
                varIntent.putExtra("IDON",online.get(position).getIdSubCategory());
                varIntent.putExtra("NAMAON",online.get(position).getNamaSubCategory());
                varIntent.putExtra("DESKON",online.get(position).getDeskripsi());
                context.startActivity(varIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return online.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama,tvDeskk;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.nama_Online);
            tvDeskk = itemView.findViewById(R.id.desk_subo);
        }
    }
}
