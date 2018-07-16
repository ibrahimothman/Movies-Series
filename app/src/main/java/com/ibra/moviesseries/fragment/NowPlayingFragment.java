package com.ibra.moviesseries.fragment;

import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.ViewPagerAdapter;
import com.ibra.moviesseries.data.ApiClinet;
import com.ibra.moviesseries.data.ApiInterface;
import com.ibra.moviesseries.data.CatchData;
import com.ibra.moviesseries.model.MovieList;
import com.ibra.moviesseries.ui.HomeActivity;

import retrofit2.Call;

public class NowPlayingFragment extends CatchData {


    private static final String TAG = NowPlayingFragment.class.getSimpleName();
    private boolean loadOnce = true;
    private String showType;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        showType = bundle.getString("TYPE");

    }


    @Override
    protected  Call getData() {
        Log.d(TAG,"getdata");
        Log.d(TAG,"type is "+showType);
        if(showType.equals("movie")) {
            Log.d(TAG,"getMovieTopRated");
            return  ApiClinet.getApiClient().create(ApiInterface.class).getNowPlayingMovies();
        }else {
            Log.d(TAG,"getTvTopRated");
            return  ApiClinet.getApiClient().create(ApiInterface.class).getNowPlayingTv();
        }
    }


}
