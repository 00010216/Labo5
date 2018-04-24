package com.example.kcruz.seriesapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int NumberOfTabs;

    public PagerAdapter (FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.NumberOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: SeriesFragment tab1 = new SeriesFragment(); return tab1;
            case 1: FavoritesFragment tab2 = new FavoritesFragment(); return tab2;
            default: return null;
        }
    }

    @Override
    public int getCount() { //envia el numero de tabs que se tiene
        return NumberOfTabs;
    }
}
