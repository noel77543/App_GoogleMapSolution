package tw.com.creatidea.t_57_googlemap_solution.connect;

import android.content.Context;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;
import tw.com.creatidea.t_57_googlemap_solution.model.AddressInfo;
import tw.com.creatidea.t_57_googlemap_solution.model.DirectionInfo;
import tw.com.creatidea.t_57_googlemap_solution.R;
import tw.com.creatidea.t_57_googlemap_solution.util.EventCenter;

import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_ADDRESS;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_DIRECTION;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_LOCATION;

/**
 * Created by noel on 2017/8/16.
 */

public class GoogleConnect extends BasicJsonConnect {
    private DirectionInfo directionInfo;
    private AddressInfo addressInfo;
    private Context context;

    public GoogleConnect(Context context) {
        super(context);
        this.context = context;
    }
    //--------------------------------------------------

    /**
     * 經緯度轉地址
     * http://maps.google.com/maps/api/geocode/json?latlng=25.0519231,121.5496221&language=zh-TW&sensor=true
     * 將經緯度帶入此API會回傳json
     * 解析後即可取得所有該經緯度地址資訊
     */
    public void sendAddressRequest(final double latitude, final double longitude) {
        RequestParams params = new RequestParams();
        params.put("latlng", latitude + "," + longitude);
        params.put("language", "zh-TW");
        params.put("sensor", true);
        loadingCycleManager.setLoadingMessage(context.getString(R.string.dialog_message_googlemap_getaddress));
        if (isNetWorkable()) {
            loadingCycleManager.show();
            client.get(ConnectInfo.API_GOOGLE_GEOCODE,params, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    super.onSuccess(statusCode, headers, response);
                    loadingCycleManager.dismiss();
                    addressInfo = new Gson().fromJson(response.toString(), AddressInfo.class);
                    EventCenter.getInstance().sendAddress(TYPE_ADDRESS, addressInfo);
                }

                @Override
                public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                    loadingCycleManager.dismiss();
                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_address));
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                    loadingCycleManager.dismiss();
                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_address));
                }
            });
        } else {
            loadingCycleManager.dismiss();
            EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_net_cant_work));
        }
    }


    //--------------------------------------------------

    /**
     * 地址轉經緯度
     */
    public void sendLocationRequest(final String address) {

        LatLng addressLatlng;
        double latitude = 0;
        double longitude = 0;

        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<android.location.Address> addressRequest = geocoder.getFromLocationName(address, 1);
            if (addressRequest.size() != 0) {
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
    public void sendDirectionRequest(String startLat, String startLng, String endLat, String endLng) {
        String origin = startLat + "," + startLng;
        String destination = endLat + "," + endLng;
        String mode = "walking";
        String language = "zh-TW";
        boolean sensor = true;
        String key = context.getString(R.string.google_maps_key);

        RequestParams params = new RequestParams();
        params.put("origin", origin);
        params.put("destination", destination);
        params.put("mode", mode);
        params.put("language", language);
        params.put("sensor", sensor);
        params.put("key", key);

        loadingCycleManager.setLoadingMessage(context.getString(R.string.dialog_message_googlemap_getaddress));
        if (isNetWorkable()) {
            loadingCycleManager.show();
            client.get(ConnectInfo.API_GOOGLE_DIRECTION,params, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    super.onSuccess(statusCode, headers, response);
                    loadingCycleManager.dismiss();
                    directionInfo = new Gson().fromJson(response.toString(), DirectionInfo.class);
                    EventCenter.getInstance().sendRoute(TYPE_DIRECTION, directionInfo);
                }

                @Override
                public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                    loadingCycleManager.dismiss();
                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_address));
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                    loadingCycleManager.dismiss();
                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_address));
                }
            });
        } else {
            loadingCycleManager.dismiss();
            EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_net_cant_work));
        }
    }


}
