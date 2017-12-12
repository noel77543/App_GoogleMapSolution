package tw.com.creatidea.t_57_googlemap_solution.util;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import butterknife.ButterKnife;
import tw.com.creatidea.t_57_googlemap_solution.MainActivity;
import tw.com.creatidea.t_57_googlemap_solution.R;
import tw.com.creatidea.t_57_googlemap_solution.basic.BasicPopupWindow;
import tw.com.creatidea.t_57_googlemap_solution.model.PlaceInfo;

import static tw.com.creatidea.t_57_googlemap_solution.connect.ConnectInfo.API_GOOGLE_PHOTO_REFERENCE;

/**
 * Created by noel on 2017/12/8.
 */

public class PlaceDetailPopupWindow extends BasicPopupWindow {
    private MainActivity mainActivity;
    private View view;
    private PlaceInfo.ResultsBean resultBeans;

    private ImageView placeDetailAr;
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
    public void showSightFoodDescribePopupWindow(PlaceInfo.ResultsBean resultBeans) {
        this.resultBeans = resultBeans;
        initSightFoodDescribePopupWindow();
        showAtLocation(mainActivity.drawerLayout, Gravity.CENTER, 0, 0);
    }
    //--------

    /**
     * 初始化
     */
    private void initSightFoodDescribePopupWindow() {
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        if (view == null) { //todo 同container觀念  _noel
            view = inflater.inflate(R.layout.a_popup_place_detail, null);
            ButterKnife.bind(this, view);
            setContentView(view);
            placeDetailPhoto = ButterKnife.findById(view, R.id.imageview);
            placeDetailTitle = ButterKnife.findById(view, R.id.tv_title);
            placeDetailAddress = ButterKnife.findById(view, R.id.tv_address);
            placeDetailStatus = ButterKnife.findById(view, R.id.tv_status);
            placeDetailAr = ButterKnife.findById(view, R.id.iv_goto_ar);
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
//        if(resultBeans.getOpeningHours()!=null){
            placeDetailStatus.setText(resultBeans.getOpeningHours().isOpenNow() ? mainActivity.getString(R.string.place_detail_status_is_working) : mainActivity.getString(R.string.place_detail_status_not_working));
//        }
//        placeDetailMessage.setText(getMessages(placeDetail.getResult().getReviews()));
    }

//    //--------
//
//    /***
//     * 處理地方詳細資訊中的留言
//     */
//    private String getMessages(ArrayList<PlaceDetail.ResultBean.ReviewsBean> reviewBeans) {
//        StringBuilder sb = new StringBuilder();
//        if(reviewBeans.size()>0){
//            for (int i = 0; i < reviewBeans.size(); i++) {
//                PlaceDetail.ResultBean.ReviewsBean reviewBean = reviewBeans.get(i);
//                sb.append(reviewBean.getAuthorName() + ":" + reviewBean.getText());
//            }
//        }else {
//            sb.append("");
//        }
//        return sb.toString();
//    }


    //--------

    /***
     * 處理照片
     */
    private void initPhoto() {
        if (resultBeans.getPhotos() != null) {
            Glide
                    .with(mainActivity)
                    .load(String.format(API_GOOGLE_PHOTO_REFERENCE, resultBeans.getPhotos().get(0).getPhotoReference(), mainActivity.getString(R.string.google_maps_key)))
                    .into(placeDetailPhoto);
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(mainActivity.getString(R.string.toast_googlemap_non_place_detail));
        }

    }
}
