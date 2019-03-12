package com.simple.ibnuqarib.myapplication.ResponseModul.MODUL;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.simple.ibnuqarib.myapplication.Download;
import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseModul.ModulItem;
import com.simple.ibnuqarib.myapplication.ResponseModul.ResponseModul;

import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class LihatDokumen extends AppCompatActivity {
    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_modul);
        recyclerView = findViewById(R.id.listModul);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tampilModul();
    }

    private void tampilModul() {
        ApiServices api = InitRetrofit.getInstance();
        retrofit2.Call<ResponseModul> modulCall = api.request_show_modul();
        modulCall.enqueue(new Callback<ResponseModul>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseModul> call, Response<ResponseModul> response) {
                if (response.isSuccessful()) {
                    Log.d("response api Modul", response.body().toString());
                    List<ModulItem> data_modul = response.body().getModul();
                    boolean status = response.body().isStatus();
                    if (status) {
                        AdapterModul adapter = new AdapterModul(LihatDokumen.this, data_modul);
                        recyclerView.setAdapter(adapter);
                    } else {
                        // kalau tidak true
                        Toast.makeText(LihatDokumen.this, "Tidak ada berita untuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseModul> call, Throwable t) {

            }
        });

    }
}
