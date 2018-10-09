package com.sung.noel.tw.googlemapsolution.util.dialog.talk.register;

import android.app.Dialog;
import android.content.Context;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.util.TimeUtil;
import com.sung.noel.tw.googlemapsolution.util.firebase.database.MyFirebaseDataBaseCenter;
import com.sung.noel.tw.googlemapsolution.util.firebase.database.model.FirebaseData;
import com.sung.noel.tw.googlemapsolution.util.preference.SharedPreferenceUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterDialog extends Dialog implements MyFirebaseDataBaseCenter.OnFirebaseDataChangeListener {

    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private FirebaseData firebaseData;
    private MyFirebaseDataBaseCenter myFirebaseDataBaseCenter;
    private TimeUtil timeUtil;
    private SharedPreferenceUtil sharedPreferenceUtil;

    public RegisterDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_register);
        ButterKnife.bind(this);
        init();
    }

    //------------

    private void init() {
        sharedPreferenceUtil = new SharedPreferenceUtil(getContext(), SharedPreferenceUtil.NAME_TALK_BOARD);
        timeUtil = new TimeUtil();
        myFirebaseDataBaseCenter = new MyFirebaseDataBaseCenter();
        myFirebaseDataBaseCenter.setOnFirebaseDataChangeListener(this);
    }


    //----------

    @OnClick({R.id.btn_register})
    public void onViewClicked(View view) {
        String name = editText.getText().toString();
        //如若該名稱允許註冊
        if (isAllowedName(name)) {
            myFirebaseDataBaseCenter.registerUser(getUserData(name));
            sharedPreferenceUtil.setUsetName(name);
        }
    }
    //---------------

    /***
     * 建立欲發送的model
     * @return
     */
    private FirebaseData.RegisterBean getUserData(String name) {
        //取得在初次打開裝置時產生的64位16進位碼 如若裝置重置 會被刷新 其他情況下是唯一值存在
        String androidID = Settings.System.getString(getContext().getContentResolver(), Settings.System.ANDROID_ID);

        FirebaseData.RegisterBean registerBean = new FirebaseData.RegisterBean();
        registerBean.setName(name);
        registerBean.setUuid(androidID);
        registerBean.setTime(timeUtil.getCurrentTime());
        return registerBean;
    }
    //---------------

    /***
     * 命名是否允許 -> 字串長度小於等於5  且不曾被使用
     * @param name
     * @return
     */
    private boolean isAllowedName(String name) {
        ArrayList<FirebaseData.RegisterBean> registerBeans = firebaseData.getRegister();
        for (int i = 0; i < registerBeans.size(); i++) {
            FirebaseData.RegisterBean registerBean = registerBeans.get(i);
            if (name.equals(registerBean.getName())) {
                Toast.makeText(getContext(), getContext().getString(R.string.toast_same_name_error), Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (name.length() > 5) {
            Toast.makeText(getContext(), getContext().getString(R.string.toast_name_length_error), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    //---------------

    @Override
    public void onFirebaseDataChange(FirebaseData firebaseData) {
        this.firebaseData = firebaseData;
    }
}
