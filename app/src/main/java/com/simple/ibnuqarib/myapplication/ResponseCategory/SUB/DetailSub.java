package com.simple.ibnuqarib.myapplication.ResponseCategory.SUB;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.simple.ibnuqarib.myapplication.R;


public class DetailSub extends AppCompatActivity {
    TextView tvNamasub,tvDeskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sub);
        tvNamasub = findViewById(R.id.nama_sub);
        tvDeskripsi = findViewById(R.id.deskripsi);
        showDetail();
    }

    private void showDetail() {
        String namasub = getIntent().getStringExtra("NAMASUBB");
        String deskrip = getIntent().getStringExtra("DESKRIP");

        tvNamasub.setText(namasub);
        tvDeskripsi.setText(deskrip);
    }
}
