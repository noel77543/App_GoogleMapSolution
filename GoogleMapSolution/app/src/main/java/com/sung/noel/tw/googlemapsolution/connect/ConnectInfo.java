package com.sung.noel.tw.googlemapsolution.connect;

/**
 * Created by noel on 2017/8/17.
 */

public class ConnectInfo {

    //經緯度轉地址
    public static final String API_GOOGLE_GEOCODE = "https://maps.google.com/maps/api/geocode/json";
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
    public static final String API_GOOGLE_DIRECTION = "https://maps.googleapis.com/maps/api/directions/json";
    //-------

    /***
     * origins=25.0519432,121.5496224&destinations=25.0511223,121.5505239&key=AIzaSyBEZQZ_LbypO2dSxd3KG4PfGm5HFjq9pHg
     * 距離,耗時
     */
    public static final String API_GOOGLE_MATRIX = "https://maps.googleapis.com/maps/api/distancematrix/json";

    //------todo 以下api接與API_GOOGLE_PLACE相關------
    /**
     * 種類：https://developers.google.com/places/supported_types#table1
     * 參數：location=座標&radius=搜尋範圍&types=種類&sensor=true&key=server api key
     * 地方資訊
     */
    public static final String API_GOOGLE_PLACE = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    /***
     * 從API_GOOGLE_PLACE取得place_id後串接 這隻api取得該地點的詳細資訊
     * ?placeid=ChIJg6bY6eirQjQRfXUA56FEqJU
     * &key=AIzaSyBEZQZ_LbypO2dSxd3KG4PfGm5HFjq9pHg
     */
    public static final String API_GOOGLE_PLACE_DETAIL = "https://maps.googleapis.com/maps/api/place/details/json";
    /***
     * 從API_GOOGLE_PLACE取得photo_reference後串接 這隻api取得該地點的照片
     * ?photoreference=CmRaAAAAM0uyvNyS-c6qkMwvaAn_vibeefraIr5tC6stwyR9AJc8StSOiy_VOZQaDuED1Gps_CPNJal3B2HsrL8IQf7NTurEUWaOsBexSgDldpF_57HIDUP_udGB45MmVxKBnEH0EhDULdzmDg_6d12L4fiMrziwGhRlDD-RYhTlHvJ-qoZ6XNotVq8eOg
     * &maxheight=120
     * &maxwidth=200
     * &key=AIzaSyBEZQZ_LbypO2dSxd3KG4PfGm5HFjq9pHg
     */
    public static final String API_GOOGLE_PHOTO_REFERENCE = "https://maps.googleapis.com/maps/api/place/photo?photoreference=%1$s&maxheight=300&maxwidth=550&key=%2$s";
}
