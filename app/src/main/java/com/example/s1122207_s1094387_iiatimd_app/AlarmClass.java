package com.example.s1122207_s1094387_iiatimd_app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AlarmClass extends AppCompatActivity implements View.OnClickListener {

    private int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_class);

        //Set onClick Listener
        findViewById(R.id.setButton).setOnClickListener(this);
        findViewById(R.id.cnlButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        EditText editAlarm = findViewById(R.id.editAlarm);
        TimePicker timePicker = findViewById(R.id.timePicker);

        //Set notifications & message
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("notificationID", notificationID);
        intent.putExtra("message", editAlarm.toString());

        //PendingIntent
        PendingIntent alarmIntent = PendingIntent.getBroadcast(
                AlarmClass.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT
        );

        //AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (v.getId()){
            case R.id.setButton:
                //Set Alarm
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                //Create Time (GOD)
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();

                //Set Alarm
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);

                Toast.makeText(this, "Take med!", Toast.LENGTH_SHORT).show();
                break;


            case R.id.cnlButton:
                //Cancel Alarm
                alarmManager.cancel(alarmIntent);
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
        }
    }
}
