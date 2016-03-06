package com.example.bill.movies1;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by bill on 3/6/16.
 */
public class SortPreferenceFragment extends PreferenceFragment{

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.sort_preference);
        }
    }

