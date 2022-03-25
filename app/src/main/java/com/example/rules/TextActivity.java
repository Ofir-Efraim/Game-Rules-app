package com.example.rules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TextActivity extends AppCompatActivity {

    private String readTxt(InputStream is) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = is.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = is.read();
            }
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_lay);

        TextView helloTxt = (TextView) findViewById(R.id.hellotxt);

        Intent intent = getIntent();

        int num = intent.getExtras().getInt("number");
        if (num == 0)
        {
            InputStream inputStream = getResources().openRawResource(R.raw.checkers);
            helloTxt.setText(readTxt(inputStream));
        }
        if (num == 1)
        {
            InputStream inputStream = getResources().openRawResource(R.raw.chess);
            helloTxt.setText(readTxt(inputStream));
        }
        if (num == 2)
        {
            InputStream inputStream = getResources().openRawResource(R.raw.backgammon);
            helloTxt.setText(readTxt(inputStream));
        }
        if (num == 3)
        {
            InputStream inputStream = getResources().openRawResource(R.raw.poker);
            helloTxt.setText(readTxt(inputStream));
        }
        if (num == 4)
        {
            InputStream inputStream = getResources().openRawResource(R.raw.blackjack);
            helloTxt.setText(readTxt(inputStream));
        }
        if (num == 5)
        {
            InputStream inputStream = getResources().openRawResource(R.raw.taki);
            helloTxt.setText(readTxt(inputStream));
        }
        if (num == 6)
        {
            InputStream inputStream = getResources().openRawResource(R.raw.monopoly);
            helloTxt.setText(readTxt(inputStream));
        }
        if (num == 7)
        {
            InputStream inputStream = getResources().openRawResource(R.raw.spider_solitaire);
            helloTxt.setText(readTxt(inputStream));
        }
        if (num == 8)
        {
            InputStream inputStream = getResources().openRawResource(R.raw.jungle_speed);
            helloTxt.setText(readTxt(inputStream));
        }
    }
}

