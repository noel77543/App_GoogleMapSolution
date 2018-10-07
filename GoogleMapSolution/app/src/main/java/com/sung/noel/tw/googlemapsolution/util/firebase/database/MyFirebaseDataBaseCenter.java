package com.sung.noel.tw.googlemapsolution.util.firebase.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyFirebaseDataBaseCenter {
    private DatabaseReference databaseReference;

    public MyFirebaseDataBaseCenter(){
        databaseReference = FirebaseDatabase.getInstance().getReference();

    }
}
