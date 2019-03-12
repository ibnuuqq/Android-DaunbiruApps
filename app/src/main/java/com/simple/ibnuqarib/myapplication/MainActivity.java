package com.simple.ibnuqarib.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.simple.ibnuqarib.myapplication.ResponseCategory.LihatCategory;
import com.simple.ibnuqarib.myapplication.ResponseNews.NEWS.LihatNews;
import com.simple.ibnuqarib.myapplication.ResponseProduk.PRODUCT.LihatProduk;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void News (View view) {
        Intent intent = new Intent(MainActivity.this, LihatNews.class);
       startActivity(intent);
    }

    public void product(View view) {
        Intent intent = new Intent(MainActivity.this, LihatProduk.class);
        startActivity(intent);
    }

    public void produkk(View view) {
    Intent intent = new Intent(MainActivity.this, LihatCategory.class);
    startActivity(intent);
    }
}
