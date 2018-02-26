package com.sung.noel.tw.googlemapsolution.main.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by noel on 2017/12/11.
 */

public class PlaceDetail {

    /**
     * html_attributions : []
     * result : {"address_components":[{"long_name":"100","short_name":"100","types":["street_number"]},{"long_name":"敦化北路","short_name":"敦化北路","types":["route"]},{"long_name":"松山區","short_name":"松山區","types":["administrative_area_level_3","political"]},{"long_name":"台北市","short_name":"台北市","types":["administrative_area_level_1","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]},{"long_name":"105","short_name":"105","types":["postal_code"]}],"adr_address":"","formatted_address":"105台灣台北市松山區敦化北路100號","formatted_phone_number":"02 2716 8900","geometry":{"location":{"lat":25.0523688,"lng":121.5485008},"viewport":{"northeast":{"lat":25.0537184302915,"lng":121.5499664302915},"southwest":{"lat":25.0510204697085,"lng":121.5472684697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id":"1d6d3941a37bcf13896f332cb5ebba409ef74e2e","international_phone_number":"+886 2 2716 8900","name":"IKEA瑞典餐廳","opening_hours":{"open_now":true,"periods":[{"close":{"day":0,"time":"2130"},"open":{"day":0,"time":"0900"}},{"close":{"day":1,"time":"2130"},"open":{"day":1,"time":"0900"}},{"close":{"day":2,"time":"2130"},"open":{"day":2,"time":"0900"}},{"close":{"day":3,"time":"2130"},"open":{"day":3,"time":"0900"}},{"close":{"day":4,"time":"2130"},"open":{"day":4,"time":"0900"}},{"close":{"day":5,"time":"2200"},"open":{"day":5,"time":"0900"}},{"close":{"day":6,"time":"2200"},"open":{"day":6,"time":"0900"}}],"weekday_text":["星期一: 09:00 \u2013 21:30","星期二: 09:00 \u2013 21:30","星期三: 09:00 \u2013 21:30","星期四: 09:00 \u2013 21:30","星期五: 09:00 \u2013 22:00","星期六: 09:00 \u2013 22:00","星期日: 09:00 \u2013 21:30"]},"photos":[{"height":1152,"html_attributions":[""],"photo_reference":"CmRaAAAAoAsYBXgD3lnS2JkzAeMlTUX99t8B6KRond345mP3NhL1EuPMvBHwEnW7ZemJ7IZPU2wdfz5KsJ2aljyOIvxl4ZzKBdvwTIJDlgFKLByiBE-fLzQQW7WWuGEHD3y4Tp8NEhCLQfDg079L1PfpxzDKrJ6NGhSC_mqMW-VxKSkPg-P2CBQ9TnEh_w","width":2048},{"height":2448,"html_attributions":[""],"photo_reference":"CmRaAAAANifxmZOIUz4KfmctwNOu20MwWCwJkvyGIib0WH-_gvcEYWhaUHuRL_PUkuQKiYqf4zv90MQrM8za0wifTZYXesVZFkWQ2eZxsjvH5nB7jZp5P8-716eUEgqpESo_87b3EhB7rXsG1xMcfSrNuUGPSt_sGhQ6vX83BvtHEDJqdgZN-4kG33jNZw","width":2448},{"height":3024,"html_attributions":[""],"photo_reference":"CmRaAAAAlL01E0vMa9AOzvT8BfV15Gri0t7ydQrko9FQaSXqHvKQQy6KaAWxYjOxoD23CdzYiMj67wpDpLGPCUM6PqsXKToUPpJht6TDsHcGwXbucELim_KDWXXu5W5HbzENGrrsEhD7g1IByqyk7Mg7CSWNqkpJGhTXAOvG4a2-rvpAdV2MxLPtV4ruVg","width":4032},{"height":2448,"html_attributions":[""],"photo_reference":"CmRaAAAARt2uepOhEquVCZ5nzvw3uVeXXN8VG58hf_SUKUZoMual0kTvUTDHLDtnqczTJ4YL9vAj1tWmYJkJ_UZVBwq5ZQHfRW_wA1uAtM7QktSIMrZd9TC2pVrYPGzZDiSnllbdEhDfyToapT4z8pM6jjWEYkCwGhTPZR9XE9QDrEHYh59T9JYXoqq-bw","width":3264},{"height":3024,"html_attributions":[""],"photo_reference":"CmRaAAAAWiWtXy9y2TVsK7BKKx2Ye9oLyDAd8QmXUP6ixN2sdpXuKoBx4wzSKtsLUgqL1aAZ4RC17gScfFOn0hiyKAdeJXT7U1VlmrS7qpBlyJWFoTUVQEL4-xTPD9UWQPrdVVfOEhBoNIxvuXlQ5x0Fu-EHW2gpGhTE5XGukzWPhOjS6y4DGEZgKkrKJQ","width":4032},{"height":960,"html_attributions":[""],"photo_reference":"CmRaAAAAfZmMVxM5dn5G61rSQvi6DIRbvc80TYCzK6-GlA3PiYLrCvEgYe1P_S8AlUHlolgm2YPd4B7Cuo-7ZwL5_RYrLe3VQxHUKxY_Aly0-syH4e9yVTOHr6UA8xlJpaZzB52CEhAFBd7bHHrf98-qkD-sXCutGhR4Mgxk_qplIBgdKAr63o1bv2d64A","width":1706},{"height":3120,"html_attributions":[""],"photo_reference":"CmRaAAAASqfKT_oDI1o15DZWKqwDygOrkCHYTFSaUwsUab9nQzaOuluISVcxyexjvStjkGy_gjx7iFmMVh_TqrV7ud6RoMZMVW-eYH7yARpH8IuL8r1nswFu6lrGEfqJMVut-oS4EhBbxJzGDXNkegO2103ffUOVGhQZq2DyWWm1yOkab7a-cw9mKdRHaw","width":4208},{"height":2250,"html_attributions":[""],"photo_reference":"CmRaAAAAt6-ovGRCzAEBj_QpthPTKvcG5ttq-HJ6VxMnsSu3qKlHpvjhKIqZHwh4ZCL0CUyqqF9ubUHecTX-76bhN69CXveKyHkSUrkslXL_xuhDsfW6zyeWk0DlptCS2_DD4HQLEhAJoErHKvAeRm1u_kWT8oCuGhTnKeoJtohgZP-LgAO7gX1W85AFuQ","width":4000},{"height":2448,"html_attributions":[""],"photo_reference":"CmRaAAAALZmiMmUaJkoAvgZas3PRaQofBDbFzYUNBx8I1Hah1lllUYprv8njV5jjzriT9XL4hyfvbwVp8fFyppbNQRdfUJYE3QmQd4nYO-6KHnPp3yiiHyljv044dkf84fIdWf4lEhAjYuesVTGlUoO1lZoSJDNeGhR5SJCdO_7xXEvZ1EzxICLiUunJpA","width":3264},{"height":2448,"html_attributions":[""],"photo_reference":"CmRaAAAAV9Cgxm2z_37IaSf35Hh35Z9Kga-wc9cqxPK9LYIROmxRvwGSD2Eud4nbxYtzxIZlaeSmZ2-vfYNTXgdclcwtCOoBeOLKEKUBurHWeQd9dOQ-DWhMtUPY_3RcZ-3LaK0qEhD9kf59ekIymghDIzQ2TKH1GhQHGcHFdPe0jwyttrfw6rWemx1nZQ","width":3264}],"place_id":"ChIJ1yfNC-irQjQRJQFthSFD9Xk","rating":4,"reference":"CmRRAAAA-XcXJDZf0vgyS9n9sAruoGdMBEtxRvSL3NX1wKBU-UcYbqsI12rHek9VM49ZBpnykfnWbqrVlnmPbNyvzhAQsUFIxlMDlHIBlCpdmjhGQmy1NnG0dKaqVxmbTSVSe-bpEhCCvRP_TMnVjlr76w_kiK_DGhQCwsDLGToc_YBCscC6W4Nv1WMKmg","reviews":[{"author_name":"Leah Sung","author_url":"https://www.google.com/maps/contrib/106108039179683035102/reviews","language":"zh-Hant","profile_photo_url":"https://lh5.googleusercontent.com/-JTveOEFVVGg/AAAAAAAAAAI/AAAAAAAAJDA/YQV8PJM_SHw/s128-c0x00000000-cc-rp-mo-ba3/photo.jpg","rating":3,"relative_time_description":"本星期","text":"每次去都好多人，要等好久才有位子>","time":1512836877},{"author_name":"秦嘉誼","author_url":"https://www.google.com/maps/contrib/112207505274984588885/reviews","language":"zh-Hant","profile_photo_url":"https://lh5.googleusercontent.com/-ZthOt1BF_xo/AAAAAAAAAAI/AAAAAAAACIM/InDPqIGmYXU/s128-c0x00000000-cc-rp-mo-ba3/photo.jpg","rating":5,"relative_time_description":"本星期","text":"我喜愛的是小丸子，$10霜淇淋","time":1512822200},{"author_name":"高傑","author_url":"https://www.google.com/maps/contrib/111579595000783674188/reviews","language":"zh-Hant","profile_photo_url":"https://lh6.googleusercontent.com/-uTMgJCHUIW8/AAAAAAAAAAI/AAAAAAABFJI/VcmkiIpE10M/s128-c0x00000000-cc-rp-mo-ba6/photo.jpg","rating":4,"relative_time_description":"1 週前","text":"來吃肉丸跟薯條。 -- 宜家家居（瑞典語：[ɪˈkeːˈa]；/aɪˈkiːə/） 是一家瑞典公司，為居家用品零售企業， 於全球多國擁有分店， 販售平整式包裝的傢具、 配件、浴室和廚房用品。 宜家家居是開創以平實價格 銷售自行組裝家具的領導品牌， 目前是全球最大傢具零售企業。 宜家家居是在1943年由當時17歲的 英格瓦·坎普拉於瑞典創立。 目前，宜家家居是由荷蘭的 Stichting INGKA基金會 （Stichting INGKA Foundation）， 以及Interogo基金會 （Interogo Foundation） Stichting INGKA基金會擁有 宜家企業集團（IKEAGroup） 所有股權， 而宜家企業集團擁有全球約 90%的IKEA商店。","time":1512114600},{"author_name":"林佑昕","author_url":"https://www.google.com/maps/contrib/116386431536543890538/reviews","language":"zh-Hant","profile_photo_url":"https://lh4.googleusercontent.com/-LvPzocHZmmk/AAAAAAAAAAI/AAAAAAAAAAA/AFiYof2y1LCuna5lgG3W5Ut2QR38Zrhpaw/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":4,"relative_time_description":"1 個月前","text":"來這邊吃東西的人很多，座位不太好找，IKEA在這方面除了用廣播勸導之外，一直沒有甚麼明顯的改善措施。 2017年時改版了，座位變得比較多，找位子有變得容易一點，不過人多的話，我會轉去微風吃。 在台灣，做吃的比賣家具好賺多了。","time":1508298580},{"author_name":"Duffy Hung","author_url":"https://www.google.com/maps/contrib/100064626353771911852/reviews","language":"zh-Hant","profile_photo_url":"https://lh5.googleusercontent.com/-69lAzk7yKjA/AAAAAAAAAAI/AAAAAAAAAlw/pUwv1wPV_GU/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":3,"relative_time_description":"3 週前","text":"丸子份量越來越少，薯條好吃，起司豬排還可以99元又有薯條配菜，久久才會來吃一次 20171115","time":1510805111}],"scope":"GOOGLE","types":["restaurant","food","point_of_interest","establishment"],"url":"https://maps.google.com/?cid=8788004059134886181","utc_offset":480,"vicinity":"松山區敦化北路100號","website":"http://www.ikea.com/tw/zh/store/asia_world"}
     * status : OK
     */

    @SerializedName("result")
    private ResultBean result;
    @SerializedName("status")
    private String status;
    @SerializedName("html_attributions")
    private ArrayList<?> htmlAttributions;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<?> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(ArrayList<?> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public static class ResultBean {
        /**
         * address_components : [{"long_name":"100","short_name":"100","types":["street_number"]},{"long_name":"敦化北路","short_name":"敦化北路","types":["route"]},{"long_name":"松山區","short_name":"松山區","types":["administrative_area_level_3","political"]},{"long_name":"台北市","short_name":"台北市","types":["administrative_area_level_1","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]},{"long_name":"105","short_name":"105","types":["postal_code"]}]
         * adr_address :
         * formatted_address : 105台灣台北市松山區敦化北路100號
         * formatted_phone_number : 02 2716 8900
         * geometry : {"location":{"lat":25.0523688,"lng":121.5485008},"viewport":{"northeast":{"lat":25.0537184302915,"lng":121.5499664302915},"southwest":{"lat":25.0510204697085,"lng":121.5472684697085}}}
         * icon : https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png
         * id : 1d6d3941a37bcf13896f332cb5ebba409ef74e2e
         * international_phone_number : +886 2 2716 8900
         * name : IKEA瑞典餐廳
         * opening_hours : {"open_now":true,"periods":[{"close":{"day":0,"time":"2130"},"open":{"day":0,"time":"0900"}},{"close":{"day":1,"time":"2130"},"open":{"day":1,"time":"0900"}},{"close":{"day":2,"time":"2130"},"open":{"day":2,"time":"0900"}},{"close":{"day":3,"time":"2130"},"open":{"day":3,"time":"0900"}},{"close":{"day":4,"time":"2130"},"open":{"day":4,"time":"0900"}},{"close":{"day":5,"time":"2200"},"open":{"day":5,"time":"0900"}},{"close":{"day":6,"time":"2200"},"open":{"day":6,"time":"0900"}}],"weekday_text":["星期一: 09:00 \u2013 21:30","星期二: 09:00 \u2013 21:30","星期三: 09:00 \u2013 21:30","星期四: 09:00 \u2013 21:30","星期五: 09:00 \u2013 22:00","星期六: 09:00 \u2013 22:00","星期日: 09:00 \u2013 21:30"]}
         * photos : [{"height":1152,"html_attributions":[""],"photo_reference":"CmRaAAAAoAsYBXgD3lnS2JkzAeMlTUX99t8B6KRond345mP3NhL1EuPMvBHwEnW7ZemJ7IZPU2wdfz5KsJ2aljyOIvxl4ZzKBdvwTIJDlgFKLByiBE-fLzQQW7WWuGEHD3y4Tp8NEhCLQfDg079L1PfpxzDKrJ6NGhSC_mqMW-VxKSkPg-P2CBQ9TnEh_w","width":2048},{"height":2448,"html_attributions":[""],"photo_reference":"CmRaAAAANifxmZOIUz4KfmctwNOu20MwWCwJkvyGIib0WH-_gvcEYWhaUHuRL_PUkuQKiYqf4zv90MQrM8za0wifTZYXesVZFkWQ2eZxsjvH5nB7jZp5P8-716eUEgqpESo_87b3EhB7rXsG1xMcfSrNuUGPSt_sGhQ6vX83BvtHEDJqdgZN-4kG33jNZw","width":2448},{"height":3024,"html_attributions":[""],"photo_reference":"CmRaAAAAlL01E0vMa9AOzvT8BfV15Gri0t7ydQrko9FQaSXqHvKQQy6KaAWxYjOxoD23CdzYiMj67wpDpLGPCUM6PqsXKToUPpJht6TDsHcGwXbucELim_KDWXXu5W5HbzENGrrsEhD7g1IByqyk7Mg7CSWNqkpJGhTXAOvG4a2-rvpAdV2MxLPtV4ruVg","width":4032},{"height":2448,"html_attributions":[""],"photo_reference":"CmRaAAAARt2uepOhEquVCZ5nzvw3uVeXXN8VG58hf_SUKUZoMual0kTvUTDHLDtnqczTJ4YL9vAj1tWmYJkJ_UZVBwq5ZQHfRW_wA1uAtM7QktSIMrZd9TC2pVrYPGzZDiSnllbdEhDfyToapT4z8pM6jjWEYkCwGhTPZR9XE9QDrEHYh59T9JYXoqq-bw","width":3264},{"height":3024,"html_attributions":[""],"photo_reference":"CmRaAAAAWiWtXy9y2TVsK7BKKx2Ye9oLyDAd8QmXUP6ixN2sdpXuKoBx4wzSKtsLUgqL1aAZ4RC17gScfFOn0hiyKAdeJXT7U1VlmrS7qpBlyJWFoTUVQEL4-xTPD9UWQPrdVVfOEhBoNIxvuXlQ5x0Fu-EHW2gpGhTE5XGukzWPhOjS6y4DGEZgKkrKJQ","width":4032},{"height":960,"html_attributions":[""],"photo_reference":"CmRaAAAAfZmMVxM5dn5G61rSQvi6DIRbvc80TYCzK6-GlA3PiYLrCvEgYe1P_S8AlUHlolgm2YPd4B7Cuo-7ZwL5_RYrLe3VQxHUKxY_Aly0-syH4e9yVTOHr6UA8xlJpaZzB52CEhAFBd7bHHrf98-qkD-sXCutGhR4Mgxk_qplIBgdKAr63o1bv2d64A","width":1706},{"height":3120,"html_attributions":[""],"photo_reference":"CmRaAAAASqfKT_oDI1o15DZWKqwDygOrkCHYTFSaUwsUab9nQzaOuluISVcxyexjvStjkGy_gjx7iFmMVh_TqrV7ud6RoMZMVW-eYH7yARpH8IuL8r1nswFu6lrGEfqJMVut-oS4EhBbxJzGDXNkegO2103ffUOVGhQZq2DyWWm1yOkab7a-cw9mKdRHaw","width":4208},{"height":2250,"html_attributions":[""],"photo_reference":"CmRaAAAAt6-ovGRCzAEBj_QpthPTKvcG5ttq-HJ6VxMnsSu3qKlHpvjhKIqZHwh4ZCL0CUyqqF9ubUHecTX-76bhN69CXveKyHkSUrkslXL_xuhDsfW6zyeWk0DlptCS2_DD4HQLEhAJoErHKvAeRm1u_kWT8oCuGhTnKeoJtohgZP-LgAO7gX1W85AFuQ","width":4000},{"height":2448,"html_attributions":[""],"photo_reference":"CmRaAAAALZmiMmUaJkoAvgZas3PRaQofBDbFzYUNBx8I1Hah1lllUYprv8njV5jjzriT9XL4hyfvbwVp8fFyppbNQRdfUJYE3QmQd4nYO-6KHnPp3yiiHyljv044dkf84fIdWf4lEhAjYuesVTGlUoO1lZoSJDNeGhR5SJCdO_7xXEvZ1EzxICLiUunJpA","width":3264},{"height":2448,"html_attributions":[""],"photo_reference":"CmRaAAAAV9Cgxm2z_37IaSf35Hh35Z9Kga-wc9cqxPK9LYIROmxRvwGSD2Eud4nbxYtzxIZlaeSmZ2-vfYNTXgdclcwtCOoBeOLKEKUBurHWeQd9dOQ-DWhMtUPY_3RcZ-3LaK0qEhD9kf59ekIymghDIzQ2TKH1GhQHGcHFdPe0jwyttrfw6rWemx1nZQ","width":3264}]
         * place_id : ChIJ1yfNC-irQjQRJQFthSFD9Xk
         * rating : 4
         * reference : CmRRAAAA-XcXJDZf0vgyS9n9sAruoGdMBEtxRvSL3NX1wKBU-UcYbqsI12rHek9VM49ZBpnykfnWbqrVlnmPbNyvzhAQsUFIxlMDlHIBlCpdmjhGQmy1NnG0dKaqVxmbTSVSe-bpEhCCvRP_TMnVjlr76w_kiK_DGhQCwsDLGToc_YBCscC6W4Nv1WMKmg
         * reviews : [{"author_name":"Leah Sung","author_url":"https://www.google.com/maps/contrib/106108039179683035102/reviews","language":"zh-Hant","profile_photo_url":"https://lh5.googleusercontent.com/-JTveOEFVVGg/AAAAAAAAAAI/AAAAAAAAJDA/YQV8PJM_SHw/s128-c0x00000000-cc-rp-mo-ba3/photo.jpg","rating":3,"relative_time_description":"本星期","text":"每次去都好多人，要等好久才有位子>","time":1512836877},{"author_name":"秦嘉誼","author_url":"https://www.google.com/maps/contrib/112207505274984588885/reviews","language":"zh-Hant","profile_photo_url":"https://lh5.googleusercontent.com/-ZthOt1BF_xo/AAAAAAAAAAI/AAAAAAAACIM/InDPqIGmYXU/s128-c0x00000000-cc-rp-mo-ba3/photo.jpg","rating":5,"relative_time_description":"本星期","text":"我喜愛的是小丸子，$10霜淇淋","time":1512822200},{"author_name":"高傑","author_url":"https://www.google.com/maps/contrib/111579595000783674188/reviews","language":"zh-Hant","profile_photo_url":"https://lh6.googleusercontent.com/-uTMgJCHUIW8/AAAAAAAAAAI/AAAAAAABFJI/VcmkiIpE10M/s128-c0x00000000-cc-rp-mo-ba6/photo.jpg","rating":4,"relative_time_description":"1 週前","text":"來吃肉丸跟薯條。 -- 宜家家居（瑞典語：[ɪˈkeːˈa]；/aɪˈkiːə/） 是一家瑞典公司，為居家用品零售企業， 於全球多國擁有分店， 販售平整式包裝的傢具、 配件、浴室和廚房用品。 宜家家居是開創以平實價格 銷售自行組裝家具的領導品牌， 目前是全球最大傢具零售企業。 宜家家居是在1943年由當時17歲的 英格瓦·坎普拉於瑞典創立。 目前，宜家家居是由荷蘭的 Stichting INGKA基金會 （Stichting INGKA Foundation）， 以及Interogo基金會 （Interogo Foundation） Stichting INGKA基金會擁有 宜家企業集團（IKEAGroup） 所有股權， 而宜家企業集團擁有全球約 90%的IKEA商店。","time":1512114600},{"author_name":"林佑昕","author_url":"https://www.google.com/maps/contrib/116386431536543890538/reviews","language":"zh-Hant","profile_photo_url":"https://lh4.googleusercontent.com/-LvPzocHZmmk/AAAAAAAAAAI/AAAAAAAAAAA/AFiYof2y1LCuna5lgG3W5Ut2QR38Zrhpaw/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":4,"relative_time_description":"1 個月前","text":"來這邊吃東西的人很多，座位不太好找，IKEA在這方面除了用廣播勸導之外，一直沒有甚麼明顯的改善措施。 2017年時改版了，座位變得比較多，找位子有變得容易一點，不過人多的話，我會轉去微風吃。 在台灣，做吃的比賣家具好賺多了。","time":1508298580},{"author_name":"Duffy Hung","author_url":"https://www.google.com/maps/contrib/100064626353771911852/reviews","language":"zh-Hant","profile_photo_url":"https://lh5.googleusercontent.com/-69lAzk7yKjA/AAAAAAAAAAI/AAAAAAAAAlw/pUwv1wPV_GU/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":3,"relative_time_description":"3 週前","text":"丸子份量越來越少，薯條好吃，起司豬排還可以99元又有薯條配菜，久久才會來吃一次 20171115","time":1510805111}]
         * scope : GOOGLE
         * types : ["restaurant","food","point_of_interest","establishment"]
         * url : https://maps.google.com/?cid=8788004059134886181
         * utc_offset : 480
         * vicinity : 松山區敦化北路100號
         * website : http://www.ikea.com/tw/zh/store/asia_world
         */

        @SerializedName("adr_address")
        private String adrAddress;
        @SerializedName("formatted_address")
        private String formattedAddress;
        @SerializedName("formatted_phone_number")
        private String formattedPhoneNumber;
        @SerializedName("geometry")
        private GeometryBean geometry;
        @SerializedName("icon")
        private String icon;
        @SerializedName("id")
        private String id;
        @SerializedName("international_phone_number")
        private String internationalPhoneNumber;
        @SerializedName("name")
        private String name;
//        @SerializedName("opening_hours")
//        private OpeningHoursBean openingHours;
        @SerializedName("place_id")
        private String placeId;
        @SerializedName("rating")
        private int rating;
        @SerializedName("reference")
        private String reference;
        @SerializedName("scope")
        private String scope;
        @SerializedName("url")
        private String url;
        @SerializedName("utc_offset")
        private int utcOffset;
        @SerializedName("vicinity")
        private String vicinity;
        @SerializedName("website")
        private String website;
        @SerializedName("address_components")
        private ArrayList<AddressComponentsBean> addressComponents;
//        @SerializedName("photos")
//        private ArrayList<PhotosBean> photos;
//        @SerializedName("reviews")
//        private ArrayList<ReviewsBean> reviews;
        @SerializedName("types")
        private ArrayList<String> types;

        public String getAdrAddress() {
            return adrAddress;
        }

        public void setAdrAddress(String adrAddress) {
            this.adrAddress = adrAddress;
        }

        public String getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public String getFormattedPhoneNumber() {
            return formattedPhoneNumber;
        }

        public void setFormattedPhoneNumber(String formattedPhoneNumber) {
            this.formattedPhoneNumber = formattedPhoneNumber;
        }

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInternationalPhoneNumber() {
            return internationalPhoneNumber;
        }

        public void setInternationalPhoneNumber(String internationalPhoneNumber) {
            this.internationalPhoneNumber = internationalPhoneNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

//        public OpeningHoursBean getOpeningHours() {
//            return openingHours;
//        }
//
//        public void setOpeningHours(OpeningHoursBean openingHours) {
//            this.openingHours = openingHours;
//        }

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUtcOffset() {
            return utcOffset;
        }

        public void setUtcOffset(int utcOffset) {
            this.utcOffset = utcOffset;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public ArrayList<AddressComponentsBean> getAddressComponents() {
            return addressComponents;
        }

        public void setAddressComponents(ArrayList<AddressComponentsBean> addressComponents) {
            this.addressComponents = addressComponents;
        }

//        public ArrayList<PhotosBean> getPhotos() {
//            return photos;
//        }
//
//        public void setPhotos(ArrayList<PhotosBean> photos) {
//            this.photos = photos;
//        }
//
//        public ArrayList<ReviewsBean> getReviews() {
//            return reviews;
//        }
//
//        public void setReviews(ArrayList<ReviewsBean> reviews) {
//            this.reviews = reviews;
//        }

        public ArrayList<String> getTypes() {
            return types;
        }

        public void setTypes(ArrayList<String> types) {
            this.types = types;
        }

        public static class GeometryBean {
            /**
             * location : {"lat":25.0523688,"lng":121.5485008}
             * viewport : {"northeast":{"lat":25.0537184302915,"lng":121.5499664302915},"southwest":{"lat":25.0510204697085,"lng":121.5472684697085}}
             */

            @SerializedName("location")
            private LocationBean location;
            @SerializedName("viewport")
            private ViewportBean viewport;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public ViewportBean getViewport() {
                return viewport;
            }

            public void setViewport(ViewportBean viewport) {
                this.viewport = viewport;
            }

            public static class LocationBean {
                /**
                 * lat : 25.0523688
                 * lng : 121.5485008
                 */

                @SerializedName("lat")
                private double lat;
                @SerializedName("lng")
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class ViewportBean {
                /**
                 * northeast : {"lat":25.0537184302915,"lng":121.5499664302915}
                 * southwest : {"lat":25.0510204697085,"lng":121.5472684697085}
                 */

                @SerializedName("northeast")
                private NortheastBean northeast;
                @SerializedName("southwest")
                private SouthwestBean southwest;

                public NortheastBean getNortheast() {
                    return northeast;
                }

                public void setNortheast(NortheastBean northeast) {
                    this.northeast = northeast;
                }

                public SouthwestBean getSouthwest() {
                    return southwest;
                }

                public void setSouthwest(SouthwestBean southwest) {
                    this.southwest = southwest;
                }

                public static class NortheastBean {
                    /**
                     * lat : 25.0537184302915
                     * lng : 121.5499664302915
                     */

                    @SerializedName("lat")
                    private double lat;
                    @SerializedName("lng")
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class SouthwestBean {
                    /**
                     * lat : 25.0510204697085
                     * lng : 121.5472684697085
                     */

                    @SerializedName("lat")
                    private double lat;
                    @SerializedName("lng")
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }

        public static class OpeningHoursBean {
            /**
             * open_now : true
             * periods : [{"close":{"day":0,"time":"2130"},"open":{"day":0,"time":"0900"}},{"close":{"day":1,"time":"2130"},"open":{"day":1,"time":"0900"}},{"close":{"day":2,"time":"2130"},"open":{"day":2,"time":"0900"}},{"close":{"day":3,"time":"2130"},"open":{"day":3,"time":"0900"}},{"close":{"day":4,"time":"2130"},"open":{"day":4,"time":"0900"}},{"close":{"day":5,"time":"2200"},"open":{"day":5,"time":"0900"}},{"close":{"day":6,"time":"2200"},"open":{"day":6,"time":"0900"}}]
             * weekday_text : ["星期一: 09:00 \u2013 21:30","星期二: 09:00 \u2013 21:30","星期三: 09:00 \u2013 21:30","星期四: 09:00 \u2013 21:30","星期五: 09:00 \u2013 22:00","星期六: 09:00 \u2013 22:00","星期日: 09:00 \u2013 21:30"]
             */

            @SerializedName("open_now")
            private boolean openNow;
            @SerializedName("periods")
            private ArrayList<PeriodsBean> periods;
//            @SerializedName("weekday_text")
//            private ArrayList<String> weekdayText;

            public boolean isOpenNow() {
                return openNow;
            }

            public void setOpenNow(boolean openNow) {
                this.openNow = openNow;
            }

            public ArrayList<PeriodsBean> getPeriods() {
                return periods;
            }

            public void setPeriods(ArrayList<PeriodsBean> periods) {
                this.periods = periods;
            }

//            public ArrayList<String> getWeekdayText() {
//                return weekdayText;
//            }

//            public void setWeekdayText(ArrayList<String> weekdayText) {
//                this.weekdayText = weekdayText;
//            }

            public static class PeriodsBean {
                /**
                 * close : {"day":0,"time":"2130"}
                 * open : {"day":0,"time":"0900"}
                 */

                @SerializedName("close")
                private CloseBean close;
                @SerializedName("open")
                private OpenBean open;

                public CloseBean getClose() {
                    return close;
                }

                public void setClose(CloseBean close) {
                    this.close = close;
                }

                public OpenBean getOpen() {
                    return open;
                }

                public void setOpen(OpenBean open) {
                    this.open = open;
                }

                public static class CloseBean {
                    /**
                     * day : 0
                     * time : 2130
                     */

                    @SerializedName("day")
                    private int day;
                    @SerializedName("time")
                    private String time;

                    public int getDay() {
                        return day;
                    }

                    public void setDay(int day) {
                        this.day = day;
                    }

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class OpenBean {
                    /**
                     * day : 0
                     * time : 0900
                     */

                    @SerializedName("day")
                    private int day;
                    @SerializedName("time")
                    private String time;

                    public int getDay() {
                        return day;
                    }

                    public void setDay(int day) {
                        this.day = day;
                    }

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }
        }

        public static class AddressComponentsBean {
            /**
             * long_name : 100
             * short_name : 100
             * types : ["street_number"]
             */

            @SerializedName("long_name")
            private String longName;
            @SerializedName("short_name")
            private String shortName;
            @SerializedName("types")
            private ArrayList<String> types;

            public String getLongName() {
                return longName;
            }

            public void setLongName(String longName) {
                this.longName = longName;
            }

            public String getShortName() {
                return shortName;
            }

            public void setShortName(String shortName) {
                this.shortName = shortName;
            }

            public ArrayList<String> getTypes() {
                return types;
            }

            public void setTypes(ArrayList<String> types) {
                this.types = types;
            }
        }

//        public static class PhotosBean {
//            /**
//             * height : 1152
//             * html_attributions : [""]
//             * photo_reference : CmRaAAAAoAsYBXgD3lnS2JkzAeMlTUX99t8B6KRond345mP3NhL1EuPMvBHwEnW7ZemJ7IZPU2wdfz5KsJ2aljyOIvxl4ZzKBdvwTIJDlgFKLByiBE-fLzQQW7WWuGEHD3y4Tp8NEhCLQfDg079L1PfpxzDKrJ6NGhSC_mqMW-VxKSkPg-P2CBQ9TnEh_w
//             * width : 2048
//             */
//
//            @SerializedName("height")
//            private int height;
//            @SerializedName("photo_reference")
//            private String photoReference;
//            @SerializedName("width")
//            private int width;
//            @SerializedName("html_attributions")
//            private ArrayList<String> htmlAttributions;
//
//            public int getHeight() {
//                return height;
//            }
//
//            public void setHeight(int height) {
//                this.height = height;
//            }
//
//            public String getPhotoReference() {
//                return photoReference;
//            }
//
//            public void setPhotoReference(String photoReference) {
//                this.photoReference = photoReference;
//            }
//
//            public int getWidth() {
//                return width;
//            }
//
//            public void setWidth(int width) {
//                this.width = width;
//            }
//
//            public ArrayList<String> getHtmlAttributions() {
//                return htmlAttributions;
//            }
//
//            public void setHtmlAttributions(ArrayList<String> htmlAttributions) {
//                this.htmlAttributions = htmlAttributions;
//            }
//        }

//        public static class ReviewsBean {
//            /**
//             * author_name : Leah Sung
//             * author_url : https://www.google.com/maps/contrib/106108039179683035102/reviews
//             * language : zh-Hant
//             * profile_photo_url : https://lh5.googleusercontent.com/-JTveOEFVVGg/AAAAAAAAAAI/AAAAAAAAJDA/YQV8PJM_SHw/s128-c0x00000000-cc-rp-mo-ba3/photo.jpg
//             * rating : 3
//             * relative_time_description : 本星期
//             * text : 每次去都好多人，要等好久才有位子>
//             * time : 1512836877
//             */
//
//            @SerializedName("author_name")
//            private String authorName;
//            @SerializedName("author_url")
//            private String authorUrl;
//            @SerializedName("language")
//            private String language;
//            @SerializedName("profile_photo_url")
//            private String profilePhotoUrl;
////            @SerializedName("rating")
////            private int rating;
//            @SerializedName("relative_time_description")
//            private String relativeTimeDescription;
//            @SerializedName("text")
//            private String text;
//            @SerializedName("time")
//            private int time;
//
//            public String getAuthorName() {
//                return authorName;
//            }
//
//            public void setAuthorName(String authorName) {
//                this.authorName = authorName;
//            }
//
//            public String getAuthorUrl() {
//                return authorUrl;
//            }
//
//            public void setAuthorUrl(String authorUrl) {
//                this.authorUrl = authorUrl;
//            }
//
//            public String getLanguage() {
//                return language;
//            }
//
//            public void setLanguage(String language) {
//                this.language = language;
//            }
//
//            public String getProfilePhotoUrl() {
//                return profilePhotoUrl;
//            }
//
//            public void setProfilePhotoUrl(String profilePhotoUrl) {
//                this.profilePhotoUrl = profilePhotoUrl;
//            }
//
//            public int getRating() {
//                return rating;
//            }
//
//            public void setRating(int rating) {
//                this.rating = rating;
//            }
//
//            public String getRelativeTimeDescription() {
//                return relativeTimeDescription;
//            }
//
//            public void setRelativeTimeDescription(String relativeTimeDescription) {
//                this.relativeTimeDescription = relativeTimeDescription;
//            }
//
//            public String getText() {
//                return text;
//            }
//
//            public void setText(String text) {
//                this.text = text;
//            }
//
//            public int getTime() {
//                return time;
//            }
//
//            public void setTime(int time) {
//                this.time = time;
//            }
//        }
    }
}
