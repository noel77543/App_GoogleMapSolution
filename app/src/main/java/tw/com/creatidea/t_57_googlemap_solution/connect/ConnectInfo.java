package tw.com.creatidea.t_57_googlemap_solution.connect;

/**
 * Created by noel on 2017/8/17.
 */

public class ConnectInfo {

    //經緯度轉地址
    public static final String API_GOOGLE_GEOCODE = "http://maps.google.com/maps/api/geocode/json";
    //-------
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
    public static final String API_GOOGLE_DIRECTION = "https://maps.googleapis.com/maps/api/directions/json";
    //-------
    /**
     * 種類：https://developers.google.com/places/supported_types#table1
     * 參數：location=座標&radius=搜尋範圍&types=種類&sensor=true&key=server api key
     * */
    public static final String API_GOOGLE_PLACE = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";

}
