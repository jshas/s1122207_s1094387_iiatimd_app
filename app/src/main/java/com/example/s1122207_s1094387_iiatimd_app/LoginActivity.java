package com.example.s1122207_s1094387_iiatimd_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener((View v) -> {
                    Intent loginIntent = new Intent(this, MainActivity.class);
                    startActivity(loginIntent);
                }
        );
    }
}
