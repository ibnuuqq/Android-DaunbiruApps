package com.simple.ibnuqarib.myapplication.ResponseModul.MODUL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.Maps;
import com.simple.ibnuqarib.myapplication.R;

import retrofit2.http.Url;

public class DetailModul extends Activity {
    TextView tvNama,tvVersii,tvWaktu,tvKett;
    //Button button;
    String URL_DOWNLOAD;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_modul);
        tvNama = findViewById(R.id.namaa_dokumen);
        tvVersii = findViewById(R.id.versi_dokumen);
        tvWaktu = findViewById(R.id.tanggal_dokumen);
        tvKett = findViewById(R.id.keterangan_dokumen);


        URL_DOWNLOAD = getIntent().getStringExtra("LINK");
        showDetailModul();
        webView = findViewById(R.id.view_modulDownload);
        Button go = findViewById(R.id.download);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(DetailModul.this,DownloadModul.class);
                inten.putExtra("LINK2",URL_DOWNLOAD);
                Log.d("URL", "onClick: " + inten.putExtra("LINK2",URL_DOWNLOAD));
                startActivity(inten);
               // webView.loadUrl("https://google.com");
                //webView.setWebViewClient(new WebViewClient());
            }
        });



    }


    @SuppressLint("SetTextI18n")
    public void showDetailModul() {
        String nama_dokumen = getIntent().getStringExtra("NAMA");
        String versi = getIntent().getStringExtra("VERSI");
        String waktu = getIntent().getStringExtra("WAKTU");
        String keterangan = getIntent().getStringExtra("KET");


        tvNama.setText(nama_dokumen);
        tvVersii.setText(versi);
        tvWaktu.setText("Uploaded on " + waktu);
        tvKett.setText(keterangan);
    }
}
