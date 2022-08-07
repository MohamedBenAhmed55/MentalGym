package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorScrambleLevels extends AppCompatActivity implements View.OnClickListener {

    private Button lvl1, lvl2, lvl3, lvl4, lvl5, lvl6, lvl7, lvl8, lvl9;
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wor_scramble_levels);

        lvl1 = findViewById(R.id.lvl1);
        lvl2 = findViewById(R.id.lvl2);
        lvl3 = findViewById(R.id.lvl3);
        lvl4 = findViewById(R.id.lvl4);
        lvl5 = findViewById(R.id.lvl5);
        lvl6 = findViewById(R.id.lvl6);
        lvl7 = findViewById(R.id.lvl7);
        lvl8 = findViewById(R.id.lvl8);
        lvl9 = findViewById(R.id.lvl9);

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
//        if (v.getId() == R.id.lvl1){
//            Intent i = new Intent(this,WorldScrambelvl1.class);
//            startActivity(i);
//        }


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
            i = new Intent(this, WordScramblelvl2.class);
        } else {
            i = new Intent(this, WorldScrambelvl1.class);
        }
        startActivity(i);
    }
}