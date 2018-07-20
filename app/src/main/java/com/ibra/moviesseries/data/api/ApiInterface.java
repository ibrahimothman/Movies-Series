package com.ibra.moviesseries.data.api;

import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.retrofit.credit.Credit;
import com.ibra.moviesseries.retrofit.movie.MovieList;
import com.ibra.moviesseries.retrofit.tv.TvList;
import com.ibra.moviesseries.retrofit.video.Video;
import com.ibra.moviesseries.retrofit.video.VideoList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {



    @GET(Constant.TOP_RATED_MOVIES)
    public Call<MovieList> getTopReatedMovies();

    @GET(Constant.UPCOMING_MOVIES)
    public Call<MovieList> getUpcomingMovies();

    @GET(Constant.NOW_PLAYING_MOVIES)
    public Call<MovieList> getNowPlayingMovies();

    @GET(Constant.POPULAR_MOVIES)
    public Call<MovieList> getPopularMovies();


    @GET(Constant.TOP_RATED_TV)
    public Call<TvList> getTopReatedTv();

    @GET(Constant.UPCOMING_TV)
    public Call<TvList> getUpcomingTv();

    @GET(Constant.NOW_PLAYING_TV)
    public Call<TvList> getNowPlayingTv();

    @GET(Constant.POPULAR_TV)
    public Call<TvList> getPopularTv();

    @GET(Constant.MOVIE_CRIDIT)
    public Call<Credit> getMovieCridit(@Path("id") int id);

    @GET(Constant.MOVIE_VIDEO)
    public Call<VideoList> getMovieVideo(@Path("id") int id);


}
