package com.ibra.moviesseries.retrofit.credit;

import com.google.gson.annotations.SerializedName;
import com.ibra.moviesseries.retrofit.genre.Genre;

import java.util.List;

public class Credit {

    @SerializedName("genres")
    private List<Genre> genres;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("title")
    private String title;


    @SerializedName("vote_average")
    private double voteAverage;


    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompany;

    @SerializedName("production_countries")
    private List<Productioncountry> productionCountries;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("runtime")
    private double duration;

    @SerializedName("status")
    private String status;

    @SerializedName("credits")
    private CastCrowList castCrewList;

    @SerializedName("overview")
    public String overview;



    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<ProductionCompany> getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(List<ProductionCompany> productionCompany) {
        this.productionCompany = productionCompany;
    }

    public List<Productioncountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<Productioncountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CastCrowList getCastCrewList() {
        return castCrewList;
    }

    public void setCastCrewList(CastCrowList castCrewList) {
        this.castCrewList = castCrewList;
    }
}
