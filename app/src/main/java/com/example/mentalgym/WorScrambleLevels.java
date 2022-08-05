package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorScrambleLevels extends AppCompatActivity implements View.OnClickListener {

    private Button lvl1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wor_scramble_levels);

        lvl1 = findViewById(R.id.lvl1);
        lvl1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.lvl1){
            Intent i = new Intent(this,WorldScrambelvl1.class);
            startActivity(i);
        }
    }
}