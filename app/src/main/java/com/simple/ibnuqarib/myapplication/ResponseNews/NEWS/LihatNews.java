package com.simple.ibnuqarib.myapplication.ResponseNews.NEWS;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;
import com.simple.ibnuqarib.myapplication.ResponseNews.BeritaItem;
import com.simple.ibnuqarib.myapplication.ResponseNews.ResponseBerita;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("Registered")
public class LihatNews extends AppCompatActivity {
    //Deklarasi Widget
    private RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_news);
        //Inisialisasi Widget
        recyclerView = findViewById(R.id.listNews);
        //RecyclerView Harus memakai Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Eksekus Method
        tampilBerita();

    }

    private void tampilBerita() {
        ApiServices api = InitRetrofit.getInstance();
        Log.d("API", "tampilBerita: " + InitRetrofit.getInstance());
        //siapkan request
        Call<ResponseBerita> beritaCall = api.request_show_all_berita();
        //Kirim Request
        beritaCall.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                //pastikan response sukses
                if (response.isSuccessful()){
                    Log.d("RESPONSE API", Objects.requireNonNull(response.body()).toString());
                    //Tampung data dari response bodi ke variabel
                    List<BeritaItem> data_berita = Objects.requireNonNull(response.body()).getBerita();
                    boolean status = Objects.requireNonNull(response.body()).isStatus();
                    //Kalau response Statusnya True
                    if (status){
                        //Buat Adapter untuk recyclerView
                        AdapterBerita adapter = new AdapterBerita(LihatNews.this, data_berita);
                        recyclerView.setAdapter(adapter);

                        //AdapterBerita adapter = new AdapterBerita(LihatNews.this, data_berita);
                        //recyclerView.setAdapter(adapter);
                    }else{
                        //Kalau Tdak True
                        Toast.makeText(LihatNews.this, "Tidak Ada Berita UNtuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                //Print jika LOG Eror
                t.printStackTrace();
            }
        });
    }
}
