package com.ibra.moviesseries.retrofit.person;

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("name")
    private String name;

    @SerializedName("biography")
    private String bio;

    @SerializedName("place_of_birth")
    private String placeOfBirth;

    @SerializedName("profile_path")
    private String profilePath;

}
