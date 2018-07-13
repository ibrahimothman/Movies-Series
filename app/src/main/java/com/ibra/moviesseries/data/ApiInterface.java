package com.ibra.moviesseries.data;

import com.ibra.moviesseries.model.GenreList;
import com.ibra.moviesseries.model.MovieList;

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
}
