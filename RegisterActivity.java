package com.example.loginsimple;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsername, etEmail, etPhone, etPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etLoginUsername);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etLoginPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();

                // Simpan data ke SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("username", username);
                editor.putString("email", email);
                editor.putString("phone", phone);
                editor.putString("password", password);
                editor.apply();

                // Pindah ke LoginActivity
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

