package com.example.s1122207_s1094387_iiatimd_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String MEDICINE_URL = "http://10.0.2.2:8000/api/medicine";
        setContentView(R.layout.activity_main);
        VolleySingleton vs = VolleySingleton.getInstance(getApplicationContext());
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());

        // Main buttons with single onClickListener
        Button toMedicineUserButton = findViewById(R.id.toMedicineScreen);
        toMedicineUserButton.setOnClickListener((View v) -> {
                Intent toMedicineUserIntent = new Intent(this, MedicineUserActivity.class);
                startActivity(toMedicineUserIntent);
            }
        );
        Button buttonMedicineTimeline = findViewById(R.id.toMedicineTimeline);
        buttonMedicineTimeline.setOnClickListener((View v) -> {
                    Intent toTimelineActivity = new Intent(this, TimelineActivity.class);
                    startActivity(toTimelineActivity);
                }
        );

        // nameDisplay
        TextView nameDisplay = findViewById(R.id.textView);





//         TODO: Remove seeded data and seeders in production version
        AppDatabaseSeeder.insertAllUsersTask(db);
        AppDatabaseSeeder.insertAllMedicinesTask(db);
        AppDatabaseSeeder.insertAllPrescriptions(db);
        AppDatabaseSeeder.insertAllHistory(db);

        // TODO: MEDICINE ARRAY
        //  1) Replace hardcoded array with an API fetch

        //TODO: replace hardcode user with login
        // Gets @string/welcome_text = welcome (var) And adds the User's name at (var).
        String text;
        String firstUserName = db.userDao().getById(0).getName();
        text = getString(R.string.welcome_text, firstUserName);
        nameDisplay.setText(text);

        //A User creates a list with a medicine to take
        MedicinesCard firstCard = new MedicinesCard(firstUserName, db.medicineDao().getAll().get(1));
    }

    @Override
    public void onClick(View v) {

    }
}