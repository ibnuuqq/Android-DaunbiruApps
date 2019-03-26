package com.simple.ibnuqarib.myapplication.LihatOnline.Monitoring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;


import com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer.AdapterSpek;
import com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer.LihatMediaAnalyzer;
import com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer.MediaItem;
import com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer.ResponseSpek;
import com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer.SpekItem;
import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.network.ApiServices;
import com.simple.ibnuqarib.myapplication.network.InitRetrofit;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatMediaOnline extends AppCompatActivity{
    //String IDSUB,nama,DeskSub;
    TextView tvNamasub,tvDeskSub,tvDeskMed;
    ImageView imgMedia;
    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_media_online);

        tvNamasub = findViewById(R.id.namaSubOnline);
        tvDeskMed = findViewById(R.id.deskripsi_mediaON);
        tvDeskSub = findViewById(R.id.deskripsi_subON);
        imgMedia = findViewById(R.id.img_OnlineMedia);
        recyclerView = findViewById(R.id.listMediaOnline);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tampilDetailMedia();
    }

    private void tampilDetailMedia() {
        ApiServices api = InitRetrofit.getInstance();
        String IDSUB = getIntent().getStringExtra("IDON");
        Call<List<MediaItem>> mediaCall = api.request_get_media(IDSUB);
        mediaCall.enqueue(new Callback<List<MediaItem>>() {
            @Override
            public void onResponse(Call<List<MediaItem>> call, Response<List<MediaItem>> response) {
                if (response.isSuccessful()){
                    for (int i = 0; i < response.body().size(); i++){
                        String nama = getIntent().getStringExtra("NAMAON");
                        tvNamasub.setText(nama);
                        String desksub = getIntent().getStringExtra("DESKON");
                        tvDeskSub.setText(desksub);
                        String UrlGambar = "http://10.10.10.11:9999/admin/images/" + response.body().get(i).getMedia();
                        Picasso.with(LihatMediaOnline.this).load(UrlGambar).into(imgMedia);
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
                        AdapterSpek adapter = new AdapterSpek(LihatMediaOnline.this,data_spek);
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
