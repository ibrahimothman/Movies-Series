package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.view.View;

import com.ibra.moviesseries.retrofit.show.Show;

import java.util.List;

public class SimilarAdapter extends ShowAdapter {
    public SimilarAdapter(Context mContext, List<Show> showList) {
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

    }


}
