package com.sung.noel.tw.googlemapsolution.connect;

import android.support.annotation.StringDef;

/**
 * Created by noel on 2017/8/17.
 */

public class ConnectInfo {

    /***
     *  版控
     */
    public static final String API_VERSION = "https://www.dropbox.com/s/igorutrueqdw0o5/app_googlemap_solution.json?dl=1";


    //--------------------
    /***
     * google play
     */
    public static final String GOOGLE_PLAY = "https://play.google.com/store/apps/details?id=com.sung.noel.tw.googlemapsolution";


    //-------
    private final static String DOMAIN_GOOGLE_MAP = "https://maps.google.com/maps/api/";
    private final static String DOMAIN_GOOGLE_API = "https://maps.googleapis.com/maps/api/";

    //-------
    //經緯度轉地址
    public static final String API_GOOGLE_GEOCODE = DOMAIN_GOOGLE_MAP + "geocode/json?latlng={0}&language={1}&key={2}";


    //-------
    //路線
    /**
     * 參考：http://blog.csdn.net/mad1989/article/details/9734667
     * <p>
     * origin起始點（緯度,經度）
     * destination目標點（緯度,經度）
     * mode 路線型態 ->{walking (要求使用人行道及行人步行導航),
     * bicycling（要求使用自行車導航。(只適用美國)）,
     * driving(默认值,要求使用標準行車導航)
     * }
     * key 你的googleAPI key
     */
    public static final String API_GOOGLE_DIRECTION = DOMAIN_GOOGLE_API + "directions/json?origin={0}&destination={1}&mode={2}&key={3}&language={4}";

    //-------

    /***
     * origins=25.0519432,121.5496224&destinations=25.0511223,121.5505239&key=AIzaSyBEZQZ_LbypO2dSxd3KG4PfGm5HFjq9pHg
     * 距離,耗時
     */
    public static final String API_GOOGLE_MATRIX = DOMAIN_GOOGLE_API + "distancematrix/json?origins={0}&destinations={1}&language={2}&key={3}";

    //------todo 以下api接與API_GOOGLE_PLACE相關------
    /**
     * 種類：https://developers.google.com/places/supported_types#table1
     * 參數：location=座標&radius=搜尋範圍&types=種類&sensor=true&key=server api key
     * 地方資訊
     */
    public static final String API_GOOGLE_PLACE = DOMAIN_GOOGLE_API + "place/nearbysearch/json?location={0}&radius={1}&types={2}&language={3}&key={4}";

    /***
     * 從API_GOOGLE_PLACE取得place_id後串接 這隻api取得該地點的詳細資訊
     * ?placeid=ChIJg6bY6eirQjQRfXUA56FEqJU
     * &key=AIzaSyBEZQZ_LbypO2dSxd3KG4PfGm5HFjq9pHg
     */
    public static final String API_GOOGLE_PLACE_DETAIL = DOMAIN_GOOGLE_API + "place/details/json";
    /***
     * 從API_GOOGLE_PLACE取得photo_reference後串接 這隻api取得該地點的照片
     * ?photoreference=CmRaAAAAM0uyvNyS-c6qkMwvaAn_vibeefraIr5tC6stwyR9AJc8StSOiy_VOZQaDuED1Gps_CPNJal3B2HsrL8IQf7NTurEUWaOsBexSgDldpF_57HIDUP_udGB45MmVxKBnEH0EhDULdzmDg_6d12L4fiMrziwGhRlDD-RYhTlHvJ-qoZ6XNotVq8eOg
     * &maxheight=120
     * &maxwidth=200
     * &key=AIzaSyBEZQZ_LbypO2dSxd3KG4PfGm5HFjq9pHg
     */
    public static final String API_GOOGLE_PHOTO_REFERENCE = DOMAIN_GOOGLE_API + "place/photo?photoreference={0}&maxheight=300&maxwidth=550&key={1}";


    //-------------------
    //todo 以下與天氣相關
    /***
     * 取得所有縣市地區的索引值
     */
    public static final String API_WEATHER_ALL_AREA = "https://works.ioa.tw/weather/api/all.json";
}
