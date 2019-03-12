package com.simple.ibnuqarib.myapplication.ResponseProduk.PRODUCT;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseProduk.ProdukItem;
import com.squareup.picasso.Picasso;

import java.util.List;

class AdapterProduk extends RecyclerView.Adapter<AdapterProduk.MyViewHolder> {
    private Context context;
    private List<ProdukItem> produk;

    AdapterProduk(Context context, List<ProdukItem> data_produk){
        this.context = context;
        this.produk = data_produk;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.isi_produk,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduk.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tvNamaProduk.setText(produk.get(position).getNamaProduk());
        holder.tvId.setText(produk.get(position).getId());
        Log.d("Holder", "onBindViewHolder: " + produk.get(position).getId());
        final String urlGambarProduk = "http://192.168.1.44/daunbiruapp/images/" + produk.get(position).getGambarProduk();
        Picasso.with(context).load(urlGambarProduk).into(holder.ivGambarProduk);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varIntent = new Intent(context, DetailProduk.class);
                varIntent.putExtra("ID", produk.get(position).getId());
                Log.d("adap","INI DI ADAP" + produk.get(position).getId());
               //DetailProduk detailProduk = new DetailProduk();
                //detailProduk.SetID(produk.get(position).getId());
                varIntent.putExtra("NAMA", produk.get(position).getNamaProduk());
                varIntent.putExtra("SPEK", produk.get(position).getSpesifikasi());
                varIntent.putExtra("HARGA", produk.get(position).getHarga());
                varIntent.putExtra("GAMBAR", urlGambarProduk);
                    context.startActivity(varIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return produk.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGambarProduk;
        TextView tvNamaProduk;
        TextView tvId;
        MyViewHolder(View itemView) {
            super(itemView);
            ivGambarProduk = itemView.findViewById(R.id.img_produk);
            tvId = itemView.findViewById(R.id.idproduk);
            tvNamaProduk = itemView.findViewById(R.id.namaSub);
            }
    }
}
