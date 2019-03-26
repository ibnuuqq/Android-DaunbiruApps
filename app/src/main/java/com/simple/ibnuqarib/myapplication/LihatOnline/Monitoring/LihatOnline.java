package com.simple.ibnuqarib.myapplication.LihatOnline.Monitoring;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.simple.ibnuqarib.myapplication.LihatOnline.OnlineItem;
import com.simple.ibnuqarib.myapplication.LihatOnline.ResponseOnline;
import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatOnline extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipe;
    @SuppressLint("ResourceAsColor")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_online);
        recyclerView = findViewById(R.id.listOnline);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSwipe = findViewById(R.id.swipe_online);
        mSwipe.setOnRefreshListener(this);
        mSwipe.setColorSchemeColors(R.color.bg_screen3);
        tampilOnline();
    }

    private void tampilOnline() {
        mSwipe.setRefreshing(true);
        ApiServices api = InitRetrofit.getInstance();
        Call<ResponseOnline> onlineCall = api.request_show_monita();
        onlineCall.enqueue(new Callback<ResponseOnline>() {
            @Override
            public void onResponse(Call<ResponseOnline> call, Response<ResponseOnline> response) {
                if (response.isSuccessful()){
                    List<OnlineItem> data_online = response.body().getOnline();
                    boolean status = response.body().isStatus();
                    if (status){
                        mSwipe.setRefreshing(false);
                        AdapterOnline adapterOnline = new AdapterOnline(LihatOnline.this,data_online);
                        recyclerView.setAdapter(adapterOnline);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseOnline> call, Throwable t) {
                mSwipe.setRefreshing(false);
                t.printStackTrace();
            }
        });

    }

    @Override
    public void onRefresh() {
        tampilOnline();
    }
}
