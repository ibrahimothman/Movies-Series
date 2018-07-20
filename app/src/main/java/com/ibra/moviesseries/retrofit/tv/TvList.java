package com.ibra.moviesseries.retrofit.tv;

import com.google.gson.annotations.SerializedName;
import com.ibra.moviesseries.retrofit.tv.Tv;

import java.util.List;

public class TvList {

    @SerializedName("results")
    private List<Tv> tvList;

    public List<Tv> getTvList() {
        return tvList;
    }

    public void setTvList(List<Tv> tvList) {
        this.tvList = tvList;
    }
}
