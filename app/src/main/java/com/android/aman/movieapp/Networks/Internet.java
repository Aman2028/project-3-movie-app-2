package com.android.aman.movieapp.Networks;



import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.aman.movieapp.MainActivity;

public class Internet
{
    public boolean checkConnection()
    {
        ConnectivityManager cm =
                (ConnectivityManager) MainActivity.context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}
