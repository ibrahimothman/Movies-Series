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

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.CastAdapter;
import com.ibra.moviesseries.adapter.VideoAdapter;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.event.Event;
import com.ibra.moviesseries.retrofit.credit.Cast;
import com.ibra.moviesseries.retrofit.movie.Movie;
import com.ibra.moviesseries.retrofit.video.VideoList;
import com.ibra.moviesseries.ui.DetailActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CastFragment extends BaseFragment {


}