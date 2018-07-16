package com.ibra.moviesseries.data;

import com.ibra.moviesseries.model.GenreList;
import com.ibra.moviesseries.model.MovieList;
import com.ibra.moviesseries.model.TvList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("genre/movie/list?api_key=b74d1d1ae9314a57ace0a639dfff09ef")
    public Call<GenreList> getGenres();

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
}
