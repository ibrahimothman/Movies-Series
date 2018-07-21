package com.ibra.moviesseries.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.CastAdapter;
import com.ibra.moviesseries.adapter.ListAdapter;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.credit.Cast;
import com.ibra.moviesseries.retrofit.credit.Credit;
import com.ibra.moviesseries.retrofit.show.Show;
import com.ibra.moviesseries.ui.DetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CastFragment extends BaseDetailFragment {

    private static final String TAG = CastFragment.class.getSimpleName();
    @BindView(R.id.list)
    RecyclerView mList;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;


    private CastAdapter mCastAdapter;
    private List<Cast> castList;


    public CastFragment() {
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list,container,false);
        ButterKnife.bind(this,view);

        loadData();

        return view;
    }


    @Override
    protected void updateUi() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),numberOfColumns());
        mList.setLayoutManager(gridLayoutManager);
        mCastAdapter = new CastAdapter(getContext(),credit.getCastCrewList().getCastList());
        mList.setAdapter(mCastAdapter);
    }




}
