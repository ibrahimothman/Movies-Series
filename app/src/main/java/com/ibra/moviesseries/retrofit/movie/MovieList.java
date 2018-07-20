package com.ibra.moviesseries.retrofit.movie;

import com.google.gson.annotations.SerializedName;
import com.ibra.moviesseries.retrofit.movie.Movie;

import java.util.List;

public class MovieList {

    @SerializedName("results")
    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
