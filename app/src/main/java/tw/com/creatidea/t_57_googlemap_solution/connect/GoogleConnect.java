package tw.com.creatidea.t_57_googlemap_solution.connect;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tw.com.creatidea.t_57_googlemap_solution.MapsActivity;
import tw.com.creatidea.t_57_googlemap_solution.R;
import tw.com.creatidea.t_57_googlemap_solution.util.EventCenter;
import tw.com.creatidea.t_57_googlemap_solution.util.HttpHandler;

import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_ADDRESS;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_DIRECTION;
import static tw.com.creatidea.t_57_googlemap_solution.util.EventCenter.TYPE_LOCATION;

/**
 * Created by noel on 2017/8/16.
 */

public class GoogleConnect {
    private Context context;
    private String address = "";
    private HttpHandler hh;
    //--------------------------------------------------

    public GoogleConnect(Context context) {
        this.context = context;
        hh = new HttpHandler();
    }
    //--------------------------------------------------

    /**
     * 經緯度轉地址
     * http://maps.google.com/maps/api/geocode/json?latlng=25.0519231,121.5496221&language=zh-TW&sensor=true
     * 將經緯度帶入此API會回傳json
     * 解析後即可取得所有該經緯度地址資訊
     */
    public void sendAddressRequest(final String url, final double latitude, final double longitude) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                final String ADDRESS_URL = MessageFormat.format(url, latitude, longitude);
                String jsonStr = hh.makeServiceCall(ADDRESS_URL);

                if (jsonStr != null) {
                    try {
                        JSONObject jObj1 = new JSONObject(jsonStr);
                        String status = jObj1.getString("status");//在API中表示此位置資訊正常
                        if (status.equals("OK")) {
                            JSONArray results = jObj1.getJSONArray("results");
                            JSONObject jObj2 = results.getJSONObject(0);
                            String formatted_address = jObj2.getString("formatted_address");
                            address = formatted_address;
                        } else {
                            address = context.getString(R.string.toast_noninfomation);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {
                        EventCenter.getInstance().sendAddress(TYPE_ADDRESS, address);

                    }
                }
            }
        });
        t.start();
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
            List<Address> addressRequest = geocoder.getFromLocationName(address, 1);
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
     * 取得最佳路線
     */
    public void sendDirectionRequest(final String ADDRESS_URL) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                List<LatLng> dataList = new ArrayList<>();
                String jsonStr = hh.makeServiceCall(ADDRESS_URL);
                if (jsonStr != null) {
                    try {
                        JSONObject jObj1 = new JSONObject(jsonStr);
                        String status = jObj1.getString("status");

                        if (status.equals("OK")) {
                            JSONArray routes = jObj1.getJSONArray("routes");
                            JSONObject jobj2 = routes.getJSONObject(0);
                            JSONArray legs = jobj2.getJSONArray("legs");
                            JSONObject jobj3 = legs.getJSONObject(0);

                            //所有途經點位
                            JSONArray steps = jobj3.getJSONArray("steps");

                            //取得

                            for (int i = 0; i < steps.length(); i++) {
                                JSONObject jobj4 = steps.getJSONObject(i);
                                JSONObject jobj5 = jobj4.getJSONObject("end_location");
                                double lat = Double.parseDouble(jobj5.getString("lat"));
                                double lng = Double.parseDouble(jobj5.getString("lng"));

                                Log.e("lat",""+lat);
                                Log.e("lng",""+lng);
                                dataList.add(new LatLng(lat, lng));
                            }

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {
                        EventCenter.getInstance().sendRoute(TYPE_DIRECTION, dataList);

                    }
                }
            }
        });
        t.start();
    }


}
