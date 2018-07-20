package com.ibra.moviesseries.adapter;

import android.content.Context;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.retrofit.tv.Tv;
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
        String posterFullUrl = Constant.BASE_URL_IMAGE+"w185/"+posterUrl;
        String title = tvList.get(position).getTvTitle();

        // update list ui
        Picasso.with(mContext).load(posterFullUrl)
                .resizeDimen(R.dimen.poster_width_default,R.dimen.poster_height_default)
                .centerCrop()
                .into(listHolder.Image);
        listHolder.title.setText(title);
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
