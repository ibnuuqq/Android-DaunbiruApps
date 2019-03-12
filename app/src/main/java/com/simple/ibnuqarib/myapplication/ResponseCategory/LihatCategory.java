package com.simple.ibnuqarib.myapplication.ResponseCategory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.simple.ibnuqarib.myapplication.Drawerr;
import com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer.LihatAnalyzer;
import com.simple.ibnuqarib.myapplication.LihatOnline.Monitoring.LihatOnline;
import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseProduk.PRODUCT.LihatProduk;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatCategory extends AppCompatActivity{
   // RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_category);
     //   recyclerView = findViewById(R.id.listCategory);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // tampilCategory();
    //}
   // private void tampilCategory() {
     //   ApiServices api = InitRetrofit.getInstance();
        //Log.d("API", "tampilBerita: " + InitRetrofit.getInstance());
        //Call<ResponseCategory> categoryCall = api.getCategory();
        //Log.d("CEK API", "tampilSub: " + categoryCall.request().url().toString());
        //categoryCall.enqueue(new Callback<ResponseCategory>() {
          //  @Override
            //public void onResponse(Call<ResponseCategory> call, Response<ResponseCategory> response) {
              ///  if (response.isSuccessful()){
                 //   Log.d("RESPONSE API", Objects.requireNonNull(response.body()).toString());
                    //Tampung data dari response bodi ke variabel
                   // List<CategoryItem> data_category = response.body().getCategory();
                   // Log.d("DI CATEGORY", "RESPONSE CATEGORY: "+ response.body().getCategory());
                    //boolean status = response.body().isStatus();
                    //if (status){
                      ///  AdapterCategory adapter = new AdapterCategory(LihatCategory.this, data_category);
                        //recyclerView.setAdapter(adapter);
                    //}
                //}
            //}

            //@Override
            //public void onFailure(Call<ResponseCategory> call, Throwable t) {

            //}
        //});
    }

    public void Portabel(View view) {
        Intent intent = new Intent(LihatCategory.this, LihatAnalyzer.class);
        startActivity(intent);
    }

    public void OnlineMonitor(View view) {
        Intent intent = new Intent(LihatCategory.this, LihatOnline.class);
        startActivity(intent);
    }
}