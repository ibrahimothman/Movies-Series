package com.ibra.moviesseries.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Constant;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.retrofit.credit.Cast;
import com.ibra.moviesseries.retrofit.credit.Credit;
import com.ibra.moviesseries.retrofit.credit.Crew;
import com.ibra.moviesseries.retrofit.genre.Genre;
import com.ibra.moviesseries.retrofit.show.Show;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


    private Show show;
    private String type;

    private Credit credit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        // get show detail
        Intent intent = getIntent();
        if (intent != null && intent.getParcelableExtra("show") != null) {
            show = intent.getParcelableExtra("show");
            type = intent.getStringExtra("type");

        }

        // setup toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(show.getTitle());

        loadCredit();

    }

    private void loadCredit() {
        Call<Credit> call = ApiClinet.getApiClient().create(ApiInterface.class).getCridit(type,show.getMovieId());
        call.enqueue(new Callback<Credit>() {
            @Override
            public void onResponse(Call<Credit> call, Response<Credit> response) {
               credit =  response.body();
               updateUi();

            }

            @Override
            public void onFailure(Call<Credit> call, Throwable t) {
                Log.d(TAG,"error "+t.getLocalizedMessage());
            }
        });
    }

    private void updateUi() {
        mTitleText.setText(show.getTitle());
        mGenreText.setText(getGenres());
        mDurationText.setText(credit.getDuration()+" mins");
        mDateText.setText(show.getReleaseDate()+",");
        mRateText.setText(show.getMovieVoteAverage()+"/10");
        Picasso.with(this).load(Constant.BASE_URL_IMAGE+"w185/"+show.getMoviePoster())
                .into(mPosterImage);
        mOverviewText.setText(show.getMovieOverview());

    }

    private String getGenres() {
        List<Genre> genreList = credit.getGenres();
        StringBuilder builder = new StringBuilder();
        for(Genre genre : genreList){
            builder.append(genre.getName()+" | ");
        }
        if(builder.charAt(builder.length()-2) == '|'){
            builder.delete(builder.length()-3,builder.length()-1);
        }
        return builder.toString();
    }


}


