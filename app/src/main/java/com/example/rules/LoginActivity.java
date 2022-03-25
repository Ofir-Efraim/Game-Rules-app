package com.example.rules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin2;

    EditText usernameInput;
    EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_lay);
        btnLogin2 = findViewById(R.id.btnLogin2);
        btnLogin2.setOnClickListener(this);
        usernameInput = findViewById(R.id.etLogEmail);
        passwordInput = findViewById(R.id.etLogPassword);
    }

    @Override
    public void onClick(View view) {
        if (btnLogin2 == view)

        {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();


            final JSONObject user = new JSONObject();
            try {
                user.put("username", username);
                user.put("password", password);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    ServerHandler serverHandler = new ServerHandler();
                    serverHandler.start();
                    serverHandler.sendMessage("login");
                    serverHandler.sendMessage(user.toString());

                    System.out.println("DEADPOOL");

                    String msg = "";
                    while ((msg = serverHandler.getMessage()).equals("")) {
                    }

                    if (msg.equals("true")) {
                        Intent intent = new Intent(LoginActivity.this, MainScreen.class);
                        startActivity(intent);
                    } else {
                           Toast.makeText(LoginActivity.this, "username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }).run();



        }
    }
}
