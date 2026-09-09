package com.example.secureloginapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPin;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etUsername);
        etPin = findViewById(R.id.etPin);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String pin = etPin.getText().toString().trim();
            if (username.isEmpty() || pin.length() != 4) {
                Toast.makeText(this,
                        "Enter a username and a 4-digit PIN",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(MainActivity.this,
                    DashboardActivity.class);
            intent.putExtra("USERNAME", username);
            intent.putExtra("PIN", pin);
            startActivity(intent);
        });
    }
}