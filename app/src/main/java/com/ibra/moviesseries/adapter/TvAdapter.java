package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.view.View;

import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.model.Movie;
import com.ibra.moviesseries.model.Tv;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TvAdapter extends ListAdapter {

    private List<Tv> tvList;

    public TvAdapter(Context mContext, List<Tv> tvList) {
        super(mContext);
        this.tvList = tvList;
    }



    @Override
    protected void bindViews(ListHolder listHolder, Context mContext, int position) {
        String posterUrl = tvList.get(position).getTvPoster();
        String posterFullUrl = Contract.BASE_URL_IMAGE+"w185/"+posterUrl;
        String title = tvList.get(position).getTvTitle();

        // update list ui
        Picasso.with(mContext).load(posterFullUrl).into(listHolder.posterImage);
        listHolder.titleTextview.setText(title);
    }

    public void notifyAdapter(List<Tv> tvList){
        this.tvList = tvList;
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if(tvList != null)
          return tvList.size();
        else return 0;
    }

    @Override
    protected void onViewClicked(int position) {

    }
}
