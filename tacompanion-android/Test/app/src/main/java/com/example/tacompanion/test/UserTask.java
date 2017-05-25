package com.example.tacompanion.test;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.example.tacompanion.test.TpnClient.UserAPI;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Pedro Lanzagorta M on 11/26/2016.
 */
public class UserTask extends AsyncTask<Void,Void,Response> {
    Activity activity;
    public UserTask(Activity activity){
        this.activity=activity;
    }
    @Override
    protected Response doInBackground(Void... params) {

        UserAPI userAPI = TpnClient.retrofit.create(UserAPI.class);
        User user= new User("pelanmar1@gmail.com","Pedro","Lanzagorta","honguito");
        Call<Response> call=userAPI.addUser(user);
        Response result = null;
        try {
            result = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        if(response!=null) {
            ((TextView) activity.findViewById(R.id.result)).setText(String.valueOf(response.getUserId()));
            System.out.println("-----> " + response.getUserId());
        }
    }
}
