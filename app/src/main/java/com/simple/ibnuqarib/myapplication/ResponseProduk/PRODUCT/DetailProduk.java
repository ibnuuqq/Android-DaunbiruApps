package com.simple.ibnuqarib.myapplication.ResponseProduk.PRODUCT;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseProduk.ProdukItem;
import com.simple.ibnuqarib.myapplication.ResponseProduk.ResponseProduk;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;
import com.squareup.picasso.Picasso;
import com.simple.ibnuqarib.myapplication.ResponseProduk.ProdukItem;

import retrofit2.Call;

public class DetailProduk extends AppCompatActivity {
    ImageView ivGambarProduk;
    TextView tvHarga,tvNamaProduk,tvSpek;
   // String ID_PRODUK;
   // ProdukItem produkItem;

  //  ProdukItem produkItem = new ProdukItem(ID_PRODUK);
       // produkItem
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);
        ivGambarProduk = findViewById(R.id.img_produk);
        tvNamaProduk = findViewById(R.id.namaSub);
        tvHarga = findViewById(R.id.harga);
        tvSpek = findViewById(R.id.spek);

        //
        //produkItem.setId(produkItem.id_categ);
     //ApiServices api = InitRetrofit.getInstance();
       // Call<ResponseProduk> produkCall = api.request_show_produk(produkItem.id_categ);
        //Log.d("API ID", "Show ID : " + produkCall.request().url().toString());
        ShowDetailProduk();

    }
    @SuppressLint("SetTextI18n")
    private void ShowDetailProduk() {

        Log.d("Milih ID ", "ShowDetailProduk: "+ getIntent().getStringExtra("ID"));
        String nama = getIntent().getStringExtra("NAMA");
        String spek = getIntent().getStringExtra("SPEK");
        String harga_produk = getIntent().getStringExtra("HARGA");
        String gambar = getIntent().getStringExtra("GAMBAR");

        tvNamaProduk.setText(nama);
        tvSpek.setText(spek);
        tvHarga.setText(harga_produk);
        Picasso.with(this).load(gambar).into(ivGambarProduk);

    }
}
