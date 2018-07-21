package com.ibra.moviesseries.data;

public class Constant {

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


    public static final String CRIDIT = BASE_URL+"{type}/{id}?api_key="+API_KEY+"&append_to_response=credits";
    public static final String VIDEO = BASE_URL+"{type}/{id}/videos?api_key="+API_KEY;





    public static final String BASE_URL_IMAGE = "http://image.tmdb.org/t/p/";


}
