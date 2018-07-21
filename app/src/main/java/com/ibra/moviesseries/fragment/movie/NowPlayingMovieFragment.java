package com.ibra.moviesseries.fragment.movie;

import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.movie.MovieList;

import retrofit2.Call;

public class NowPlayingMovieFragment extends BaseMovieFragment  {


    @Override
    protected Call<MovieList> getData() {
        return ApiClinet.getApiClient().create(ApiInterface.class).getMovies(Constant.NOW_PALYING);
    }


}
