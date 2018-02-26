package com.sung.noel.tw.googlemapsolution.navigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.navigation.model.NavigationData;

/**
 * Created by noel on 2017/12/6.
 */

public class NavigationAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<NavigationData> navigationDatas;

    public NavigationAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        navigationDatas = new ArrayList<>();
    }

    public void setData(ArrayList<NavigationData> navigationDatas) {
        this.navigationDatas = navigationDatas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return navigationDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return navigationDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_white_text_with_right_arrow, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(navigationDatas.get(position).getTextCh());
        return convertView;
    }
    //-----------------

    static class ViewHolder {
        @BindView(R.id.textview)
        TextView textView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
