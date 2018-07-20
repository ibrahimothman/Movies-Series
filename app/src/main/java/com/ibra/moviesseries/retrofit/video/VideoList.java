package com.ibra.moviesseries.retrofit.video;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoList {

    @SerializedName("results")
    private List<Video> videoList;


    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }
}
