package com.example.s1122207_s1094387_iiatimd_app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private static final String CHANNEL_ID = "SAMPLE_ID";

    @Override
    public void onReceive(Context context, Intent intent) {

        //Get id & message from intent
        int notificationID = intent.getIntExtra("notificationId", 0);
        String message = intent.getStringExtra("message");

        //Call AlarmClass when notification is tapped
        Intent alarmIntent = new Intent(context, AlarmClass.class);
        PendingIntent contentIntent = PendingIntent.getActivity(
                context, 0, alarmIntent, 0
        );

        //NotificationManager
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

//       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.0){
            //For API 26 and above
//            CharSequence channel_name = "My Notification";
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channel_name, importance);
//            notificationManager.createNotificationChannel(channel);
//            Log.d("API version","above 26");
//        }

        //Prepare notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("Pill Reminder")
                .setContentText(message)
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        //Notify
        notificationManager.notify(notificationID, builder.build());

    }
}
