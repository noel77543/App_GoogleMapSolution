package tw.com.creatidea.t_57_googlemap_solution.main.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by noel on 2017/12/5.
 */

public class AddressInfo {

    /**
     * results : [{"address_components":[{"long_name":"1","short_name":"1","types":["street_number"]},{"long_name":"南京東路四段","short_name":"南京東路四段","types":["route"]},{"long_name":"中華里","short_name":"中華里","types":["administrative_area_level_4","political"]},{"long_name":"松山區","short_name":"松山區","types":["administrative_area_level_3","political"]},{"long_name":"台北市","short_name":"台北市","types":["administrative_area_level_1","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]},{"long_name":"105","short_name":"105","types":["postal_code"]}],"formatted_address":"105台灣台北市松山區南京東路四段1號","geometry":{"location":{"lat":25.0519742,"lng":121.5495307},"location_type":"ROOFTOP","viewport":{"northeast":{"lat":25.0533231802915,"lng":121.5508796802915},"southwest":{"lat":25.0506252197085,"lng":121.5481817197085}}},"place_id":"ChIJdfnHFuirQjQR4tZHIpk7Zfw","types":["street_address"]},{"address_components":[{"long_name":"南京敦化路口(小巨蛋)","short_name":"南京敦化路口(小巨蛋)","types":["bus_station","establishment","point_of_interest","transit_station"]},{"long_name":"松山區","short_name":"松山區","types":["administrative_area_level_3","political"]},{"long_name":"台北市","short_name":"台北市","types":["administrative_area_level_1","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]},{"long_name":"105","short_name":"105","types":["postal_code"]}],"formatted_address":"105台灣台北市松山區南京敦化路口(小巨蛋)","geometry":{"location":{"lat":25.051763,"lng":121.549522},"location_type":"GEOMETRIC_CENTER","viewport":{"northeast":{"lat":25.0531119802915,"lng":121.5508709802915},"southwest":{"lat":25.0504140197085,"lng":121.5481730197085}}},"place_id":"ChIJH9PaGeirQjQRt61EAJ8bm5Q","types":["bus_station","establishment","point_of_interest","transit_station"]},{"address_components":[{"long_name":"臺北市","short_name":"臺北市","types":["colloquial_area","locality","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]}],"formatted_address":"台灣臺北市","geometry":{"bounds":{"northeast":{"lat":25.2443731,"lng":121.7300824},"southwest":{"lat":24.7900797,"lng":121.2826735}},"location":{"lat":25.0329694,"lng":121.5654177},"location_type":"APPROXIMATE","viewport":{"northeast":{"lat":25.2443731,"lng":121.7300824},"southwest":{"lat":24.7900797,"lng":121.2826735}}},"place_id":"ChIJmQrivHKsQjQR4MIK3c41aj8","types":["colloquial_area","locality","political"]},{"address_components":[{"long_name":"中華里","short_name":"中華里","types":["administrative_area_level_4","political"]},{"long_name":"松山區","short_name":"松山區","types":["administrative_area_level_3","political"]},{"long_name":"台北市","short_name":"台北市","types":["administrative_area_level_1","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]},{"long_name":"105","short_name":"105","types":["postal_code"]}],"formatted_address":"105台灣台北市松山區中華里","geometry":{"bounds":{"northeast":{"lat":25.0566654,"lng":121.5529628},"southwest":{"lat":25.0517239,"lng":121.5488616}},"location":{"lat":25.0541473,"lng":121.5505587},"location_type":"APPROXIMATE","viewport":{"northeast":{"lat":25.0566654,"lng":121.5529628},"southwest":{"lat":25.0517239,"lng":121.5488616}}},"place_id":"ChIJoZ2I5OirQjQRig79-StoUU4","types":["administrative_area_level_4","political"]},{"address_components":[{"long_name":"松山區","short_name":"松山區","types":["administrative_area_level_3","political"]},{"long_name":"台北市","short_name":"台北市","types":["administrative_area_level_1","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]},{"long_name":"105","short_name":"105","types":["postal_code"]}],"formatted_address":"105台灣台北市松山區","geometry":{"bounds":{"northeast":{"lat":25.0759635,"lng":121.5800758},"southwest":{"lat":25.0443819,"lng":121.5385388}},"location":{"lat":25.0541591,"lng":121.5638621},"location_type":"APPROXIMATE","viewport":{"northeast":{"lat":25.0759635,"lng":121.5800758},"southwest":{"lat":25.0443819,"lng":121.5385388}}},"place_id":"ChIJkRGtsfKrQjQRYWPBFx-XsMA","types":["administrative_area_level_3","political"]},{"address_components":[{"long_name":"105","short_name":"105","types":["postal_code"]},{"long_name":"松山區","short_name":"松山區","types":["administrative_area_level_3","political"]},{"long_name":"台北市","short_name":"台北市","types":["administrative_area_level_1","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]}],"formatted_address":"105台灣台北市松山區","geometry":{"bounds":{"northeast":{"lat":25.0759635,"lng":121.5800758},"southwest":{"lat":25.0443819,"lng":121.5385388}},"location":{"lat":25.0552958,"lng":121.5541264},"location_type":"APPROXIMATE","viewport":{"northeast":{"lat":25.0759635,"lng":121.5800758},"southwest":{"lat":25.0443819,"lng":121.5385388}}},"place_id":"ChIJ7WbTsfKrQjQRvw4VhBEwgnk","types":["postal_code"]},{"address_components":[{"long_name":"台北市","short_name":"台北市","types":["administrative_area_level_1","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]}],"formatted_address":"台灣台北市","geometry":{"bounds":{"northeast":{"lat":25.2103038,"lng":121.6659421},"southwest":{"lat":24.9605084,"lng":121.4570603}},"location":{"lat":25.0329636,"lng":121.5654268},"location_type":"APPROXIMATE","viewport":{"northeast":{"lat":25.2103038,"lng":121.6659421},"southwest":{"lat":24.9605084,"lng":121.4570603}}},"place_id":"ChIJi73bYWusQjQRgqQGXK260bw","types":["administrative_area_level_1","political"]},{"address_components":[{"long_name":"台灣","short_name":"TW","types":["country","political"]}],"formatted_address":"台灣","geometry":{"bounds":{"northeast":{"lat":26.4545,"lng":123.5021012},"southwest":{"lat":20.5170001,"lng":116.6665}},"location":{"lat":23.69781,"lng":120.960515},"location_type":"APPROXIMATE","viewport":{"northeast":{"lat":26.4545,"lng":123.5021012},"southwest":{"lat":20.5170001,"lng":116.6665}}},"place_id":"ChIJL1cHXAbzbjQRaVScvwTwEec","types":["country","political"]}]
     * status : OK
     */

    @SerializedName("status")
    private String status;
    @SerializedName("results")
    private List<ResultsBean> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * address_components : [{"long_name":"1","short_name":"1","types":["street_number"]},{"long_name":"南京東路四段","short_name":"南京東路四段","types":["route"]},{"long_name":"中華里","short_name":"中華里","types":["administrative_area_level_4","political"]},{"long_name":"松山區","short_name":"松山區","types":["administrative_area_level_3","political"]},{"long_name":"台北市","short_name":"台北市","types":["administrative_area_level_1","political"]},{"long_name":"台灣","short_name":"TW","types":["country","political"]},{"long_name":"105","short_name":"105","types":["postal_code"]}]
         * formatted_address : 105台灣台北市松山區南京東路四段1號
         * geometry : {"location":{"lat":25.0519742,"lng":121.5495307},"location_type":"ROOFTOP","viewport":{"northeast":{"lat":25.0533231802915,"lng":121.5508796802915},"southwest":{"lat":25.0506252197085,"lng":121.5481817197085}}}
         * place_id : ChIJdfnHFuirQjQR4tZHIpk7Zfw
         * types : ["street_address"]
         */

        @SerializedName("formatted_address")
        private String formattedAddress;
        @SerializedName("geometry")
        private GeometryBean geometry;
        @SerializedName("place_id")
        private String placeId;
        @SerializedName("address_components")
        private List<AddressComponentsBean> addressComponents;
        @SerializedName("types")
        private List<String> types;

        public String getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public List<AddressComponentsBean> getAddressComponents() {
            return addressComponents;
        }

        public void setAddressComponents(List<AddressComponentsBean> addressComponents) {
            this.addressComponents = addressComponents;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public static class GeometryBean {
            /**
             * location : {"lat":25.0519742,"lng":121.5495307}
             * location_type : ROOFTOP
             * viewport : {"northeast":{"lat":25.0533231802915,"lng":121.5508796802915},"southwest":{"lat":25.0506252197085,"lng":121.5481817197085}}
             */

            @SerializedName("location")
            private LocationBean location;
            @SerializedName("location_type")
            private String locationType;
            @SerializedName("viewport")
            private ViewportBean viewport;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public String getLocationType() {
                return locationType;
            }

            public void setLocationType(String locationType) {
                this.locationType = locationType;
            }

            public ViewportBean getViewport() {
                return viewport;
            }

            public void setViewport(ViewportBean viewport) {
                this.viewport = viewport;
            }

            public static class LocationBean {
                /**
                 * lat : 25.0519742
                 * lng : 121.5495307
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
                 * northeast : {"lat":25.0533231802915,"lng":121.5508796802915}
                 * southwest : {"lat":25.0506252197085,"lng":121.5481817197085}
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
                     * lat : 25.0533231802915
                     * lng : 121.5508796802915
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
                     * lat : 25.0506252197085
                     * lng : 121.5481817197085
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

        public static class AddressComponentsBean {
            /**
             * long_name : 1
             * short_name : 1
             * types : ["street_number"]
             */

            @SerializedName("long_name")
            private String longName;
            @SerializedName("short_name")
            private String shortName;
            @SerializedName("types")
            private List<String> types;

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

            public List<String> getTypes() {
                return types;
            }

            public void setTypes(List<String> types) {
                this.types = types;
            }
        }
    }
}
