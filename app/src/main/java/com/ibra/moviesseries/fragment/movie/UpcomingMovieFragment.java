package com.ibra.moviesseries.fragment.movie;

import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.show.ShowList;

import retrofit2.Call;

public class UpcomingMovieFragment extends BaseMovieFragment  {


    @Override
    protected Call<ShowList> getData() {
        return ApiClinet.getApiClient().create(ApiInterface.class).getMovies(Contract.UPCOMING);    }
}
