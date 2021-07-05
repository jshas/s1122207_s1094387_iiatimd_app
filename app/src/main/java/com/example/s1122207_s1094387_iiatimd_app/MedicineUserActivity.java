package com.example.s1122207_s1094387_iiatimd_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MedicineUserActivity extends Activity implements AdapterView.OnItemSelectedListener{

    private Spinner spinnerMedicineNames;

    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.medicine_user_activity);

        spinnerMedicineNames = findViewById(R.id.medicineNames);

        String[] medicineNames = getResources().getStringArray(R.array.medicine_names);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, medicineNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMedicineNames.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.medicineNames){
            String valueFromSpinner = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
