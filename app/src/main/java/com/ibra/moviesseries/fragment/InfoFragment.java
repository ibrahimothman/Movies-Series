package com.ibra.moviesseries.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.api.ApiClinet;
import com.ibra.moviesseries.data.api.ApiInterface;
import com.ibra.moviesseries.event.Event;
import com.ibra.moviesseries.retrofit.credit.Crew;
import com.ibra.moviesseries.retrofit.credit.Credit;
import com.ibra.moviesseries.retrofit.genre.Genre;
import com.ibra.moviesseries.retrofit.movie.Movie;
import com.ibra.moviesseries.ui.DetailActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InfoFragment extends Fragment {

    private static final String TAG = InfoFragment.class.getSimpleName();

    @BindView(R.id.title_info)
    TextView titleTextview;
    @BindView(R.id.genre_info)
    TextView genreTextview;
    @BindView(R.id.language_info)
    TextView languageTextview;
    @BindView(R.id.director_info)
    TextView directorTextview;
    @BindView(R.id.release_date_info)
    TextView releaseDateTextview;
    @BindView(R.id.rate_info)
    TextView rateTextview;
    @BindView(R.id.movie_overview_info)
    TextView overviewTextview;


    private Movie movie;
    private Credit credit;

    public InfoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info,container,false);
        ButterKnife.bind(this,view);

        if(getActivity()!= null){
            movie = ((DetailActivity)getActivity()).movie;
        }

        loadCridit();
        return view;
    }



    public void loadCridit(){
        Call<Credit> call = ApiClinet.getApiClient().create(ApiInterface.class).getMovieCridit(movie.getMovieId());
        call.enqueue(new Callback<Credit>() {
            @Override
            public void onResponse(Call<Credit> call, Response<Credit> response) {
                credit = response.body();
                Log.d(TAG,"title is "+ credit.getTitle());
                EventBus.getDefault().post(new Event(credit.getCastCrewList().getCastList()));
                updateUi();
            }

            @Override
            public void onFailure(Call<Credit> call, Throwable t) {
                Log.d("fromInfo","error is "+t.getLocalizedMessage());
            }
        });
    }

    private void updateUi() {
        releaseDateTextview.setText(credit.getReleaseDate());
        rateTextview.setText(credit.getVoteAverage()+"/10");
        languageTextview.setText(credit.getOriginalLanguage());
        directorTextview.setText(getDirector());
        overviewTextview.setText(credit.getOverview());
        genreTextview.setText(getGenres());
        titleTextview.setText(credit.getTitle());

    }

    // get movie directors
    private StringBuilder getDirector() {
        List<Crew> crewList = credit.getCastCrewList().getCrewList();
        List<String> directors = new ArrayList<>();
        StringBuilder directorBuilder = new StringBuilder();
        for(Crew crew : crewList){

            if(crew.getDepartment().equals("Directing")){
                String d = crew.getName();
                directorBuilder.append(d);
                if(crew != (crewList.get(crewList.size()-1))){
                    directorBuilder.append(" | ");
                }
            }
        }
        return directorBuilder;
    }


    // get movie genres
    private StringBuilder getGenres() {
        List<Genre> genres = credit.getGenres();
        StringBuilder genreBuilder = new StringBuilder();
        for(Genre genre : genres){
            String g = genre.getName();
            genreBuilder.append(g);
            if(genre != (genres.get(genres.size()-1))){
                genreBuilder.append(" | ");
            }
        }
        return genreBuilder;
    }


}
