package com.ibra.moviesseries.adapter;

import android.content.Context;
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
        cursor.moveToFirst();
        cursor.moveToPosition(position);
        String showTitle = cursor.getString(cursor.getColumnIndex(Contract.FavEntry.TITLE_COL));
        String showDate = cursor.getString(cursor.getColumnIndex(Contract.FavEntry.RELEASE_DATE_COL));
        String showRate = cursor.getString(cursor.getColumnIndex(Contract.FavEntry.RATE_COL));
        String showPoster = cursor.getString(cursor.getColumnIndex(Contract.FavEntry.POSTER_COL));

        holder.title.setText(showTitle);
        holder.date.setText("Released on : "+showDate);
        holder.rate.setText(showRate+" / 10");
        Picasso.with(mContext).load(Contract.BASE_URL_IMAGE+"w185/"+showPoster).into(holder.poster);
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


    class FavViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title_fav)
        TextView title;
        @BindView(R.id.release_date_fav)
        TextView date;
        @BindView(R.id.rate_fav)
        TextView rate;
        @BindView(R.id.poster_fav)
        ImageView poster;

        public FavViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
