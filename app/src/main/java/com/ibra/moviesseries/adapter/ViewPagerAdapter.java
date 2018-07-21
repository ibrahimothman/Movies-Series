package com.ibra.moviesseries.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.util.Log;

import butterknife.ButterKnife;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private static final String SHOW_TYPE = "TYPE";

    private Fragment[] fragments;
    private String type;
    private String[]tabNames;



    public ViewPagerAdapter(FragmentManager fm, Fragment[]fragments, String[]tabNames,String type) {
        super(fm);
        this.fragments = fragments;
        this.tabNames = tabNames;
        this.type = type;

    }

    public ViewPagerAdapter(FragmentManager fm, Fragment[] fragments, String[]tabNames) {
        super(fm);
        this.fragments = fragments;
        this.tabNames = tabNames;
    }

    @Override
    public Fragment getItem(int position) {
        if(!TextUtils.isEmpty(type)) {
            Bundle bundle = new Bundle();
            bundle.putString(SHOW_TYPE, type);
            fragments[position].setArguments(bundle);
        }
        Log.d("fromPagerAdapter","type is "+type);
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }
}
