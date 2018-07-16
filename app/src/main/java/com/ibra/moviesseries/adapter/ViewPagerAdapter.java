package com.ibra.moviesseries.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import butterknife.ButterKnife;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private static final String SHOW_TYPE = "TYPE";
    private static final CharSequence TOP_RATED = "TOP RATED";
    private static final CharSequence UPCOMING = "UPCOMING";
    private static final CharSequence NOW_PALYING = "NOW PLAYING";
    private static final CharSequence POPULAR = "POPULAR";
    private static final CharSequence ON_THE_AIR = "ON THE AIR";
    private static final CharSequence AIRING_TODAY = "AIRING TODAY";
    private Fragment[] fragments;

    private String type;



    public ViewPagerAdapter(FragmentManager fm, Fragment[]fragments,String type) {
        super(fm);
        this.fragments = fragments;

        this.type = type;


    }


    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(SHOW_TYPE,type);
        fragments[position].setArguments(bundle);
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
        if(position == 0) return TOP_RATED;
        else if(position == 1 && type.equals("movie")) return UPCOMING;
        else if(position == 1 && type.equals("tv")) return AIRING_TODAY;
        else if(position == 2 && type.equals("movie")) return NOW_PALYING;
        else if(position == 2 && type.equals("tv")) return ON_THE_AIR;
        else if(position == 3) return POPULAR;
        else return null;
    }
}
