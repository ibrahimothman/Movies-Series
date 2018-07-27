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
import com.ibra.moviesseries.ui.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavViewHolder> {

    private Context mContext;
    private Cursor cursor;

    public FavouriteAdapter(Context mContext, Cursor cursor) {
        this.mContext = mContext;
        this.cursor = cursor;
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
        if (cursor != null) return cursor.getCount();
        else return 0;
    }

    public void swipCursor(Cursor cursor) {
        this.cursor = cursor;
        this.notifyDataSetChanged();
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
            cursor.moveToFirst();
            cursor.moveToPosition(position);
            String showTitle = cursor.getString(cursor.getColumnIndex(Contract.FavEntry.TITLE_COL));
            String showDate = cursor.getString(cursor.getColumnIndex(Contract.FavEntry.RELEASE_DATE_COL));
            String showRate = cursor.getString(cursor.getColumnIndex(Contract.FavEntry.RATE_COL));
            String showPoster = cursor.getString(cursor.getColumnIndex(Contract.FavEntry.POSTER_COL));
            String showId =  cursor.getString(cursor.getColumnIndex(Contract.FavEntry._ID));
            itemView.setTag(showId);

            title.setText(showTitle);
            date.setText("Released on : "+showDate);
            rate.setText(showRate+" / 10");
            Picasso.with(mContext).load(Contract.BASE_URL_IMAGE+"w185/"+showPoster).into(poster);
        }

        @Override
        public void onClick(View view) {
            Show show = new Show();
            cursor.moveToPosition(index);
            show.setMovieId(cursor.getInt(cursor.getColumnIndex(Contract.FavEntry._ID)));
            show.setMovieOverview(cursor.getString(cursor.getColumnIndex(Contract.FavEntry.OVERVIEW_COL)));
            show.setMoviePoster(cursor.getString(cursor.getColumnIndex(Contract.FavEntry.POSTER_COL)));
            show.setMovieVoteAverage(cursor.getInt(cursor.getColumnIndex(Contract.FavEntry.RATE_COL)));
            show.setTitle(cursor.getString(cursor.getColumnIndex(Contract.FavEntry.TITLE_COL)));
            show.setReleaseDate(cursor.getString(cursor.getColumnIndex(Contract.FavEntry.RELEASE_DATE_COL)));


            Intent intent = new Intent(mContext,DetailActivity.class);
            intent.putExtra("show",show);
            intent.putExtra("type","movie");
            mContext.startActivity(intent);
        }


    }
}
