package com.example.tacompanion.test;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Pedro Lanzagorta M on 11/26/2016.
 */
public interface TestAPI {

    @GET("/checkin")
    Call<Test> getData();
    @POST("/user")
    Call<Test> setData(String x);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.5.8:8001")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
