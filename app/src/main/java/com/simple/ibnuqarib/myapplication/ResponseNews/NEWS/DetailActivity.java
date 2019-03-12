package com.simple.ibnuqarib.myapplication.ResponseNews.NEWS;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    //Deklarasi
    ImageView ivimg_news;
    TextView tvjudul,tvtgl,tvpenulis,tvisi;
    TextView wvisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //Inisialisasi
        ivimg_news = findViewById(R.id.img_news);
        tvjudul = findViewById(R.id.judul);
        tvtgl = findViewById(R.id.tgl);

        wvisi = findViewById(R.id.isi);
        //jalankan Method tampil Detail Berita
        showDetailBerita();
    }

    @SuppressLint({"SetTextI18n", "SetJavaScriptEnabled"})
    private void showDetailBerita() {
        //tangkap data dari intent
        String judul_artikel = getIntent().getStringExtra("JDL_ARTIKEL");
        String tanggal_artikel = getIntent().getStringExtra("TGL_ARTIKEL");
       // String penulis_artikel = getIntent().getStringExtra("PNS_ARTIKEL");
        String isi_artikel = getIntent().getStringExtra("ISI_ARTIKEL");
        String foto_artikel = getIntent().getStringExtra("FTO_ARTIKEL");

        //Set ke Widget
        tvjudul.setText(judul_artikel);
        tvtgl.setText("Uploaded on " + tanggal_artikel);
        //Untuk Gambar Artikel
        Picasso.with(DetailActivity.this).load(foto_artikel).into(ivimg_news);
        //Set isi berita sebagai html ke webview
        wvisi.setText(isi_artikel);
    }
}