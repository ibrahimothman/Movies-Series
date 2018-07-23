package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.view.View;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.retrofit.credit.Cast;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CastAdapter extends ListAdapter {

    private Context mContext;
    private List<Cast> castList;

    public CastAdapter(Context mContext,List<Cast> castList) {
        super(mContext);
        this.mContext = mContext;
        this.castList = castList;
    }




    @Override
    protected void bindViews(ListHolder listHolder, Context mContext, int position) {
        String posterUrl = castList.get(position).getProfilePath();
        String posterFullUrl = Contract.BASE_URL_IMAGE+"w185/"+posterUrl;
        String title = castList.get(position).getName();

        // update list ui
        Picasso.with(mContext).load(posterFullUrl)
                .resizeDimen(R.dimen.poster_width_default,R.dimen.poster_height_default)
                .centerCrop()
                .into(listHolder.Image);
        listHolder.title.setText(title);
        listHolder.job.setVisibility(View.VISIBLE);
        listHolder.playImage.setVisibility(View.GONE);
        listHolder.job.setText(castList.get(position).getCharacter());
    }

    @Override
    public int getItemCount() {
        if(castList != null) return castList.size();
        else return 0;
    }

    public void notifyAdapter(List<Cast> castList){
        this.castList = castList;
        this.notifyDataSetChanged();
    }

    @Override
    protected void onViewClicked(int position) {

    }
}
