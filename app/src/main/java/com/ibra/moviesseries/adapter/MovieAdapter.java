package com.ibra.moviesseries.adapter;

import android.content.Context;

import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public  class MovieAdapter extends ListAdapter  {

    private List<Movie> movieList;

    public MovieAdapter(Context mContext, List<Movie>movieList) {
        super(mContext);
        this.movieList = movieList;
    }

    @Override
    protected void bindViews(ListHolder listHolder,Context mContext, int position) {
        String posterUrl = movieList.get(position).getMoviePoster();
        String posterFullUrl = Contract.BASE_URL_IMAGE+"w185/"+posterUrl;
        String title = movieList.get(position).getMovieTitle();

        // update list ui
        Picasso.with(mContext).load(posterFullUrl).into(listHolder.posterImage);
        listHolder.titleTextview.setText(title);
    }

    public void notifyAdapter(List<Movie> movieList){
        this.movieList = movieList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}