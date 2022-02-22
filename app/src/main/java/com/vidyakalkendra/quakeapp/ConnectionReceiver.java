package com.vidyakalkendra.quakeapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionReceiver extends BroadcastReceiver {

    public static ReceiverListner listner;

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(listner != null){
            boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
            listner.onNetworkChange(isConnected);
        }
    }

    public interface ReceiverListner{
        void onNetworkChange(boolean isConnected);
    }
}
