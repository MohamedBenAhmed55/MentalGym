package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameSelect extends AppCompatActivity implements View.OnClickListener {

    private Button MemoryCards;
    private Button WordScramble;
    private Button Cryptogramme;
    private Button Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select);

        MemoryCards = findViewById(R.id.btn1);
        WordScramble = findViewById(R.id.btn2);
        Cryptogramme = findViewById(R.id.btn3);
        Menu = findViewById(R.id.Menu);

        MemoryCards.setOnClickListener(this);
        WordScramble.setOnClickListener(this);
        Cryptogramme.setOnClickListener(this);
        Menu.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1:
                Intent i1 = new Intent(this,MemoryCards.class);
                startActivity(i1);
                break;
            case R.id.btn2:
                Intent i2 = new Intent(this,WordScramble.class);
                i2.putExtra("scoreinit",0);
                startActivity(i2);
                break;
            case R.id.btn3:
                Intent i3 = new Intent(this,Cryptogramme.class);
                startActivity(i3);
                break;
            case R.id.Menu:
                Intent i4 = new Intent(this,MainActivity.class);
                startActivity(i4);
                break;
            default:
                break;
        }
    }
}