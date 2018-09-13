package com.ibra.moviesseries.fragment;


import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.retrofit.genre.Genre;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoFragment extends BaseDetailFragment {

    private static final String TAG = InfoFragment.class.getSimpleName();
    private static final int LOADER_ID = 55;

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
    @BindView(R.id.add_to_fav)
    ImageButton addToFavBtn;




    public InfoFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_fragment,container,false);
        ButterKnife.bind(this,view);

        if(NetworkUtils.connectionIsAvailable(getContext())) {
            loadData();
        }else{
            Toast.makeText(getContext(), "No internet!", Toast.LENGTH_SHORT).show();
        }
        

        addToFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isAlreadyExist()) {
                    addToFavDb();
                }else
                    Toast.makeText(getContext(), "it's already added to watchlist", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }


    @Override
    protected void updateUi() {
        mTitleText.setText(show.getTitle());
        mGenreText.setText(getGenres());
        mDurationText.setText(getString(R.string.text,credit.getDuration(),getString(R.string.mins)));
        mDateText.setText(getString(R.string.text,String.valueOf(show.getReleaseDate()),","));
        mRateText.setText(getString(R.string.text,String.valueOf(show.getMovieVoteAverage()),getString(R.string.percentage)));
        Picasso.with(getContext()).load(Contract.BASE_URL_IMAGE+show.getMoviePoster())
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



    // insert new record to sqlite database
    private void addToFavDb() {
        ContentValues cv = new ContentValues();
        cv.put(Contract.FavEntry.TITLE_COL,show.getTitle());
        cv.put(Contract.FavEntry._ID,show.getMovieId());
        cv.put(Contract.FavEntry.POSTER_COL,show.getMoviePoster());
        cv.put(Contract.FavEntry.OVERVIEW_COL,show.getMovieOverview());
        cv.put(Contract.FavEntry.RATE_COL,show.getMovieVoteAverage());
        cv.put(Contract.FavEntry.RELEASE_DATE_COL,show.getReleaseDate());
        Uri uri = Contract.FavEntry.CONTENT_URI;
        getContext().getContentResolver().insert(uri,cv);


    }

    private boolean isAlreadyExist(){
        Uri uri = ContentUris.withAppendedId(Contract.FavEntry.CONTENT_URI,show.getMovieId());
        Cursor cursor = getContext().getContentResolver()
                .query(uri,null,null,null,null);

        if(cursor.getCount() != 0){
            // show has already existed
            return true;

        }
        else {
            return false;
        }
    }


}
