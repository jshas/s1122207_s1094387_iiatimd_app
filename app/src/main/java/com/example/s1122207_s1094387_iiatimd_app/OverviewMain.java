package com.example.s1122207_s1094387_iiatimd_app;

// FIXME: DEZE CLASS IS NIET MEER NODIG //

import android.os.Bundle;
import android.util.Log;

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


        //recyclerViewAdapter = new HistoryAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}

