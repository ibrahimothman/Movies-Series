package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.retrofit.show.Show;
import com.ibra.moviesseries.retrofit.show.ShowList;
import com.ibra.moviesseries.ui.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavViewHolder> {

    private Context mContext;
    private List<Show> showList;

    public FavouriteAdapter(Context mContext, List<Show> showList) {
        this.mContext = mContext;
        this.showList = showList;
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_fav,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (showList != null) return showList.size();
        else return 0;
    }

    public void swipCursor(List<Show> showList) {
        this.showList = showList;
        this.notifyDataSetChanged();
    }

    public Show getShow(int position){
        return showList.get(position);
    }

    public void remove(int position){
        showList.remove(position);
        this.notifyItemRemoved(position);
    }

    public void restore(Show show,int position){
        showList.add(position,show);
        this.notifyItemInserted(position);
    }

    class FavViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.title_fav)
        TextView title;
        @BindView(R.id.release_date_fav)
        TextView date;
        @BindView(R.id.rate_fav)
        TextView rate;
        @BindView(R.id.poster_fav)
        ImageView poster;
        int index;

        public FavViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }


        public void bind(int position) {
            index = position;
            Show show = showList.get(position);
            String showTitle = show.getTitle();
            String showDate = show.getReleaseDate();
            String showRate = String.valueOf(show.getMovieVoteAverage());
            String showPoster = show.getMoviePoster();
            int showId =  show.getMovieId();
            itemView.setTag(showId);

            title.setText(showTitle);
            date.setText(mContext.getString(R.string.text,mContext.getString(R.string.released_on),showDate));
            rate.setText(mContext.getString(R.string.text,showRate,R.string.percentage));
            Picasso.with(mContext).load(Contract.BASE_URL_IMAGE+showPoster).into(poster);
        }



        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext,DetailActivity.class);
            intent.putExtra("show",showList.get(index));
            intent.putExtra("type","movie");
            mContext.startActivity(intent);
        }


    }
}