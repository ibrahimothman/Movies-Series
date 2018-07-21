package com.ibra.moviesseries.fragment.tv;

import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.show.ShowList;

import retrofit2.Call;

public class TopRatedTvFragment extends BaseTvFragment {


    @Override
    protected Call<ShowList> getData() {
        return ApiClinet.getApiClient().create(ApiInterface.class).getTvShows(Constant.TOP_RATED);    }
}
