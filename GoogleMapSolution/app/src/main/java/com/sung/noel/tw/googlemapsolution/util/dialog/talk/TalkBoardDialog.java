package com.sung.noel.tw.googlemapsolution.util.dialog.talk;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.PlaceInfo;
import com.sung.noel.tw.googlemapsolution.util.preference.SharedPreferenceUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TalkBoardDialog extends Dialog {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.edit_text_view)
    EditText editTextView;
    @BindView(R.id.btn_sent)
    Button btnSent;
    @BindView(R.id.btn_close)
    Button btnClose;

    private SharedPreferenceUtil sharedPreferenceUtil;
    private ArrayList<PlaceInfo.ResultsBean> data;

    public TalkBoardDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_talk);
        ButterKnife.bind(this);
        setCancelable(false);
        init();
    }

    //----------------
    private void init() {

    }

    @OnClick({R.id.btn_sent, R.id.btn_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //發送
            case R.id.btn_sent:
                break;
            //關閉
            case R.id.btn_close:
                break;
        }
    }
}
