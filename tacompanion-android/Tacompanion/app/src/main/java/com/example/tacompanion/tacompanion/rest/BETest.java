package com.example.tacompanion.tacompanion.rest;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.tacompanion.tacompanion.API.RestSessionAPI;
import com.example.tacompanion.tacompanion.R;

/**
 * Created by Pedro Lanzagorta M on 11/25/2016.
 */
public class BETest extends AsyncTask<Void,Void,String> {
    Activity activity;
    BETest(Activity activity){
        this.activity=activity;
    }
    @Override
    protected String doInBackground(Void... urls) {

        RestSessionAPI api = new RestSessionAPI();
        return api.getData();
    }

    protected void onProgressUpdate(Integer... progress) {

    }
    protected void onPostExecute(String results) {

        System.out.println(results.toString()+" ----------------------------------------");
        ((TextView) activity.findViewById(R.id.result)).setText(results.toString());

    }

}
