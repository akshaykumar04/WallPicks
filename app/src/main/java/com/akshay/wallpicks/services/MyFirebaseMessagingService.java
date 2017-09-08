package com.akshay.wallpicks.services;

import android.util.Log;
import android.media.RingtoneManager;
import android.content.Intent;
import android.content.Context;
import android.app.PendingIntent;
import android.app.NotificationManager;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import android.support.v4.app.NotificationCompat;
import android.net.Uri;

import com.akshay.wallpicks.activities.MainActivity;
import com.akshay.wallpicks.R;
/**
 * Created by Akshay on 8/11/2017.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
//Displaying data in log
//It is optional
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " +
                remoteMessage.getNotification().getBody());
//Calling method to generate notification
        sendNotification(remoteMessage.getNotification().getBody());
    }
    //This method to generate push notification
    private void sendNotification(String messageBody) {
//MainActivity Intent Registration
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);
//Take Notification Sound
        Uri defaultSoundUri=
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//Generate the Notification
        NotificationCompat.Builder notificationBuilder = new
                NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_wallpaper_black_48dp)
                .setContentTitle("WallPicks")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager =
                (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
//Create Push Notification
        notificationManager.notify(0, notificationBuilder.build());
    }
}
