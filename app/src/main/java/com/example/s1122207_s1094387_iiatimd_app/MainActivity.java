package com.example.s1122207_s1094387_iiatimd_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Main buttons with single onClickListener
       Button toMedicineUserButton = findViewById(R.id.toMedicineScreen);
        toMedicineUserButton.setOnClickListener(this);
       Button buttonMedicineAdd = findViewById(R.id.addMedicine);
        buttonMedicineAdd.setOnClickListener(this);
       Button buttonMedicineTimeline = findViewById(R.id.medicineTimeline);
        buttonMedicineTimeline.setOnClickListener(this);
       Button buttonAPIFetch = findViewById(R.id.fetchMedicine);
        buttonAPIFetch.setOnClickListener(this);

        // nameDisplay
        TextView nameDisplay = findViewById(R.id.textView);
        //Recyclerview setup
        recyclerView = findViewById(R.id.navigationRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();

        // SINGLETONS // //FIXME: Replace .allowMainThreadQueries() with seperate Task Classes in project
        VolleySingleton vs = VolleySingleton.getInstance(getApplicationContext());
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());


        // TODO: Remove seeded data and seeders in production version
//        AppDatabaseSeeder.insertAllUsersTask(db);
//        AppDatabaseSeeder.insertAllMedicinesTask(db);
//        AppDatabaseSeeder.insertAllPrescriptions(db);
//        AppDatabaseSeeder.insertAllHistory(db);

        // TODO: MEDICINE ARRAY
        //  1) Replace hardcoded array with an API fetch

        //TODO: replace hardcode user with login
        // Gets @string/welcome_text = welcome (var) And adds the User's name at (var).
        String text;
//        String firstUserName = db.userDao().getById(0).getName();
        String firstUserName = "userDao() needs help.";
        text = getString(R.string.welcome_text, firstUserName);
        nameDisplay.setText(text);

        //A User creates a list with a medicine to take
        MedicinesCard firstCard = new MedicinesCard(firstUserName, db.medicineDao().getAll().get(1));


        //Makes a recyclerview "timeline" with al the timelineItems

        //mAdapter = new HistoryAdapter(timeline);

        // Returns the the medc
        mAdapter = new MedicineAdapter(db.medicineDao().getAll());
//        recyclerView.setAdapter(mAdapter);

    }

    public void onClick(View v){
        String viewId = getResources().getResourceEntryName(v.getId());
        switch (viewId){
            case "toMedicineScreen":
                Log.d("vID", viewId);
                Log.d("Scherm2", "Test scherm2");
                Intent toMedicineUserIntent = new Intent(this, MedicineUserActivity.class);
                startActivity(toMedicineUserIntent);
                break;
            case "addMedicine":
                Log.d("vID-add", viewId);
                break;
            case "medicineTimeline":
                Log.d("vID-timeline", viewId);
                break;
            case "fetchMedicine":
                Log.d("vID-fetch", viewId);
                break;
            default:
                Log.e("mainActivity.onClick","No matching viewId found.");
        }

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        //

    }
}