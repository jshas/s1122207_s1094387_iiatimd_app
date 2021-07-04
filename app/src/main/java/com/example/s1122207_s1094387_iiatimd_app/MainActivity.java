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


        // TODO: MEDICINE ARRAY
        //  1) Replace hardcoded array with an API fetch
        Medicine[] medicines = new Medicine[5];
        medicines[0] = new Medicine(1, "Ibuprofen", 200d, "mg", 1);
        medicines[1] = new Medicine(2, "Ritalin", 5d, "mg", 4);
        medicines[2] = new Medicine(3, "Dexamfetamine", 2.5d, "mg", 4);
        medicines[3] = new Medicine(4, "Advil", 1000d, "mg", 4);
        medicines[4] = new Medicine(5, "Cough Syrup", 200d, "ml", 4);


        User person = new User(1, "Sjon Haan", "sjonnie@testkip.nl");

        //FIXME: Replace .allowMainThreadQueries() with seperate Task Classes in project
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        db.medicineDao().insertAllMedicines(medicines);
        db.userDao().insertUser(person);

        // Gets welcome_text = Hello, (var)! And adds the User's name at (var).
        String text = getString(R.string.welcome_text, person.getName().split(" ")[0]);
        nameDisplay.setText(text);

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

    public void onClick(View v){
        Log.d("Scherm2", "Test scherm2");
        Intent toMedicineUserIntent = new Intent(this, MedicineUserActivity.class);
        startActivity(toMedicineUserIntent);
    }
}