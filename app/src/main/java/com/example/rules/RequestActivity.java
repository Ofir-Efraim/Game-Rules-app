package com.example.rules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RequestActivity extends AppCompatActivity implements View.OnClickListener  {
    EditText name ;
    EditText ages ;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_lay);
        submit = findViewById(R.id.btnsubmit);
        submit.setOnClickListener(this);
        name = findViewById(R.id.etGameName);
        ages = findViewById(R.id.etAges);
    }

    @Override
    public void onClick(View v) {

        if(submit == v)
        {
            String GameName = name.getText().toString();
            String GameAges = ages.getText().toString();
            ServerHandler serverHandler = new ServerHandler();
            serverHandler.start();
            serverHandler.sendMessage("request");
            serverHandler.sendMessage(GameName);
            serverHandler.sendMessage(GameAges);
            Toast.makeText(this, "Request sent", Toast.LENGTH_SHORT).show();
        }

    }
}
