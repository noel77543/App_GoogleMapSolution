package tw.com.creatidea.t_57_googlemap_solution;

import java.util.List;

/**
 * Created by noel on 2017/9/1.
 */

public class Directions {

    /**
     * geocoded_waypoints : [{"geocoder_status":"OK","place_id":"ChIJG8RyFuirQjQRL7QCT0zG6Qo","types":["street_address"]},{"geocoder_status":"OK","place_id":"ChIJFfTXlNurQjQRIdIL_YkbPW4","types":["street_address"]}]
     * routes : [{"bounds":{"northeast":{"lat":25.0518232,"lng":121.5496618},"southwest":{"lat":25.0458488,"lng":121.5439589}},"copyrights":"地圖資料©2017 Google","legs":[{"distance":{"text":"1.2 公里","value":1150},"duration":{"text":"15 分","value":903},"end_address":"105台灣台北市松山區復興南路一段41號","end_location":{"lat":25.0458488,"lng":121.5439589},"start_address":"105台灣台北市松山區南京東路四段11號","start_location":{"lat":25.0518182,"lng":121.5496618},"steps":[{"distance":{"text":"93 公尺","value":93},"duration":{"text":"2 分","value":97},"end_location":{"lat":25.0518232,"lng":121.5487344},"html_instructions":"往<b>西<\/b>走<b>南京東路四段<\/b>朝<b>敦化北路<\/b>前進","polyline":{"points":"{|{wCkd{dV?n@?n@Aj@@l@"},"start_location":{"lat":25.0518182,"lng":121.5496618},"travel_mode":"WALKING"},{"distance":{"text":"0.4 公里","value":412},"duration":{"text":"5 分","value":315},"end_location":{"lat":25.0482031,"lng":121.5484151},"html_instructions":"於<b>敦化北路<\/b>向<b>左<\/b>轉","maneuver":"turn-left","polyline":{"points":"{|{wCq~zdV^AR@T?P?P@|@?~@?vA@P?F?B?fH@XPJFLHTR"},"start_location":{"lat":25.0518232,"lng":121.5487344},"travel_mode":"WALKING"},{"distance":{"text":"40 公尺","value":40},"duration":{"text":"1 分","value":35},"end_location":{"lat":25.0481976,"lng":121.548021},"html_instructions":"於<b>八德路二段<\/b>向<b>右<\/b>轉","maneuver":"turn-right","polyline":{"points":"gf{wCs|zdV?T?X?^"},"start_location":{"lat":25.0482031,"lng":121.5484151},"travel_mode":"WALKING"},{"distance":{"text":"0.4 公里","value":412},"duration":{"text":"5 分","value":311},"end_location":{"lat":25.0475844,"lng":121.5440093},"html_instructions":"靠<b>左<\/b>行駛後，繼續朝<b>八德路二段<\/b>前進","maneuver":"turn-slight-left","polyline":{"points":"gf{wCczzdVBH@H?L?V?X?P?P@rB?L?FDz@B`@Fd@@L@F?JBRBJBJFd@ZpBl@tD"},"start_location":{"lat":25.0481976,"lng":121.548021},"travel_mode":"WALKING"},{"distance":{"text":"0.2 公里","value":193},"duration":{"text":"2 分","value":145},"end_location":{"lat":25.0458488,"lng":121.5439589},"html_instructions":"於復興南路一段向左轉目的地在左邊","maneuver":"turn-left","polyline":{"points":""},"start_location":{"lat":25.0475844,"lng":121.5440093},"travel_mode":"WALKING"}],"traffic_speed_entry":[],"via_waypoint":[]}],"overview_polyline":{"points":""},"summary":"敦化北路和八德路二段","warnings":["步行路線指示目前為測試版。\n使用注意事項\u2013此路線可能沒有行人道或步行徑。"],"waypoint_order":[]}]
     * status : OK
     */

    private String status;
    private List<GeocodedWaypointsBean> geocoded_waypoints;
    private List<RoutesBean> routes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GeocodedWaypointsBean> getGeocoded_waypoints() {
        return geocoded_waypoints;
    }

    public void setGeocoded_waypoints(List<GeocodedWaypointsBean> geocoded_waypoints) {
        this.geocoded_waypoints = geocoded_waypoints;
    }

    public List<RoutesBean> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutesBean> routes) {
        this.routes = routes;
    }

    public static class GeocodedWaypointsBean {
        /**
         * geocoder_status : OK
         * place_id : ChIJG8RyFuirQjQRL7QCT0zG6Qo
         * types : ["street_address"]
         */

        private String geocoder_status;
        private String place_id;
        private List<String> types;

        public String getGeocoder_status() {
            return geocoder_status;
        }

        public void setGeocoder_status(String geocoder_status) {
            this.geocoder_status = geocoder_status;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }
    }

    public static class RoutesBean {
        /**
         * bounds : {"northeast":{"lat":25.0518232,"lng":121.5496618},"southwest":{"lat":25.0458488,"lng":121.5439589}}
         * copyrights : 地圖資料©2017 Google
         * legs : [{"distance":{"text":"1.2 公里","value":1150},"duration":{"text":"15 分","value":903},"end_address":"105台灣台北市松山區復興南路一段41號","end_location":{"lat":25.0458488,"lng":121.5439589},"start_address":"105台灣台北市松山區南京東路四段11號","start_location":{"lat":25.0518182,"lng":121.5496618},"steps":[{"distance":{"text":"93 公尺","value":93},"duration":{"text":"2 分","value":97},"end_location":{"lat":25.0518232,"lng":121.5487344},"html_instructions":"往<b>西<\/b>走<b>南京東路四段<\/b>朝<b>敦化北路<\/b>前進","polyline":{"points":"{|{wCkd{dV?n@?n@Aj@@l@"},"start_location":{"lat":25.0518182,"lng":121.5496618},"travel_mode":"WALKING"},{"distance":{"text":"0.4 公里","value":412},"duration":{"text":"5 分","value":315},"end_location":{"lat":25.0482031,"lng":121.5484151},"html_instructions":"於<b>敦化北路<\/b>向<b>左<\/b>轉","maneuver":"turn-left","polyline":{"points":"{|{wCq~zdV^AR@T?P?P@|@?~@?vA@P?F?B?fH@XPJFLHTR"},"start_location":{"lat":25.0518232,"lng":121.5487344},"travel_mode":"WALKING"},{"distance":{"text":"40 公尺","value":40},"duration":{"text":"1 分","value":35},"end_location":{"lat":25.0481976,"lng":121.548021},"html_instructions":"於<b>八德路二段<\/b>向<b>右<\/b>轉","maneuver":"turn-right","polyline":{"points":"gf{wCs|zdV?T?X?^"},"start_location":{"lat":25.0482031,"lng":121.5484151},"travel_mode":"WALKING"},{"distance":{"text":"0.4 公里","value":412},"duration":{"text":"5 分","value":311},"end_location":{"lat":25.0475844,"lng":121.5440093},"html_instructions":"靠<b>左<\/b>行駛後，繼續朝<b>八德路二段<\/b>前進","maneuver":"turn-slight-left","polyline":{"points":"gf{wCczzdVBH@H?L?V?X?P?P@rB?L?FDz@B`@Fd@@L@F?JBRBJBJFd@ZpBl@tD"},"start_location":{"lat":25.0481976,"lng":121.548021},"travel_mode":"WALKING"},{"distance":{"text":"0.2 公里","value":193},"duration":{"text":"2 分","value":145},"end_location":{"lat":25.0458488,"lng":121.5439589},"html_instructions":"於復興南路一段向左轉目的地在左邊","maneuver":"turn-left","polyline":{"points":""},"start_location":{"lat":25.0475844,"lng":121.5440093},"travel_mode":"WALKING"}],"traffic_speed_entry":[],"via_waypoint":[]}]
         * overview_polyline : {"points":""}
         * summary : 敦化北路和八德路二段
         * warnings : ["步行路線指示目前為測試版。\n使用注意事項\u2013此路線可能沒有行人道或步行徑。"]
         * waypoint_order : []
         */

        private BoundsBean bounds;
        private String copyrights;
        private OverviewPolylineBean overview_polyline;
        private String summary;
        private List<LegsBean> legs;
        private List<String> warnings;
        private List<?> waypoint_order;

        public BoundsBean getBounds() {
            return bounds;
        }

        public void setBounds(BoundsBean bounds) {
            this.bounds = bounds;
        }

        public String getCopyrights() {
            return copyrights;
        }

        public void setCopyrights(String copyrights) {
            this.copyrights = copyrights;
        }

        public OverviewPolylineBean getOverview_polyline() {
            return overview_polyline;
        }

        public void setOverview_polyline(OverviewPolylineBean overview_polyline) {
            this.overview_polyline = overview_polyline;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<LegsBean> getLegs() {
            return legs;
        }

        public void setLegs(List<LegsBean> legs) {
            this.legs = legs;
        }

        public List<String> getWarnings() {
            return warnings;
        }

        public void setWarnings(List<String> warnings) {
            this.warnings = warnings;
        }

        public List<?> getWaypoint_order() {
            return waypoint_order;
        }

        public void setWaypoint_order(List<?> waypoint_order) {
            this.waypoint_order = waypoint_order;
        }

        public static class BoundsBean {
            /**
             * northeast : {"lat":25.0518232,"lng":121.5496618}
             * southwest : {"lat":25.0458488,"lng":121.5439589}
             */

            private NortheastBean northeast;
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
                 * lat : 25.0518232
                 * lng : 121.5496618
                 */

                private double lat;
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
                 * lat : 25.0458488
                 * lng : 121.5439589
                 */

                private double lat;
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

        public static class OverviewPolylineBean {
            /**
             * points :
             */

            private String points;

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }
        }

        public static class LegsBean {
            /**
             * distance : {"text":"1.2 公里","value":1150}
             * duration : {"text":"15 分","value":903}
             * end_address : 105台灣台北市松山區復興南路一段41號
             * end_location : {"lat":25.0458488,"lng":121.5439589}
             * start_address : 105台灣台北市松山區南京東路四段11號
             * start_location : {"lat":25.0518182,"lng":121.5496618}
             * steps : [{"distance":{"text":"93 公尺","value":93},"duration":{"text":"2 分","value":97},"end_location":{"lat":25.0518232,"lng":121.5487344},"html_instructions":"往<b>西<\/b>走<b>南京東路四段<\/b>朝<b>敦化北路<\/b>前進","polyline":{"points":"{|{wCkd{dV?n@?n@Aj@@l@"},"start_location":{"lat":25.0518182,"lng":121.5496618},"travel_mode":"WALKING"},{"distance":{"text":"0.4 公里","value":412},"duration":{"text":"5 分","value":315},"end_location":{"lat":25.0482031,"lng":121.5484151},"html_instructions":"於<b>敦化北路<\/b>向<b>左<\/b>轉","maneuver":"turn-left","polyline":{"points":"{|{wCq~zdV^AR@T?P?P@|@?~@?vA@P?F?B?fH@XPJFLHTR"},"start_location":{"lat":25.0518232,"lng":121.5487344},"travel_mode":"WALKING"},{"distance":{"text":"40 公尺","value":40},"duration":{"text":"1 分","value":35},"end_location":{"lat":25.0481976,"lng":121.548021},"html_instructions":"於<b>八德路二段<\/b>向<b>右<\/b>轉","maneuver":"turn-right","polyline":{"points":"gf{wCs|zdV?T?X?^"},"start_location":{"lat":25.0482031,"lng":121.5484151},"travel_mode":"WALKING"},{"distance":{"text":"0.4 公里","value":412},"duration":{"text":"5 分","value":311},"end_location":{"lat":25.0475844,"lng":121.5440093},"html_instructions":"靠<b>左<\/b>行駛後，繼續朝<b>八德路二段<\/b>前進","maneuver":"turn-slight-left","polyline":{"points":"gf{wCczzdVBH@H?L?V?X?P?P@rB?L?FDz@B`@Fd@@L@F?JBRBJBJFd@ZpBl@tD"},"start_location":{"lat":25.0481976,"lng":121.548021},"travel_mode":"WALKING"},{"distance":{"text":"0.2 公里","value":193},"duration":{"text":"2 分","value":145},"end_location":{"lat":25.0458488,"lng":121.5439589},"html_instructions":"於復興南路一段向左轉目的地在左邊","maneuver":"turn-left","polyline":{"points":""},"start_location":{"lat":25.0475844,"lng":121.5440093},"travel_mode":"WALKING"}]
             * traffic_speed_entry : []
             * via_waypoint : []
             */

            private DistanceBean distance;
            private DurationBean duration;
            private String end_address;
            private EndLocationBean end_location;
            private String start_address;
            private StartLocationBean start_location;
            private List<StepsBean> steps;
            private List<?> traffic_speed_entry;
            private List<?> via_waypoint;

            public DistanceBean getDistance() {
                return distance;
            }

            public void setDistance(DistanceBean distance) {
                this.distance = distance;
            }

            public DurationBean getDuration() {
                return duration;
            }

            public void setDuration(DurationBean duration) {
                this.duration = duration;
            }

            public String getEnd_address() {
                return end_address;
            }

            public void setEnd_address(String end_address) {
                this.end_address = end_address;
            }

            public EndLocationBean getEnd_location() {
                return end_location;
            }

            public void setEnd_location(EndLocationBean end_location) {
                this.end_location = end_location;
            }

            public String getStart_address() {
                return start_address;
            }

            public void setStart_address(String start_address) {
                this.start_address = start_address;
            }

            public StartLocationBean getStart_location() {
                return start_location;
            }

            public void setStart_location(StartLocationBean start_location) {
                this.start_location = start_location;
            }

            public List<StepsBean> getSteps() {
                return steps;
            }

            public void setSteps(List<StepsBean> steps) {
                this.steps = steps;
            }

            public List<?> getTraffic_speed_entry() {
                return traffic_speed_entry;
            }

            public void setTraffic_speed_entry(List<?> traffic_speed_entry) {
                this.traffic_speed_entry = traffic_speed_entry;
            }

            public List<?> getVia_waypoint() {
                return via_waypoint;
            }

            public void setVia_waypoint(List<?> via_waypoint) {
                this.via_waypoint = via_waypoint;
            }

            public static class DistanceBean {
                /**
                 * text : 1.2 公里
                 * value : 1150
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class DurationBean {
                /**
                 * text : 15 分
                 * value : 903
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class EndLocationBean {
                /**
                 * lat : 25.0458488
                 * lng : 121.5439589
                 */

                private double lat;
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

            public static class StartLocationBean {
                /**
                 * lat : 25.0518182
                 * lng : 121.5496618
                 */

                private double lat;
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

            public static class StepsBean {
                /**
                 * distance : {"text":"93 公尺","value":93}
                 * duration : {"text":"2 分","value":97}
                 * end_location : {"lat":25.0518232,"lng":121.5487344}
                 * html_instructions : 往<b>西</b>走<b>南京東路四段</b>朝<b>敦化北路</b>前進
                 * polyline : {"points":"{|{wCkd{dV?n@?n@Aj@@l@"}
                 * start_location : {"lat":25.0518182,"lng":121.5496618}
                 * travel_mode : WALKING
                 * maneuver : turn-left
                 */

                private DistanceBeanX distance;
                private DurationBeanX duration;
                private EndLocationBeanX end_location;
                private String html_instructions;
                private PolylineBean polyline;
                private StartLocationBeanX start_location;
                private String travel_mode;
                private String maneuver;

                public DistanceBeanX getDistance() {
                    return distance;
                }

                public void setDistance(DistanceBeanX distance) {
                    this.distance = distance;
                }

                public DurationBeanX getDuration() {
                    return duration;
                }

                public void setDuration(DurationBeanX duration) {
                    this.duration = duration;
                }

                public EndLocationBeanX getEnd_location() {
                    return end_location;
                }

                public void setEnd_location(EndLocationBeanX end_location) {
                    this.end_location = end_location;
                }

                public String getHtml_instructions() {
                    return html_instructions;
                }

                public void setHtml_instructions(String html_instructions) {
                    this.html_instructions = html_instructions;
                }

                public PolylineBean getPolyline() {
                    return polyline;
                }

                public void setPolyline(PolylineBean polyline) {
                    this.polyline = polyline;
                }

                public StartLocationBeanX getStart_location() {
                    return start_location;
                }

                public void setStart_location(StartLocationBeanX start_location) {
                    this.start_location = start_location;
                }

                public String getTravel_mode() {
                    return travel_mode;
                }

                public void setTravel_mode(String travel_mode) {
                    this.travel_mode = travel_mode;
                }

                public String getManeuver() {
                    return maneuver;
                }

                public void setManeuver(String maneuver) {
                    this.maneuver = maneuver;
                }

                public static class DistanceBeanX {
                    /**
                     * text : 93 公尺
                     * value : 93
                     */

                    private String text;
                    private int value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }

                public static class DurationBeanX {
                    /**
                     * text : 2 分
                     * value : 97
                     */

                    private String text;
                    private int value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }

                public static class EndLocationBeanX {
                    /**
                     * lat : 25.0518232
                     * lng : 121.5487344
                     */

                    private double lat;
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

                public static class PolylineBean {
                    /**
                     * points : {|{wCkd{dV?n@?n@Aj@@l@
                     */

                    private String points;

                    public String getPoints() {
                        return points;
                    }

                    public void setPoints(String points) {
                        this.points = points;
                    }
                }

                public static class StartLocationBeanX {
                    /**
                     * lat : 25.0518182
                     * lng : 121.5496618
                     */

                    private double lat;
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
    }
}
