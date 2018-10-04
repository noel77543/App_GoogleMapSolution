package com.sung.noel.tw.googlemapsolution.util.dialog.history;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.main.model.PlaceInfo;
import com.sung.noel.tw.googlemapsolution.util.dialog.history.adapter.HistoryPagerAdapter;
import com.sung.noel.tw.googlemapsolution.util.preference.SharedPreferenceUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryDialog extends Dialog implements ViewPager.OnPageChangeListener {
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    private SharedPreferenceUtil sharedPreferenceUtil;
    private ArrayList<PlaceInfo.ResultsBean> data;

    public HistoryDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_history);
        ButterKnife.bind(this);
        init();

    }

    //----------------
    private void init() {
        sharedPreferenceUtil = new SharedPreferenceUtil(getContext(), SharedPreferenceUtil.NAME_HISTORY);
        data = sharedPreferenceUtil.getHistory();
        viewPager.setAdapter(new HistoryPagerAdapter(getContext(), data));
        viewPager.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ivRight.setVisibility(position < data.size() - 1 ? View.VISIBLE : View.INVISIBLE);
        ivLeft.setVisibility(position > 0 ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
