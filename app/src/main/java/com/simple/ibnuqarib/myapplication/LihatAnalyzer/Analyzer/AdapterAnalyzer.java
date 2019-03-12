package com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.LihatAnalyzer.AnalyzerItem;
import com.simple.ibnuqarib.myapplication.R;

import java.util.List;

public class AdapterAnalyzer extends RecyclerView.Adapter<AdapterAnalyzer.MyViewHolder> {
    Context context;
    List<AnalyzerItem> analyzer;

    public AdapterAnalyzer(Context context,List<AnalyzerItem> data_analyzer){
        this.context = context;
        this.analyzer = data_analyzer;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.isi_analyzer,parent,false);
        return new AdapterAnalyzer.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tvNama.setText(analyzer.get(position).getNamaSubCategory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varIntent = new Intent(context,LihatMediaAnalyzer.class);
                varIntent.putExtra("IDSUB",analyzer.get(position).getIdSubCategory());
                varIntent.putExtra("NAMASUB",analyzer.get(position).getNamaSubCategory());
                varIntent.putExtra("DESKSUB",analyzer.get(position).getDeskripsi());
                context.startActivity(varIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return analyzer.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.nama_Analyzer);
        }
    }
}
