package com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.NavigableMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LihatMediaAnalyzer extends AppCompatActivity {
    //String IDSUB,nama,DeskSub;
    TextView tvNamasub,tvDeskSub,tvDeskMed,tvNamaSpek,tvValueSpek;
    ImageView imgMedia;
    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_media_analyzer);

        tvNamasub = findViewById(R.id.namaSUB);
        tvDeskMed = findViewById(R.id.deskripsi_media);
        tvDeskSub = findViewById(R.id.deskripsi_sub);
        imgMedia = findViewById(R.id.img_AnalyzerMedia);
        recyclerView = findViewById(R.id.listMediaAnalyzer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tampilDetailMedia();
    }

    private void tampilDetailMedia() {
        ApiServices api = InitRetrofit.getInstance();
       String IDSUB = getIntent().getStringExtra("IDSUB");
       Call<List<MediaItem>> mediaCall = api.request_get_media(IDSUB);
       mediaCall.enqueue(new Callback<List<MediaItem>>() {
           @Override
           public void onResponse(Call<List<MediaItem>> call, Response<List<MediaItem>> response) {
               if (response.isSuccessful()){
                   for (int i = 0; i < response.body().size(); i++){
                       String nama = getIntent().getStringExtra("NAMASUB");
                       tvNamasub.setText(nama);
                       String desksub = getIntent().getStringExtra("DESKSUB");
                       tvDeskSub.setText(desksub);
                       String UrlGambar = "http://192.168.1.44/daunbiruapp/images/" + response.body().get(i).getMedia();
                       Picasso.with(LihatMediaAnalyzer.this).load(UrlGambar).into(imgMedia);
                       tvDeskMed.setText(response.body().get(i).getDeskripsi());
                   }
               }
           }

           @Override
           public void onFailure(Call<List<MediaItem>> call, Throwable t) {

           }
       });
       ApiServices apii = InitRetrofit.getInstance();
       Call<ResponseSpek> dataCall = apii.request_get_spek(IDSUB);
       dataCall.enqueue(new Callback<ResponseSpek>() {
           @Override
           public void onResponse(Call<ResponseSpek> call, Response<ResponseSpek> response) {
               if (response.isSuccessful()){
                   List<SpekItem> data_spek = response.body().getSpek();
                   boolean status = response.body().isStatus();
                   if (status){
                       AdapterSpek adapter = new AdapterSpek(LihatMediaAnalyzer.this,data_spek);
                       recyclerView.setAdapter(adapter);
                   }

               }
           }

           @Override
           public void onFailure(Call<ResponseSpek> call, Throwable t) {

           }
       });


       // Call<MediaItem> mediaCall = api.request_get_media(IDSUB);
        //Log.d("CEK API", "tampilSub: " + mediaCall.request().url().toString());

        //mediaCall.enqueue(new Callback<MediaItem>() {
          //  @Override
            //public void onResponse(Call<MediaItem> call, Response<MediaItem> response) {
              //      String nama = getIntent().getStringExtra("NAMASUB");
                //    tvNamasub.setText(nama);
                    //tvDeskSub.setText(DeskSub);
                  //  String DeskSub = getIntent().getStringExtra("DESKSUB");
                    //tvDeskMed.setText(DeskSub);

            //}

            //@Override
            //public void onFailure(Call<MediaItem> call, Throwable t) {

            //}
        //});
    }
}
