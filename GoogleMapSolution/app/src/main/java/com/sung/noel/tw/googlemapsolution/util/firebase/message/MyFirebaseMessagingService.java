package com.sung.noel.tw.googlemapsolution.util.firebase.message;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.sung.noel.tw.googlemapsolution.util.CustomNotification;

import java.util.Map;

/**
 * Created by noel on 2018/5/28.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    /***
     *  firebase console  messaging自訂Key
     */
    private final String KEY_TITLE = "title";
    private final String KEY_CONTENT = "content";

    //-----------

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Map<String, String> data = remoteMessage.getData();

        new CustomNotification(this, CustomNotification.CHANNEL_ID_NORMAL, CustomNotification.CHANNEL_NAME_NORMAL, null).
                sendNotification(CustomNotification.NOTIFICATION_ID_NORMAL, data.get(KEY_TITLE), data.get(KEY_CONTENT));


    }

    //-------------

}
