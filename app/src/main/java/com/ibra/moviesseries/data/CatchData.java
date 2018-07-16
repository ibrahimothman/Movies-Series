package com.ibra.moviesseries.data;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.ListAdapter;

import com.ibra.moviesseries.adapter.MovieAdapter;
import com.ibra.moviesseries.adapter.TvAdapter;
import com.ibra.moviesseries.model.Movie;
import com.ibra.moviesseries.model.MovieList;
import com.ibra.moviesseries.model.Tv;
import com.ibra.moviesseries.model.TvList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CatchData extends Fragment {

    RecyclerView list;



    private MovieAdapter movieAdapter;
    private TvAdapter tvAdapter;
    private List<Movie> movieList = new ArrayList<>();
    private List<Tv> tvList = new ArrayList<>();


    public CatchData() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View row = inflater.inflate(R.layout.list,container,false);

        // setup recycler view
        list = (RecyclerView)row.findViewById(R.id.list);
        movieAdapter = new MovieAdapter(getContext(),movieList);
        tvAdapter = new TvAdapter(getContext(),tvList);

        list.setLayoutManager(new GridLayoutManager(getContext(),3));
        list.setHasFixedSize(true);


        loadData();


        return row;
    }

    private void loadData() {
        Call call = getData();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                if(response.body() != null){
                    Object obj = response.body().getClass();
                    if(obj == MovieList.class){
                        list.setAdapter(movieAdapter);
                        movieList = ((MovieList)response.body()).getMovieList();
                        movieAdapter.notifyAdapter(movieList);
                        Log.d("fromCatchData","movieList size is "+movieList.size());
                    }else if(obj == TvList.class){
                        list.setAdapter(tvAdapter);
                        tvList = ((TvList)response.body()).getTvList();
                        tvAdapter.notifyAdapter(tvList);
                        Log.d("fromCatchData","tvList size is "+tvList.size());

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull Throwable t) {
                Log.d("fromCatchData","error is "+t.getLocalizedMessage());
            }
        });
    }


    protected abstract <T> Call<T> getData();

}
