package com.example.tacompanion.tacompanion.activities;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.tacompanion.tacompanion.R;

public class UserPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.user_preferences);
    }
}
