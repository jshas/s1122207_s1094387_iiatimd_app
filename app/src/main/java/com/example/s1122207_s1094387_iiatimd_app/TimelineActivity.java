package com.example.s1122207_s1094387_iiatimd_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.room.RoomDatabase;
import androidx.room.Room;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TimelineActivity extends Activity implements View.OnClickListener{

    VolleySingleton vs = VolleySingleton.getInstance(getApplicationContext());
    AppDatabase db = AppDatabase.getInstance(getApplicationContext());

    private ImageView pills;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;



    TimelineItem[] testTimeline = new TimelineItem[2];
    //testTimeline[0] = db. //FIXME

    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.timeline_activity);
        pills=(ImageView)findViewById(R.id.imagePills);


        recyclerView = findViewById(R.id.historyRecyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();

        //recyclerViewAdapter = new HistoryAdapter(); //TODO: Get list from database
        //recyclerView.setAdapter(recyclerViewAdapter);


        Button updateButton = findViewById(R.id.fetchMedicine);
        updateButton.setOnClickListener((View v) -> {
            Log.d("test","test");
        });

        Button toMainActivity = findViewById(R.id.toMainActivityButton);
        toMainActivity.setOnClickListener((View v) -> {
            Intent toMedicineUserIntent = new Intent(this, MainActivity.class);
            startActivity(toMedicineUserIntent);
        });


    }

    @Override
    public void onClick(View v) {

    }
}
