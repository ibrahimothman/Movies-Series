package com.ibra.moviesseries.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.retrofit.genre.Genre;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoFragment extends BaseDetailFragment {

    private static final String TAG = InfoFragment.class.getSimpleName();

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
    @BindView(R.id.image_detail)
    ImageView mPosterImage;




    public InfoFragment() {
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_fragment,container,false);
        ButterKnife.bind(this,view);
        loadData();
        return view;
    }


    @Override
    protected void updateUi() {
        mTitleText.setText(show.getTitle());
        mGenreText.setText(getGenres());
        mDurationText.setText(credit.getDuration()+" mins");
        mDateText.setText(show.getReleaseDate()+",");
        mRateText.setText(show.getMovieVoteAverage()+"/10");
        Picasso.with(getContext()).load(Contract.BASE_URL_IMAGE+"w185/"+show.getMoviePoster())
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
