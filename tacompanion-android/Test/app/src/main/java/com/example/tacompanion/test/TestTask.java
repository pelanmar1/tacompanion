package com.example.tacompanion.test;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.VisibleForTesting;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;

/**
 * Created by Pedro Lanzagorta M on 11/26/2016.
 */
public class TestTask extends AsyncTask<Void,Void,String> {
    Activity activity;
    TestTask(Activity activity){
        this.activity=activity;
    }
    @Override
    protected String doInBackground(Void... params) {

        TestAPI testAPI = TestAPI.retrofit.create(TestAPI.class);
        Call<Test> call=testAPI.getData();
        Test result = null;
        try {
            result = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.getData();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ((TextView) activity.findViewById(R.id.result)).setText(s);
        System.out.println("-----> "+s);
    }
}
