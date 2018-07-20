package com.ibra.moviesseries.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.VideoAdapter;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.credit.Credit;
import com.ibra.moviesseries.retrofit.movie.Movie;
import com.ibra.moviesseries.retrofit.video.Video;
import com.ibra.moviesseries.retrofit.video.VideoList;
import com.ibra.moviesseries.ui.DetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoFragment extends BaseFragment {

    private static final String TAG = VideoFragment.class.getSimpleName();

    private Movie movie;
    private List<Video> videoList;
    private VideoAdapter videoAdapter;



    public VideoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        videoAdapter = new VideoAdapter(getContext(),videoList);

        // get selected movie
        if(getActivity() != null){
            movie = ((DetailActivity)getActivity()).movie;
        }
        loadDate();
    }

    // load movie's videos
    private void loadDate() {
        Call<VideoList> call = ApiClinet.getApiClient().create(ApiInterface.class).getMovieVideo(movie.getMovieId());
        call.enqueue(new Callback<VideoList>() {
            @Override
            public void onResponse(Call<VideoList> call, Response<VideoList> response) {
                videoList = response.body().getVideoList();
                Log.d(TAG,videoList.get(0).getName());
                videoAdapter.notifyAdapter(videoList);
            }

            @Override
            public void onFailure(Call<VideoList> call, Throwable t) {
                Log.d("fromInfo","error is "+t.getLocalizedMessage());
            }
        });
    }

    @Override
    protected RecyclerView.Adapter getAdapter(Context mContext) {
        return videoAdapter;
    }


}
