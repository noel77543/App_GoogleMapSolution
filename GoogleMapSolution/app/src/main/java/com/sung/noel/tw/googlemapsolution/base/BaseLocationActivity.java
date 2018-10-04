package com.sung.noel.tw.googlemapsolution.base;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.util.dialog.LoadingImageCircleDialog;

/**
 * Created by noel on 2017/12/5.
 */

@RuntimePermissions
public abstract class BaseLocationActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private onLocationChangeListener onLocationChangeListener;
    // Google API用戶端物件
    public GoogleApiClient googleApiClient;
    // Location請求物件
    private LocationRequest locationRequest;
    private LoadingImageCircleDialog loadingImageCircleDialog;
    private boolean isFirstIn = true;
    private Location userLocation;

    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void AllowedGetMyLocation() {
        connectToGoogleMapServer();
    }

    @OnShowRationale({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void onShowRationale(final PermissionRequest request) {
        request.proceed();
    }

    @OnPermissionDenied({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void onPermissionDenied() {
        Toast.makeText(this, getString(R.string.toast_permission_refuse), Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void onNeverAskAgain() {
        goToSettingPermissions();
    }

    //-----------------------------
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        BaseLocationActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
    //-------------

    /**
     * 檢查權限
     **/
    public void getLocationPermissionsWithCheck() {
        loadingImageCircleDialog = new LoadingImageCircleDialog(this);
        loadingImageCircleDialog.setLoadingMessage(this.getString(R.string.dialog_message_googlemap_location));
        loadingImageCircleDialog.showLoadingDialog();
        BaseLocationActivityPermissionsDispatcher.AllowedGetMyLocationWithCheck(this);
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
    //-------------

    /**
     * 每當位置改變
     */
    @Override
    public void onLocationChanged(Location location) {
        setUserLocation(location);
        //這邊用作第一次取得位置時之行為 接口為抽象方法 強制實作
        if (isFirstIn) {
            isFirstIn = false;
            onLocationGet(location);
            //位置改變第二次之後 接口為介面 可用可不用
        } else {
            if (onLocationChangeListener != null) {
                onLocationChangeListener.onLocationChange(location);
            }
        }
        loadingImageCircleDialog.dismiss();
    }
    //-------------

    @Override
    public void onConnectionSuspended(int i) {
        // Google Services連線中斷
        // int參數是連線中斷的代號
        loadingImageCircleDialog.dismiss();
        Toast.makeText(this, String.format(getString(R.string.toast_googlemap_connect_error), i + ""),
                Toast.LENGTH_LONG).show();
    }
    //-------------

    /**
     * Google Map連線失敗
     */
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        loadingImageCircleDialog.dismiss();
        // ConnectionResult參數是連線失敗的資訊
        int errorCode = connectionResult.getErrorCode();
        // 裝置沒有安裝Google Play服務
        if (errorCode == ConnectionResult.SERVICE_MISSING) {
            Toast.makeText(this, getString(R.string.toast_permission_error),
                    Toast.LENGTH_LONG).show();
        }
    }

    //-------------

    /**
     * 切換頁面的時候 關閉
     */
    @Override
    public void onPause() {
        super.onPause();
        // 移除Google API用戶端連線
        if (googleApiClient != null) {
            if (googleApiClient.isConnected()) {
                googleApiClient.disconnect();
            }
        }
    }
    //-------------

    /**
     * 回到調用頁面的時候 開啟
     */
    @Override
    public void onResume() {
        super.onResume();
        if (googleApiClient != null) {
            if (!googleApiClient.isConnected()) {
                googleApiClient.connect();
            }
        }
    }
    //-------------

    /**
     * 當下位置
     */
    public Location getUserLocation() {
        return userLocation;
    }

    private void setUserLocation(Location userLocation) {
        this.userLocation = userLocation;
    }

    //-------------

    /**
     * 當接收google map的response後的  子class執行的行為起始點  負責處理只進行一次的行為 初始化 等
     */
    protected abstract void onLocationGet(Location location);

    //-------------

    /**
     * 進行了onLocationGet後下一次座標變動都會進行的 行為
     * 這裡另外開立接口 可用 可不用
     */
    public interface onLocationChangeListener {
        void onLocationChange(Location location);
    }

    public void setonLocationChangeListener(onLocationChangeListener onLocationChangeListener) {
        this.onLocationChangeListener = onLocationChangeListener;
    }
}

