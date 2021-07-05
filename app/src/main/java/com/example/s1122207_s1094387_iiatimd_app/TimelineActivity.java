package com.example.s1122207_s1094387_iiatimd_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TimelineActivity extends Activity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.timeline_activity);


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
