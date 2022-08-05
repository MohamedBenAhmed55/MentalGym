package com.example.mentalgym;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MemoryCards extends AppCompatActivity implements View.OnClickListener{
    private Button Easy1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_cards);

        Easy1 = findViewById(R.id.Easy1);
        Easy1.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Easy1) {
            Intent i = new Intent(this, MemoryCardsLevelE1.class);
            startActivity(i);
        }
    }
}