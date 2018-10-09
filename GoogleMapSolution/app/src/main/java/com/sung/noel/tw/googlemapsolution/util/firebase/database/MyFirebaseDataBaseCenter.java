package com.sung.noel.tw.googlemapsolution.util.firebase.database;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sung.noel.tw.googlemapsolution.util.firebase.database.model.FirebaseData;

public class MyFirebaseDataBaseCenter implements ValueEventListener {
    private DatabaseReference databaseReference;
    private OnFirebaseDataChangeListener onFirebaseDataChangeListener;

    public MyFirebaseDataBaseCenter() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(this);
    }
    //--------------

    /***
     * 註冊 使用者
     */
    public void registerUser(FirebaseData.RegisterBean registerBean){
        databaseReference.child("Register").setValue(registerBean);
    }



    //-------------

    /***
     *  使用者 發送字串訊息
     * @param registerBean
     */
    public void sendMessage(FirebaseData.BoardBean registerBean){
        databaseReference.child("Board").setValue(registerBean);
    }




    //--------------


    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
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

