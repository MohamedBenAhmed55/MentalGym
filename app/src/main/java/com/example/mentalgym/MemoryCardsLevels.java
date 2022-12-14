package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemoryCardsLevels extends AppCompatActivity implements View.OnClickListener {


    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_cards_levels);
        Button lvl1 = findViewById(R.id.lvl1);
        Button lvl2 = findViewById(R.id.lvl2);
        Button lvl3 = findViewById(R.id.lvl3);
        Button lvl4 = findViewById(R.id.lvl4);
        Button lvl5 = findViewById(R.id.lvl5);
        Button lvl6 = findViewById(R.id.lvl6);
        Button lvl7 = findViewById(R.id.lvl7);
        Button lvl8 = findViewById(R.id.lvl8);
        Button lvl9 = findViewById(R.id.lvl9);

        lvl1.setOnClickListener(this);
        lvl2.setOnClickListener(this);
        lvl3.setOnClickListener(this);
        lvl4.setOnClickListener(this);
        lvl5.setOnClickListener(this);
        lvl6.setOnClickListener(this);
        lvl7.setOnClickListener(this);
        lvl8.setOnClickListener(this);
        lvl9.setOnClickListener(this);


        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
    }
    @Override
    public void onClick(View v) {



        switch (v.getId()) {
            case (R.id.lvl1):
                myPref.edit().putInt("level", 1).apply();
                break;
            case (R.id.lvl2):
                myPref.edit().putInt("level", 2).apply();
                break;
            case (R.id.lvl3):
                myPref.edit().putInt("level", 3).apply();
                break;
            case (R.id.lvl4):
                myPref.edit().putInt("level", 4).apply();
                break;
            case (R.id.lvl5):
                myPref.edit().putInt("level", 5).apply();
                break;
            case (R.id.lvl6):
                myPref.edit().putInt("level", 6).apply();
                break;
            case (R.id.lvl7):
                myPref.edit().putInt("level", 7).apply();
                break;
            case (R.id.lvl8):
                myPref.edit().putInt("level", 8).apply();
                break;
            case (R.id.lvl9):
                myPref.edit().putInt("level", 9).apply();
                break;
            default:
                break;
        }

        Intent i;

        if (myPref.getString("dif", "easy").equals("mid")) {
            i = new Intent(this,MemoryCardsLevelM.class);
        } else if(myPref.getString("dif","easy").equals("easy")) {
            i = new Intent(this, MemoryCardsLevelE.class);
        } else {
            i = new Intent(this,MemoryCardsLevelH.class);
        }
        startActivity(i);
    }

}


