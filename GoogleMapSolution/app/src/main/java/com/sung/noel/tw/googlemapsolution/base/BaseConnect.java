package com.sung.noel.tw.googlemapsolution.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.sung.noel.tw.googlemapsolution.util.dialog.loading.LoadingDialog;

import java.io.Reader;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class BaseConnect {
    protected OkHttpClient client;
    protected LoadingDialog loadingDialog;
    protected Request request;
    protected Gson gson;
    protected Reader reader;

    private final int TIME_OUT = 15000;
    private Context context;


    public BaseConnect(Context context) {
        this.context = context;
        gson = new Gson();
        loadingDialog = new LoadingDialog(context);
        client = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .build();
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
