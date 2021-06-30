package com.example.s1122207_s1094387_iiatimd_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Maak button aan die naar en link eigenschappen
        Button toHistoryOverviewButton = findViewById(R.id.toHistoryOverview);
        toHistoryOverviewButton.setOnClickListener(this);
    }

    public void onClick(View v){
        //Geef een bundle mee naar volgende scherm
        Bundle bundleForHistoryOverview = new Bundle();
        String name = "Username";
        bundleForHistoryOverview.putString("name",name);

        //Maak intent om Class te openen en open hem daarna
        Intent toHistoryOverviewIntent = new Intent(this, OverviewMain.class);
        toHistoryOverviewIntent.putExtras(bundleForHistoryOverview);
        startActivity(toHistoryOverviewIntent);
    }
}