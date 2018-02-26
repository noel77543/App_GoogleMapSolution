package com.sung.noel.tw.googlemapsolution.navigation.model;

/**
 * Created by noel on 2017/12/6.
 */

public class NavigationData {

    private String textCh;
    private String textEn;

    public NavigationData(String textCh, String textEn) {
        this.textCh = textCh;
        this.textEn = textEn;
    }

    public String getTextCh() {
        return textCh;
    }

    public String getTextEn() {
        return textEn;
    }

    @Override
    public String toString() {
        return getTextCh();
    }
}
