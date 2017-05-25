package com.example.tacompanion.test;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pedro Lanzagorta M on 11/26/2016.
 */
public class Response {

    @SerializedName("user_id")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
