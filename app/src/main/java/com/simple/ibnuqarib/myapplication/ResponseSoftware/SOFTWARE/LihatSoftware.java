package com.simple.ibnuqarib.myapplication.ResponseSoftware.SOFTWARE;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseSoftware.ResponseSoftware;
import com.simple.ibnuqarib.myapplication.ResponseSoftware.SoftwareItem;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("Registered")
public class LihatSoftware extends AppCompatActivity{

    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_software);

        recyclerView = findViewById(R.id.listSoft);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tampilSoftware();
    }

    private void tampilSoftware() {
        ApiServices apiServices = InitRetrofit.getInstance();
        Call<ResponseSoftware> softwareCall = apiServices.request_show_software();
        softwareCall.enqueue(new Callback<ResponseSoftware>() {
            @Override
            public void onResponse(Call<ResponseSoftware> call, Response<ResponseSoftware> response) {
                if (response.isSuccessful()){
                    Log.d("response api Software", response.body().toString());
                    List<SoftwareItem> data_soft = response.body().getSoftware();
                    boolean status = response.body().isStatus();
                    if (status){
                        AdapterSoftware adapter = new AdapterSoftware (LihatSoftware.this, data_soft);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseSoftware> call, Throwable t) {

            }
        });
    }
}
