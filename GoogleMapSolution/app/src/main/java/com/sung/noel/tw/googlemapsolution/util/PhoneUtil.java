package com.sung.noel.tw.googlemapsolution.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by noel on 2019/4/25.
 */
public class PhoneUtil {
    private Context context;

    public PhoneUtil(Context context) {
        this.context = context;

    }

    //--------------

    /***
     *  取得手機寬高
     * @return
     */
    public int[] getPhoneSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int phoneWidth = metrics.widthPixels;
        int phoneHeight = metrics.heightPixels;
        return new int[]{phoneWidth, phoneHeight};
    }

    //-------------

    /***
     * 取得狀態欄高度
     */
    public int getStatusHeight() {
        int statusHeight = 0;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }
    //--------------------

    /***
     *  取得actionbar高度
     */
    public int getActionBarHeight() {
        int actionbarHeight = 0;
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionbarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        return actionbarHeight;
    }


    //--------

    /***
     * need android api 21 up  (android 5.0)
     * 更改statusbar背景色
     * @param  activity
     * @param statusColor  R.color.xxx
     */
    public void setStatusBarColor(Activity activity, int statusColor) {
        Window window = activity.getWindow();
        //取消透明狀態欄
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //將狀態欄設為可繪製
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //設置狀態欄背景顏色
        window.setStatusBarColor(context.getResources().getColor(statusColor));
        //將狀態欄設為可見
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        //讓View不根據系統窗口而自動調整佈局
        ViewGroup contentView = (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT);
        View childView = contentView.getChildAt(0);
        if (childView != null) {
            ViewCompat.setFitsSystemWindows(childView, false);
            ViewCompat.requestApplyInsets(childView);
        }
    }
}
