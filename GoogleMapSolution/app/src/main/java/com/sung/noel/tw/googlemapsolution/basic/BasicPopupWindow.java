package com.sung.noel.tw.googlemapsolution.basic;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.PopupWindow;

/**
 * Created by noel on 2017/12/1.
 */

public class BasicPopupWindow extends PopupWindow {
    private int windowHeight;
    private int windowWidth;

    public BasicPopupWindow(Activity activity) {
        windowHeight = activity.getWindowManager().getDefaultDisplay().getHeight();
        windowWidth = activity.getWindowManager().getDefaultDisplay().getWidth();
        setFocusable(true);
        setOutsideTouchable(true);setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

    protected int getWindowHeight() {
        return windowHeight;
    }

    protected int getWindowWidth() {
        return windowWidth;
    }

}
