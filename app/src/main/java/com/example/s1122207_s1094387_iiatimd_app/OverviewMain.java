package com.example.s1122207_s1094387_iiatimd_app;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class OverviewMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.overview_main);

        Bundle myBundle = getIntent().getExtras();
        Log.d("bundle test",myBundle.getString("name"));
    }
}
