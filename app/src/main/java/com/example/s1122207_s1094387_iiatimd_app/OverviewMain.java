package com.example.s1122207_s1094387_iiatimd_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OverviewMain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.overview_main);

        Bundle myBundle = getIntent().getExtras();
        Log.d("bundle test",myBundle.getString("name"));

        recyclerView = findViewById(R.id.HistoryRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize(); //Tenzij de lijst dat niet heeft


        //Hier de array met data
        Medicine[] ritalin = new Medicine[5];

        //Test data, verwijderen
        for(int i = 0; i < 5; i++){
            ritalin[i] = new Medicine(1, "Ritalin", 3.5f, "Pil");
        }

        recyclerViewAdapter = new HistoryAdapter(ritalin);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
