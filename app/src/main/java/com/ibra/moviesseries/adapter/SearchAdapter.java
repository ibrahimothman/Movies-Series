package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.content.Intent;
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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SeacrhViewHolder> {

    List<Show> showList;
    Context mContext;

    public SearchAdapter(Context mContext,List<Show>showList ) {
        this.showList = showList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SeacrhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SeacrhViewHolder(LayoutInflater.from(mContext)
        .inflate(R.layout.item_fav,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SeacrhViewHolder holder, final int position) {
        holder.title.setText(showList.get(position).getTitle());
        holder.rate.setText(showList.get(position).getMovieVoteAverage()+" / 10");
        holder.date.setText(showList.get(position).getReleaseDate());
        Picasso.with(mContext).load(Contract.BASE_URL_IMAGE+showList.get(position).getMoviePoster())
        .into(holder.poster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(mContext, DetailActivity.class);
                detailIntent.putExtra("show",showList.get(position));
                detailIntent.putExtra("type","movie");
                mContext.startActivity(detailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
       if(showList != null) return showList.size();
       else return 0;
    }

    public void notifiy(List<Show>showList){
        this.showList = showList;
        this.notifyDataSetChanged();
    }

    class SeacrhViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title_fav)
        TextView title;
        @BindView(R.id.release_date_fav)
        TextView date;
        @BindView(R.id.rate_fav)
        TextView rate;
        @BindView(R.id.poster_fav)
        ImageView poster;
        public SeacrhViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
