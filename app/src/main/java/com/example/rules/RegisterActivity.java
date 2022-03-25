package com.example.rules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRegister2;
    EditText usernameInput;
    EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_lay);
        btnRegister2 = findViewById(R.id.btnRegister2);
        btnRegister2.setOnClickListener(this);
        usernameInput = findViewById(R.id.etRegUsername);
        passwordInput = findViewById(R.id.etRegPassword);
    }

    @Override
    public void onClick(View view) {
        if (btnRegister2 == view) {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            ServerHandler serverHandler = new ServerHandler();
            serverHandler.start();
            serverHandler.sendMessage("register");
            serverHandler.sendMessage(username);
            serverHandler.sendMessage(password);
            Intent intent = new Intent(this, MainScreen.class);
            startActivity(intent);

        }
    }
}
