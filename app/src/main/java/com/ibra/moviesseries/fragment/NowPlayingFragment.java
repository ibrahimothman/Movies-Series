package com.ibra.moviesseries.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.ApiClinet;
import com.ibra.moviesseries.data.ApiInterface;
import com.ibra.moviesseries.data.CatchData;
import com.ibra.moviesseries.model.MovieList;

import retrofit2.Call;

public class NowPlayingFragment extends CatchData {


    private static final String TAG = NowPlayingFragment.class.getSimpleName();
    private boolean loadOnce = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) Log.d(TAG,"not null");
        else Log.d(TAG,"null");
    }

    @Override
    protected Call<MovieList> getData() {
        return ApiClinet.getApiClient().create(ApiInterface.class).getNowPlayingMovies();
    }
}
