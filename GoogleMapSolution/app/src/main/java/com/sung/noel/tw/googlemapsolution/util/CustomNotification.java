package com.sung.noel.tw.googlemapsolution.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static android.content.Context.NOTIFICATION_SERVICE;


/**
 * Created by noel on 2018/4/13.
 */

public class CustomNotification extends Notification {

    private final int NOTIFICATION_ID = 9487;

    private Context context;
    // 開啟另一個Activity的Intent
    private Intent intentNotification;
    private PendingIntent pendingIntent;
    private Bundle bundle;
    private int flags;

    private Notification notification;
    private NotificationManager notificationManager;
    private Uri defaultSoundUri;
    private Bitmap bigIcon;


    /***
     * @param bundle  是否攜帶資訊 可null
     */
    public CustomNotification(Context context, @Nullable Bundle bundle) {
        this.context = context;
        this.bundle = bundle;
        init();
    }


    //--------

    /***
     * init..
     */
    private void init() {
        flags = PendingIntent.FLAG_CANCEL_CURRENT;
    }
    //-----------

    /***
     * 前往 主頁面
     */
    public void sendNotificationToUpdate(int smallIconRes, int largeIconRes, String title, String content, String url) {
        intentNotification = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (bundle != null) {
            intentNotification.putExtras(bundle);
        }
        intentNotification.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intentNotification.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        pendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID, intentNotification, flags);
        defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        bigIcon = BitmapFactory.decodeResource(context.getResources(), largeIconRes);
        //獲取通知服務
        notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        buildBigTextNotification(smallIconRes, title, content);

        // 發送通知
        notificationManager.notify(NOTIFICATION_ID, notification);
    }


    //-----

    /***
     * 大字串 可下拉延伸 notification
     */
    private void buildBigTextNotification(int smallIconRes, String title, String content) {
        // 建立通知
        notification = new NotificationCompat.Builder(context)
                //狀態欄的icon
                .setSmallIcon(smallIconRes)
                //通知欄的大icon
                .setLargeIcon(bigIcon)
                //使可以向下彈出
                .setPriority(Notification.PRIORITY_MAX)
                //一般狀態title
                .setContentTitle(title)
                //通知聲音
                .setSound(defaultSoundUri)
                //一般狀態內容
                .setContentText(content)
                //設置的intent
                .setContentIntent(pendingIntent)
                //點了之後自動消失
                .setAutoCancel(true)
                //設置風格 - 大字串
                .setStyle(new NotificationCompat.BigTextStyle()
                        //下拉時顯示的字串
                        .bigText(content)
                        //下拉時顯示的title
                        .setBigContentTitle(title)
                )
                .build();
    }
}
