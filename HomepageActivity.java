package com.example.loginsimple;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomepageActivity extends AppCompatActivity {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        tvWelcome = findViewById(R.id.tvWelcome);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        tvWelcome.setText("Welcome " + username);
    }
}
