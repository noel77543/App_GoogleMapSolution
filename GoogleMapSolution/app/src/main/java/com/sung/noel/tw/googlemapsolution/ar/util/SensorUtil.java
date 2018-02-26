package com.sung.noel.tw.googlemapsolution.ar.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.StringDef;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.ar.model.TargetData;

/**
 * Created by noel on 2017/12/20.
 */

public class SensorUtil implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;
    private Context context;

    private boolean isHadSensor;
    private OnSensorFormatDirectionGetListener onSensorFormatDirectionGetListener;
    private float frontCorrectAngle;
    private TargetData targetData;
    private String targetName;
    private double targetLat;
    private double targetLng;


    public static final String SENSOR_EAST = "東";
    public static final String SENSOR_E_S = "東南";
    public static final String SENSOR_SOUTH = "南";
    public static final String SENSOR_W_S = "西南";
    public static final String SENSOR_WEST = "西";
    public static final String SENSOR_W_N = "西北";
    public static final String SENSOR_NORTH = "北";
    public static final String SENSOR_N_E = "東北";

    @StringDef({SENSOR_EAST, SENSOR_WEST, SENSOR_SOUTH, SENSOR_NORTH, SENSOR_E_S, SENSOR_W_S, SENSOR_W_N, SENSOR_N_E})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SensorDirection {

    }

    public SensorUtil(Context context, String targetName, double targetLat, double targetLng) {
        this.context = context;
        this.targetName = targetName;
        this.targetLat = targetLat;
        this.targetLng = targetLng;

        init();
    }

    //----
    private void init() {


        //取得服務
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        //設定傳感器類別
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        //註冊監聽
        isHadSensor = sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);

        //false 表示裝置無陀螺儀
        if (!isHadSensor) {
            unrigisterSensor();
            Toast.makeText(context, context.getString(R.string.ar_none_sensor), Toast.LENGTH_SHORT).show();
        }
    }

    //----
    //event 介紹
    // http://blog.csdn.net/wlwlwlwl015/article/details/41759553
    // http://iluhcm.com/2015/09/03/how-to-detect-useful-sensors-for-android-devices/
    // http://androidbiancheng.blogspot.tw/2010/10/androidorientation-azimuth-pitch-roll.html
    // https://wizardforcel.gitbooks.io/w3school-android/content/145.html
    @Override
    public void onSensorChanged(SensorEvent event) {
        //取小數點後第二位
        // Log.e("方位角：", "" + (float) (Math.round(event.values[0] * 100)) / 100);
        // Log.e("倾斜角：", "" + (float) (Math.round(event.values[1] * 100)) / 100);
        // Log.e("滚动角：", "" + (float) (Math.round(event.values[2] * 100)) / 100);

        getFrontWayToString(getFrontWayByAngle((float) (Math.round(event.values[0] * 100)) / 100));
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    //----

    /**
     * 取得正前方方向 ->字串
     * 0°=北，90°=東，180°=南，270°=西。
     */
    private void getFrontWayToString(int type) {

        String frontFormatWay;
        switch (type) {
            //北
            case 0:
                frontFormatWay = SENSOR_NORTH;
                break;
            //東北
            case 1:
                frontFormatWay = SENSOR_N_E;
                break;
            //東
            case 2:
                frontFormatWay = SENSOR_EAST;
                break;
            //東南
            case 3:
                frontFormatWay = SENSOR_E_S;
                break;
            //南
            case 4:
                frontFormatWay = SENSOR_SOUTH;
                break;
            //西南
            case 5:
                frontFormatWay = SENSOR_W_S;
                break;
            //西
            case 6:
                frontFormatWay = SENSOR_WEST;
                break;
            //西北
            default:
            case 7:
                frontFormatWay = SENSOR_W_N;
                break;

        }
        //每45度為一個相位
        int frontFormatAngle = type * 45;
        targetData = new TargetData(targetName, targetLat, targetLng, new TargetData.FrontBean(frontFormatAngle, frontFormatWay, frontCorrectAngle));
        onSensorFormatDirectionGetListener.onSensorFormatDirectionGet(targetData);
    }
    //----

    /**
     * 帶入實際度數換算8個相位角,找出裝置目前正前方方向為何
     */
    private int getFrontWayByAngle(float angle) {
        frontCorrectAngle = angle;
        final int RANGE = 45;
        final int CIRCLE = 360;
        final int ANGLE_TYPE = CIRCLE / RANGE;
        float maxValue;
        float parsedValue = 0;

        if (angle != 0) {
            for (int i = 0; i < ANGLE_TYPE; i++) {
                maxValue = (RANGE + (RANGE * i));
                if (angle < maxValue) {
                    parsedValue = maxValue - RANGE;
                    //找到值就結束迴圈
                    return (int) (parsedValue / RANGE);
                }
            }
        }

        //0
        return (int) parsedValue;
    }

    //------
    //解除註冊  需再使用傳感器的頁面onpause時調用此方法
    public void unrigisterSensor() {
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    //----

    public interface OnSensorFormatDirectionGetListener {
        void onSensorFormatDirectionGet(TargetData targetData);
    }

    public void setOnSensorDirectionChangeListener(OnSensorFormatDirectionGetListener onSensorFormatDirectionGetListener) {
        this.onSensorFormatDirectionGetListener = onSensorFormatDirectionGetListener;
    }
}
