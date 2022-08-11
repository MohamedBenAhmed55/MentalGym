package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WordScramble extends AppCompatActivity implements View.OnClickListener {

    private Button Easy, Mid, Hard;

    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_scramble);

        Easy = findViewById(R.id.Easy);
        Easy.setOnClickListener(this);

        Mid = findViewById(R.id.Mid);
        Mid.setOnClickListener(this);

        Hard = findViewById(R.id.Hard);
        Hard.setOnClickListener(this);

        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.Easy):
                myPref.edit().putString("dif", "easy").apply();
                break;
            case (R.id.Mid):
                myPref.edit().putString("dif", "mid").apply();
                break;
            case (R.id.Hard):
                myPref.edit().putString("dif", "hard").apply();
                break;
            default:
                break;

        }

        Intent i = new Intent(this, WorScrambleLevels.class);
        startActivity(i);
    }
}