package com.simple.ibnuqarib.myapplication.ResponseSoftware.SOFTWARE;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;
import com.simple.ibnuqarib.myapplication.ResponseModul.MODUL.DetailModul;
import com.simple.ibnuqarib.myapplication.ResponseModul.MODUL.DownloadModul;

public class DetailSoftware extends AppCompatActivity {

    TextView tvNamaS,tvVersi,tvTgl,tvKet;
    String URL_DOWNLOAD;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_software);
        tvNamaS = findViewById(R.id.nama_software);
        tvVersi = findViewById(R.id.versi);
        tvKet = findViewById(R.id.keterangan);
        tvTgl = findViewById(R.id.tanggal_software);
        URL_DOWNLOAD = getIntent().getStringExtra("LINK");
        showSoftwareDetail();
        webView = findViewById(R.id.view_softwareDownload);
        Button go = findViewById(R.id.downloadSoft);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(DetailSoftware.this,DownloadSoftware.class);
                inten.putExtra("LINK2",URL_DOWNLOAD);
                Log.d("URL", "onClick: " + inten.putExtra("LINK2",URL_DOWNLOAD));
                startActivity(inten);
                // webView.loadUrl("https://google.com");
                //webView.setWebViewClient(new WebViewClient());
            }
        });
    }
    private void showSoftwareDetail() {
        String nama_software = getIntent().getStringExtra("NAMA_S");
        String versi = getIntent().getStringExtra("VERSI_S");
        String tanggal = getIntent().getStringExtra("TGL");
        String keterangan = getIntent().getStringExtra("KET");

        tvNamaS.setText(nama_software);
        tvTgl.setText("Uploaded on " + tanggal);
        tvVersi.setText("Version " + versi);
        tvKet.setText(keterangan);
    }
}
