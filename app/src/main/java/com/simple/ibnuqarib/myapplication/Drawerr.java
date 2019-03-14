package com.simple.ibnuqarib.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.simple.ibnuqarib.myapplication.ResponseCategory.LihatCategory;
import com.simple.ibnuqarib.myapplication.ResponseNews.NEWS.LihatNews;
import com.simple.ibnuqarib.myapplication.ResponseProduk.PRODUCT.LihatProduk;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Drawerr extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.imagee2,R.drawable.imagee3,R.drawable.imagee4,R.drawable.imagee5,R.drawable.imagee6};
    ImageButton img1,img2,img3,img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerr);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        carouselView = findViewById(R.id.Imageslid);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        //final Animation img1 = AnimationUtils.loadAnimation(this,R.drawable.radius);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
   // public void News (View view) {
     //   Intent intent = new Intent(Drawerr.this, LihatNews.class);
       // startActivity(intent);
    //}



    public void produkk(View view) {
        Intent intent = new Intent(Drawerr.this, LihatCategory.class);
        startActivity(intent);
    }
    public void download(View view) {
        Intent intent = new Intent(Drawerr.this, Download.class);
        startActivity(intent);
    }
    public void web(View view) {
        Intent intent = new Intent(Drawerr.this, web.class);
        startActivity(intent);
    }
    public void contact(View view) {
        Intent intent = new Intent(Drawerr.this, Contact.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
 @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_produk) {
            Intent intent = new Intent(Drawerr.this, LihatCategory.class);
            startActivity(intent);

        } else if (id == R.id.nav_support) {
            Intent intent = new Intent(Drawerr.this, Download.class);
            startActivity(intent);

        } else if (id == R.id.nav_contact) {
            Intent intent = new Intent(Drawerr.this, Contact.class);
            startActivity(intent);

        }  else if (id == R.id.nav_place) {
            Intent intent = new Intent(Drawerr.this, Maps.class);
            startActivity(intent);

        } else if (id == R.id.nav_web) {
            Intent intent = new Intent(Drawerr.this, web.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(Drawerr.this, About.class);
            startActivity(intent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
