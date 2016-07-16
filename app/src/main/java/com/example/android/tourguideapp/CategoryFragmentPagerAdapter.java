package com.example.android.tourguideapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by da7th on 7/13/2016.
 */


public class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Main Sites", "Archaeological", "Historical", "Facts"};

    public CategoryFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MainSitesFragment();
        } else if (position == 1) {
            return new ArchaeoFragment();
        } else if (position == 2) {
            return new HistoricalFragment();
        } else {
            return new FactsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
