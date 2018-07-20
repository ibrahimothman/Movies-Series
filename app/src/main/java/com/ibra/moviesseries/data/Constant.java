package com.ibra.moviesseries.data;

public class Constant {

    public static final String API_KEY = "b74d1d1ae9314a57ace0a639dfff09ef";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";


    public static final String TOP_RATED_MOVIES = BASE_URL+"movie/top_rated?api_key="+API_KEY;
    public static final String UPCOMING_MOVIES = BASE_URL+"movie/upcoming?api_key="+API_KEY;
    public static final String NOW_PLAYING_MOVIES = BASE_URL+"movie/now_playing?api_key="+API_KEY;
    public static final String POPULAR_MOVIES = BASE_URL+"movie/popular?api_key="+API_KEY;

    public static final String TOP_RATED_TV = BASE_URL+"tv/top_rated?api_key="+API_KEY;
    public static final String UPCOMING_TV = BASE_URL+"tv/airing_today?api_key="+API_KEY;
    public static final String NOW_PLAYING_TV = BASE_URL+"tv/on_the_air?api_key="+API_KEY;
    public static final String POPULAR_TV = BASE_URL+"tv/popular?api_key="+API_KEY;

    public static final String MOVIE_CRIDIT = BASE_URL+"movie/{id}?api_key="+API_KEY+"&append_to_response=credits";

    public static final String MOVIE_VIDEO = BASE_URL+"movie/{id}/videos?api_key="+API_KEY;



    public static final String BASE_URL_IMAGE = "http://image.tmdb.org/t/p/";


}
