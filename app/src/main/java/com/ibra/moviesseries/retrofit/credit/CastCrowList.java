package com.ibra.moviesseries.retrofit.credit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CastCrowList {

    @SerializedName("cast")
    private List<Cast>castList;

    @SerializedName("crew")
    private List<Crew> crewList;

    public List<Crew> getCrewList() {
        return crewList;
    }

    public void setCrewList(List<Crew> crewList) {
        this.crewList = crewList;
    }

    public List<Cast> getCastList() {
        return castList;
    }

    public void setCastList(List<Cast> castList) {
        this.castList = castList;
    }
}
