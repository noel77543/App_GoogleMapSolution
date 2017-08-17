package tw.com.creatidea.t_57_googlemap_solution.connect;

/**
 * Created by User on 2017/8/17.
 */

public class ConnectInfo {

    public static final String ADDRESS_API = "http://maps.google.com/maps/api/geocode/json?latlng={0},{1}&language=zh-TW&sensor=true";

    /**
     * 參考: http://blog.csdn.net/mad1989/article/details/9734667
     * origin 起點(緯度,經度)
     * destination 終點(緯度,經度)
     * mode 路線類型 分為 driving(預設,開車)  walking  (使用人行道)  bicycling (使用自行車導航,只適用於美國)
     * */
    public static final String ROUTE_API = "https://maps.googleapis.com/maps/api/directions/json?origin={0}&destination={1}&sensor=false&mode={2}";
}
