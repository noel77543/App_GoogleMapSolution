package tw.com.creatidea.t_57_googlemap_solution;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by noel on 2017/8/16.
 */

public class MyInfoAdapter implements GoogleMap.InfoWindowAdapter {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvLongitude)
    TextView tvLongitude;
    @BindView(R.id.tvLatitude)
    TextView tvLatitude;
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
        tvLatitude.setText("緯度：" + marker.getPosition().latitude);
        tvLongitude.setText("經度：" + marker.getPosition().longitude);
        return v;
    }
}
