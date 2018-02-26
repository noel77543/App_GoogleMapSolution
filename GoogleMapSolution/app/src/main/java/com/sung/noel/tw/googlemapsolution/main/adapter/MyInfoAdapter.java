package com.sung.noel.tw.googlemapsolution.main.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.sung.noel.tw.googlemapsolution.R;

/**
 * Created by noel on 2017/8/16.
 */

public class MyInfoAdapter implements GoogleMap.InfoWindowAdapter {
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tv_location)
    TextView tvLocation;

    private Activity context;

    public MyInfoAdapter(Activity context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View v = context.getLayoutInflater().inflate(R.layout.map_info, null);
        ButterKnife.bind(this, v);
        tvName.setText(marker.getTitle());
        tvLocation.setText(String.format(context.getString(R.string.ar_target_location),marker.getPosition().longitude+"", marker.getPosition().latitude+""));
        return v;
    }
}
