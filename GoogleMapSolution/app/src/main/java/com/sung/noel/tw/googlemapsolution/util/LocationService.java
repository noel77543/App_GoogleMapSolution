package com.sung.noel.tw.googlemapsolution.util;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.sung.noel.tw.googlemapsolution.R;

//@RuntimePermissions
public class LocationService extends Service implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private OnLocationChangeListener onLocationChangeListener;
    // Google API用戶端物件
    public GoogleApiClient googleApiClient;
    // Location請求物件
    private LocationRequest locationRequest;
    private boolean isFirstIn = true;
    private Location userLocation;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //-------

    @Override
    public void onCreate() {
        super.onCreate();
    }
    //-------

//    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
//    void AllowedGetMyLocation() {
//        connectToGoogleMapServer();
//    }
//    //-------
//
//    @OnShowRationale({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
//    void onShowRationale(final PermissionRequest request) {
//        request.proceed();
//    }
//    //-------
//
//    @OnPermissionDenied({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
//    void onPermissionDenied() {
//        Toast.makeText(this, getString(R.string.toast_permission_refuse), Toast.LENGTH_SHORT).show();
//    }
//    //-------
//
//    @OnNeverAskAgain({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
//    void onNeverAskAgain() {
//        goToSettingPermissions();
//    }

    //-------------

    /**
     * 發起請求 至 googlemap伺服器
     */
    private void connectToGoogleMapServer() {
        prepareConnect();
        if (!googleApiClient.isConnected()) {
            googleApiClient.connect();
        }
    }
    //-----------------------------

    /**
     * 連線前準備
     */
    private void prepareConnect() {
        configGoogleApiClient();
        configLocationRequest();
    }

    //-----------------------------

    /**
     * 建立Google API用戶端物件
     */
    private void configGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                //位置
                .addApi(LocationServices.API)
                .build();
    }

    //-----------------------------

    /**
     * 建立Location請求物件
     */
    private void configLocationRequest() {
        locationRequest = new LocationRequest();

        locationRequest
                // 設定讀取位置資訊的間隔時間為一秒（1000ms）
                .setInterval(1000)
                // 設定讀取位置資訊最快的間隔時間為一秒（1000ms）
                .setFastestInterval(1000)
                // 設定優先讀取高精確度的位置資訊（GPS）
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }


    //------

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    //-------------

    /**
     * 當成功連線至googlemap server
     */
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //Location位置變動設置
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }
    //------

    @Override
    public void onConnectionSuspended(int i) {

    }
    //------

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    //------

    @Override
    public void onLocationChanged(Location location) {
        this.userLocation = location;
        if (onLocationChangeListener != null) {

            //第一次取得位置
            if (isFirstIn) {
                isFirstIn = false;
                onLocationChangeListener.onLocationGet(location);

            }
            //位置改變第二次之後
            else {
                onLocationChangeListener.onLocationChange(location);
            }
        }
    }


    //-----------------------------

    /**
     * 前往開啟權限
     */
    private void goToSettingPermissions() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(getString(R.string.dialog_message_goto_setting));
        alert.setPositiveButton(getString(R.string.dialog_go), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent settings = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                settings.addCategory(Intent.CATEGORY_DEFAULT);
                settings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(settings);
            }
        });
        alert.show();
    }
    //-------------

    /**
     * 進行了onLocationGet後下一次座標變動都會進行的 行為
     * 這裡另外開立接口 可用 可不用
     */
    public interface OnLocationChangeListener {
        void onLocationGet(Location location);

        void onLocationChange(Location location);
    }

    public void setOnLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
        this.onLocationChangeListener = onLocationChangeListener;
    }
}
