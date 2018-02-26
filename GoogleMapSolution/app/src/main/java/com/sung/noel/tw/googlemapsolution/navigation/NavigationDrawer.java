package com.sung.noel.tw.googlemapsolution.navigation;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.main.MainActivity;
import com.sung.noel.tw.googlemapsolution.navigation.adapter.NavigationAdapter;
import com.sung.noel.tw.googlemapsolution.navigation.model.NavigationData;

/**
 * Created by noel on 2017/12/6.
 */

public class NavigationDrawer implements AdapterView.OnItemClickListener {
    private ArrayList<NavigationData> navigationDatas;
    private String[] itemsCh;
    private String[] itemsEn;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private MainActivity activity;
    private OnNavigationItemClickListener onNavigationItemClickListener;
    private NavigationAdapter adapter;

    //-----
    public NavigationDrawer(Context context) {
        activity = (MainActivity) context;
        drawerLayout = activity.drawerLayout;
        listView = activity.listview;
        initDrawaerListview();
    }

    //-----
    private void initDrawaerListview() {
        adapter = new NavigationAdapter(activity);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        navigationDatas = new ArrayList<>();
        itemsCh = activity.getResources().getStringArray(R.array.navigation_array_ch);
        itemsEn = activity.getResources().getStringArray(R.array.navigation_array_en);
        for (int i = 0; i < itemsCh.length; i++) {
            navigationDatas.add(new NavigationData(itemsCh[i], itemsEn[i]));
        }
        adapter.setData(navigationDatas);
    }

    //-----
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        drawerLayout.closeDrawers();
        onNavigationItemClickListener.onNavigationItemClick(parent, view, position, id);
    }

    //-----
    public interface OnNavigationItemClickListener {
        void onNavigationItemClick(AdapterView<?> parent, View view, int position, long id);
    }

    public void setOnNavigationItemClickListener(OnNavigationItemClickListener onNavigationItemClickListener) {
        this.onNavigationItemClickListener = onNavigationItemClickListener;
    }
}
