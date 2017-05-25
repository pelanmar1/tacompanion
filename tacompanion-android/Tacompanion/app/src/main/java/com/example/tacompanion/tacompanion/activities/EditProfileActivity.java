package com.example.tacompanion.tacompanion.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.tacompanion.tacompanion.R;

/**
 * Created by Pedro Lanzagorta M on 11/23/2016.
 */
public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void goToMainActivity(View view) {
        this.finish();
    }
}
