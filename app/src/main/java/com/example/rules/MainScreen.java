package com.example.rules;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainScreen extends AppCompatActivity  {
    ArrayList<Gamedes> GameList;

    Gameadapter gameAdapter;

    ListView lv;


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_request) {

            Toast.makeText(this, "You selected Request", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, RequestActivity.class);
            startActivity(intent);

        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_lay);


       GameList = new ArrayList<Gamedes>();
//
      Gamedes t1 = new Gamedes("Name:\ncheckers", "Ages:5-99", (BitmapFactory.decodeResource(getResources(), R.drawable.checkers)), "");
////
////
       Gamedes t2 = new Gamedes("Name:\nchess", "Ages:5-99", BitmapFactory.decodeResource(getResources(), R.drawable.chess), "");
////
////       // t2.setInstruncrions(getStringFromFile(R.raw.chess));
////
       Gamedes t3 = new Gamedes("Name:\nbackgammon", "Ages:5-99", (BitmapFactory.decodeResource(getResources(), R.drawable.backgammon)), "");
////
////       // t3.setInstruncrions(getStringFromFile(R.raw.backgammon));
////
      Gamedes t4 = new Gamedes("Name:\npoker", "Ages:18-99", (BitmapFactory.decodeResource(getResources(), R.drawable.poker)), "");
////
////        // t4.setInstruncrions(getStringFromFile(R.raw.poker));
////
       Gamedes t5 = new Gamedes("Name:\nblackjack", "Ages:18-99", (BitmapFactory.decodeResource(getResources(), R.drawable.blackjack)), "");
////
////       // t5.setInstruncrions(getStringFromFile(R.raw.blackjack));
////
        Gamedes t6 = new Gamedes("Name:\ntaki", "Ages:5-99", (BitmapFactory.decodeResource(getResources(), R.drawable.taki)), "");
////
////       // t6.setInstruncrions(getStringFromFile(R.raw.taki));
////
        Gamedes t7 = new Gamedes("Name:\nmonopoly", "Ages:5-99", (BitmapFactory.decodeResource(getResources(), R.drawable.monopoly)), "");
////
////       // t7.setInstruncrions(getStringFromFile(R.raw.monopoly));
////
       Gamedes t8 = new Gamedes("Name:\nSpider Solitaire", "Ages:5-99", (BitmapFactory.decodeResource(getResources(), R.drawable.spider_solitaire)), "");
////
////       // t8.setInstruncrions(getStringFromFile(R.raw.spider_solitaire));
////
      Gamedes t9 = new Gamedes("Name:\nJungle Speed", "Ages:5-99", (BitmapFactory.decodeResource(getResources(), R.drawable.jungle_speed)), "");
////
////       // t9.setInstruncrions(getStringFromFile(R.raw.jungle_speed));
////
        GameList.add(t1);
        GameList.add(t2);
        GameList.add(t3);

        GameList.add(t4);
        GameList.add(t5);
        GameList.add(t6);

        GameList.add(t7);
        GameList.add(t8);
        GameList.add(t9);

        gameAdapter = new Gameadapter(this, 0, 0, GameList);

        //phase 4 reference to listview

        lv = (ListView) findViewById(R.id.Lv);
        lv.setAdapter(gameAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                    int num = -1 ;
                    if(position == 0)
                    {
                    num = 0;
                    }
                    if(position == 1)
                    {
                        num = 1;
                    }
                    if(position == 2)
                    {
                        num = 2;
                    }
                    if(position == 3)
                    {
                        num = 3;
                    }
                    if(position == 4)
                    {
                        num = 4;
                    }
                    if(position == 5)
                    {
                        num = 5;
                    }
                    if(position == 6)
                    {
                        num = 6;
                    }
                    if(position == 7)
                    {
                        num = 7;
                    }
                    if(position == 8)
                    {
                        num = 8;
                    }

                    Intent intent = new Intent(MainScreen.this, TextActivity.class);

                    intent.putExtra("number",num);


                    startActivity(intent);

            }
        });
    }
}
