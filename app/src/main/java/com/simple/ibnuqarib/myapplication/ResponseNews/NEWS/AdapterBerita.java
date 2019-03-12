package com.simple.ibnuqarib.myapplication.ResponseNews.NEWS;

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
import com.simple.ibnuqarib.myapplication.ResponseNews.BeritaItem;
import com.squareup.picasso.Picasso;

import java.util.List;

class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.MyViewHolder> {
    //Buat Global Variavel untuk menampung context
        private Context context;
        private List<BeritaItem> berita;
        AdapterBerita(Context context, List<BeritaItem> data_berita){
            //Inisialisasi
            this.context = context;
            this.berita = data_berita;
        }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Layout Inflater
        View view = LayoutInflater.from(context).inflate(R.layout.isi_news, parent,false);
        //Hubungkan dengan MyViewHolder
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //Set Widget
        holder.tvjudul.setText(berita.get(position).getJudulArtikel());
        holder.tvisi.setText(berita.get(position).getIsiArtikel());
        //Dapatkan URL GAMBAR
        final String urlGambarBerita = "http://192.168.1.44/daunbiruapp/images/" + berita.get(position).getGambarArtikel();
            //Set Image ke Widget dengan menggunakan library PICASSO,Karena Imagenya dari internet
        Picasso.with(context).load(urlGambarBerita).into(holder.ivimg_news);
                //Event klik ketika item listnya diklik
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //Mulai Activity Detail

                Intent varIntent = new Intent(context, DetailActivity.class);
                //sisipkan data ke intent
                Log.d("YANG DI CLIK", "onClick: "+ berita.get(position).getId());
                varIntent.putExtra("JDL_ARTIKEL", berita.get(position).getJudulArtikel());
                varIntent.putExtra("TGL_ARTIKEL", berita.get(position).getTanggalArtikel());
                varIntent.putExtra("PNS_ARTIKEL", berita.get(position).getPenulisArtikel());
                varIntent.putExtra("FTO_ARTIKEL", urlGambarBerita);
                varIntent.putExtra("ISI_ARTIKEL", berita.get(position).getIsiArtikel());

                //Method startActivty cuma bisa di pake di activity/ fragmen
                //Jadi kudu make context dulu
                context.startActivity(varIntent);
            }

        });
    }
    //Menentukan Jumlah item yang ditampil
    @Override
    public int getItemCount() {
        return berita.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        //Deklarasi Widget
        ImageView ivimg_news;
        TextView tvjudul,tvtanggal,tvpenulis,tvisi;
        MyViewHolder(View itemView) {
            super(itemView);
            //inisialisasi
            ivimg_news = itemView.findViewById(R.id.img_news);
            tvjudul = itemView.findViewById(R.id.judul);
            tvtanggal = itemView.findViewById(R.id.tgl);
            tvpenulis = itemView.findViewById(R.id.penulis);
            tvisi = itemView.findViewById(R.id.isi);
        }
    }
}
