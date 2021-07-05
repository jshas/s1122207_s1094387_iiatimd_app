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
    RecyclerView.Adapter mAdapter;
    // SINGLETONS // //FIXME: Replace .allowMainThreadQueries() with seperate Task Classes in project



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String MEDICINE_URL = "http://10.0.2.2:8000/api/medicine";
        setContentView(R.layout.activity_main);
        VolleySingleton vs = VolleySingleton.getInstance(getApplicationContext());
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());

        // Main buttons with single onClickListener
       Button toMedicineUserButton = findViewById(R.id.toMedicineScreen);
        toMedicineUserButton.setOnClickListener(this);
       Button buttonMedicineAdd = findViewById(R.id.addMedicine);
        buttonMedicineAdd.setOnClickListener(this);
       Button buttonMedicineTimeline = findViewById(R.id.medicineTimeline);
        buttonMedicineTimeline.setOnClickListener(this);

        // FETCH NEW MEDICINES FROM THE BACKEND
       Button buttonAPIFetch = findViewById(R.id.fetchMedicine);
        buttonAPIFetch.setOnClickListener((View v) -> {
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                    (Request.Method.GET, MEDICINE_URL, null,
                            Medicine::fromJson,
                            error    -> Log.e("API Fetch error", "Foute boel in de API.")
//                    error.getMessage(
                    );
            vs.addToRequestQueue(jsonArrayRequest);
        });

        // nameDisplay
        TextView nameDisplay = findViewById(R.id.textView);
        //Recyclerview setup
        recyclerView = findViewById(R.id.navigationRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();




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
        String firstUserName = db.userDao().getById(2).getName().split(" ")[0];
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
        VolleySingleton vs = VolleySingleton.getInstance(getApplicationContext());
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
        }

    }
}