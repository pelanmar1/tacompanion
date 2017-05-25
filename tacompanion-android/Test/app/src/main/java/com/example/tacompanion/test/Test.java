package com.example.tacompanion.test;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pedro Lanzagorta M on 11/25/2016.
 */

public class Test {

    @SerializedName("data")
    private String data;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
