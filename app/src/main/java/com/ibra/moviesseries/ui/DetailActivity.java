package com.ibra.moviesseries.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


import com.ibra.moviesseries.R;
import com.ibra.moviesseries.retrofit.show.Show;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();


    @BindView(R.id.title_detail)
    TextView mTitleText;
    @BindView(R.id.genre_detail)
    TextView mGenreText;
    @BindView(R.id.release_date_detail)
    TextView mDateText;
    @BindView(R.id.duration_detail)
    TextView mDurationText;
    @BindView(R.id.rate_detail)
    TextView mRateText;
    @BindView(R.id.overview_detail)
    TextView mOverviewText;
    @BindView(R.id.cast_list)
    RecyclerView mCastList;
    @BindView(R.id.crew_list)
    RecyclerView mCrewList;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @BindView(R.id.image_detail)
    ImageView mPosterImage;


    public Show movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        // get movie detail
        Intent intent = getIntent();
        if (intent != null && intent.getParcelableExtra("movie") != null) {
            movie = intent.getParcelableExtra("movie");

        }

        // setup toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(movie.getTitle());

        updateUi();




    }

    private void updateUi() {
        mTitleText.setText(movie.getTitle());

    }


}


