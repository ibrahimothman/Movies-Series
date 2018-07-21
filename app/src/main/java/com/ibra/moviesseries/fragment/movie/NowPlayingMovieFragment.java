package com.ibra.moviesseries.fragment.movie;

import android.support.v7.widget.RecyclerView;

import com.ibra.moviesseries.adapter.MovieAdapter;
import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.movie.Movie;
import com.ibra.moviesseries.retrofit.movie.MovieList;

import java.util.List;

import retrofit2.Call;

public class NowPlayingMovieFragment extends BaseMovieFragment  {


    @Override
    protected Call<MovieList> getData() {
        return ApiClinet.getApiClient().create(ApiInterface.class).getMovies(Constant.NOW_PALYING);
    }




}
