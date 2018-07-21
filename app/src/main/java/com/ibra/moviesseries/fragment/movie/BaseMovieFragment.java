package com.ibra.moviesseries.fragment.movie;

import android.content.Context;
import android.opengl.Visibility;
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
import android.widget.ProgressBar;


import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.MovieAdapter;
import com.ibra.moviesseries.fragment.BaseFragment;
import com.ibra.moviesseries.retrofit.movie.Movie;
import com.ibra.moviesseries.retrofit.movie.MovieList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseMovieFragment extends BaseFragment {

    private static final String TAG = BaseMovieFragment.class.getSimpleName();
    private List<Movie> movieList;
    private MovieAdapter movieAdapter;


    @BindView(R.id.list) RecyclerView list;
    @BindView(R.id.progress_bar) ProgressBar mProgressBar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list,container,false);

        ButterKnife.bind(this,view);

        movieAdapter = new MovieAdapter(getContext(),movieList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),numberOfColumns());
        list.setLayoutManager(gridLayoutManager);
        list.setHasFixedSize(true);
        list.setAdapter(movieAdapter);


        loadData();


        return view;
    }


    public void loadData(){
        mProgressBar.setVisibility(View.VISIBLE);
        Call<MovieList> call = getData();
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                if(response.isSuccessful() && response.body() != null){
                    mProgressBar.setVisibility(View.INVISIBLE);
                    movieList = response.body().getMovieList();
                    movieAdapter.notifyAdapter(movieList);
                }
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.d(TAG,"error is "+t.getLocalizedMessage());
            }
        });
    }



    protected abstract Call<MovieList> getData();


}
