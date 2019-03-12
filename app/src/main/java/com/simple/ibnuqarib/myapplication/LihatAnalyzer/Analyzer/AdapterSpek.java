package com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;

import java.util.List;

public class AdapterSpek extends RecyclerView.Adapter<AdapterSpek.MyViewHolder> {
    Context context;
    List<SpekItem> spek;
    public AdapterSpek(Context context,List<SpekItem> data_spek){
        this.context = context;
        this.spek = data_spek;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.isi_spek,parent,false);
        return new AdapterSpek.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvNamaSpek.setText(spek.get(position).getNamaSpek());
        holder.tvValueSpek.setText(spek.get(position).getValueSpek());
    }

    @Override
    public int getItemCount() {
        return spek.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaSpek,tvValueSpek;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvNamaSpek = itemView.findViewById(R.id.nama_Spek);
            tvValueSpek = itemView.findViewById(R.id.valueSpek);
        }
    }
}
