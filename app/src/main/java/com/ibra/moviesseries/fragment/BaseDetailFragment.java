package com.ibra.moviesseries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.credit.Credit;
import com.ibra.moviesseries.retrofit.show.Show;
import com.ibra.moviesseries.ui.DetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseDetailFragment extends BaseFragment {

    public Show show;
    public String type;
    public Credit credit;

    public BaseDetailFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get some info from detail activity
        if(getActivity() != null){
            show = ((DetailActivity)getActivity()).show;
            type = ((DetailActivity)getActivity()).type;
        }

        loadData();
    }

    public void loadData() {
        Call<Credit> call = ApiClinet.getApiClient().create(ApiInterface.class).getCridit(type,show.getMovieId());
        call.enqueue(new Callback<Credit>() {
            @Override
            public void onResponse(Call<Credit> call, Response<Credit> response) {
                credit =  response.body();
                updateUi();

            }

            @Override
            public void onFailure(Call<Credit> call, Throwable t) {
                Log.d(getTag(),"error "+t.getLocalizedMessage());
            }
        });
    }

    protected abstract void updateUi();
}
