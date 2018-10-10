package com.sung.noel.tw.googlemapsolution.util.firebase.analytics;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.webkit.JavascriptInterface;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.main.MainActivity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by noel on 2018/5/26.
 */

public class MyFirebaseEventCenter {


    public static final String VIEW_MAIN = "首頁";

    @StringDef(VIEW_MAIN)
    @Retention(RetentionPolicy.SOURCE)
    public @interface FirebaseView {
    }


    public static final String ACTION_MAIN_START = "開始使用";
    public static final String ACTION_MAIN_MAP_MARKER_REMOVE = "地圖 - 移除Marker";
    public static final String ACTION_MAIN_MAP_MARKER_PUT = "地圖 - 插上Marker";
    public static final String ACTION_MAIN_MAP_DIRECTION = "地圖 - 取得路徑";
    public static final String ACTION_MAIN_MAP_ADDRESS = "地圖 - 地址查詢";
    public static final String ACTION_MAIN_MAP_PLACE = "地圖 - 附近商家(%s)";
    public static final String ACTION_MAIN_MAP_PLACE_DETAIL = "地圖 - 附近商家資訊";

    public static final String ACTION_MAIN_TALK_BOARD_ENTER = "聊天室 - 進入";
    public static final String ACTION_MAIN_TALK_BOARD_EXIT = "聊天室 - 關閉";
    public static final String ACTION_MAIN_TALK_BOARD_SEND = "聊天室 - 發送訊息";
    public static final String ACTION_MAIN_TALK_BOARD_REGISTER = "聊天室 - 註冊";


    public static final String ACTION_MAIN_UPDATE = "更新";

    @StringDef({ACTION_MAIN_START, ACTION_MAIN_MAP_MARKER_REMOVE,
            ACTION_MAIN_MAP_MARKER_PUT,ACTION_MAIN_MAP_DIRECTION,
            ACTION_MAIN_MAP_ADDRESS,ACTION_MAIN_MAP_PLACE,
            ACTION_MAIN_MAP_PLACE_DETAIL,ACTION_MAIN_TALK_BOARD_ENTER,
            ACTION_MAIN_TALK_BOARD_EXIT,ACTION_MAIN_TALK_BOARD_SEND,ACTION_MAIN_TALK_BOARD_REGISTER
            ,ACTION_MAIN_UPDATE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface FirebaseEvent {
    }


    public static final String CLASS_MAIN = "MainActivity";

    @StringDef(CLASS_MAIN)
    @Retention(RetentionPolicy.SOURCE)
    public @interface FirebaseClass {
    }


    private FirebaseAnalytics firebaseAnalytics;
    private Context context;

    public MyFirebaseEventCenter(Context context) {
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
     * 發送事件
     * @param viewName 畫面名稱
     * @param className class名稱
     * @param event 事件名稱
     */
    @JavascriptInterface
    public void sentEvent(@FirebaseView String viewName, @FirebaseClass String className, @FirebaseEvent String event) {
        Bundle bundle = new Bundle();
        bundle.putString(context.getString(R.string.firebase_analytics_class), className);
        bundle.putString(context.getString(R.string.firebase_analytics_event), event);
        firebaseAnalytics.logEvent(viewName, bundle);
    }
}
