package com.ibra.moviesseries.retrofit.show;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Show implements Parcelable {


    @SerializedName("id")
    private int movieId;

    @SerializedName("vote_average")
    private double movieVoteAverage;

    @SerializedName(value = "title",alternate = "name")
    private String title;



    @SerializedName("poster_path")
    private String moviePoster;




    @SerializedName("backdrop_path")
    private String movieBackDropPoster;


    @SerializedName("overview")
    private String movieOverview;

    @SerializedName(value = "release_date",alternate = "first_air_date")
    private String releaseDate;


    public Show() {
    }

    protected Show(Parcel in) {
        movieId = in.readInt();
        movieVoteAverage = in.readDouble();
        title = in.readString();
        moviePoster = in.readString();
        movieBackDropPoster = in.readString();
        movieOverview = in.readString();
        releaseDate = in.readString();
    }


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public double getMovieVoteAverage() {
        return movieVoteAverage;
    }

    public void setMovieVoteAverage(double movieVoteAverage) {
        this.movieVoteAverage = movieVoteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieBackDropPoster() {
        return movieBackDropPoster;
    }

    public void setMovieBackDropPoster(String movieBackDropPoster) {
        this.movieBackDropPoster = movieBackDropPoster;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(movieId);
        dest.writeDouble(movieVoteAverage);
        dest.writeString(title);
        dest.writeString(moviePoster);
        dest.writeString(movieBackDropPoster);
        dest.writeString(movieOverview);
        dest.writeString(releaseDate);
    }

    public static final Creator<Show> CREATOR = new Creator<Show>() {
        @Override
        public Show createFromParcel(Parcel in) {
            return new Show(in);
        }

        @Override
        public Show[] newArray(int size) {
            return new Show[size];
        }
    };
}
