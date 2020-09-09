package com.daa.jappslider;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.viewpager.widget.PagerAdapter;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    //list of images
    public int[] lst_images = {
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5
    };
    // list of titles
    public String[] lst_title = {
            "Yoga",
            "Running",
            "CrossFit"
    };
    //list of descriptions
    public String[] lst_description = {
            "Revisa los horarios de nuestras clases de yoga",
            "Revisa los horarios del área de cardio en GynX",
            "Revisa los horarios de nuestras clases de CrossFit"
    };
    //list of background colors
    public int[] lst_backgroundcolor ={
            Color.rgb(255,255,255),
            Color.rgb(255,255,255),
            Color.rgb(255,255,255),
    };
    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(ConstraintLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);

        //INI::Refactorizando
        ConstraintLayout layoutslide = (ConstraintLayout) view.findViewById(R.id.slideLinearLayout);
        //INI::Refactorizando

        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txttitle = (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);


        //INI::Refactorizando
        //Objeto @+id/txttitle
        txttitle.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT));

        //txttitle.setTextSize(30);
        txttitle.setTextSize(2,25);
        txttitle.setTextColor(Color.GRAY);
        description.setTextAlignment(4);

        ConstraintSet constraintSet = new ConstraintSet();;
        constraintSet.clone(layoutslide);

        constraintSet.connect(R.id.slideimg,ConstraintSet.BOTTOM,R.id.txtdescription,ConstraintSet.BOTTOM,0);
        constraintSet.connect(R.id.slideimg,ConstraintSet.TOP,R.id.slideimg,ConstraintSet.TOP,0);
        constraintSet.applyTo(layoutslide);
        layoutslide.setConstraintSet(constraintSet);


        //Objeto @+id/txtdescription
        description.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT));

        //description.setTextSize(20);
        txttitle.setTextSize(2,25);
        description.setTextColor(Color.GRAY);
        description.setTextAlignment(4); //center //https://developer.android.com/reference/android/view/View.html#setTextAlignment(int)
        //agregar más codigo aqui


        //FIN::Refactorizando

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}