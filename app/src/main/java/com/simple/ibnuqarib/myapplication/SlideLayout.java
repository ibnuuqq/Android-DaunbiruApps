package com.simple.ibnuqarib.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideLayout extends PagerAdapter {

    Context context;
    LayoutInflater LayoutInflater;

    public SlideLayout(Context context) {

        this.context = context;
    }

    // Arrays
    public int[] slide_images = {
            R.drawable.slider1,
            R.drawable.slider2,
            R.drawable.slider1
    };

    public String[] slide_heading = {
            "Measure",
            "Analyze",
            "Improve"
    };

    public String[] slide_desc = {
            "Daun Biru provide a solution to monitor and measure the performance of the engine/assets offline and online, so that measurement data can be used as a reference for further analysis.",
            "Daun Biru solution are able to analyze actual conditions of asset/engine based on measurement data that exist so that maintenance or repair action taken was proper and correct.",
            "Action proper maintenance or repair and will actually help improve the effectiveness of asset/machine, so that be efficiency and reliability of the plant can be maintained or even increased."
    };
    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}
