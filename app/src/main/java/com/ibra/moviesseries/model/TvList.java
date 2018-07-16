package com.ibra.moviesseries.model;

import com.google.gson.annotations.SerializedName;

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
