package com.ibra.moviesseries.retrofit.tv;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tv {

    @SerializedName("original_name")
    private String tvOriginalTitle;

    @SerializedName("genre_ids")
    private List<Double> tvGenreList;

    @SerializedName("name")
    private String tvTitle;

    @SerializedName("popularity")
    private double tvPopularity;

    @SerializedName("origin_country")
    private List<String> tvOriginCountry;



    @SerializedName("vote_count")
    private int tvVoteCount;

    @SerializedName("first_air_date")
    private String tvFirstAirDate;

    @SerializedName("backdrop_path")
    private String tvBackDropPoster;

    @SerializedName("original_language")
    private String tvLanguage;

    @SerializedName("id")
    private int tvId;

    @SerializedName("vote_average")
    private double tvVoteAverage;

    @SerializedName("overview")
    private String tvOverview;

    @SerializedName("poster_path")
    private String tvPoster;


    public String getTvOriginalTitle() {
        return tvOriginalTitle;
    }

    public void setTvOriginalTitle(String tvOriginalTitle) {
        this.tvOriginalTitle = tvOriginalTitle;
    }

    public List<Double> getTvGenreList() {
        return tvGenreList;
    }

    public void setTvGenreList(List<Double> tvGenreList) {
        this.tvGenreList = tvGenreList;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    public double getTvPopularity() {
        return tvPopularity;
    }

    public void setTvPopularity(double tvPopularity) {
        this.tvPopularity = tvPopularity;
    }

    public List<String> getTvOriginCountry() {
        return tvOriginCountry;
    }

    public void setTvOriginCountry(List<String> tvOriginCountry) {
        this.tvOriginCountry = tvOriginCountry;
    }

    public int getTvVoteCount() {
        return tvVoteCount;
    }

    public void setTvVoteCount(int tvVoteCount) {
        this.tvVoteCount = tvVoteCount;
    }

    public String getTvFirstAirDate() {
        return tvFirstAirDate;
    }

    public void setTvFirstAirDate(String tvFirstAirDate) {
        this.tvFirstAirDate = tvFirstAirDate;
    }

    public String getTvBackDropPoster() {
        return tvBackDropPoster;
    }

    public void setTvBackDropPoster(String tvBackDropPoster) {
        this.tvBackDropPoster = tvBackDropPoster;
    }

    public String getTvLanguage() {
        return tvLanguage;
    }

    public void setTvLanguage(String tvLanguage) {
        this.tvLanguage = tvLanguage;
    }

    public int getTvId() {
        return tvId;
    }

    public void setTvId(int tvId) {
        this.tvId = tvId;
    }

    public double getTvVoteAverage() {
        return tvVoteAverage;
    }

    public void setTvVoteAverage(double tvVoteAverage) {
        this.tvVoteAverage = tvVoteAverage;
    }

    public String getTvOverview() {
        return tvOverview;
    }

    public void setTvOverview(String tvOverview) {
        this.tvOverview = tvOverview;
    }

    public String getTvPoster() {
        return tvPoster;
    }

    public void setTvPoster(String tvPoster) {
        this.tvPoster = tvPoster;
    }
}
