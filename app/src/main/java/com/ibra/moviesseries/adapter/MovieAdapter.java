package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.content.Intent;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.retrofit.movie.Movie;
import com.ibra.moviesseries.ui.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public  class MovieAdapter extends ListAdapter  {

    private List<Movie> movieList;
    private Context mContext;

    public MovieAdapter(Context mContext, List<Movie>movieList) {
        super(mContext);
        this.mContext = mContext;
        this.movieList = movieList;
    }



    @Override
    protected void bindViews(ListHolder listHolder,Context mContext, int position) {
        String posterUrl = movieList.get(position).getMoviePoster();
        String posterFullUrl = Constant.BASE_URL_IMAGE+"w185/"+posterUrl;
        String title = movieList.get(position).getMovieTitle();

        // update list ui
        Picasso.with(mContext).load(posterFullUrl)
                .resizeDimen(R.dimen.poster_width_default,R.dimen.poster_height_default)
                .centerCrop()
                .into(listHolder.Image);
        listHolder.title.setText(title);
    }

    public void notifyAdapter(List<Movie> movieList){
        this.movieList = movieList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(movieList != null) return movieList.size();
        else return 0;
    }

    @Override
    protected void onViewClicked(int position) {
        Intent detailIntent = new Intent(mContext, DetailActivity.class);
        detailIntent.putExtra("movie",movieList.get(position));
        mContext.startActivity(detailIntent);

    }
}