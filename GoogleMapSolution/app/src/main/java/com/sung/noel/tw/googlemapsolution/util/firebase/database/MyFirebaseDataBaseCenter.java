package com.sung.noel.tw.googlemapsolution.util.firebase.database;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sung.noel.tw.googlemapsolution.util.firebase.database.model.FirebaseData;

import java.util.ArrayList;

public class MyFirebaseDataBaseCenter implements ValueEventListener {
    private DatabaseReference databaseReference;
    private OnFirebaseDataChangeListener onFirebaseDataChangeListener;
    private DataSnapshot dataSnapshot;

    public MyFirebaseDataBaseCenter() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(this);
    }
    //--------------

    /***
     * 註冊 使用者
     */
    public void registerUser(FirebaseData.RegisterBean registerBean, int index) {
        DatabaseReference newRef = databaseReference.child("Register").child(String.valueOf(index));
        newRef.setValue(registerBean);
    }


    //-------------

    /***
     *  使用者 發送字串訊息
     * @param boardBean
     */
    public void sendMessage(FirebaseData.BoardBean boardBean, int index) {
        DatabaseReference newRef = databaseReference.child("Board").child(String.valueOf(index));
        newRef.setValue(boardBean);
    }

    //--------------


    /***
     * 登入
     */
    public void login(FirebaseData.OnlineBean onlineBean, int index) {
        DatabaseReference newRef = databaseReference.child("Online").child(String.valueOf(index));
        newRef.setValue(onlineBean);
    }

    //-------------

    /***
     *  登出
     */
    public void logout(FirebaseData.OnlineBean onlineBean) {
        if (dataSnapshot != null && onlineBean != null) {
            ArrayList<FirebaseData.OnlineBean> onlineBeans = dataSnapshot.getValue(FirebaseData.class).getOnline();
            for (int i = 0; i < onlineBeans.size(); i++) {
                FirebaseData.OnlineBean currentOnlineBean = onlineBeans.get(i);
                if (currentOnlineBean.getUuid().equals(onlineBean.getUuid())) {
                    onlineBeans.remove(i);
                }
            }

            databaseReference.child("Online").setValue(onlineBeans);
        }
    }


    //--------------


    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        this.dataSnapshot = dataSnapshot;
        onFirebaseDataChangeListener.onFirebaseDataChange(dataSnapshot.getValue(FirebaseData.class));
    }

    //----------

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }


    //-----------------
    public interface OnFirebaseDataChangeListener {
        void onFirebaseDataChange(FirebaseData firebaseData);
    }

    public void setOnFirebaseDataChangeListener(OnFirebaseDataChangeListener onFirebaseDataChangeListener) {
        this.onFirebaseDataChangeListener = onFirebaseDataChangeListener;
    }
}

