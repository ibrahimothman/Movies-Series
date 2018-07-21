package com.ibra.moviesseries.fragment.tv;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.MovieAdapter;
import com.ibra.moviesseries.adapter.TvAdapter;
import com.ibra.moviesseries.fragment.BaseFragment;
import com.ibra.moviesseries.retrofit.movie.MovieList;
import com.ibra.moviesseries.retrofit.tv.Tv;
import com.ibra.moviesseries.retrofit.tv.TvList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseTvFragment extends BaseFragment {

    private static final String TAG = BaseTvFragment.class.getSimpleName();
    private List<Tv> tvList;
    private TvAdapter tvAdapter;

    @BindView(R.id.list) RecyclerView list;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list,container,false);

        ButterKnife.bind(this,view);

        tvAdapter = new TvAdapter(getContext(),tvList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),numberOfColumns());
        list.setLayoutManager(gridLayoutManager);
        list.setHasFixedSize(true);
        list.setAdapter(tvAdapter);


        loadData();


        return view;
    }


    public void loadData(){
        mProgressBar.setVisibility(View.VISIBLE);
        Call<TvList> call = getData();
        call.enqueue(new Callback<TvList>() {
            @Override
            public void onResponse(Call<TvList> call, Response<TvList> response) {
                if(response.isSuccessful() && response.body() != null){
                    mProgressBar.setVisibility(View.INVISIBLE);
                    tvList = response.body().getTvList();
                    tvAdapter.notifyAdapter(tvList);
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
