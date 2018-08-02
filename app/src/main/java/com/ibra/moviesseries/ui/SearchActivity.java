package com.ibra.moviesseries.ui;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.MovieAdapter;
import com.ibra.moviesseries.adapter.SearchAdapter;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.show.Show;
import com.ibra.moviesseries.retrofit.show.ShowList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = SearchActivity.class.getSimpleName();
    @BindView(R.id.search_view)SearchView mSearchView;
    @BindView(R.id.toolbar)Toolbar mToolbar;
    @BindView(R.id.progress_bar)ProgressBar mProgressBar;
    @BindView(R.id.search_results)RecyclerView mSearchList;

    SearchAdapter searchAdapter;
    List<Show> showList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);


        Intent intent = getIntent();
        String query = intent.getStringExtra(SearchManager.QUERY);
        Log.d(TAG,"query is "+query);

        mSearchView.setOnQueryTextListener(this);
        mSearchList.setLayoutManager(new LinearLayoutManager(this));
        searchAdapter = new SearchAdapter(this,showList);
        mSearchList.setAdapter(searchAdapter);
        mSearchList.setHasFixedSize(true);




    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(TAG,newText.toLowerCase());
        startLoading(newText.toLowerCase());
        return true;
    }

    private void startLoading(String s) {
        mProgressBar.setVisibility(View.VISIBLE);
        Call<ShowList> call = ApiClinet.getApiClient().create(ApiInterface.class).serach(s);
        call.enqueue(new Callback<ShowList>() {
            @Override
            public void onResponse(Call<ShowList> call, Response<ShowList> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"response is done");
                    showList = response.body().getShowList();
                    searchAdapter.notifiy(showList);
                    mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ShowList> call, Throwable t) {

            }
        });
    }


}
