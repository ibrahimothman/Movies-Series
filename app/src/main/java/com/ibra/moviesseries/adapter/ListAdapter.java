package com.ibra.moviesseries.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibra.moviesseries.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private Context mContext;
    public ListAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, final int position) {
        ListHolder listHolder = (ListHolder) holder;
        bindViews(listHolder,mContext,position);
        listHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked(position);
            }
        });
    }

    protected abstract void onViewClicked(int position);

    protected abstract void bindViews(ListHolder listHolder,Context mContext, int position);



    public class ListHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.image)ImageView Image;
        @BindView(R.id.title)TextView title;
        @BindView(R.id.play)ImageView playImage;
        public ListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            playImage.setVisibility(View.GONE);
        }
    }
}