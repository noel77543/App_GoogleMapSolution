package tw.com.creatidea.t_57_googlemap_solution;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
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
import tw.com.creatidea.t_57_googlemap_solution.basic.BasicMapActivity;
import tw.com.creatidea.t_57_googlemap_solution.connect.GoogleConnect;
import tw.com.creatidea.t_57_googlemap_solution.model.AddressInfo;
import tw.com.creatidea.t_57_googlemap_solution.model.DirectionInfo;
import tw.com.creatidea.t_57_googlemap_solution.model.DistanceInfo;
import tw.com.creatidea.t_57_googlemap_solution.model.PlaceDetail;
import tw.com.creatidea.t_57_googlemap_solution.model.PlaceInfo;
import tw.com.creatidea.t_57_googlemap_solution.navigation.NavigationDrawer;
import tw.com.creatidea.t_57_googlemap_solution.navigation.model.NavigationData;
import tw.com.creatidea.t_57_googlemap_solution.util.EventCenter;
import tw.com.creatidea.t_57_googlemap_solution.util.PlaceDetailPopupWindow;
import tw.com.creatidea.t_57_googlemap_solution.util.TargetChooseDialog;

import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_ADDRESS;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_DIRECTION;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_DISTANCE;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_LOCATION;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_PLACE;
//import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_PLACE_DETAIL;

/**
 * Created by noel on 2017/12/5.
 */

public class MainActivity extends BasicMapActivity implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMapClickListener, NavigationDrawer.OnNavigationItemClickListener, View.OnKeyListener, View.OnClickListener, TargetChooseDialog.OnAcceptClickListener, PlaceDetailPopupWindow.OnMapIconClickListener {
    private Snackbar snackBar;
    private Map<String, Marker> placeMarkerMap = new HashMap<>();
    private Map<String, Integer> placeMarkerIndex = new HashMap<>();
    private MyInfoAdapter adapter;
    //點選的目標點位
    private LatLng latLngTarget;
    private Marker markerTarget;
    private MarkerOptions optionsTarget = new MarkerOptions();

    private GoogleConnect connect;
    //用來控制infowindow 開啟或關閉
    private boolean isInfoWindowShown = false;
    //路線規劃
    private Polyline polyline;
    //drawer
    private NavigationDrawer navigationDrawer;
    private TargetChooseDialog targetChooseDialog;
    private PlaceInfo placeInfo;
    //劃線用 終點marker
    private Marker destinationMarker;
    private String markerTitle;

    // butterknife
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.edit)
    MultiAutoCompleteTextView edit;
    @BindView(R.id.btn_focus)
    Button btnFocus;
    @BindView(R.id.btn_reload)
    Button btnReload;
    @BindView(R.id.imageview)
    ImageView imageview;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.listview)
    public ListView listview;
    @BindView(R.id.drawer_layout)
    public DrawerLayout drawerLayout;


    private PlaceDetailPopupWindow placeDetailPopupWindow;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        edit.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        edit.setOnKeyListener(this);
        targetChooseDialog = new TargetChooseDialog(this);
        targetChooseDialog.setOnAcceptClickListener(this);
        navigationDrawer = new NavigationDrawer(this);
        navigationDrawer.setOnNavigationItemClickListener(this);
        adapter = new MyInfoAdapter(this);
        connect = new GoogleConnect(this);
        placeDetailPopupWindow = new PlaceDetailPopupWindow(this);
        placeDetailPopupWindow.setOnMapIconClickListener(this);
        initSnackbar();
        initGooglemapUtils();
    }
    //----------

    /***
     * Snackbar 初始化
     */
    private void initSnackbar() {
        snackBar = Snackbar
                .make(coordinatorLayout, "", Snackbar.LENGTH_INDEFINITE)
                .setActionTextColor(getResources().getColor(R.color.white))
                .setAction(getString(R.string.snackbar_distance_googlemap_action), this);
    }
    //--------

    /**
     * snackbar用
     */
    @Override
    public void onClick(View v) {
        if (placeMarkerIndex.get(markerTitle) != null) {
            PlaceInfo.ResultsBean resultBeans = placeInfo.getResults().get(placeMarkerIndex.get(markerTitle));
            placeDetailPopupWindow.showSightFoodDescribePopupWindow(resultBeans);
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(getString(R.string.toast_googlemap_non_place_detail));
        }
    }
    //----------


    /**
     * google map 地圖設定
     */
    private void initGooglemapUtils() {
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
    }

    //----------
    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    //----------
    //EventBus
    @Subscribe
    public void onSuccessConnect(Map<String, Object> data) {
        //經緯度轉地址
        if ((int) data.get("type") == TYPE_ADDRESS) {
            AddressInfo addressInfo = (AddressInfo) data.get("data");
            addTargetMarkerOnMap(latLngTarget, getAddressFormat(addressInfo.getResults()));

            //輸入查詢 地址轉經緯度
        } else if ((int) data.get("type") == TYPE_LOCATION) {
            latLngTarget = (LatLng) data.get("data");
            addTargetMarkerOnMap((LatLng) data.get("data"), edit.getText().toString());
            goToTargetLocationByAnimate(latLngTarget, 12.0f);

            //途經點查詢 路線規劃
        } else if ((int) data.get("type") == TYPE_DIRECTION) {
            DirectionInfo directionInfo = (DirectionInfo) data.get("data");
            addPolyLineOnMap(directionInfo);
            double targetLat = markerTarget == null ? destinationMarker.getPosition().latitude : markerTarget.getPosition().latitude;
            double targetLng = markerTarget == null ? destinationMarker.getPosition().longitude : markerTarget.getPosition().longitude;
            connect.connectToGetDistance(getUserLocation().getLatitude(), getUserLocation().getLongitude(), targetLat, targetLng);

            //地方資訊
        } else if ((int) data.get("type") == TYPE_PLACE) {
            btnSearch.setVisibility(View.VISIBLE);
            placeInfo = (PlaceInfo) data.get("data");
            goToTargetLocationByAnimate(new LatLng(getUserLocation().getLatitude(), getUserLocation().getLongitude()), 16.0f);
            targetChooseDialog.setStationData(placeInfo);
            new PlaceMarkerHandler(this, googleMap, placeInfo, placeMarkerMap, placeMarkerIndex).execute();

            //error message
        } else if ((int) data.get("type") == TYPE_DISTANCE) {
            DistanceInfo distanceInfo = (DistanceInfo) data.get("data");
            String distance = (distanceInfo.getRows().get(0).getElements().get(0).getDistance().getValue() / 10) + "公尺";
            String time = (distanceInfo.getRows().get(0).getElements().get(0).getDuration().getValue() / 60) + "分";
            snackBar.setText(String.format(getString(R.string.snackbar_distance_googlemap), distance, time));
            snackBar.show();
        } else {
            String errString = (String) data.get("data");
            Toast.makeText(this, errString, Toast.LENGTH_SHORT).show();
            if (errString.equals(getString(R.string.toast_googlemap_non_place))) {
                placeMarkerMap.clear();
                btnSearch.setVisibility(View.INVISIBLE);
            }
        }
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

        if (markerTarget != null && isInfoWindowShown) {
            markerTarget.hideInfoWindow();
            markerTarget.remove();
            isInfoWindowShown = false;
        } else if (!isInfoWindowShown) {

            latLngTarget = latLng;
            connect.connectToGetAddress(latLngTarget.latitude, latLngTarget.longitude);
            isInfoWindowShown = true;
        }
    }


    //----------


    @Override
    public void onInfoWindowClick(final Marker marker) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(MessageFormat.format(getString(R.string.toast_route), marker.getTitle()));
        dialog.setPositiveButton(getString(R.string.permission_goahead), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                destinationMarker = marker;
                String startLat = getUserLocation().getLatitude() + "";
                String startLng = getUserLocation().getLongitude() + "";
                String endLat = marker.getPosition().latitude + "";
                String endLng = marker.getPosition().longitude + "";
                connect.connectToGetDirection(startLat, startLng, endLat, endLng);
                markerTitle = marker.getTitle();
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
        targetChooseDialog.setTitleType(navigation.getTextCh());
        connect.connectToGetPlace(getUserLocation().getLatitude() + "", getUserLocation().getLongitude() + "", navigation.getTextEn());
    }
    //----------

    /***
     * 當選擇place名稱後
     * @param index
     */
    @Override
    public void OnAcceptClick(int index) {
        isInfoWindowShown = true;
        Marker marker = placeMarkerMap.get(placeInfo.getResults().get(index).getName());
        marker.showInfoWindow();
        goToTargetLocationByAnimate(marker.getPosition(), 20.0f);
    }

    //--------

    // 進行 地址搜尋
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
            String searchAddress = edit.getText().toString();
            if (searchAddress.length() > 0) {
                connect.connectToGetLocation(searchAddress);
            } else {
                Toast.makeText(this, getString(R.string.toast_enteraddress), Toast.LENGTH_SHORT).show();
            }
            closeKeyboard();//關閉Keyboard
            return true;
        }
        return false;
    }


    //----------
    @OnClick({R.id.btn_focus, R.id.btn_reload, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_focus:
                goToTargetLocation(new LatLng(getUserLocation().getLatitude(), getUserLocation().getLongitude()), 16.0f);
                break;

            case R.id.btn_reload:
                googleMap.clear();
                btnSearch.setVisibility(View.INVISIBLE);
                checkPermissionsForResult();
                break;

            case R.id.btn_search:
                targetChooseDialog.show();
                break;
        }
    }
    //-------------
    /**
     * 當點選dialog中的地圖icon
     * */
    @Override
    public void onMapIconClick(PlaceInfo.ResultsBean resultBeans) {
        Log.e("goto",resultBeans.getGeometry().getLocation().getLat()+","+resultBeans.getGeometry().getLocation().getLng());
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
