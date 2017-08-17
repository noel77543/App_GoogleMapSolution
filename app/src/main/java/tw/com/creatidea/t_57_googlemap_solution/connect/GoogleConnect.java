package tw.com.creatidea.t_57_googlemap_solution.connect;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

import tw.com.creatidea.t_57_googlemap_solution.R;
import tw.com.creatidea.t_57_googlemap_solution.eventcenter.EventCenter;
import tw.com.creatidea.t_57_googlemap_solution.util.HttpHandler;

import static tw.com.creatidea.t_57_googlemap_solution.eventcenter.EventCenter.TYPE_ADDRESS;
import static tw.com.creatidea.t_57_googlemap_solution.eventcenter.EventCenter.TYPE_LOCATION;

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
        }finally {

            addressLatlng = new LatLng(latitude, longitude);
            EventCenter.getInstance().sendLocation(TYPE_LOCATION,addressLatlng);
        }
    }

}
