package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WordScramble extends AppCompatActivity implements View.OnClickListener {

    private Button Easy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_scramble);

        Easy = findViewById(R.id.Easy);
        Easy.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Easy) {
            Intent i = new Intent(this, WorScrambleLevels.class);
            startActivity(i);
        }
    }
}