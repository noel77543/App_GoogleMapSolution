package com.sung.noel.tw.googlemapsolution.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;
import com.google.maps.android.kml.KmlLayer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import com.sung.noel.tw.googlemapsolution.BuildConfig;
import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.base.BaseMapActivity;
import com.sung.noel.tw.googlemapsolution.connect.GoogleConnect;
import com.sung.noel.tw.googlemapsolution.connect.VersionConnect;
import com.sung.noel.tw.googlemapsolution.event.EventCenter;
import com.sung.noel.tw.googlemapsolution.main.adapter.MyInfoAdapter;
import com.sung.noel.tw.googlemapsolution.main.model.VersionData;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.AddressInfo;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.DirectionInfo;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.DistanceInfo;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.PlaceInfo;
import com.sung.noel.tw.googlemapsolution.navigation.NavigationDrawer;
import com.sung.noel.tw.googlemapsolution.navigation.model.NavigationData;
import com.sung.noel.tw.googlemapsolution.util.PhoneUtil;
import com.sung.noel.tw.googlemapsolution.util.PlaceDetailPopupWindow;
import com.sung.noel.tw.googlemapsolution.util.PlaceMarkerHandler;
import com.sung.noel.tw.googlemapsolution.util.dialog.talk.TalkBoardDialog;
import com.sung.noel.tw.googlemapsolution.util.dialog.version.VersionDialog;
import com.sung.noel.tw.googlemapsolution.util.firebase.analytics.MyFirebaseEventCenter;
import com.sung.noel.tw.googlemapsolution.util.firebase.database.MyFirebaseDataBaseCenter;
import com.sung.noel.tw.googlemapsolution.util.firebase.database.model.FirebaseData;
import com.sung.noel.tw.googlemapsolution.util.preference.SharedPreferenceUtil;

import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_ADDRESS;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_DIRECTION;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_DISTANCE;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_LOCATION;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_PLACE;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_VERSION;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_VERSION_ON_GOOGLE_PLAY;

/**
 * Created by noel on 2017/12/5.
 */

public class MainActivity extends BaseMapActivity implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMapClickListener, NavigationDrawer.OnNavigationItemClickListener, View.OnKeyListener, View.OnClickListener, MyFirebaseDataBaseCenter.OnFirebaseDataChangeListener, VersionDialog.OnAcceptListener, TalkBoardDialog.OnSuccessRegisterListener {

    private final float MAP_SIZE_SMALL = 12.0f;
    private final float MAP_SIZE_NORMAL = 15.5f;
    private final float MAP_SIZE_LARGE = 20.0f;


    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.edit)
    MultiAutoCompleteTextView edit;
    @BindView(R.id.btn_talk)
    Button btnTalk;
    @BindView(R.id.btn_focus)
    Button btnFocus;
    @BindView(R.id.btn_reload)
    Button btnReload;

    @BindView(R.id.listview)
    public ListView listview;
    @BindView(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    private VersionData versionData;
    private PhoneUtil phoneUtil;
    private Map<String, Marker> placeMarkerMap = new HashMap<>();
    private Map<String, Integer> placeMarkerIndex = new HashMap<>();
    private MyInfoAdapter adapter;
    //點選的目標點位
    private LatLng latLngTarget;
    private Marker markerTarget;
    private MarkerOptions optionsTarget = new MarkerOptions();
    //用來控制infowindow 開啟或關閉
    private boolean isInfoWindowShown = false;
    //路線規劃
    private Polyline polyline;
    //drawer
    private NavigationDrawer navigationDrawer;
    private PlaceInfo placeInfo;
    //劃線用 終點marker
    private Marker destinationMarker;
    private String markerTitle;

    private GoogleConnect connect;
    private VersionConnect versionConnect;
    private VersionDialog versionDialog;
    private TalkBoardDialog talkBoardDialog;
    private PlaceDetailPopupWindow placeDetailPopupWindow;
    private MyFirebaseEventCenter myFirebaseEventCenter;
    private MyFirebaseDataBaseCenter myFirebaseDataBaseCenter;
    private FirebaseData firebaseData;
    private SharedPreferenceUtil sharedPreferenceUtil;
    private FirebaseData.OnlineBean onlineBean;
    private boolean isLogin = false;
    //剛開啟App的boolean 判斷  會影響Login
    private boolean isStartUsed = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        phoneUtil = new PhoneUtil(this);
        sharedPreferenceUtil = new SharedPreferenceUtil(this, SharedPreferenceUtil.NAME_TALK_BOARD);
        myFirebaseDataBaseCenter = new MyFirebaseDataBaseCenter();
        myFirebaseEventCenter = new MyFirebaseEventCenter(this);
        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.setOnNavigationItemClickListener(this);
        adapter = new MyInfoAdapter(this);
        connect = new GoogleConnect(this);
        versionConnect = new VersionConnect(this);
        placeDetailPopupWindow = new PlaceDetailPopupWindow(this);
        talkBoardDialog = new TalkBoardDialog(this);
        talkBoardDialog.setOnSuccessRegisterListener(this);
        versionDialog = new VersionDialog(this);


        phoneUtil.setStatusBarColor(this, android.R.color.transparent);
        myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, MyFirebaseEventCenter.ACTION_MAIN_START);
        myFirebaseDataBaseCenter.setOnFirebaseDataChangeListener(this);
        edit.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        edit.setOnKeyListener(this);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        initGoogleMapUtils();
        connectToGetVersionData();
    }

    //-----------

    /***
     *  取得版控資訊
     */
    public void connectToGetVersionData() {
        versionConnect.connectToGetVersionData();
    }
    //-----------

    /***
     *  取得最新版本名稱
     */
    public void connectToGetVersionOnGooglePlay() {
        versionConnect.connectToGetVersionOnGooglePlay();
    }

    //---------

    /***
     * 當成功註冊
     */
    @Override
    public void onSuccessRegistered() {
        isLogin = true;
    }

    //-------

    /***
     * 登入
     */
    private void login() {
        if (!isLogin) {
            String name = sharedPreferenceUtil.getUserName();
            //已經註冊的對象
            if (firebaseData != null && !name.equals("")) {
                myFirebaseDataBaseCenter.login(onlineBean, firebaseData.getOnline().size());
                isLogin = true;
            }
        }
    }

    //--------

    /***
     * 登出
     */
    private void logout() {
        if (isLogin) {
            if (firebaseData != null) {
                myFirebaseDataBaseCenter.logout(onlineBean);
                isLogin = false;
            }
        }
    }


    //----------


    /**
     * google map 地圖設定
     */
    private void initGoogleMapUtils() {
        //隱藏準心按鈕
        googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        //資訊視窗樣式
        googleMap.setInfoWindowAdapter(adapter);
        // 資訊視窗點擊監聽
        googleMap.setOnInfoWindowClickListener(this);
        //MapClickListener
        googleMap.setOnMapClickListener(this);
    }

    //----------
    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        login();
    }

    //----------
    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
        logout();
    }

    //-------------

    /***
     * 當點選前往更新
     */
    @Override
    public void onAcceptToUpdateVersion() {
        myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, MyFirebaseEventCenter.ACTION_MAIN_UPDATE);
        String appPackageName = getPackageName();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        finish();
    }

    //----------
    //EventBus
    @Subscribe
    public void onSuccessConnect(final Map<String, Object> data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //版控
                if ((int) data.get("type") == TYPE_VERSION) {
                    versionData = (VersionData) data.get("data");
                    connectToGetVersionOnGooglePlay();
                }
                //google play上的version name
                else if ((int) data.get("type") == TYPE_VERSION_ON_GOOGLE_PLAY) {
                    if (!checkVersionName((String) data.get("data"))) {
                        //TODO 這裡以後可以更改結構 加入 type for 強制更新 非強制更新 不提醒更新等行為
                        if (versionData.getVersionCode() != BuildConfig.VERSION_CODE || !versionData.getVersionName().equals(BuildConfig.VERSION_NAME)) {
                            versionDialog.setOnAcceptListener(MainActivity.this).show();
                        }
                    }
                }
                //經緯度轉地址
                else if ((int) data.get("type") == TYPE_ADDRESS) {
                    AddressInfo addressInfo = (AddressInfo) data.get("data");
                    addTargetMarkerOnMap(latLngTarget, getAddressFormat(addressInfo.getResults()));

                    //輸入查詢 地址轉經緯度
                } else if ((int) data.get("type") == TYPE_LOCATION) {
                    latLngTarget = (LatLng) data.get("data");
                    addTargetMarkerOnMap((LatLng) data.get("data"), edit.getText().toString());
                    goToTargetLocationByAnimate(latLngTarget, MAP_SIZE_LARGE);

                    //途經點查詢 路線規劃
                } else if ((int) data.get("type") == TYPE_DIRECTION) {
                    DirectionInfo directionInfo = (DirectionInfo) data.get("data");
                    addPolyLineOnMap(directionInfo);
                    double targetLat = destinationMarker.getPosition().latitude;
                    double targetLng = destinationMarker.getPosition().longitude;
                    if (markerTarget != null) {
                        targetLat = markerTarget.getPosition().latitude;
                        targetLng = markerTarget.getPosition().longitude;
                    }
                    connect.connectToGetDistance(getUserLocation().getLatitude(), getUserLocation().getLongitude(), targetLat, targetLng);

                    //地方資訊
                } else if ((int) data.get("type") == TYPE_PLACE) {
                    placeInfo = (PlaceInfo) data.get("data");
                    goToTargetLocationByAnimate(new LatLng(getUserLocation().getLatitude(), getUserLocation().getLongitude()), MAP_SIZE_NORMAL);
                    new PlaceMarkerHandler(MainActivity.this, googleMap, placeInfo, placeMarkerMap, placeMarkerIndex).execute();

                    //error message
                } else if ((int) data.get("type") == TYPE_DISTANCE) {
                    DistanceInfo distanceInfo = (DistanceInfo) data.get("data");
                    String distance = String.format(getString(R.string.distance_meter), (distanceInfo.getRows().get(0).getElements().get(0).getDistance().getValue() / 10));
                    String time = String.format(getString(R.string.distance_time), (distanceInfo.getRows().get(0).getElements().get(0).getDuration().getValue() / 60));
                    displaySnackbar(distance, time);

                } else {
                    String errString = (String) data.get("data");
                    Toast.makeText(MainActivity.this, errString, Toast.LENGTH_SHORT).show();
                    if (errString.equals(getString(R.string.toast_googlemap_non_place))) {
                        placeMarkerMap.clear();
                    }
                }
            }
        });

    }
    //----------------------------

    /***
     * 檢測版本名稱
     * @param googlePlayVersionName
     * @return
     */
    private boolean checkVersionName(String googlePlayVersionName) {
        String[] currentVersionNameArray = BuildConfig.VERSION_NAME.split("\\.");
        String[] googlePlayVersionNameArray = googlePlayVersionName.split("\\.");

        for (int i = 0; i < currentVersionNameArray.length; i++) {
            Log.e("C"+i,""+currentVersionNameArray[i]);
            Log.e("G"+i,""+googlePlayVersionNameArray[i]);

            if (Integer.parseInt(currentVersionNameArray[i]) < Integer.parseInt(googlePlayVersionNameArray[i])) {
                return false;
            }
        }
        return true;
    }

    //----------------------------

    /***
     *  display snackbar
     */
    private void displaySnackbar(String distance, String time) {
        Snackbar.make(coordinatorLayout, String.format(getString(R.string.snackbar_distance_googlemap), distance, time), Snackbar.LENGTH_LONG)
                .setActionTextColor(getResources().getColor(android.R.color.white))
                .setAction(getString(R.string.snackbar_distance_googlemap_action), this)
                .show();
    }

    //-----------------------------

    /**
     * 可能回傳 多筆地址資訊 有字串就return
     */
    private String getAddressFormat(List<AddressInfo.ResultsBean> results) {
        for (int i = 0; i < results.size(); i++) {
            String address = results.get(i).getFormattedAddress();
            if (address != null && !address.equals(""))
                return address;
        }
        return getString(R.string.text_googlemap_non_address);
    }

    //-----------------------------
    private void addTargetMarkerOnMap(LatLng myPostion, String myTitle) {

        if (markerTarget != null) {
            markerTarget.remove();
        }

        markerTarget = googleMap.addMarker(optionsTarget
                .position((myPostion))
                .title(myTitle)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.myicon))
                .anchor(0.5f, 0.9f));
        markerTarget.showInfoWindow();
    }

    //-----------------------------

    /**
     * 繪製polyline在地圖上
     */
    private void addPolyLineOnMap(DirectionInfo directionInfo) {
        if (polyline != null) {
            polyline.remove();
        }
        PolylineOptions polyLines = new PolylineOptions();
        polyLines.width(10);
        polyLines.color(Color.RED);
        String line = directionInfo.getRoutes().get(0).getOverview_polyline().getPoints();

        //因為google 此 api 路線僅規劃於道路上 為了使起點與目標終點 都與此線段連線 需要在最初與最後分別加入使用者位置與目標位置
        List<LatLng> decodedPath = PolyUtil.decode(line);
        decodedPath.add(0, new LatLng(getUserLocation().getLatitude(), getUserLocation().getLongitude()));
        decodedPath.add(decodedPath.size(), destinationMarker.getPosition());
        polyline = googleMap.addPolyline(polyLines.addAll(decodedPath));
    }
    //----------

    @Override
    public void onMapClick(LatLng latLng) {
        //每次繪製前這裡清除前一次繪製的路線
        if (polyline != null) {
            polyline.remove();
        }

        //拔除marker
        if (markerTarget != null && isInfoWindowShown) {
            markerTarget.hideInfoWindow();
            markerTarget.remove();
            isInfoWindowShown = false;

            myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, MyFirebaseEventCenter.ACTION_MAIN_MAP_MARKER_REMOVE);
        }
        //插上marker
        else if (!isInfoWindowShown) {
            latLngTarget = latLng;
            connect.connectToGetAddress(latLngTarget.latitude, latLngTarget.longitude);
            isInfoWindowShown = true;

            myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, MyFirebaseEventCenter.ACTION_MAIN_MAP_MARKER_PUT);
        }
    }


    //----------

    /***
     * 當點擊Info Window
     * @param marker
     */
    @Override
    public void onInfoWindowClick(final Marker marker) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(MessageFormat.format(getString(R.string.toast_route), marker.getTitle()));
        dialog.setPositiveButton(getString(R.string.dialog_go), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                destinationMarker = marker;
                String startLat = getUserLocation().getLatitude() + "";
                String startLng = getUserLocation().getLongitude() + "";
                String endLat = marker.getPosition().latitude + "";
                String endLng = marker.getPosition().longitude + "";
                connect.connectToGetDirection(startLat, startLng, endLat, endLng);
                markerTitle = marker.getTitle();
                goToTargetLocationByAnimate(currentLatlng, MAP_SIZE_NORMAL);
                myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, MyFirebaseEventCenter.ACTION_MAIN_MAP_DIRECTION);
            }
        });
        dialog.show();
    }
    //----------

    /***
     *
     * 當選擇側邊欄項目時 取得附近五百公尺內該項目位置
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onNavigationItemClick(AdapterView<?> parent, View view, int position, long id) {
        googleMap.clear();
        NavigationData navigation = (NavigationData) parent.getAdapter().getItem(position);
        connect.connectToGetPlace(getUserLocation().getLatitude() + "", getUserLocation().getLongitude() + "", navigation.getTextEn());
        myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, String.format(MyFirebaseEventCenter.ACTION_MAIN_MAP_PLACE, navigation.getTextCh()));
    }

    //--------

    /***
     * 進行 地址搜尋
     */
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
            String searchAddress = edit.getText().toString();
            if (searchAddress.length() > 0) {
                connect.connectToGetLocation(searchAddress);
                myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, MyFirebaseEventCenter.ACTION_MAIN_MAP_ADDRESS);
            } else {
                Toast.makeText(this, getString(R.string.toast_enteraddress), Toast.LENGTH_SHORT).show();
            }
            closeKeyboard();//關閉Keyboard
            return true;
        }
        return false;
    }


    //----------
    @OnClick({R.id.btn_focus, R.id.btn_reload, R.id.btn_talk, R.id.btn_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //定位
            case R.id.btn_focus:
                goToTargetLocation(new LatLng(getUserLocation().getLatitude(), getUserLocation().getLongitude()), MAP_SIZE_SMALL);
                break;
            //重載
            case R.id.btn_reload:
                googleMap.clear();
                getLocationPermissionsWithCheck();
                break;
            //聊天室
            case R.id.btn_talk:
                talkBoardDialog.showDialog();
                break;
            //菜單
            case R.id.btn_menu:
                //如果菜單是打開的
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                //關閉的
                else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                break;
        }
    }

    /**
     * snackbar用
     */
    @Override
    public void onClick(View v) {

        if (placeMarkerIndex.get(markerTitle) != null) {
            PlaceInfo.ResultsBean resultBeans = placeInfo.getResults().get(placeMarkerIndex.get(markerTitle));
            placeDetailPopupWindow.showPopupWindow(resultBeans);
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(getString(R.string.toast_googlemap_non_place_detail));
        }
        myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, MyFirebaseEventCenter.ACTION_MAIN_MAP_PLACE_DETAIL);
    }


    //---------

    /***
     * 當 real time db資料改變
     * @param firebaseData
     */
    @Override
    public void onFirebaseDataChange(FirebaseData firebaseData) {
        this.firebaseData = firebaseData;
        onlineBean = new FirebaseData.OnlineBean();
        onlineBean.setName(sharedPreferenceUtil.getUserName());
        onlineBean.setUuid(Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID));
        if (!isStartUsed) {
            login();
            isStartUsed = true;
        }
    }

    //-----------------------------

    /**
     * 更多Kml相關用法在以下網址
     * http://googlemaps.github.io/android-maps-utils/
     * https://developers.google.com/maps/documentation/android-api/utility/kml?hl=zh-tw
     */

    private void loadKML() {
        try {
            KmlLayer layer = new KmlLayer(googleMap, getAssets().open("testroute.kml"), this);
            layer.addLayerToMap();
            //            layer.removeLayerFromMap();移除該kmllayer
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
