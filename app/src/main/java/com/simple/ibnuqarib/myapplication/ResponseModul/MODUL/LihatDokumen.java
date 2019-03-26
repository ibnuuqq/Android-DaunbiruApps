package com.simple.ibnuqarib.myapplication.ResponseModul.MODUL;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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

public class LihatDokumen extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipe;
    @SuppressLint("ResourceAsColor")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_modul);
        mSwipe = findViewById(R.id.swipe_dokumen);
        mSwipe.setOnRefreshListener(this);
        mSwipe.setColorSchemeColors(R.color.bg_screen3);
        recyclerView = findViewById(R.id.listModul);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tampilModul();
    }

    private void tampilModul() {
        mSwipe.setRefreshing(true);
        ApiServices api = InitRetrofit.getInstance();
        final retrofit2.Call<ResponseModul> modulCall = api.request_show_modul();
        modulCall.enqueue(new Callback<ResponseModul>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseModul> call, Response<ResponseModul> response) {
                if (response.isSuccessful()) {
                    Log.d("response api Modul", response.body().toString());
                    List<ModulItem> data_modul = response.body().getModul();
                    boolean status = response.body().isStatus();
                    if (status) {
                        mSwipe.setRefreshing(false);
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
                mSwipe.setRefreshing(false);
            }
        });

    }

    @Override
    public void onRefresh() {
        tampilModul();
    }
}
