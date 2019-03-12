package com.simple.ibnuqarib.myapplication.ResponseCategory.SUB;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("Registered")
public class LihatSub  extends AppCompatActivity {
    private RecyclerView recyclerView;
    String ID;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sub);
        recyclerView = findViewById(R.id.listSub);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ID = getIntent().getStringExtra("ID");
        tampilSub();
    }

    private void tampilSub() {
        ApiServices api = InitRetrofit.getInstance();
        Call<ResponseSub> subItemCall = api.request_get_sub(ID);
        Log.d("CEK API", "tampilSub: " + subItemCall.request().url().toString());
        subItemCall.enqueue(new Callback<ResponseSub>() {
            @Override
            public void onResponse(Call<ResponseSub> call, Response<ResponseSub> response) {
                if (response.isSuccessful()){
                    Log.d("RESPONSE API", Objects.requireNonNull(response.body()).toString());
                    List<SubcategoryItem> data_sub = response.body().getSubcategory();
                    Log.d("DI SUB", "RESPONSE SUB: "+ response.body().getSubcategory());
                    boolean status = response.body().isStatus();
                    if (status){
                        AdapterSub adapterSub = new AdapterSub(LihatSub.this, data_sub);
                        recyclerView.setAdapter(adapterSub);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseSub> call, Throwable t) {

            }


        });
     //  ApiServices spekApi = InitRetrofit.getInstance();
       // Call<ResponseSpek> SpekCall = api.request_get_spek(ID);

    }
}

