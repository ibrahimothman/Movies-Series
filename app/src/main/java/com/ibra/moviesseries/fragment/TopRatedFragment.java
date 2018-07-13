package com.ibra.moviesseries.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.MovieAdapter;
import com.ibra.moviesseries.data.ApiClinet;
import com.ibra.moviesseries.data.ApiInterface;
import com.ibra.moviesseries.data.CatchData;
import com.ibra.moviesseries.model.Movie;
import com.ibra.moviesseries.model.MovieList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedFragment extends CatchData {


    private static final String TAG = TopRatedFragment.class.getSimpleName();
    private boolean loadOnce = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) Log.d(TAG,"not null");
        else Log.d(TAG,"null");
    }


    @Override
    protected Call<MovieList> getData() {
        Log.d(TAG,"getdata");
        return ApiClinet.getApiClient().create(ApiInterface.class).getTopReatedMovies();
    }
}
