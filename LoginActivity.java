package com.example.loginsimple;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etLoginUsername, etLoginPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginUsername = etLoginUsername.getText().toString();
                String loginPassword = etLoginPassword.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String registeredUsername = sharedPreferences.getString("username", "");
                String registeredPassword = sharedPreferences.getString("password", "");

                if (loginUsername.equals(registeredUsername) && loginPassword.equals(registeredPassword)) {
                    // Pindah ke Homepage
                    Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
