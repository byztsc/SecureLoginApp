package com.example.secureloginapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView tvWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnLogout;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tvWelcome = findViewById(R.id.tvWelcome);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        String username = getIntent().getStringExtra("USERNAME");
        String pin = getIntent().getStringExtra("PIN");
        String maskedPin = "****";
        tvWelcome.setText(
                "Welcome, " + username +
                        "\nPIN: " + maskedPin +
                        "\nLogin Successful"
        );

    }
}