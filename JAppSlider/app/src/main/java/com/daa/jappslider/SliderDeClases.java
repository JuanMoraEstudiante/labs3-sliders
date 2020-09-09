package com.daa.jappslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;


public class SliderDeClases extends AppCompatActivity {
    private ViewPager viewPager;
    private SliderAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_de_clases);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SliderAdapter(this);
        viewPager.setAdapter(myadapter);
    }
}