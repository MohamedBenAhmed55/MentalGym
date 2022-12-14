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

    //Sounds
    private MediaPlayer mediaPlayer;

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
        mediaPlayer = MediaPlayer.create(this,R.raw.click);

    }


    //Saves the chosen difficulty and redirects you to the corresponding levels
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

        mediaPlayer.start();
        Intent i = new Intent(this, WordScrambleLevelsRecycler.class);
        startActivity(i);
        finish();
    }
}