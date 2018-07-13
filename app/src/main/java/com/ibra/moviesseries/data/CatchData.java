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
import com.ibra.moviesseries.adapter.MovieAdapter;
import com.ibra.moviesseries.model.Movie;
import com.ibra.moviesseries.model.MovieList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CatchData extends Fragment {

    RecyclerView list;


    private MovieAdapter movieAdapter;
    private List<Movie> movieList = new ArrayList<>();



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

        list = (RecyclerView)row.findViewById(R.id.list);

        movieAdapter = new MovieAdapter(getContext(),movieList);
        list.setLayoutManager(new GridLayoutManager(getContext(),3));
        list.setHasFixedSize(true);
        list.setAdapter(movieAdapter);


        Call<MovieList> call = getData();
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(@NonNull Call<MovieList> call, @NonNull Response<MovieList> response) {
                if(response.body() != null) {
                    movieAdapter.notifyAdapter(response.body().getMovieList());
                }
                else Toast.makeText(getContext(), getString(R.string.error_message), Toast.LENGTH_LONG).show();;

            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.d("fromApi",t.getLocalizedMessage());
            }
        });
        return row;
    }

    protected abstract Call<MovieList> getData();
}
