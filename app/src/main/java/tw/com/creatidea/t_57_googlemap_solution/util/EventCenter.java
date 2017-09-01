package tw.com.creatidea.t_57_googlemap_solution.util;

import com.google.android.gms.maps.model.LatLng;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tw.com.creatidea.t_57_googlemap_solution.Directions;

/**
 * Created by noel on 2017/8/16.
 */

public class EventCenter {

    public static final int TYPE_ADDRESS = 111;
    public static final int TYPE_LOCATION = 222;
    public static final int TYPE_DIRECTION = 333;


    //--------------------------------------------------
    private static EventCenter ourInstance = new EventCenter();

    //--------------------------------------------------
    public static EventCenter getInstance() {
        return ourInstance;
    }

    //--------------------------------------------------
    private EventCenter() {

    }

    //--------------------------------------------------
    private void sendListEvent(int type, List<?> dataList) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", type);
        data.put("data", dataList);
        EventBus.getDefault().post(data);
    }

    //--------------------------------------------------
    private void sendObjectEvent(int type, Object object) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", type);
        data.put("data", object);
        EventBus.getDefault().post(data);
    }
    //--------------------------------------------------

    /**
     * 經緯度轉地址
     * @param address 地址
     * */
    public void sendAddress(int type,String address){
        sendObjectEvent(type,address);

    }

    //--------------------------------------------------

    /**
     * 地址轉經緯度
     * @param address 地址
     * */
    public void sendLocation(int type,LatLng address){
        sendObjectEvent(type,address);

    }

    //--------------------------------------------------

    /**
     * 最佳路線規劃
     *
     * */
    public void sendRoute(int type, Directions directions){
        sendObjectEvent(type, directions);

    }

}
