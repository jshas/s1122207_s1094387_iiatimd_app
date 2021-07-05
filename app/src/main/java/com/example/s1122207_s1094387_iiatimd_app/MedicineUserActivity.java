package com.example.s1122207_s1094387_iiatimd_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MedicineUserActivity extends Activity implements AdapterView.OnItemSelectedListener{

    private ImageView pills;
    private Spinner spinnerMedicineNames;
    private String input;

    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.medicine_user_activity);
        pills=(ImageView)findViewById(R.id.imagePills);

        spinnerMedicineNames = findViewById(R.id.medicineNames);

        String[] medicineNames = getResources().getStringArray(R.array.medicine_names);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, medicineNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMedicineNames.setAdapter(adapter);


        Button addButton = findViewById(R.id.addMedicineButton);
        addButton.setOnClickListener((View v) -> {
                    Intent toMainActivityIntent = new Intent(this, MainActivity.class);
                    startActivity(toMainActivityIntent);
                }
        );
        Button toMainActivity = findViewById(R.id.toMainActivityButton);
        toMainActivity.setOnClickListener((View v) -> {
                    Intent toMainActivityIntent = new Intent(this, MainActivity.class);
                    startActivity(toMainActivityIntent);
                }
        );
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.medicineNames){
            this.input = parent.getItemAtPosition(position).toString();
            Log.d("test_input", "input is: " + input);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
