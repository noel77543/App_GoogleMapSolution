package com.sung.noel.tw.googlemapsolution.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.sung.noel.tw.googlemapsolution.R;

/**
 * Created by User on 2017/11/4.
 */

public class LoadingCycleManager extends Dialog {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;

    public LoadingCycleManager(Context context) {
        super(context);
        setContentView(R.layout.dialog_loading);
        ButterKnife.bind(this);
        initLoadingCycle();
    }

    private void initLoadingCycle() {
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.setCancelable(false);
        initViews();
    }

    private void initViews() {
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.animation_loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();//動畫開始
    }

    public void setLoadingMessage(String loadingMessage) {
        textView.setText(loadingMessage);
    }
}
