package com.ibra.moviesseries.data.api;

import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.retrofit.credit.Credit;
import com.ibra.moviesseries.retrofit.movie.MovieList;
import com.ibra.moviesseries.retrofit.tv.TvList;
import com.ibra.moviesseries.retrofit.video.VideoList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {



    @GET(Constant.LOAD_MOVIES)
    public Call<MovieList> getMovies(@Path("cat") String category);

    @GET(Constant.LOAD_TVS)
    public Call<TvList> getTvShows(@Path("cat") String category);


    @GET(Constant.MOVIE_CRIDIT)
    public Call<Credit> getMovieCridit(@Path("id") int id);

    @GET(Constant.MOVIE_VIDEO)
    public Call<VideoList> getMovieVideo(@Path("id") int id);


}
