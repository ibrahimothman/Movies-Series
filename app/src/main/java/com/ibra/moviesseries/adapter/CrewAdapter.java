package com.ibra.moviesseries.adapter;


import android.content.Context;
import android.view.View;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.retrofit.credit.Crew;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CrewAdapter extends ListAdapter {
    private Context mContext;
    private List<Crew> crewList;

    public CrewAdapter(Context mContext,List<Crew> crewList) {
        super(mContext);
        this.mContext = mContext;
        this.crewList = crewList;
    }




    @Override
    protected void bindViews(ListHolder listHolder, Context mContext, int position) {
        String posterUrl = crewList.get(position).getProfilePath();
        String posterFullUrl = Contract.BASE_URL_IMAGE+"w185/"+posterUrl;
        String title = crewList.get(position).getName();

        // update list ui
        Picasso.with(mContext).load(posterFullUrl)
                .resizeDimen(R.dimen.poster_width_default,R.dimen.poster_height_default)
                .centerCrop()
                .into(listHolder.Image);
        listHolder.title.setText(title);
        listHolder.job.setVisibility(View.VISIBLE);
        listHolder.playImage.setVisibility(View.GONE);
        listHolder.job.setText(crewList.get(position).getDepartment());
    }

    @Override
    public int getItemCount() {
        if(crewList != null) return crewList.size();
        else return 0;
    }



    @Override
    protected void onViewClicked(int position) {

    }
}
