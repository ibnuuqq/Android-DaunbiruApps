package com.simple.ibnuqarib.myapplication.ResponseCategory;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseCategory.SUB.LihatSub;


import java.util.List;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.MyViewHolder> {

    private Context context;
    private List<CategoryItem> category;
    AdapterCategory(Context context, List<CategoryItem> data_category){
        //Inisialisasi
        this.context = context;
        this.category = data_category;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Layout Inflater
        View view = LayoutInflater.from(context).inflate(R.layout.isi_category, parent,false);
        //Hubungkan dengan MyViewHolder
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.tvCategory.setText(category.get(position).getNamaCategory());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent varIntent = new Intent(context,LihatSub.class);
                    varIntent.putExtra("ID",category.get(position).getIdCategory());
                    varIntent.putExtra("CATEGORY",category.get(position).getNamaCategory());
                    context.startActivity(varIntent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.nama_category);
        }
    }
}
