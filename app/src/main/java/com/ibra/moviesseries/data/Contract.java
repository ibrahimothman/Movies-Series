package com.ibra.moviesseries.data;

public class Contract {

    public static final String API_KEY = "b74d1d1ae9314a57ace0a639dfff09ef";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static final String TOP_RATED_MOVIES = BASE_URL+"movie/top_rated?api_key="+API_KEY;
    public static final String UPCOMING_MOVIES = BASE_URL+"movie/upcoming?api_key="+API_KEY;
    public static final String NOW_PLAYING_MOVIES = BASE_URL+"movie/now_playing?api_key="+API_KEY;
    public static final String POPULAR_MOVIES = BASE_URL+"movie/popular?api_key="+API_KEY;


    public static final String BASE_URL_IMAGE = "http://image.tmdb.org/t/p/";


}
