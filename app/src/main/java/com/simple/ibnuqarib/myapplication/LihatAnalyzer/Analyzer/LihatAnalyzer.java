package com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.simple.ibnuqarib.myapplication.LihatAnalyzer.AnalyzerItem;
import com.simple.ibnuqarib.myapplication.LihatAnalyzer.ResponseAnalyzer;
import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



@SuppressLint("Registered")
public class LihatAnalyzer extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    @SuppressLint("ResourceAsColor")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_analyzer);
        recyclerView = findViewById(R.id.listAnalyzer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout = findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(R.color.bg_screen4,
                R.color.bg_screen3, R.color.bg_screen1);
        tampilAnalyzer();
    }

    private void tampilAnalyzer() {
        swipeRefreshLayout.setRefreshing(true);
        ApiServices api = InitRetrofit.getInstance();
        Call<ResponseAnalyzer> analyzerCall = api.request_show_analyzer();
        Log.d("CEK API", "tampilAnalyzer: " + analyzerCall.request().url().toString());
        analyzerCall.enqueue(new Callback<ResponseAnalyzer>() {
            @Override
            public void onResponse(Call<ResponseAnalyzer> call, Response<ResponseAnalyzer> response) {
                if (response.isSuccessful()) {
                    List<AnalyzerItem> data_analyzer = response.body().getAnalyzer();
                    boolean status = response.body().isStatus();
                    if (status) {
                        swipeRefreshLayout.setRefreshing(false);
                        AdapterAnalyzer adapter = new AdapterAnalyzer(LihatAnalyzer.this, data_analyzer);
                        recyclerView.setAdapter(adapter);
                    } else {
                        swipeRefreshLayout.setRefreshing(false);
                        // kalau tidak true
                        Toast.makeText(LihatAnalyzer.this, "Tidak ada berita untuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseAnalyzer> call, Throwable t) {
                // print ke log jika Error
                swipeRefreshLayout.setRefreshing(false);
                t.printStackTrace();
            }
        });
    }



    @Override
    public void onRefresh() {
       tampilAnalyzer();
    }
//    private void tampilAnalyzer() {
//        ApiServices api = InitRetrofit.getInstance();
//        Call<ResponseAnalyzer> analyzerCall = api.request_show_analyzer();
//        analyzerCall.enqueue(new Callback<ResponseAnalyzer>() {
//            @Override
//            public void onResponse(Call<ResponseAnalyzer> call, Response<ResponseAnalyzer> response) {
//                if (response.isSuccessful()) {
//                    List<AnalyzerItem> data_analyzer = response.body().getAnalyzer();
//                    boolean status = response.body().isStatus();
//                    if (status) {
//                        AdapterAnalyzer adapter = new AdapterAnalyzer(LihatAnalyzer.this, data_analyzer);
//                        recyclerView.setAdapter(adapter);
//                    } else {
//                        // kalau tidak true
//                        Toast.makeText(LihatAnalyzer.this, "Tidak ada berita untuk saat ini", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseAnalyzer> call, Throwable t) {
//                // print ke log jika Error
//                t.printStackTrace();
//            }
//        });
//    }


}
