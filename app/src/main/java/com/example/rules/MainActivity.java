package com.example.rules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin,btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin1);
        btnRegister = findViewById(R.id.btnRegister1);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        Intent intent = new Intent(MainActivity.this , MusicService.class);
        startService(intent);

    }

    @Override
    public void onClick(View view) {
        if (btnRegister == view)
        {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);

        }

        if (btnLogin == view)

        {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        }
    }
}
