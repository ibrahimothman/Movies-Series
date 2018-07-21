package com.ibra.moviesseries.data.api;

import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.retrofit.credit.Credit;
import com.ibra.moviesseries.retrofit.show.ShowList;
import com.ibra.moviesseries.retrofit.video.VideoList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {



    @GET(Constant.LOAD_MOVIES)
    public Call<ShowList> getMovies(@Path("cat") String category);

    @GET(Constant.LOAD_TVS)
    public Call<ShowList> getTvShows(@Path("cat") String category);


    @GET(Constant.CRIDIT)
    public Call<Credit> getCridit(@Path("type") String type, @Path("id") int id);


}
