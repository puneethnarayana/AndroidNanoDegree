package com.example.bill.movies1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by bill on 3/6/16.
 */
public class NetworkActions {
    public static Boolean networkcheck(Context context){

        Boolean returnValue = false; // Initial Value

        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            returnValue = true;

        }

        return returnValue;

    }
}
