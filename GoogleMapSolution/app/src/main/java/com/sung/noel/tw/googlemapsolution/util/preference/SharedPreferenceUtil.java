package com.sung.noel.tw.googlemapsolution.util.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.StringDef;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.PlaceInfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class SharedPreferenceUtil {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({NAME_HISTORY})
    public @interface SharedPreferencesKey {
    }

    ;

    public final static String NAME_HISTORY = "NameHistory";
    private final String KEY_HISTORY = "history";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

    public SharedPreferenceUtil(Context context, @SharedPreferencesKey String keyName) {
        gson = new Gson();
        sharedPreferences = context.getSharedPreferences(keyName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //-------

    /***
     * 取得 查詢紀錄
     * @return
     */
    public ArrayList<PlaceInfo.ResultsBean> getHistory() {
        return gson.fromJson(sharedPreferences.getString(KEY_HISTORY, ""), new TypeToken<ArrayList<PlaceInfo.ResultsBean>>() {
        }.getType());
    }

    //--------

    /***
     * 設置 查詢紀錄
     */
    public void addHistory(PlaceInfo.ResultsBean placeData) {
        ArrayList<PlaceInfo.ResultsBean> data = getHistory();
        data.add(0, placeData);
        editor.putString(KEY_HISTORY, gson.toJsonTree(data).getAsJsonArray().toString()).commit();
    }
    //--------
    /***
     * 清除目標紀錄
     */
    public void removeTargetHistory(int position){
        ArrayList<PlaceInfo.ResultsBean> data = getHistory();
        data.remove(position);
        editor.putString(KEY_HISTORY, gson.toJsonTree(data).getAsJsonArray().toString()).commit();
    }

}
