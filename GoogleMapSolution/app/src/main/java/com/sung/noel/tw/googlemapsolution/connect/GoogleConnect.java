package com.sung.noel.tw.googlemapsolution.connect;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.base.BaseConnect;
import com.sung.noel.tw.googlemapsolution.event.EventCenter;
import com.sung.noel.tw.googlemapsolution.main.MainActivity;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.AddressInfo;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.DirectionInfo;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.DistanceInfo;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.PlaceDetail;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.PlaceInfo;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_ADDRESS;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_DIRECTION;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_DISTANCE;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_LOCATION;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_PLACE;

public class GoogleConnect extends BaseConnect {

    private DirectionInfo directionInfo;
    private AddressInfo addressInfo;
    private PlaceInfo placeInfo;
    private PlaceDetail placeDetail;
    private DistanceInfo distanceInfo;
    private MainActivity context;

    public GoogleConnect(Context context) {
        super(context);
        this.context = (MainActivity) context;
    }
    //--------------------------------------------------

    /**
     * 經緯度轉地址
     * http://maps.google.com/maps/api/geocode/json?latlng=25.0519231,121.5496221&language=zh-TW&sensor=true
     * 將經緯度帶入此API會回傳json
     * 解析後即可取得所有該經緯度地址資訊
     */
    public void connectToGetAddress(final double latitude, final double longitude) {

        loadingDialog.setLoadingMessage(context.getString(R.string.dialog_message_googlemap_getaddress));
        if (isNetWorkable()) {
            loadingDialog.showLoadingDialog();
            String url = MessageFormat.format(ConnectInfo.API_GOOGLE_GEOCODE, latitude + "," + longitude, "zh-TW",context.getString(R.string.google_maps_key));
            request = new Request.Builder().url(url).get().build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    loadingDialog.dismiss();
                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_address));
                }

                @Override
                public void onResponse(Call call, Response response)  {

                    loadingDialog.dismiss();
                    reader = response.body().charStream();
                    addressInfo = gson.fromJson(reader, AddressInfo.class);
                    EventCenter.getInstance().sendAddress(TYPE_ADDRESS, addressInfo);
                }
            });
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_net_cant_work));
        }
    }


    //--------------------------------------------------

    /**
     * 地址轉經緯度   todo p.s 與sendAddressRequest該api中加入address="" 的方式相同都能取得該地址的經緯度
     */
    public void connectToGetLocation(final String address) {

        LatLng addressLatlng;
        double latitude = 0;
        double longitude = 0;
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addressRequest = geocoder.getFromLocationName(address, 1);
            if (addressRequest.size() > 0) {
                latitude = addressRequest.get(0).getLatitude();
                longitude = addressRequest.get(0).getLongitude();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            addressLatlng = new LatLng(latitude, longitude);
            EventCenter.getInstance().sendLocation(TYPE_LOCATION, addressLatlng);
        }
    }

    //---------------------

    /**
     * https://maps.googleapis.com/maps/api/directions/json?origin=25.051875,121.549663&destination=25.045848,121.543998&mode=walking&language=zh-TW&sensor=true&key=AIzaSyBEZQZ_LbypO2dSxd3KG4PfGm5HFjq9pHg
     * https://developers.google.com/maps/documentation/javascript/directions#DirectionsRequests
     * 取得最佳路線
     */
    public void connectToGetDirection(String startLat, String startLng, String endLat, String endLng) {
        String origin = startLat + "," + startLng;
        String destination = endLat + "," + endLng;
        String mode = "walking";
        String key = context.getString(R.string.google_maps_key);

        if (isNetWorkable()) {
            String url = MessageFormat.format(ConnectInfo.API_GOOGLE_DIRECTION, origin, destination, mode, key, "zh-TW");

            request = new Request.Builder().url(url).get().build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_address));
                }

                @Override
                public void onResponse(Call call, Response response)  {
                    reader = response.body().charStream();
                    directionInfo = gson.fromJson(reader, DirectionInfo.class);
                    EventCenter.getInstance().sendRoute(TYPE_DIRECTION, directionInfo);
                }
            });
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_net_cant_work));
        }
    }
    //---------------------

    /**
     * 取得地方資訊
     */
    public void connectToGetPlace(String lat, String lng, String type) {

        String location = lat + "," + lng;
        int radius = 500;
        String language = "zh-tw";
        String key = context.getString(R.string.google_maps_key);
        loadingDialog.setLoadingMessage(context.getString(R.string.dialog_message_googlemap_place));
        if (isNetWorkable()) {
            loadingDialog.showLoadingDialog();
            String url = MessageFormat.format(ConnectInfo.API_GOOGLE_PLACE, location, radius, type, language, key);

            Log.e("TTT",url);
            request = new Request.Builder().url(url).get().build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    loadingDialog.dismiss();
                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_place));
                }

                @Override
                public void onResponse(Call call, Response response)  {
                    loadingDialog.dismiss();
                    reader = response.body().charStream();
                    placeInfo = gson.fromJson(reader, PlaceInfo.class);
                    if (placeInfo.getStatus().equals("OK")) {
                        EventCenter.getInstance().sendPlace(TYPE_PLACE, placeInfo);
                    } else {
                        EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_googlemap_non_place));
                    }
                }
            });
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_net_cant_work));
        }
    }

//    //---------------------
//
//    /**
//     * 取得地方詳細資訊
//     */
//    public void connectToGetPlaceDetail(String placeid) {
//
//        RequestParams params = new RequestParams();
//        params.put("placeid", placeid);
//        Log.e("placeid", placeid);
//        params.put("key", context.getString(R.string.google_maps_key));
//
//        loadingCycleManager.setLoadingMessage(context.getString(R.string.dialog_message_googlemap_place_detail));
//        if (isNetWorkable()) {
//            loadingCycleManager.show();
//            client.get(ConnectInfo.API_GOOGLE_PLACE_DETAIL, params, new JsonHttpResponseHandler() {
//                @Override
//                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                    super.onSuccess(statusCode, headers, response);
//                    loadingCycleManager.dismiss();
//                    placeDetail = new Gson().fromJson(response.toString(), PlaceDetail.class);
//                    if (placeDetail.getStatus().equals("OK")) {
//                        EventCenter.getInstance().sendPlaceDetail(TYPE_PLACE_DETAIL, placeDetail);
//                    } else {
//                        EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_googlemap_non_place_detail));
//                    }
//                }
//
//                @Override
//                public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
//                    loadingCycleManager.dismiss();
//                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_place_detail));
//                }
//
//                @Override
//                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                    super.onFailure(statusCode, headers, throwable, errorResponse);
//                    loadingCycleManager.dismiss();
//                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_place_detail));
//                }
//            });
//        } else {
//            EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_net_cant_work));
//        }
//    }

    //-----------------

    /**
     * 距離, 需時
     */
    public void connectToGetDistance(double startLat, double startLng, double endLat, double endLng) {

        String origins = startLat + "," + startLng;
        String destinations = endLat + "," + endLng;
        String language = "zh-tw";
        String key = context.getString(R.string.google_maps_key);

        if (isNetWorkable()) {
            String url = MessageFormat.format(ConnectInfo.API_GOOGLE_MATRIX, origins, destinations, language, key);
            request = new Request.Builder().url(url).get().build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_distance));
                }

                @Override
                public void onResponse(Call call, Response response)  {
                    reader = response.body().charStream();
                    distanceInfo = gson.fromJson(reader, DistanceInfo.class);
                    if (distanceInfo.getStatus().equals("OK")) {
                        EventCenter.getInstance().sendDistance(TYPE_DISTANCE, distanceInfo);
                    } else {
                        EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_googlemap_non_distance));
                    }
                }
            });
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_net_cant_work));
        }
    }
}
