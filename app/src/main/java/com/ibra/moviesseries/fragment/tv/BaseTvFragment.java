package com.ibra.moviesseries.fragment.tv;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ibra.moviesseries.adapter.TvAdapter;
import com.ibra.moviesseries.fragment.BaseFragment;
import com.ibra.moviesseries.retrofit.tv.Tv;
import com.ibra.moviesseries.retrofit.tv.TvList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseTvFragment extends BaseFragment {

    private static final String TAG = BaseTvFragment.class.getSimpleName();
    private List<Tv> tvList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        Call<TvList> call = getData();
        call.enqueue(new Callback<TvList>() {
            @Override
            public void onResponse(Call<TvList> call, Response<TvList> response) {
                if(response.isSuccessful() && response.body() != null){
                    tvList = response.body().getTvList();
                }
            }

            @Override
            public void onFailure(Call<TvList> call, Throwable t) {
                Log.d(TAG,"error is "+t.getLocalizedMessage());
            }
        });


    }

    protected abstract Call<TvList> getData();


}
