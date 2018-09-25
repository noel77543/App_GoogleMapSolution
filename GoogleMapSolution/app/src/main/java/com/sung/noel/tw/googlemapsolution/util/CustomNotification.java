package com.sung.noel.tw.googlemapsolution.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;


import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.main.MainActivity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static android.content.Context.NOTIFICATION_SERVICE;


/**
 * Created by noel on 2018/4/13.
 */

public class CustomNotification extends Notification {

    public static final int NOTIFICATION_ID_NORMAL = 9487;
    public static final int NOTIFICATION_ID_DISTANCE = 9488;

    @IntDef({NOTIFICATION_ID_NORMAL, NOTIFICATION_ID_DISTANCE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationIDType {
    }

    public static final String CHANNEL_ID_NORMAL = "normal";
    public static final String CHANNEL_ID_DISTANCE = "distance";
    public static final String CHANNEL_ID_BACKGROUND = "backgroundService";

    @StringDef({CHANNEL_ID_BACKGROUND, CHANNEL_ID_DISTANCE, CHANNEL_ID_NORMAL})
    @Retention(RetentionPolicy.SOURCE)
    private @interface ChannelIDType {
    }

    public static final String CHANNEL_NAME_NORMAL = "一般通知";
    private static final String CHANNEL_NAME_DISTANCE = "距離監測通知";

    @StringDef({CHANNEL_NAME_NORMAL, CHANNEL_NAME_DISTANCE})
    @Retention(RetentionPolicy.SOURCE)
    private @interface ChannelNameType {
    }

    private Context context;
    private PendingIntent pendingIntent;
    private Bundle bundle;
    private NotificationManager notificationManager;
    private Uri defaultSoundUri;
    private String channelId;
    private String channelName;

    /***
     * @param bundle  是否攜帶資訊 可null
     */
    public CustomNotification(Context context, @ChannelIDType String channelId, @ChannelNameType String channelName, @Nullable Bundle bundle) {
        this.context = context;
        this.bundle = bundle;
        this.channelId = channelId;
        this.channelName = channelName;

        init();
    }


    //--------

    /***
     * init..
     */
    private void init() {
        //獲取通知服務
        notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent intentNotification = new Intent(context, MainActivity.class);
        if (bundle != null) {
            intentNotification.putExtras(bundle);
        }
        intentNotification.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intentNotification.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        pendingIntent = PendingIntent.getActivity(context, 0, intentNotification, PendingIntent.FLAG_CANCEL_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    //-----------

    /***
     * 前往 主頁面
     */
    public void sendNotification(@NotificationIDType int notificationId, String title, String content) {
        RemoteViews remoteViews = null;
        Notification notification;

        switch (notificationId) {
            case NOTIFICATION_ID_NORMAL:
                remoteViews = getNormalRemoteViews(title, content);
                break;
            case NOTIFICATION_ID_DISTANCE:
                remoteViews = getDistanceRemoteViews(title, content);
                break;
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Notification.Builder notificationBuilder = new Notification.Builder(context, channelId)
                    //狀態欄的icon
                    .setSmallIcon(R.drawable.gothere)
                    //通知聲音
                    .setSound(defaultSoundUri)
                    //設置的intent
                    .setContentIntent(pendingIntent)
                    //點了之後自動消失
                    .setAutoCancel(true);

            notification = notificationBuilder.build();
        } else {
            NotificationCompat.Builder notificationCompatBuilder = new NotificationCompat.Builder(context)
                    //狀態欄的icon
                    .setSmallIcon(R.drawable.gothere)
                    //使可以向下彈出
                    .setPriority(Notification.PRIORITY_HIGH)
                    //通知聲音
                    .setSound(defaultSoundUri)
                    //設置的intent
                    .setContentIntent(pendingIntent)
                    //點了之後自動消失
                    .setAutoCancel(true);

            notification = notificationCompatBuilder.build();
        }

        if (remoteViews != null) {
            notification.contentView = remoteViews;
        }

        // 發送通知
        notificationManager.notify(notificationId, notification);
    }

    //-------------

    private RemoteViews getNormalRemoteViews(String title, String content) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_normal);
        remoteViews.setTextViewText(R.id.tv_title, title);
        remoteViews.setTextViewText(R.id.tv_content, content);
        return remoteViews;
    }
    //-------------

    private RemoteViews getDistanceRemoteViews(String title, String content) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_distance);
        remoteViews.setTextViewText(R.id.tv_title, title);
        remoteViews.setTextViewText(R.id.tv_content, content);
        return remoteViews;
    }

    //-------------

    /***
     * 移除通知
     */
    public void removeNotification(@NotificationIDType int notificationId) {
        notificationManager.cancel(notificationId);
    }
}
