package com.ibra.moviesseries.data.api;

import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.retrofit.credit.Credit;
import com.ibra.moviesseries.retrofit.show.ShowList;
import com.ibra.moviesseries.retrofit.video.VideoList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {



    @GET(Contract.LOAD_MOVIES)
    public Call<ShowList> getMovies(@Path("cat") String category);

    @GET(Contract.LOAD_TVS)
    public Call<ShowList> getTvShows(@Path("cat") String category);


    @GET(Contract.CRIDIT)
    public Call<Credit> getCridit(@Path("type") String type, @Path("id") int id);


    @GET(Contract.VIDEO)
    public Call<VideoList> getVideos(@Path("type") String type, @Path("id") int id);

    @GET(Contract.SEARCH)
    public Call<ShowList> serach(@Query("query") String name);


}
