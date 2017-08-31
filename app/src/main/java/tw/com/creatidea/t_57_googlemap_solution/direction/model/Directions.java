package tw.com.creatidea.t_57_googlemap_solution.direction.model;

/**
 * Created by noel on 2017/8/31.
 */

public class Directions {

    /**
     * distance : {"text":"93 公尺","value":93}
     * duration : {"text":"2 分","value":97}
     * end_location : {"lat":25.0518232,"lng":121.5487344}
     * html_instructions : 往<b>西</b>走<b>南京東路四段</b>朝<b>敦化北路</b>前進
     * polyline : {"points":"{|{wCkd{dV?n@?n@Aj@@l@"}
     * start_location : {"lat":25.0518182,"lng":121.5496618}
     * travel_mode : WALKING
     */

    private DistanceBean distance;
    private DurationBean duration;
    private EndLocationBean end_location;
    private String html_instructions;
    private PolylineBean polyline;
    private StartLocationBean start_location;
    private String travel_mode;

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

    public EndLocationBean getEnd_location() {
        return end_location;
    }

    public void setEnd_location(EndLocationBean end_location) {
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

    public StartLocationBean getStart_location() {
        return start_location;
    }

    public void setStart_location(StartLocationBean start_location) {
        this.start_location = start_location;
    }

    public String getTravel_mode() {
        return travel_mode;
    }

    public void setTravel_mode(String travel_mode) {
        this.travel_mode = travel_mode;
    }

    public static class DistanceBean {
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

    public static class DurationBean {
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

    public static class EndLocationBean {
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
}
