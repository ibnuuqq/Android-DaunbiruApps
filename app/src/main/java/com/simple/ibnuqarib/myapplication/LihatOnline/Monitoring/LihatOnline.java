package com.simple.ibnuqarib.myapplication.LihatOnline.Monitoring;

import android.os.Bundle;
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

public class LihatOnline extends AppCompatActivity {
    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_online);
        recyclerView = findViewById(R.id.listOnline);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tampilOnline();
    }

    private void tampilOnline() {
        ApiServices api = InitRetrofit.getInstance();
        Call<ResponseOnline> onlineCall = api.request_show_monita();
        onlineCall.enqueue(new Callback<ResponseOnline>() {
            @Override
            public void onResponse(Call<ResponseOnline> call, Response<ResponseOnline> response) {
                if (response.isSuccessful()){
                    List<OnlineItem> data_online = response.body().getOnline();
                    boolean status = response.body().isStatus();
                    if (status){
                        AdapterOnline adapterOnline = new AdapterOnline(LihatOnline.this,data_online);
                        recyclerView.setAdapter(adapterOnline);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseOnline> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
