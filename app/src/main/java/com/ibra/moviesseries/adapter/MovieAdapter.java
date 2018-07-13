package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {



    private Context mContext;
    private List<Movie> movieList;

    public MovieAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;

    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieHolder(LayoutInflater.from(mContext)
                                .inflate(R.layout.item_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void notifyAdapter(List<Movie>movieList){
        this.movieList = movieList;
        this.notifyDataSetChanged();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.poster_imageview)ImageView poster;
        @BindView(R.id.title_textview)TextView title;
        public MovieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(int position) {
            String movie_poster = Contract.BASE_URL_IMAGE+"/w185"+movieList.get(position).getMoviePoster();
            Picasso.with(mContext).load(movie_poster)
                    .into(poster);

            title.setText(movieList.get(position).getMovieTitle());
        }
    }
}
