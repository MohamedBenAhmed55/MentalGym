package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class WordScrambleLevelsRecycler extends AppCompatActivity implements WsrRecyclerInterface {

    ArrayList<WsrModel> WsrModels = new ArrayList<>();
    SharedPreferences myPref;
    private TextView scoretxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_scramble_levels_recycler);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setUpWsrModels();
        WsrRecyclerAdapter adapter = new WsrRecyclerAdapter(this,this,WsrModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        //Score display
        scoretxt = findViewById(R.id.scoretxt);
        int sc = 0;

        if (myPref.getString("dif", "easy").equals("mid")) {
            sc = myPref.getInt("midSc", 0);
        } else if (myPref.getString("dif", "easy").equals("easy")) {
            sc = myPref.getInt("easySc", 0);
        } else {
            sc = myPref.getInt("hardSc", 0);
        }

        scoretxt.setText("Score : " + sc);

    }

    private void setUpWsrModels() {
        String[] Levels = getResources().getStringArray(R.array.Levels);

        for (int i = 0; i < Levels.length; i++) {
            WsrModels.add(new WsrModel(Levels[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        myPref.edit().putInt("level", position + 1).apply();
        Intent i;

        if (myPref.getString("dif", "easy").equals("mid")) {
            i = new Intent(this, WordScramblelvl2.class);
        } else if (myPref.getString("dif", "easy").equals("easy")) {
            i = new Intent(this, WorldScrambelvl1.class);
        } else {
            i = new Intent(this, WordScramblelvl3.class);
        }
        startActivity(i);

    }
}