package com.ibra.moviesseries.event;

import com.ibra.moviesseries.retrofit.credit.Cast;

import java.util.List;

public class Event {

    private List<Cast> castList;

    public Event(List<Cast> castList) {
        this.castList = castList;
    }

    public List<Cast> getCastList() {
        return castList;
    }
}
