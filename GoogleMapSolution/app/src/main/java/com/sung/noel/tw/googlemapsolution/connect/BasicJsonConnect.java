package com.sung.noel.tw.googlemapsolution.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.loopj.android.http.AsyncHttpClient;

import com.sung.noel.tw.googlemapsolution.util.LoadingCycleManager;

/**
 * Created by noel on 2017/11/2.
 */

public class BasicJsonConnect {
    protected LoadingCycleManager loadingCycleManager;
    protected AsyncHttpClient client;
    private final int TIME_OUT = 15000;
    private Context context;

    public BasicJsonConnect(Context context) {
        this.context = context;
        loadingCycleManager = new LoadingCycleManager(context);
        client = new AsyncHttpClient();
        client.setMaxRetriesAndTimeout(2,TIME_OUT);

    }
    //------------------

    /**
     * 確認網路功能可用
     */
    protected boolean isNetWorkable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isAvailable()) {
            return true;
        }
        return false;
    }
}
