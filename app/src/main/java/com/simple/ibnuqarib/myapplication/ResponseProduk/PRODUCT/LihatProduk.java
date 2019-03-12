package com.simple.ibnuqarib.myapplication.ResponseProduk.PRODUCT;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseProduk.ProdukItem;
import com.simple.ibnuqarib.myapplication.ResponseProduk.ResponseProduk;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatProduk extends AppCompatActivity{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_produk);
        recyclerView = findViewById(R.id.listProduk);
        mLayout = new GridLayoutManager(getParent(),2);
        recyclerView.setLayoutManager(mLayout);

        tamplProduk();
    }

    private void tamplProduk() {
        ApiServices api = InitRetrofit.getInstance();
        Call<ResponseProduk> produkCall = api.request_show_produk("id");
        Log.d("Liat API", "Tampil Produk: " + produkCall.request().url().toString());
        produkCall.enqueue(new Callback<ResponseProduk>() {
            @Override
            public void onResponse(Call<ResponseProduk> call, Response<ResponseProduk> response) {
                if (response.isSuccessful()){
                    List<ProdukItem> data_produk = response.body().getProduk();
                    boolean status = response.body().isStatus();
                    if (status){
                        AdapterProduk adapterProduk = new AdapterProduk(LihatProduk.this,data_produk);
                        recyclerView.setAdapter(adapterProduk);
                    }else {
                        // kalau tidak true
                        Toast.makeText(LihatProduk.this, "Tidak ada Produk untuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseProduk> call, Throwable t) {

            }
        });
    }
}