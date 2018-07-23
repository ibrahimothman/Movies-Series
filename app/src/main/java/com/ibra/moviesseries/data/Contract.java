package com.ibra.moviesseries.data;

import android.net.Uri;
import android.provider.BaseColumns;

import java.net.URI;

public class Contract {

    public static final String NOW_PALYING = "now_playing";
    public static final String UPCOMING = "upcoming";
    public static final String TOP_RATED = "top_rated";
    public static final String POPULAR = "popular";
    public static final String ON_THE_AIR = "on_the_air";
    public static final String AIRING_TODAY = "airing_today";
    public static final String API_KEY = "b74d1d1ae9314a57ace0a639dfff09ef";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String LOAD_MOVIES = BASE_URL+"movie/{cat}?api_key="+API_KEY;
    public static final String LOAD_TVS = BASE_URL+"tv/{cat}?api_key="+API_KEY;
    public static final String CRIDIT = BASE_URL+"{type}/{id}?api_key="+API_KEY+"&append_to_response=credits,videos,similar";
    public static final String VIDEO = BASE_URL+"{type}/{id}/videos?api_key="+API_KEY;
    public static final String BASE_URL_IMAGE = "http://image.tmdb.org/t/p/";


    public static final String AUTHORITY = "com.examole.android.movieseries";
    public static final Uri BASE_URI = Uri.parse("content://"+AUTHORITY);
    public static final String PATH = "favourite";

    public static class FavEntry implements BaseColumns{
        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();
        public static final String TABLE_NAME = "fav_table";
        public static final String TITLE_COL = "fav_title";
        public static final String RATE_COL = "fav_rate";
        public static final String OVERVIEW_COL = "fav_overview";
        public static final String RELEASE_DATE_COL = "fav_release_date";
        public static final String TRAILER_COL = "fav_trailr";
        public static final String POSTER_COL = "fav_movie_poster";

    }


}
