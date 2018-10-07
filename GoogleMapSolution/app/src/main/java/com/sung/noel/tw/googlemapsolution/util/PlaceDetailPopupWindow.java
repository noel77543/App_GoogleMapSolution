package com.sung.noel.tw.googlemapsolution.util;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.base.BasePopupWindow;
import com.sung.noel.tw.googlemapsolution.connect.ConnectInfo;
import com.sung.noel.tw.googlemapsolution.event.EventCenter;
import com.sung.noel.tw.googlemapsolution.main.MainActivity;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.PlaceInfo;

import java.text.MessageFormat;


/**
 * Created by noel on 2017/12/8.
 */

public class PlaceDetailPopupWindow extends BasePopupWindow {
    private MainActivity mainActivity;
    private View view;
    private PlaceInfo.ResultsBean resultBeans;

//    private ImageView placeDetailAr;
    private TextView placeDetailTitle;
    private TextView placeDetailAddress;
    private TextView placeDetailStatus;
    private ImageView placeDetailPhoto;

    public PlaceDetailPopupWindow(Activity activity) {
        super(activity);
        if (activity instanceof MainActivity) {
            mainActivity = (MainActivity) activity;
        }
    }
    //--------

    /**
     * show
     */
    public void showPopupWindow(PlaceInfo.ResultsBean resultBeans) {
        this.resultBeans = resultBeans;
        initPopupWindow();
        showAtLocation(mainActivity.drawerLayout, Gravity.CENTER, 0, 0);
    }
    //--------

    /**
     * 初始化
     */
    private void initPopupWindow() {
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        if (view == null) { //todo 同container觀念  _noel
            view = inflater.inflate(R.layout.popup_place_detail, null);
            ButterKnife.bind(this, view);
            setContentView(view);
            placeDetailPhoto = ButterKnife.findById(view, R.id.imageview);
            placeDetailTitle = ButterKnife.findById(view, R.id.tv_title);
            placeDetailAddress = ButterKnife.findById(view, R.id.tv_address);
            placeDetailStatus = ButterKnife.findById(view, R.id.tv_status);
//            placeDetailAr = ButterKnife.findById(view, R.id.iv_goto_ar);
        }
        setPlaceDetailDataOnViews();

        double popWidth = getWindowWidth() * 0.9;
        double popHeight = getWindowHeight() / 2;
        setWidth((int) popWidth);
        setHeight((int) popHeight);
    }

    /***
     * 處理顯示的資料
     */
    private void setPlaceDetailDataOnViews() {
        initPhoto();
        placeDetailTitle.setText(resultBeans.getName());
        placeDetailAddress.setText(resultBeans.getVicinity());
        placeDetailStatus.setText(resultBeans.getOpeningHours() == null ? "" : resultBeans.getOpeningHours().isOpenNow() ? mainActivity.getString(R.string.place_detail_status_is_working) : mainActivity.getString(R.string.place_detail_status_not_working));
//        placeDetailAr.setOnClickListener(this);
    }



    //--------

    /***
     * 處理照片
     */
    private void initPhoto() {
        if (resultBeans.getPhotos() != null) {
            Glide
                    .with(mainActivity)
                    .load(MessageFormat.format(ConnectInfo.API_GOOGLE_PHOTO_REFERENCE, resultBeans.getPhotos().get(0).getPhotoReference(), mainActivity.getString(R.string.google_maps_key)))
                    .into(placeDetailPhoto);
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(mainActivity.getString(R.string.toast_googlemap_non_place_image));
        }

    }
}
