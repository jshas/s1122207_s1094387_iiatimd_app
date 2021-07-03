package com.example.s1122207_s1094387_iiatimd_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // nameDisplay
        TextView nameDisplay = findViewById(R.id.textView);
        //Recyclerview setup
        recyclerView = findViewById(R.id.historyRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();


        // TODO: MEDICINE ARRAY
        //  1) Replace hardcoded array with an API fetch
        //Medicine with info are created
        Medicine[] medicines = new Medicine[5];
        medicines[0] = new Medicine(1, "Ibuprofen", 200d, "mg", 1);
        medicines[1] = new Medicine(2, "Ritalin", 5d, "mg", 4);
        medicines[2] = new Medicine(3, "Dexamfetamine", 2.5d, "mg", 4);
        medicines[3] = new Medicine(4, "Advil", 1000d, "mg", 4);
        medicines[4] = new Medicine(5, "Cough Syrup", 200d, "ml", 4);

        //TODO: replace hardcode user with login
        //A User is created
        User person = new User(1, "Sjon Haan", "sjonnie@testkip.nl");

        //TODO: replace hardcore history with data from API
        //A User creates a list with a medicine to take
        MedicinesCard firstCard = new MedicinesCard("Sjon Haan", medicines[0]);
        //More medicines are added
        firstCard.addMedicine(medicines[1]);
        firstCard.addMedicine(medicines[4]);



        //FIXME: Replace .allowMainThreadQueries() with seperate Task Classes in project
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        db.medicineDao().insertAllMedicines(medicines);
        db.userDao().insertUser(person);

        // Gets welcome_text = Hello, (var)! And adds the User's name at (var).
        String text = getString(R.string.welcome_text, person.getName().split(" ")[0]);
        nameDisplay.setText(text);

        //Makes a recyclerview "timeline" with al the timelineItems
        mAdapter = new HistoryAdapter(timeline);
        mAdapter = new MedicineAdapter(medicines);
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
}