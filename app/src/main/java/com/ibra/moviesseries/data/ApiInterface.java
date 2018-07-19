package com.ibra.moviesseries.data;

import com.ibra.moviesseries.model.Credit;
import com.ibra.moviesseries.model.MovieList;
import com.ibra.moviesseries.model.TvList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {



    @GET(Contract.TOP_RATED_MOVIES)
    public Call<MovieList> getTopReatedMovies();

    @GET(Contract.UPCOMING_MOVIES)
    public Call<MovieList> getUpcomingMovies();

    @GET(Contract.NOW_PLAYING_MOVIES)
    public Call<MovieList> getNowPlayingMovies();

    @GET(Contract.POPULAR_MOVIES)
    public Call<MovieList> getPopularMovies();


    @GET(Contract.TOP_RATED_TV)
    public Call<TvList> getTopReatedTv();

    @GET(Contract.UPCOMING_TV)
    public Call<TvList> getUpcomingTv();

    @GET(Contract.NOW_PLAYING_TV)
    public Call<TvList> getNowPlayingTv();

    @GET(Contract.POPULAR_TV)
    public Call<TvList> getPopularTv();

    @GET(Contract.MOVIE_CRIDIT)
    public Call<Credit> getMovieCridit(@Path("id") int id);


}
