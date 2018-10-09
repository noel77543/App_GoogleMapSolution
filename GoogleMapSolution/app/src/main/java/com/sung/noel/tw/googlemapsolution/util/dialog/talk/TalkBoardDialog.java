package com.sung.noel.tw.googlemapsolution.util.dialog.talk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.main.MainActivity;
import com.sung.noel.tw.googlemapsolution.util.TimeUtil;
import com.sung.noel.tw.googlemapsolution.util.dialog.talk.adapter.TalkAdapter;
import com.sung.noel.tw.googlemapsolution.util.dialog.talk.register.RegisterDialog;
import com.sung.noel.tw.googlemapsolution.util.firebase.database.model.FirebaseData;
import com.sung.noel.tw.googlemapsolution.util.firebase.database.MyFirebaseDataBaseCenter;
import com.sung.noel.tw.googlemapsolution.util.preference.SharedPreferenceUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TalkBoardDialog extends Dialog implements MyFirebaseDataBaseCenter.OnFirebaseDataChangeListener {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.edit_text_view)
    EditText editTextView;
    @BindView(R.id.btn_sent)
    Button btnSent;
    @BindView(R.id.btn_close)
    Button btnClose;
    @BindView(R.id.tv_announcement)
    TextView tvAnnouncement;
    @BindView(R.id.tv_online)
    TextView tvOnline;


    private MyFirebaseDataBaseCenter myFirebaseDataBaseCenter;
    private TalkAdapter talkAdapter;
    private FirebaseData firebaseData;
    private SharedPreferenceUtil sharedPreferenceUtil;
    private RegisterDialog registerDialog;
    private TimeUtil timeUtil;
    private Context context;

    public TalkBoardDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_talk);
        ButterKnife.bind(this);
        this.context = context;
        init();
    }

    //----------------
    private void init() {
        timeUtil = new TimeUtil();
        registerDialog = new RegisterDialog(context);
        sharedPreferenceUtil = new SharedPreferenceUtil(context, SharedPreferenceUtil.NAME_TALK_BOARD);
        talkAdapter = new TalkAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(talkAdapter);
        myFirebaseDataBaseCenter = new MyFirebaseDataBaseCenter();
        myFirebaseDataBaseCenter.setOnFirebaseDataChangeListener(this);

    }
    //----------------

    @OnClick({R.id.btn_sent, R.id.btn_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //發送
            case R.id.btn_sent:
                if (firebaseData != null) {
                    String message = editTextView.getText().toString();

                    //如果完成註冊 或 已註冊過
                    if (isRegistered(Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID))) {
                        if (!message.equals("")) {
                            FirebaseData.BoardBean boardBean = new FirebaseData.BoardBean();
                            boardBean.setName(sharedPreferenceUtil.getUserName());
                            boardBean.setText(message);
                            boardBean.setTime(timeUtil.getCurrentTime());
                            boardBean.setUuid(Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID));
                            myFirebaseDataBaseCenter.sendMessage(boardBean, firebaseData.getBoard().size());
                            editTextView.setText("");
                            hideKeyboard((MainActivity) context);
                            tvAnnouncement.requestFocus();
                        }
                    }
                    //如果還沒註冊
                    else {
                        registerDialog.show();
                    }
                }
                break;
            //關閉
            case R.id.btn_close:
                dismiss();
                break;
        }
    }

    //-------------
    public void showDialog() {
        tvAnnouncement.requestFocus();
        show();
    }


    //----------------

    /***
     * 當Real Time DB 資料改變 (新增 修改 刪除)
     * @param firebaseData
     */
    @Override
    public void onFirebaseDataChange(FirebaseData firebaseData) {
        if (firebaseData != null) {
            this.firebaseData = firebaseData;
            talkAdapter.setData(firebaseData.getBoard());
            tvAnnouncement.setText(firebaseData.getAnnouncement());
            //online 需要-1 因為有一個是作為模組的存在 並非真實使用者
            tvOnline.setText(String.format(context.getString(R.string.talk_online), firebaseData.getOnline().size() - 1, firebaseData.getRegister().size()));
        }
    }

    //---------------

    /***
     *確認是否已註冊
     */
    private boolean isRegistered(String uuid) {
        if (!uuid.equals("")) {
            ArrayList<FirebaseData.RegisterBean> registerBean = firebaseData.getRegister();
            for (int i = 0; i < registerBean.size(); i++) {
                String currentUuid = registerBean.get(i).getUuid();
                if (uuid.equals(currentUuid)) {
                    sharedPreferenceUtil.setUsetName(registerBean.get(i).getName());
                    return true;
                }
            }
        }
        return false;
    }

    //---------

    /***
     *  隱藏鍵盤
     */
    private void hideKeyboard(Activity activity) {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
