package com.ibra.moviesseries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("vote_count")
    private int movieVoteCount;

    @SerializedName("id")
    private int movieId;

    @SerializedName("video")
    private boolean videoExist;

    @SerializedName("vote_average")
    private double movieVoteAverage;

    @SerializedName("title")
    private String movieTitle;

    @SerializedName("popularity")
    private double moviePopularity;

    @SerializedName("poster_path")
    private String moviePoster;

    @SerializedName("original_language")
    private String movieLanguage;

    @SerializedName("original_title")
    private String movieOriginalTitle;

    @SerializedName("backdrop_path")
    private String movieBackDropPoster;


    @SerializedName("adult")
    private boolean movieIsAdult;


    @SerializedName("overview")
    private String movieOverview;

    @SerializedName("release_date")
    private String movieReleaseDate;

    @SerializedName("genre_ids")
    private List<Double> movieGenreList;


    public int getMovieVoteCount() {
        return movieVoteCount;
    }

    public void setMovieVoteCount(int movieVoteCount) {
        this.movieVoteCount = movieVoteCount;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public boolean isVideoExist() {
        return videoExist;
    }

    public void setVideoExist(boolean videoExist) {
        this.videoExist = videoExist;
    }

    public double getMovieVoteAverage() {
        return movieVoteAverage;
    }

    public void setMovieVoteAverage(double movieVoteAverage) {
        this.movieVoteAverage = movieVoteAverage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public double getMoviePopularity() {
        return moviePopularity;
    }

    public void setMoviePopularity(double moviePopularity) {
        this.moviePopularity = moviePopularity;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getMovieOriginalTitle() {
        return movieOriginalTitle;
    }

    public void setMovieOriginalTitle(String movieOriginalTitle) {
        this.movieOriginalTitle = movieOriginalTitle;
    }

    public String getMovieBackDropPoster() {
        return movieBackDropPoster;
    }

    public void setMovieBackDropPoster(String movieBackDropPoster) {
        this.movieBackDropPoster = movieBackDropPoster;
    }

    public boolean isMovieIsAdult() {
        return movieIsAdult;
    }

    public void setMovieIsAdult(boolean movieIsAdult) {
        this.movieIsAdult = movieIsAdult;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public List<Double> getMovieGenreList() {
        return movieGenreList;
    }

    public void setMovieGenreList(List<Double> movieGenreList) {
        this.movieGenreList = movieGenreList;
    }
}
