package com.sung.noel.tw.googlemapsolution.base;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.connect.VersionConnect;

/**
 * Created by noel on 2017/12/5.
 */

public abstract class BaseMapActivity extends BaseLocationActivity implements OnMapReadyCallback {

    //判斷是否初次進來 需聚焦在目前位置
    public GoogleMap googleMap;
    public LatLng currentLatlng;

    //繼承此class 必然有個map
    @BindView(R.id.mapview)
    protected MapView mapview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);

        mapview.onCreate(savedInstanceState);
        mapview.onResume();
        mapview.getMapAsync(this);
    }


    //------------

    /**
     * 解除小蘭點定位
     */
    @Override
    public void onPause() {
        super.onPause();
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
        if (googleApiClient != null) {
            googleMap.setMyLocationEnabled(false);
        }
    }
    //------------

    /**
     * 取得小藍點定位
     */
    @Override
    public void onResume() {
        super.onResume();
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
        if (googleApiClient != null) {
            googleMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }
    //-------------

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        getLocationPermissionsWithCheck();
    }

    //-------------

    /**
     * 當取得googlemap 連線
     */
    @Override
    public void onLocationGet(Location location) {
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
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        gotoMyLocation(location);
    }

    //-------------

    /**
     * 初次開啟時 前往目前位置
     */
    private void gotoMyLocation(Location currentLocation) {
        if (currentLocation != null) {
            currentLatlng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatlng, 12.0f));
        } else {
            Toast.makeText(this, getString(R.string.toast_googlemap_location_error), Toast.LENGTH_SHORT).show();
        }
        init();
    }

    //------------------

    /**
     * 是否字串可為數字
     */
    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
    //-----------------------------

    /**
     * 關閉虛擬鍵盤
     */
    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    //-----------------------------

    /***
     * 動畫前往
     * @param latLng
     * @param size
     */
    public void goToTargetLocationByAnimate(LatLng latLng, float size) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, size));
    }
    //-----------------------------

    /***
     * 無動畫前往
     * @param latLng
     * @param size
     */
    public void goToTargetLocation(LatLng latLng, float size) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, size));
    }


    //------------- todo 抽象方法

    /**
     * 設置view
     */
    protected abstract int getContentViewId();

    protected abstract void init();
}
