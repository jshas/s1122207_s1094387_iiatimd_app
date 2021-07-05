package com.example.s1122207_s1094387_iiatimd_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;

public class TimelineActivity extends Activity implements View.OnClickListener{


    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;



    TimelineItem[] testTimeline = new TimelineItem[2];
    //testTimeline[0] = db. //FIXME

    @Override
    public void onCreate(Bundle savedInstances) {
        VolleySingleton vs = VolleySingleton.getInstance(getApplicationContext());
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());

        final String MEDICINE_URL = "http://10.0.2.2:8000/api/medicine";
        super.onCreate(savedInstances);
        setContentView(R.layout.timeline_activity);

        recyclerView = findViewById(R.id.historyRecyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();

        //recyclerViewAdapter = new HistoryAdapter(); //TODO: Get list from database
        //recyclerView.setAdapter(recyclerViewAdapter);


        Button buttonAPIFetch = findViewById(R.id.fetchMedicine);
        buttonAPIFetch.setOnClickListener((View v) -> {
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                    MEDICINE_URL,
                    null,
                    response -> db.medicineDao().insertAllMedicines(Medicine.fromJson(response)),
                    error -> Log.e("API Fetch error", error.getMessage()));
            vs.addToRequestQueue(jsonArrayRequest);

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
