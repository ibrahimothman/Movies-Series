package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.retrofit.show.Show;
import com.ibra.moviesseries.ui.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public abstract class ShowAdapter extends ListAdapter {

    private List<Show> showList;
    private Context mContext;

    public ShowAdapter(Context mContext,List<Show> showList) {
        super(mContext);
        this.mContext = mContext;
        this.showList = showList;
    }



    @Override
    protected void bindViews(ListHolder listHolder, Context mContext, int position) {
        String posterUrl = showList.get(position).getMoviePoster();
        String posterFullUrl = Constant.BASE_URL_IMAGE+"w185/"+posterUrl;
        String title = showList.get(position).getTitle();

        // update list ui
        Picasso.with(mContext).load(posterFullUrl)
                .resizeDimen(R.dimen.poster_width_default,R.dimen.poster_height_default)
                .centerCrop()
                .into(listHolder.Image);
        listHolder.title.setText(title);
        listHolder.job.setVisibility(setJopVisibility());
        listHolder.playImage.setVisibility(setPlayImageVisibility());
    }

    protected abstract int setPlayImageVisibility();

    protected abstract int setJopVisibility();

    @Override
    public int getItemCount() {
        if(showList != null) return showList.size();
        else return 0;
    }

    public void notifyAdapter(List<Show> movieList){
        this.showList = movieList;
        this.notifyDataSetChanged();
    }

    @Override
    protected void onViewClicked(int position) {
        onViewClick(mContext,showList.get(position));
    }

    protected abstract void onViewClick(Context context, Show show);


}
