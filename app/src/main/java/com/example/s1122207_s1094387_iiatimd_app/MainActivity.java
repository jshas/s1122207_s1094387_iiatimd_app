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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toMedicineUserButton = findViewById(R.id.toMedicineUserScreen);
        toMedicineUserButton.setOnClickListener(this);

        // nameDisplay
        TextView nameDisplay = findViewById(R.id.textView);
        //Recyclerview setup
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();



        //FIXME:
        // Replace .allowMainThreadQueries() with seperate Task Classes in project
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());

        //TODO:
        // MEDICINE ARRAY
        // 1) Replace database seeding with an API FETCH
//        AppDatabaseSeeder.insertAllUsersTask(db);
//        AppDatabaseSeeder.insertAllMedicinesTask(db);
//        AppDatabaseSeeder.insertAllPrescriptions(db);
//        AppDatabaseSeeder.insertAllHistory(db);




        // Gets @string/welcome_text = welcome (var) And adds the User's name at (var).
        String text;
        text = getString(R.string.welcome_text, db.userDao().getUserNameById(1));
        nameDisplay.setText(text);

//        mAdapter = new MedicineAdapter(db.medicineDao().getAll());
        mAdapter = new MedicineAndPrescriptionAdapter(db.prescriptionDao().getMedicinesWithPrescription());

        /* MedicineAdapter
         * Used to feed the recyclerView with data from the Medicine table.
         * Useful for displaying available medicines to be added to the AmountAndInterval.
         * TODO: CARDVIEW
         *  1) Add/Remove button
         *  2) Add 'Total Amount' selector. (How much is taken daily? e.g. 30mg)
         *  3) Add interval
         *  4) Optionally: Dose is calculated by: (total amount / interval) (e.g. dose = 30mg/4 = 7.5mg)
         * */
        recyclerView.setAdapter(mAdapter);

    }

    public void onClick(View v){
        Log.d("Scherm2", "Test scherm2");
        Intent toMedicineUserIntent = new Intent(this, MedicineUserActivity.class);
        startActivity(toMedicineUserIntent);
    }
}