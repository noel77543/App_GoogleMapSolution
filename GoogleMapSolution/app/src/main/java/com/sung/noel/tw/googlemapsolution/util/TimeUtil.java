package com.sung.noel.tw.googlemapsolution.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {


    /***
     *  判斷目前時間是否在時段內
     * @param beginTime  範圍開始時間
     * @param endTime  範圍結束時間
     * @return
     */
    public boolean isRange(long beginTime, long endTime) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        return currentTime >= beginTime && currentTime <= endTime;
    }

    //----------

    /***
     * 取得當下時間
     * @return
     */
    public String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
       return simpleDateFormat.format(Calendar.getInstance().getTime());
    }
}
