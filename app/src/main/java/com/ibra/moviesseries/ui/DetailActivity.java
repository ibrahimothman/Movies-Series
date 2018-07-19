package com.ibra.moviesseries.ui;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.ViewPagerAdapter;
import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.fragment.CastFragment;
import com.ibra.moviesseries.fragment.InfoFragment;
import com.ibra.moviesseries.fragment.VideoFragment;
import com.ibra.moviesseries.model.Movie;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    private ViewPagerAdapter viewPagerAdapter;
    private Fragment[] fragments = {new InfoFragment(), new VideoFragment(), new CastFragment()};
    private String[] tabNames = {"INFO", "VIDEOS", "CAST"};


    @BindView(R.id.viewpager_detail)
    ViewPager mViewPager;
    @BindView(R.id.tablayout_detail)
    TabLayout mTabLayout;
    @BindView(R.id.image_detail)
    ImageView moviePoster;

    public Movie movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // transparent status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        // setup viewpager
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, tabNames);
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        // get movie detail
        Intent intent = getIntent();
        if (intent != null && intent.getParcelableExtra("movie") != null) {
            movie = intent.getParcelableExtra("movie");
            String poster = Contract.BASE_URL_IMAGE + "w185/" + movie.getMoviePoster();
            Picasso.with(this).load(poster).into(moviePoster);


        }




    }




}


