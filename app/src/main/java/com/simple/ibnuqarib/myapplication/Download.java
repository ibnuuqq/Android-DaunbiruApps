package com.simple.ibnuqarib.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.simple.ibnuqarib.myapplication.ResponseModul.MODUL.LihatDokumen;
import com.simple.ibnuqarib.myapplication.ResponseSoftware.SOFTWARE.LihatSoftware;

public class Download extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
    }

    public void modul(View view) {
        Intent intent = new Intent(Download.this, LihatDokumen.class);
        startActivity(intent);
    }

    public void software(View view) {
        Intent intent = new Intent(Download.this, LihatSoftware.class);
        startActivity(intent);

    }
}
