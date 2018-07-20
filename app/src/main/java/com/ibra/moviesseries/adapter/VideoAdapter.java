package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.retrofit.video.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends ListAdapter {

    private List<Video> videoList;
    private Context mContext;

    public VideoAdapter(Context mContext,List<Video> videoList) {
        super(mContext);
        this.videoList = videoList;
        this.mContext = mContext;
    }


    @Override
    protected void bindViews(ListHolder listHolder, Context mContext, int position) {
        Picasso.with(mContext)
                .load("https://img.youtube.com/vi/"+videoList.get(position).getKey()+"/1.jpg")
                .resizeDimen(R.dimen.poster_width_default,R.dimen.poster_height_default)
                .centerCrop()
                .into(listHolder.Image);

        listHolder.playImage.setVisibility(View.VISIBLE);
        listHolder.title.setText(videoList.get(position).getName());
        Log.d("fromVidAdapter",videoList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if(videoList != null) return videoList.size();
        else return 0;
    }

    @Override
    protected void onViewClicked(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v="+videoList.get(position).getKey());
        Intent playTrailerIntent = new Intent(Intent.ACTION_VIEW,uri);
        if(playTrailerIntent.resolveActivity(mContext.getPackageManager()) != null) {
            mContext.startActivity(playTrailerIntent);
        }
    }

    public void notifyAdapter(List<Video> videoList) {
        this.videoList = videoList;
        this.notifyDataSetChanged();
    }


}
