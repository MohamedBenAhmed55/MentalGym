package com.example.mentalgym;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MemoryCards extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_cards);

        Button easy = findViewById(R.id.Easy);
        easy.setOnClickListener(this);

        Button mid = findViewById(R.id.Mid);
        mid.setOnClickListener(this);

        Button hard = findViewById(R.id.Hard);
        hard.setOnClickListener(this);

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

        Intent i = new Intent(this, MemoryCardsLevels.class);
        startActivity(i);
    }
}