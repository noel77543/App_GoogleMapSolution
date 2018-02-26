package com.sung.noel.tw.googlemapsolution.main.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by noel on 2017/12/7.
 */

public class DistanceInfo {

    /**
     * destination_addresses : ["105台灣台北市松山區南京東路四段4-6號"]
     * origin_addresses : ["105台灣台北市松山區南京東路四段1號"]
     * rows : [{"elements":[{"distance":{"text":"0.7 公里","value":692},"duration":{"text":"2 分","value":126},"status":"OK"}]}]
     * status : OK
     */

    @SerializedName("status")
    private String status;
    @SerializedName("destination_addresses")
    private List<String> destinationAddresses;
    @SerializedName("origin_addresses")
    private List<String> originAddresses;
    @SerializedName("rows")
    private List<RowsBean> rows;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        @SerializedName("elements")
        private List<ElementsBean> elements;

        public List<ElementsBean> getElements() {
            return elements;
        }

        public void setElements(List<ElementsBean> elements) {
            this.elements = elements;
        }

        public static class ElementsBean {
            /**
             * distance : {"text":"0.7 公里","value":692}
             * duration : {"text":"2 分","value":126}
             * status : OK
             */

            @SerializedName("distance")
            private DistanceBean distance;
            @SerializedName("duration")
            private DurationBean duration;
            @SerializedName("status")
            private String status;

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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public static class DistanceBean {
                /**
                 * text : 0.7 公里
                 * value : 692
                 */

                @SerializedName("text")
                private String text;
                @SerializedName("value")
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
                 * value : 126
                 */

                @SerializedName("text")
                private String text;
                @SerializedName("value")
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
        }
    }
}
