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

public class MovieAdapter extends ShowAdapter  {

    public MovieAdapter(Context mContext, List<Show> showList) {
        super(mContext, showList);
    }

    @Override
    protected int setPlayImageVisibility() {
        return View.GONE;
    }

    @Override
    protected int setJopVisibility() {
        return View.GONE;
    }

    @Override
    protected void onViewClick(Context context, Show show) {
        Intent intent = new Intent(context,DetailActivity.class);
        intent.putExtra("show",show);
        intent.putExtra("type","movie");
        context.startActivity(intent);
    }


}