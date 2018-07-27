package com.ibra.moviesseries.fragment;


import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.retrofit.genre.Genre;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoFragment extends BaseDetailFragment implements LoaderManager.LoaderCallbacks<Cursor> {

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
        loadData();

        addToFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToFavDb();
            }
        });




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
        getLoaderManager().initLoader(3,null,this);

    }


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new CursorLoader(getContext(), Contract.FavEntry.CONTENT_URI,null,null,null,null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        if(data != null && data.moveToFirst()){
            do{
                Log.d(TAG,"title is "+data.getString(1));
            }
            while (data.moveToNext());
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
