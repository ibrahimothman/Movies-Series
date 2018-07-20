package com.ibra.moviesseries.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ibra.moviesseries.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public abstract class BaseFragment extends Fragment {

    @BindView(R.id.list)RecyclerView list;


    public BaseFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list,container,false);
        ButterKnife.bind(this,view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),numberOfColumns());
        list.setLayoutManager(gridLayoutManager);
        list.setHasFixedSize(true);
        list.setAdapter(getAdapter(getContext()));

        return view;
    }

    protected abstract RecyclerView.Adapter getAdapter(Context mContext);

    private int numberOfColumns() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthDivider = 600;
        int width = displayMetrics.widthPixels;
        int nColumns = width / widthDivider;
        if (nColumns < 3) {
            return 3;
        }
        return nColumns;
    }

}
