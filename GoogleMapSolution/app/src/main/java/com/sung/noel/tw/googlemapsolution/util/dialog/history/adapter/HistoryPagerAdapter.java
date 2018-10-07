package com.sung.noel.tw.googlemapsolution.util.dialog.history.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.connect.ConnectInfo;
import com.sung.noel.tw.googlemapsolution.event.EventCenter;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.PlaceInfo;

import java.text.MessageFormat;
import java.util.ArrayList;


public class HistoryPagerAdapter extends PagerAdapter {

    private ArrayList<PlaceInfo.ResultsBean> data;
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<PlaceInfo.ResultsBean.PhotosBean> photosBean;

    public HistoryPagerAdapter(Context context,ArrayList<PlaceInfo.ResultsBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }
    //---------

    @Override
    public int getCount() {
        return data.size();
    }
    //---------

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //--------
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = inflater.inflate(R.layout.list_history_pager, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        photosBean = data.get(position).getPhotos();
        (container).addView(view);

        if (photosBean != null) {
            Glide
                    .with(context)
                    .load(MessageFormat.format(ConnectInfo.API_GOOGLE_PHOTO_REFERENCE, photosBean.get(0).getPhotoReference(), context.getString(R.string.google_maps_key)))
                    .into(imageView);
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_googlemap_non_place_image));
        }

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
