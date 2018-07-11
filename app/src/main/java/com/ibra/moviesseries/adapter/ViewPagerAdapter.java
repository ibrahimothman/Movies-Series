package com.ibra.moviesseries.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;
    private String[] tabName;

    public ViewPagerAdapter(FragmentManager fm, Fragment[]fragments, String[]tabName) {
        super(fm);
        this.fragments = fragments;
        this.tabName = tabName;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabName[position];

    }
}
