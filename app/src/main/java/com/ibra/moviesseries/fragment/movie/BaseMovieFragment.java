package com.ibra.moviesseries.fragment.movie;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.MovieAdapter;
import com.ibra.moviesseries.fragment.BaseFragment;
import com.ibra.moviesseries.retrofit.movie.Movie;
import com.ibra.moviesseries.retrofit.movie.MovieList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseMovieFragment extends BaseFragment {

    private static final String TAG = BaseMovieFragment.class.getSimpleName();
    private List<Movie> movieList;
    private MovieAdapter movieAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movieAdapter = new MovieAdapter(getContext(),movieList);



        Call<MovieList> call = getData();
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                if(response.isSuccessful() && response.body() != null){
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

    @Override
    protected RecyclerView.Adapter getAdapter(Context mContext) {
        return movieAdapter;
    }
}
