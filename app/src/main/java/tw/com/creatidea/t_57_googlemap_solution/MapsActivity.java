package tw.com.creatidea.t_57_googlemap_solution;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.kml.KmlLayer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.com.creatidea.t_57_googlemap_solution.connect.GoogleConnect;
import tw.com.creatidea.t_57_googlemap_solution.util.HttpHandler;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_ADDRESS;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_LOCATION;

/**
 * Created by noel on 2017/8/16.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
        , GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    //TODO 6.0 版本後 需要權限
    final int LOCATION_PERMISSION_REQUEST = 33;

    // TODO 裝置位置用
    // Google API用戶端物件
    private GoogleApiClient googleApiClient;
    // Location請求物件
    private LocationRequest locationRequest;
    // 記錄目前最新的位置
    private Location currentLocation;
    // 顯示目前與儲存位置的標記物件
    private Marker currentMarker;
    //客製化marker
    private MarkerOptions m = new MarkerOptions();
    private LatLng here;
    private Bitmap myIcon;

    //// TODO 地標線條
    private GoogleMap mMap;

    //判斷第幾點
    boolean count = true;
    PolylineOptions polylineOpt;
    Polyline polyline;
    //    位置
    private Double myLongitude, myLatitude;
    //    特效
    private Tremble tremble;
    private FrameLayout map;
    //    地標LatLng
    private LatLng westVirginia, kingstonTownship, springTownship, kentucky, indiana,
            virginia, maryland, newJersey, connecticut, northCarolina, southCarolina, georgia;

    //地址
    private final String ADDRESS_URL = "http://maps.google.com/maps/api/geocode/json?latlng={0},{1}&language=zh-TW&sensor=true";
    private ProgressDialog progressDialog;
    private String searchAddress;


    private GoogleConnect connect;


    //  UI
    // butterknife
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.btnFocus)
    Button btnFocus;
    @BindView(R.id.btnReload)
    Button btnReload;


//             ================           ==================              ================
    //TODO 如若無法使用此範例原因有以下幾點可能

    /**
     * 請更改values 資料夾底下的google_,aps_api.xml中的金鑰
     * 請開啟手機的定位功能
     * 請給予App地理位置資訊之權限
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
//             ================           ==================              ================

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        checkPermissionsForResult();
    }
//             ================           ==================              ================

    private void init() {

        progressDialog = new ProgressDialog(this);
        connect = new GoogleConnect(this);
    }


//             ================           ==================              ================

    @OnClick({R.id.btnSearch, R.id.btnFocus, R.id.btnReload})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSearch:

                searchAddress = edit.getText().toString();

                if (searchAddress.length() > 0) {
                    progressDialog.setMessage(getString(R.string.text_connect));
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    connect.sendLocationRequest(searchAddress);
                } else {
                    Toast.makeText(this, getString(R.string.toast_enteraddress), Toast.LENGTH_SHORT).show();
                }
                closeKeyboard();//關閉Keyboard

                break;
            case R.id.btnFocus:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(here, 16.0f));

                break;
            case R.id.btnReload:
                checkPermissionsForResult();

                break;
        }
    }

//             ================           ==================              ================

    private void addLandMarks() {//插入大頭針
        landMark(westVirginia, getString(R.string.westvirginia));
        landMark(kingstonTownship, getString(R.string.kingstontownship));
        landMark(springTownship, getString(R.string.springtownship));
        landMark(kentucky, getString(R.string.kentucky));
        landMark(indiana, getString(R.string.indiana));
        landMark(virginia, getString(R.string.virginia));
        landMark(maryland, getString(R.string.maryland));
        landMark(newJersey, getString(R.string.newjersey));
        landMark(connecticut, getString(R.string.connecticut));
        landMark(northCarolina, getString(R.string.northcarolina));
        landMark(southCarolina, getString(R.string.southcarolina));
        landMark(georgia, getString(R.string.georgia));
    }
//             ================           ==================              ================

    private void initLandMarks() {
        westVirginia = new LatLng(38.495601, -81.062688);//西維吉尼亞州   (中心點)
        kingstonTownship = new LatLng(40.303698, -82.864446);//俄亥俄州
        springTownship = new LatLng(40.895947, -77.678899); //宾夕法尼亚州
        kentucky = new LatLng(37.404066, -85.017766); //肯塔基州
        indiana = new LatLng(40.199779, -86.291650); //印第安納州
        virginia = new LatLng(37.275022, -78.895902);//弗吉尼亞州
        maryland = new LatLng(39.512846, -77.053545);//馬里蘭州
        newJersey = new LatLng(39.614297, -74.711120);//新澤西州
        connecticut = new LatLng(41.651353, -72.816124);//康乃狄克州
        northCarolina = new LatLng(35.684099, -78.964883);//北卡羅來納州
        southCarolina = new LatLng(33.961673, -80.529731);//南卡羅來納州
        georgia = new LatLng(32.614273, -83.327651);//喬治亞州
    }
//             ================           ==================              ================

    private void landMark(LatLng myPostion, String myTitle) {
        Bitmap myIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.myicon);
        mMap.addMarker(new MarkerOptions()
                .position((myPostion))
                .title(myTitle)
                .icon(BitmapDescriptorFactory.fromBitmap(myIcon))
                .anchor(0.5f, 0.9f));
    }
//             ================           ==================              ================

    private void setScreenTrembleAnimation() {
        tremble = new Tremble();
        tremble.setDuration(100);//每次時間
        tremble.setRepeatCount(2);// 2+1次（包含第一次）
    }
//             ================           ==================              ================

    @Override
    public boolean onMarkerClick(Marker marker) {//Mark 點擊監聽
        map = (FrameLayout) findViewById(R.id.map);
        setScreenTrembleAnimation();
        Vibrator myVibrator = (Vibrator) getApplication().getSystemService(Service.VIBRATOR_SERVICE);
        myVibrator.vibrate(300);
        map.startAnimation(tremble);

//        //線條顏色
        polylineOpt.color(Color.BLUE);
//        //線條寬度
        polylineOpt.width(8f);
        if (count) {
            //從...
            if (polyline != null) {
                polyline.remove();
            }
            polylineOpt.add(new LatLng(marker.getPosition().latitude, marker.getPosition().longitude));
            count = false;
        } else {
            //到...
            polylineOpt.add(new LatLng(marker.getPosition().latitude, marker.getPosition().longitude));
            count = true;
            polyline = mMap.addPolyline(polylineOpt);
            polyline.setWidth(10);
            polylineOpt = new PolylineOptions();//重建一個新的polylineOpt
        }

        return false; //true 則只觸發自定義行為（會不包含鏡頭轉移及infoWindow也不會出現）
    }
//             ================           ==================              ================

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, marker.getTitle() + "\n經度:" + marker.getPosition().longitude +
                        "\n緯度:" + marker.getPosition().latitude,
                Toast.LENGTH_SHORT).show();
    }
//             ================           ==================              ================

    private void getLocation(Location location) {

        if (location != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
                return;
            }
            myLongitude = location.getLongitude();    //取得經度
            myLatitude = location.getLatitude();    //取得緯度
            here = new LatLng(myLatitude, myLongitude);
            myIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_here);
            m.position(here).anchor(0.5f, 0.9f).icon(BitmapDescriptorFactory.fromBitmap(myIcon)).title(getString(R.string.here));
            // 設定目前位置的標記
            if (currentMarker == null) {//剛開啟的第一次add mark
                currentMarker = mMap.addMarker(m);
                Log.e("is null", "is null");
            } else { //此後都跑這裡
                currentMarker.setPosition(here);//每一次位置改變都會跑進來這裡取得新的Latlng座標位置,這裡直接將此Marker的位置指定給新的地理位置
                Log.e("not null", "not null");
            }
        } else {
            Toast.makeText(this, "無法定位", Toast.LENGTH_LONG).show();
        }
    }

//             ================           ==================              ================

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        // 已經連線到Google Services
        // 啟動位置更新服務
        // 位置資訊更新的時候，應用程式會自動呼叫LocationListener.onLocationChanged
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
            //若權限不允許則return
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, MapsActivity.this);

        mMap.setMyLocationEnabled(true);//取得地圖上位置藍點及右上角準心按鈕
        mMap.getUiSettings().setMyLocationButtonEnabled(false);//隱藏準心按鈕
        mMap.getUiSettings().setMapToolbarEnabled(false);//關閉點選Marker後右下角出現的工具列
        polylineOpt = new PolylineOptions();
        //線條顏色
        polylineOpt.color(Color.BLUE);
        //線條寬度
        polylineOpt.width(8f);

        initLandMarks();
        addLandMarks();
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(westVirginia, 6.0f));//鏡頭 以WestVirginia為中心
        mMap.setOnMarkerClickListener(this);    //地標點擊監聽
        mMap.setInfoWindowAdapter(new MyInfoAdapter(this));//資訊視窗樣式
        mMap.setOnInfoWindowClickListener(this);// 資訊視窗點擊監聽
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                progressDialog.setMessage(getString(R.string.text_connect));
                progressDialog.setCancelable(false);
                progressDialog.show();
                connect.sendAddressRequest(ADDRESS_URL, latLng.latitude, latLng.longitude);
            }
        });
    }
//＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

    //EventBus
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessConnect(Map<String, Object> data) {
        if ((int) data.get("type") == TYPE_ADDRESS) {
            Toast.makeText(MapsActivity.this, (String) data.get("data"), Toast.LENGTH_SHORT).show();

        } else if ((int) data.get("type") == TYPE_LOCATION) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((LatLng) data.get("data"), 16.0f));

        }

        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

//             ================           ==================              ================

    @Override
    public void onConnectionSuspended(int i) {
        // Google Services連線中斷
        // int參數是連線中斷的代號
    }
//             ================           ==================              ================

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // Google Services連線失敗
        // ConnectionResult參數是連線失敗的資訊
        int errorCode = connectionResult.getErrorCode();
        // 裝置沒有安裝Google Play服務
        if (errorCode == ConnectionResult.SERVICE_MISSING) {
            Toast.makeText(this, "裝置沒有安裝Google Play服務",
                    Toast.LENGTH_LONG).show();
        }
    }
//             ================           ==================              ================

    @Override
    public void onLocationChanged(Location location) {
        // 位置改變
        // Location參數是目前的位置
        currentLocation = location;
        getLocation(currentLocation);
    }
//             ================           ==================              ================

    private synchronized void configGoogleApiClient() {
        // 建立Google API用戶端物件
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }
//             ================           ==================              ================

    private void startConnectGoogleMapAPI() {
        init();
        configGoogleApiClient();
        configLocationRequest();
        if (!googleApiClient.isConnected()) {
            googleApiClient.connect();
        }
//        loadKML();
    }

//             ================           ==================              ================

    /**
     * 更多Kml相關用法在以下網址
     * http://googlemaps.github.io/android-maps-utils/
     * https://developers.google.com/maps/documentation/android-api/utility/kml?hl=zh-tw
     */

    private void loadKML() {
        try {
            KmlLayer layer = new KmlLayer(mMap, getAssets().open("testroute.kml"), this);
            layer.addLayerToMap();
            //            layer.removeLayerFromMap();移除該kmllayer
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //             ================           ==================              ================
    // 建立Location請求物件
    private void configLocationRequest() {
        locationRequest = new LocationRequest();
        // 設定讀取位置資訊的間隔時間為一秒（1000ms）
        locationRequest.setInterval(1000);
        // 設定讀取位置資訊最快的間隔時間為一秒（1000ms）
        locationRequest.setFastestInterval(1000);
        // 設定優先讀取高精確度的位置資訊（GPS）
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    //   todo android 6.0後要權限          ================           ==================              ================
    //但若是版本在6.0以前的會只要有在Manifest加入權限即可直接執行,不影響程式進行
    private void checkPermissionsForResult() {
        Log.e("startcheck", "startcheck");
        final int PERMISSION_ACCESS_FINE_LOCATION = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION);
        final int PERMISSION_ACCESS_COARSE_LOCATION = ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION);
        //欲申請的權限
        String[] locationPermissions = new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION};
//        已擁有權限－PERMISSION_GRANTED
//        代表應用程式目前已獲得使用者允許使用該權限。
//
//        無權限－PERMISSION_DENIED
//        應用程式目前無該權限。

        //權限有分一般權限（在Manifest即可）及危險權限（除了Menifest還要在此和使用者請求權限）
        //https://litotom.com/2016/05/15/android-6-permission/

        //如果在系統未給予此APP權限
        if (PERMISSION_ACCESS_FINE_LOCATION == PackageManager.PERMISSION_DENIED && PERMISSION_ACCESS_COARSE_LOCATION == PackageManager.PERMISSION_DENIED) {
            //申請權限
            if (ActivityCompat.shouldShowRequestPermissionRationale(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(MapsActivity.this, locationPermissions, LOCATION_PERMISSION_REQUEST);
            } else {
                goToSettingPermissions();
            }
        } else {//如果已至系統給予權限
            startConnectGoogleMapAPI();
        }
    }

    private boolean checkPermissionAfterResult(int[] grantResults) {//對每一個權限比對
        boolean isAccept = false;
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] == PERMISSION_GRANTED) {
                isAccept = true;//如果比對過程中如果是true就繼續比對
            } else {
                isAccept = false;
                return isAccept;//如果比對過程中有一個false就馬上回傳
            }
        }
        return isAccept;//如果都是true才會走到這裡並且回傳
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST: {
                //若拒絕則grantResults[] 資料長度是0
                if (grantResults.length > 0 && checkPermissionAfterResult(grantResults)) {  //允許
                    //同意後做的事情
                    Log.e("startconnect", "startconnect");
                    startConnectGoogleMapAPI();
                } else {                                                                    //拒絕
                    Toast.makeText(MapsActivity.this, "What The Hell...?!", Toast.LENGTH_SHORT).show();
                    finish();
                    Log.e("stop", "stop");
                }
                break;
            }
        }
    }
//             ================           ==================              ================

    private void goToSettingPermissions() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MapsActivity.this);
        alert.setMessage("前往設定權限？");
        alert.setPositiveButton("前往", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent settings = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + MapsActivity.this.getPackageName()));
                settings.addCategory(Intent.CATEGORY_DEFAULT);
                settings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(settings);
            }
        });
        alert.show();
    }

    //  ========================================  ========================================  ========================================
    private void closeKeyboard() { //關閉虛擬鍵盤
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

//            ================           ==================              ================

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 移除Google API用戶端連線
        if (googleApiClient != null) {
            if (googleApiClient.isConnected()) {
                googleApiClient.disconnect();
            }
        }
        EventBus.getDefault().unregister(this);

    }

//             ================           ==================              ================

    @Override
    protected void onResume() {
        super.onResume();
//        setUpMapIfNeeded();
//         連線到Google API用戶端
        if (googleApiClient != null) {
            if (!googleApiClient.isConnected() && currentMarker != null) {
                startConnectGoogleMapAPI();
            }
        }
    }
//             ================           ==================              ================

    @Override
    protected void onPause() {
        super.onPause();
        // 移除位置請求服務
        if (googleApiClient != null) {
            if (googleApiClient.isConnected()) {
                LocationServices.FusedLocationApi.removeLocationUpdates(
                        googleApiClient, this);
            }
        }
    }

    //             ================           ==================              ================

    @Override
    protected void onStop() {
        super.onStop();
        // 移除Google API用戶端連線
        if (googleApiClient != null) {
            if (googleApiClient.isConnected()) {
                googleApiClient.disconnect();
            }
        }
    }
}
