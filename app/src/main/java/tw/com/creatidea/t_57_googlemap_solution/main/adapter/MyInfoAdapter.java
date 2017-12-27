package tw.com.creatidea.t_57_googlemap_solution.main.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import butterknife.BindView;
import butterknife.ButterKnife;
import tw.com.creatidea.t_57_googlemap_solution.R;

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
