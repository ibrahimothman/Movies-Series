package com.ibra.moviesseries.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.ibra.moviesseries.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.search_view)SearchView mSearchView;
    @BindView(R.id.toolbar)Toolbar mToolbar;
    @BindView(R.id.progress_bar)ProgressBar mProgressBar;
    @BindView(R.id.search_results)RecyclerView mSearchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}
