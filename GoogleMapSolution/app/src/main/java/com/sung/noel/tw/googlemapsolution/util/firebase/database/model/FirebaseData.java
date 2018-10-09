package com.sung.noel.tw.googlemapsolution.util.firebase.database.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FirebaseData {

    /**
     * Announcement : 嗨囉~大家好，我是這款App的開發者_Noel,因為開發的初衷是整合資源與大家分享，如若使用這款App在嘗試其他更深層開發的朋友，請使用自建立API KEY，以便其他人在使用此App的開發過程不會有連線錯誤的問題發生唷~ HappyCoding~另請麻煩至個人Github或至GooglePlay幫忙按個讚，有疑問也歡迎在下方連言版留言，謝謝。
     * Board : [{"name":"Test1","text":"哈囉大家好","time":"2018/10/01 20:18","uuid":"AAAAAA"},{"name":"Test2","text":"安安","time":"2018/10/01 20:19","uuid":"BBBBBB"}]
     * Online : [{"name":"Test1","uuid":"AAAAAA"},{"name":"Test2","uuid":"BBBBBB"}]
     * Register : [{"name":"Test1","uuid":"AAAAAA"},{"name":"Test2","uuid":"BBBBBB"}]
     */

    @SerializedName("Announcement")
    private String Announcement;
    @SerializedName("Board")
    private ArrayList<BoardBean> Board;
    @SerializedName("Online")
    private ArrayList<OnlineBean> Online;
    @SerializedName("Register")
    private ArrayList<RegisterBean> Register;

    public String getAnnouncement() {
        return Announcement;
    }

    public void setAnnouncement(String Announcement) {
        this.Announcement = Announcement;
    }

    public ArrayList<BoardBean> getBoard() {
        return Board;
    }

    public void setBoard(ArrayList<BoardBean> Board) {
        this.Board = Board;
    }

    public ArrayList<OnlineBean> getOnline() {
        return Online;
    }

    public void setOnline(ArrayList<OnlineBean> Online) {
        this.Online = Online;
    }

    public ArrayList<RegisterBean> getRegister() {
        return Register;
    }

    public void setRegister(ArrayList<RegisterBean> Register) {
        this.Register = Register;
    }

    public static class BoardBean {
        /**
         * name : Test1
         * text : 哈囉大家好
         * time : 2018/10/01 20:18
         * uuid : AAAAAA
         */

        @SerializedName("name")
        private String name;
        @SerializedName("text")
        private String text;
        @SerializedName("time")
        private String time;
        @SerializedName("uuid")
        private String uuid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }

    public static class OnlineBean {
        /**
         * name : Test1
         * uuid : AAAAAA
         */

        @SerializedName("name")
        private String name;
        @SerializedName("uuid")
        private String uuid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }

    public static class RegisterBean {
        /**
         * name : Test1
         * uuid : AAAAAA
         */

        @SerializedName("time")
        private String time;
        @SerializedName("name")
        private String name;
        @SerializedName("uuid")
        private String uuid;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }
}
