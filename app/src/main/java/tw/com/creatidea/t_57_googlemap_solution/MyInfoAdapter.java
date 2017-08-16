package tw.com.creatidea.t_57_googlemap_solution;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by noel on 2017/8/16.
 */

public class MyInfoAdapter implements GoogleMap.InfoWindowAdapter{
    private Activity context;
    //mapinfo
    private TextView name;
    private TextView mLongitude;//經度
    private TextView mLatitude;//緯度
    private ImageView img;

    public MyInfoAdapter(Activity context){
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View v = context.getLayoutInflater().inflate(R.layout.map_info,null);
        name = (TextView)v.findViewById(R.id.tvName);
        mLatitude = (TextView)v.findViewById(R.id.tvLatitude);
        mLongitude = (TextView)v.findViewById(R.id.tvLongitude);
        img = (ImageView)v.findViewById(R.id.imageView);
        name.setText(marker.getTitle());
        mLatitude.setText("經度："+marker.getPosition().latitude);
        mLongitude.setText("緯度："+marker.getPosition().longitude);
        img.setImageResource(R.mipmap.ic_launcher_round);
        return v;
    }
}
