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

public  class MovieAdapter extends ListAdapter  {

    private List<Show> showList;
    private Context mContext;

    public MovieAdapter(Context mContext, List<Show>showList) {
        super(mContext);
        this.mContext = mContext;
        this.showList = showList;
    }



    @Override
    protected void bindViews(ListHolder listHolder,Context mContext, int position) {
        String posterUrl = showList.get(position).getMoviePoster();
        String posterFullUrl = Constant.BASE_URL_IMAGE+"w185/"+posterUrl;
        String title = showList.get(position).getTitle();

        // update list ui
        Picasso.with(mContext).load(posterFullUrl)
                .resizeDimen(R.dimen.poster_width_default,R.dimen.poster_height_default)
                .centerCrop()
                .into(listHolder.Image);
        listHolder.title.setText(title);
        listHolder.job.setVisibility(View.GONE);
        listHolder.playImage.setVisibility(View.GONE);
    }

    public void notifyAdapter(List<Show> movieList){
        this.showList = movieList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(showList != null) return showList.size();
        else return 0;
    }

    @Override
    protected void onViewClicked(int position) {
        Intent detailIntent = new Intent(mContext, DetailActivity.class);
        detailIntent.putExtra("show",showList.get(position));
        detailIntent.putExtra("type","movie");
        mContext.startActivity(detailIntent);

    }
}