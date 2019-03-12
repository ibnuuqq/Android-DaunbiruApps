package com.simple.ibnuqarib.myapplication.ResponseCategory.SUB;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;

import java.util.List;

public class AdapterSub extends RecyclerView.Adapter<AdapterSub.MyViewHolder>{
    private Context context;
    private List<SubcategoryItem> subitem;
    AdapterSub(Context context, List<SubcategoryItem> data_sub) {
        this.context = context;
        this.subitem = data_sub;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.isi_sub, parent,false);
        //Hubungkan dengan MyViewHolder
        return new AdapterSub.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tvnamasub.setText(subitem.get(position).getNamaSubCategory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varIntent = new Intent(context,DetailSub.class);
                varIntent.putExtra("NAMASUBB",subitem.get(position).getNamaSubCategory());
                varIntent.putExtra("DESKRIP",subitem.get(position).getDeskripsi());
                context.startActivity(varIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subitem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvnamasub;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvnamasub = itemView.findViewById(R.id.nama_sub);
        }
    }
}
