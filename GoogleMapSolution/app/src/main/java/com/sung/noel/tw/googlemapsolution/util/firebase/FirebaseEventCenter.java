package com.sung.noel.tw.googlemapsolution.util.firebase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.webkit.JavascriptInterface;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sung.noel.tw.googlemapsolution.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by noel on 2018/5/26.
 */

public class FirebaseEventCenter {

    public static final String ACTION_START = "開始使用";

    @StringDef(ACTION_START)
    @Retention(RetentionPolicy.SOURCE)
    public @interface FirebaseEvent{}



    private FirebaseAnalytics firebaseAnalytics;
    private Context context;

    public FirebaseEventCenter(Context context) {
        this.context = context;
        initFirebase();


    }
    //----------------

    /***
     *  firebase 初始化
     */
    private void initFirebase() {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }
    //----------------
    /***
     *  發送事件
     */
    @JavascriptInterface
    public void sentEvent(@FirebaseEvent String event,String viewName){
        Bundle bundle = new Bundle();
        bundle.putString(context.getString(R.string.firebase_analytics_event), event);
        firebaseAnalytics.logEvent(viewName, bundle);
    }
}
