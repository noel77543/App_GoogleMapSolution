package com.sung.noel.tw.googlemapsolution.main.model;

import com.google.gson.annotations.SerializedName;

public class VersionData {

    /**
     * versionName : 1.1.0
     * versionCode : 5
     */
    @SerializedName("versionName")
    private String versionName;
    @SerializedName("versionCode")
    private int versionCode;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }
}
