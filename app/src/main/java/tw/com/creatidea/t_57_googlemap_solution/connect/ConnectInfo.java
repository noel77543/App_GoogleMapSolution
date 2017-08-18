package tw.com.creatidea.t_57_googlemap_solution.connect;

/**
 * Created by noel on 2017/8/17.
 */

public class ConnectInfo {
    //地址
    public static final String API_GOOGLE_GEOCODE = "http://maps.google.com/maps/api/geocode/json?latlng={0},{1}&language=zh-TW&sensor=true";

    //路線
    /**
     * 參考：http://blog.csdn.net/mad1989/article/details/9734667
     * <p>
     * origin起始點（緯度,經度）
     * destination目標點（緯度,經度）
     * mode 路線型態 ->{walking (要求使用人行道及行人步行導航),
     *                bicycling（要求使用自行車導航。(只適用美國)）,
     *                driving(默认值,要求使用標準行車導航)
     *                }
     * key 你的googleAPI key
     */
    String API_GOOGLE_DIRECTION =
            "https://maps.googleapis.com/maps/api/directions/json?origin={0}&destination={1}&mode={2}&language=zh-TW&sensor=true&key={3}";
}
