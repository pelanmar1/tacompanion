package com.example.tacompanion.test;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Pedro Lanzagorta M on 11/26/2016.
 */
public class TpnClient {

    private static final String baseUrl="http://10.6.64.2:8001";
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    interface UserAPI{
        @POST("/usertemp")
        Call<Response> addUser(@Body User newUser);
    }
}
