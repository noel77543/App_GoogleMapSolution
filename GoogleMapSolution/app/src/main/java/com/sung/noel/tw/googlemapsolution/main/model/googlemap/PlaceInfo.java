package com.sung.noel.tw.googlemapsolution.main.model.googlemap;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by noel on 2017/12/6.
 */

public class PlaceInfo {

    @SerializedName("next_page_token")
    private String nextPageToken;
    @SerializedName("status")
    private String status;
    @SerializedName("html_attributions")
    private ArrayList<?> htmlAttributions;
    @SerializedName("results")
    private ArrayList<ResultsBean> results;

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
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

    public ArrayList<ResultsBean> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Parcelable{
        /**
         * geometry : {"location":{"lat":25.0522607,"lng":121.5211383},"viewport":{"northeast":{"lat":25.0537000302915,"lng":121.5225083802915},"southwest":{"lat":25.0510020697085,"lng":121.5198104197085}}}
         * icon : https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png
         * id : 8619a91656f1de919a9c29326d18c7d9139eeabd
         * name : 欣葉台菜
         * opening_hours : {"open_now":true,"weekday_text":[]}
         * photos : [{"height":1068,"html_attributions":[],"photo_reference":"CmRaAAAAXiDXZu64b7Ie4tl_BrDp3LNy6BevMrslv5N95UJrw-lzWTrurLjX4ot69hkaeEa8whmzjU3hHS4DWQfJwz04yXD3InhpAbTvVwklIiWyyXRPFlBGRAj2hnh_PuGkvr_zEhCpj7YJFOi5Czql-pREdy0YGhT43O6nJgSbpppkXw3T9Xucrv2ZfA","width":1600}]
         * place_id : ChIJxQboPEWpQjQRNDguQnNV674
         * rating : 3.8
         * reference : CmRSAAAAzMu5Yt88n8sRdd3YHRTC5E9p2r_Azr9jgA6FouatmOR3_qt6Zu3oqodc2T-AZu_JRXbmS6JlMHLDBt9FHZ9Ptihw5BOeERb9O0jP-xVQYWN9uSnAyHOAlay6HyrnF7s8EhAiUl0Voa7MHbfMMHiE9pSxGhRfS57Tohje2SSY7PJJPSgNj-aozQ
         * scope : GOOGLE
         * types : ["restaurant","food","point_of_interest","establishment"]
         * vicinity : 中山區南京西路12號8F
         */

        @SerializedName("geometry")
        private GeometryBean geometry;
        @SerializedName("icon")
        private String icon;
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("opening_hours")
        private OpeningHoursBean openingHours;
        @SerializedName("place_id")
        private String placeId;
        @SerializedName("rating")
        private double rating;
        @SerializedName("reference")
        private String reference;
        @SerializedName("scope")
        private String scope;
        @SerializedName("vicinity")
        private String vicinity;
        @SerializedName("photos")
        private ArrayList<PhotosBean> photos;
        @SerializedName("types")
        private ArrayList<String> types;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OpeningHoursBean getOpeningHours() {
            return openingHours;
        }

        public void setOpeningHours(OpeningHoursBean openingHours) {
            this.openingHours = openingHours;
        }

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
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

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public ArrayList<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(ArrayList<PhotosBean> photos) {
            this.photos = photos;
        }

        public ArrayList<String> getTypes() {
            return types;
        }

        public void setTypes(ArrayList<String> types) {
            this.types = types;
        }

        public ResultsBean() {
        }

        protected ResultsBean(Parcel in) {
            icon = in.readString();
            id = in.readString();
            name = in.readString();
            placeId = in.readString();
            rating = in.readDouble();
            reference = in.readString();
            scope = in.readString();
            vicinity = in.readString();


        }
//        @SerializedName("geometry")
//        private GeometryBean geometry;
//        @SerializedName("opening_hours")
//        private OpeningHoursBean openingHours;
//        @SerializedName("photos")
//        private ArrayList<PhotosBean> photos;
//        @SerializedName("types")
//        private ArrayList<String> types;

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.icon);
            dest.writeString(this.id);
            dest.writeString(this.name);
            dest.writeString(this.placeId);
            dest.writeString(this.reference);
            dest.writeString(this.scope);
            dest.writeString(this.vicinity);
            dest.writeDouble(this.rating);



        }

        public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
            @Override
            public ResultsBean createFromParcel(Parcel in) {
                return new ResultsBean(in);
            }

            @Override
            public ResultsBean[] newArray(int size) {
                return new ResultsBean[size];
            }
        };




        public static class GeometryBean  {
            /**
             * location : {"lat":25.0522607,"lng":121.5211383}
             * viewport : {"northeast":{"lat":25.0537000302915,"lng":121.5225083802915},"southwest":{"lat":25.0510020697085,"lng":121.5198104197085}}
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

            public static class LocationBean  {
                /**
                 * lat : 25.0522607
                 * lng : 121.5211383
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
                 * northeast : {"lat":25.0537000302915,"lng":121.5225083802915}
                 * southwest : {"lat":25.0510020697085,"lng":121.5198104197085}
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
                     * lat : 25.0537000302915
                     * lng : 121.5225083802915
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
                     * lat : 25.0510020697085
                     * lng : 121.5198104197085
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
             * weekday_text : []
             */

            @SerializedName("open_now")
            private boolean openNow;
            @SerializedName("weekday_text")
            private ArrayList<?> weekdayText;

            public boolean isOpenNow() {
                return openNow;
            }

            public void setOpenNow(boolean openNow) {
                this.openNow = openNow;
            }

            public ArrayList<?> getWeekdayText() {
                return weekdayText;
            }

            public void setWeekdayText(ArrayList<?> weekdayText) {
                this.weekdayText = weekdayText;
            }
        }

        public static class PhotosBean {
            /**
             * height : 1068
             * html_attributions : []
             * photo_reference : CmRaAAAAXiDXZu64b7Ie4tl_BrDp3LNy6BevMrslv5N95UJrw-lzWTrurLjX4ot69hkaeEa8whmzjU3hHS4DWQfJwz04yXD3InhpAbTvVwklIiWyyXRPFlBGRAj2hnh_PuGkvr_zEhCpj7YJFOi5Czql-pREdy0YGhT43O6nJgSbpppkXw3T9Xucrv2ZfA
             * width : 1600
             */

            @SerializedName("height")
            private int height;
            @SerializedName("photo_reference")
            private String photoReference;
            @SerializedName("width")
            private int width;
            @SerializedName("html_attributions")
            private ArrayList<?> htmlAttributions;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPhotoReference() {
                return photoReference;
            }

            public void setPhotoReference(String photoReference) {
                this.photoReference = photoReference;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public ArrayList<?> getHtmlAttributions() {
                return htmlAttributions;
            }

            public void setHtmlAttributions(ArrayList<?> htmlAttributions) {
                this.htmlAttributions = htmlAttributions;
            }
        }
    }
}
