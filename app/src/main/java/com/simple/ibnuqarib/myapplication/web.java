package com.simple.ibnuqarib.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class web extends AppCompatActivity {

    private WebView websiteku;
    private ProgressBar loading; //Menambahkan widget ProgressBar

    private String URL = "http://www.daunbiru.co.id/";
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        websiteku = findViewById(R.id.my_web);
        loading = findViewById(R.id.progress); //Menginisialisasi ID ProgressBar
        settings();
        load_website();
    }

    private void load_website() {
        websiteku.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        //Tambahkan WebChromeClient
        websiteku.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //ProgressBar akan Terlihat saat Halaman Dimuat
                loading.setVisibility(View.VISIBLE);
                loading.setProgress(newProgress);
                if(newProgress == 100){
                    //ProgressBar akan Menghilang setelah Valuenya mencapat 100%
                    loading.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        websiteku.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //ProgressBar akan Menghilang setelah Halaman Selesai Dimuat
                super.onPageFinished(view, url);
                loading.setVisibility(View.GONE);
            }
        });

        websiteku.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        websiteku.loadUrl(URL);
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void settings() {
        WebSettings web_settings = websiteku.getSettings();
        web_settings.setJavaScriptEnabled(true);
        web_settings.setAllowContentAccess(true);
        web_settings.setUseWideViewPort(true);
        web_settings.setLoadsImagesAutomatically(true);
        web_settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        web_settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        web_settings.setEnableSmoothTransition(true);
        web_settings.setDomStorageEnabled(true);
    }
}
