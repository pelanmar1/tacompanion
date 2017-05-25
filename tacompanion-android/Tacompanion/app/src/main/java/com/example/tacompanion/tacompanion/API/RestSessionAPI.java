package com.example.tacompanion.tacompanion.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;

/**
 * Created by Pedro Lanzagorta M on 11/25/2016.
 */
public class RestSessionAPI {

    private String service_url = "https://192.168.5.8:8001";

    public interface GetDataAPI {
        @GET("/checkin")
        String getData();

    }

    public String getData() {

        Gson gson = new GsonBuilder().create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(service_url)
                .setConverter(new GsonConverter(gson))
                .build();

        GetDataAPI service = restAdapter.create(GetDataAPI.class);

        String data = service.getData();

        return data;
    }

}
