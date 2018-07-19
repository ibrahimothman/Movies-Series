package com.ibra.moviesseries.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie implements Parcelable {

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


    protected Movie(Parcel in) {
        movieVoteCount = in.readInt();
        movieId = in.readInt();
        videoExist = in.readByte() != 0;
        movieVoteAverage = in.readDouble();
        movieTitle = in.readString();
        moviePopularity = in.readDouble();
        moviePoster = in.readString();
        movieLanguage = in.readString();
        movieOriginalTitle = in.readString();
        movieBackDropPoster = in.readString();
        movieIsAdult = in.readByte() != 0;
        movieOverview = in.readString();
        movieReleaseDate = in.readString();
    }



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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(movieVoteCount);
        dest.writeInt(movieId);
        dest.writeByte((byte) (videoExist ? 1 : 0));
        dest.writeDouble(movieVoteAverage);
        dest.writeString(movieTitle);
        dest.writeDouble(moviePopularity);
        dest.writeString(moviePoster);
        dest.writeString(movieLanguage);
        dest.writeString(movieOriginalTitle);
        dest.writeString(movieBackDropPoster);
        dest.writeByte((byte) (movieIsAdult ? 1 : 0));
        dest.writeString(movieOverview);
        dest.writeString(movieReleaseDate);
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
