package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the content view to activity_main.xml
        setContentView(R.layout.activity_main);

        //find the viewpager that will allow the user to swipe between the fragments
        ViewPager cardViewPager = (ViewPager) findViewById(R.id.cardViewpager);

        //create an adapter that knows which fragment to show on each page
        CategoryFragmentPagerAdapter categoryAdapter = new CategoryFragmentPagerAdapter(getSupportFragmentManager());

        //set the adapter on to the viewpager
        cardViewPager.setAdapter(categoryAdapter);

        //give the tab layout the viewpager
        TabLayout categoryTabLayout = (TabLayout) findViewById(R.id.sliding_category_tabs);
        categoryTabLayout.setupWithViewPager(cardViewPager);
    }
}
