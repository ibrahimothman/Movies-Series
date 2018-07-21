package com.ibra.moviesseries.retrofit.credit;

import com.google.gson.annotations.SerializedName;

public class Cast {



    @SerializedName("character")
    private String character;

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    @SerializedName("profile_path")
    private String profilePath;



    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }
}
