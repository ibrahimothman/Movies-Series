package com.ibra.moviesseries.fragment.tv;

import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.tv.TvList;

import retrofit2.Call;

public class AiringTodayFragment extends BaseTvFragment {
    @Override
    protected Call<TvList> getData() {
        return ApiClinet.getApiClient().create(ApiInterface.class).getTvShows(Constant.AIRING_TODAY);
    }
}
