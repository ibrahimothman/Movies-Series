package com.ibra.moviesseries.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ibra.moviesseries.adapter.ViewPagerAdapter;
import com.ibra.moviesseries.data.ApiClinet;
import com.ibra.moviesseries.data.ApiInterface;
import com.ibra.moviesseries.data.CatchData;
import com.ibra.moviesseries.model.MovieList;
import com.ibra.moviesseries.ui.HomeActivity;

import retrofit2.Call;

public class TopRatedFragment extends CatchData  {


    private static final String TAG = TopRatedFragment.class.getSimpleName();
    private boolean loadOnce = true;
    private String showType;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) Log.d(TAG,"not null");
        else Log.d(TAG,"null");

        Bundle bundle = getArguments();
        showType = bundle.getString("TYPE");

    }


    @Override
    protected  Call getData() {

        if(showType.equals("movie")) {
            Log.d(TAG,"getMovieTopRated");
            return ApiClinet.getApiClient().create(ApiInterface.class).getTopReatedMovies();
        }else {
            Log.d(TAG,"getTvTopRated");
            return  ApiClinet.getApiClient().create(ApiInterface.class).getTopReatedTv();
        }
    }


}
