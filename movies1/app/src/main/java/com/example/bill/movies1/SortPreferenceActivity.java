package com.example.bill.movies1;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by bill on 3/6/16.
 */
public class SortPreferenceActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        getFragmentManager().beginTransaction().replace(R.id.pref_frame,
                new SortPreferenceFragment()).commit();
    }
}


