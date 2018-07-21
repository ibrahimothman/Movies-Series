package com.ibra.moviesseries.adapter;

import android.content.Context;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.retrofit.show.Show;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TvAdapter extends ListAdapter {

    private List<Show> tvList;

    public TvAdapter(Context mContext, List<Show> tvList) {
        super(mContext);
        this.tvList = tvList;
    }



    @Override
    protected void bindViews(ListHolder listHolder, Context mContext, int position) {
        String posterUrl = tvList.get(position).getMoviePoster();
        String posterFullUrl = Constant.BASE_URL_IMAGE+"w185/"+posterUrl;
        String title = tvList.get(position).getTitle();

        // update list ui
        Picasso.with(mContext).load(posterFullUrl)
                .resizeDimen(R.dimen.poster_width_default,R.dimen.poster_height_default)
                .centerCrop()
                .into(listHolder.Image);
        listHolder.title.setText(title);
    }

    public void notifyAdapter(List<Show> tvList){
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
