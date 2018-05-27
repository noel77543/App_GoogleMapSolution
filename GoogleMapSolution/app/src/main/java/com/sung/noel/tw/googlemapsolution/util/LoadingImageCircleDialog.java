package com.sung.noel.tw.googlemapsolution.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.sung.noel.tw.googlemapsolution.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 2017/11/4.
 */

public class LoadingImageCircleDialog extends Dialog implements DialogInterface.OnDismissListener{
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;

    private final int ANIMATION_DURATION = 800;
    private Animation animation;
    //使動畫速率始終如一
    private LinearInterpolator linearInterpolator;
    public LoadingImageCircleDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_img_circle);
        ButterKnife.bind(this);
        init();
    }

    /***
     *  init
     */
    private void init() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(false);
        linearInterpolator = new LinearInterpolator();
        setOnDismissListener(this);
    }
    //--------------
    /***
     *  show
     */
    public void showLoadingDialog() {
        animation = new RotateAnimation(0f, 360f,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(ANIMATION_DURATION);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setInterpolator(linearInterpolator);
        imageView.setAnimation(animation);

        animation.startNow();
        show();
    }
    //--------------

    /***
     *  當dismiss 解除 動畫
     * @param dialog
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        if(animation!=null){
            animation.cancel();
        }
    }
    //--------------

    /***
     *  設置文字
     * @param loadingMessage
     */
    public void setLoadingMessage(String loadingMessage) {
        textView.setText(loadingMessage);
    }
}
