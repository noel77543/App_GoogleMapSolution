package tw.com.creatidea.t_57_googlemap_solution;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Map;

import tw.com.creatidea.t_57_googlemap_solution.model.PlaceInfo;
import tw.com.creatidea.t_57_googlemap_solution.util.LoadingCycleManager;

/**
 * Created by noel on 2017/12/6.
 */

public class PlaceMarkerHandler extends AsyncTask<Void, Void, Void> {
    private GoogleMap googleMap;
    private MainActivity activity;
    private PlaceInfo placeInfo;
    private LoadingCycleManager loadingCycleManager;
    private Map<String, Marker> placeMarkerMap;
    private Map<String, Integer> placeMarkerIndex;

    public PlaceMarkerHandler(Activity activity, GoogleMap googleMap, PlaceInfo placeInfo, Map<String, Marker> placeMarkerMap, Map<String, Integer> placeMarkerIndex) {
        this.activity = (MainActivity) activity;
        this.googleMap = googleMap;
        this.placeInfo = placeInfo;
        this.placeMarkerMap = placeMarkerMap;
        this.placeMarkerIndex = placeMarkerIndex;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loadingCycleManager = new LoadingCycleManager(activity);
        loadingCycleManager.setLoadingMessage(activity.getString(R.string.dialog_message_googlemap_place_already));
        loadingCycleManager.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        placeMarkerMap.clear();
        ArrayList<PlaceInfo.ResultsBean> resultDatas = placeInfo.getResults();
        for (int i = 0; i < resultDatas.size(); i++) {
            final String name = resultDatas.get(i).getName();
            final LatLng latLng = new LatLng(resultDatas.get(i).getGeometry().getLocation().getLat(), resultDatas.get(i).getGeometry().getLocation().getLng());
            final int index = i;
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Marker marker = googleMap.addMarker(new MarkerOptions()
                            .position((latLng))
                            .title(name)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.myicon))
                            .anchor(0.5f, 0.9f));
                    placeMarkerMap.put(marker.getTitle(), marker);
                    placeMarkerIndex.put(marker.getTitle(), index);
                }
            });

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        loadingCycleManager.dismiss();
    }
}
