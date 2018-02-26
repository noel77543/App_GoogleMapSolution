package com.sung.noel.tw.googlemapsolution.ar.model;

import com.sung.noel.tw.googlemapsolution.ar.util.SensorUtil;

/**
 * Created by noel on 2017/12/27.
 */

public class TargetData {
    private String targetName;
    private double targetLng;
    private double targetLat;
    private FrontBean frontBean;

    public TargetData(String targetName, double targetLat, double targetLng, FrontBean frontBean) {
        this.targetName = targetName;
        this.targetLat = targetLat;
        this.targetLng = targetLng;
        this.frontBean = frontBean;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public double getTargetLng() {
        return targetLng;
    }

    public void setTargetLng(double targetLng) {
        this.targetLng = targetLng;
    }

    public double getTargetLat() {
        return targetLat;
    }

    public void setTargetLat(double targetLat) {
        this.targetLat = targetLat;
    }

    //面對的方向的資訊
    public FrontBean getFrontBean() {
        return frontBean;
    }

    public void setFrontBean(FrontBean frontBean) {
        this.frontBean = frontBean;
    }

    public static class FrontBean {
        public FrontBean(int frontFormatAngle, @SensorUtil.SensorDirection String frontFormatWay, float frontCorrectAngle) {
            this.frontFormatAngle = frontFormatAngle;
            this.frontFormatWay = frontFormatWay;
            this.frontCorrectAngle = frontCorrectAngle;
        }

        private float frontCorrectAngle;

        private int frontFormatAngle;
        private
        @SensorUtil.SensorDirection
        String frontFormatWay;

        public int getFrontFormatAngle() {
            return frontFormatAngle;
        }

        public void setFrontFormatAngle(int frontFormatAngle) {
            this.frontFormatAngle = frontFormatAngle;
        }

        public String getFrontFormatWay() {
            return frontFormatWay;
        }

        public void setFrontFormatWay(String frontFormatWay) {
            this.frontFormatWay = frontFormatWay;
        }

        public float getFrontCorrectAngle() {
            return frontCorrectAngle;
        }

        public void setFrontCorrectAngle(float frontCorrectAngle) {
            this.frontCorrectAngle = frontCorrectAngle;
        }
    }
}
