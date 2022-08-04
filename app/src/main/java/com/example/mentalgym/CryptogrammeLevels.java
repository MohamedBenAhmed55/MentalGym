package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CryptogrammeLevels extends AppCompatActivity {
    ArrayList<CryptogrammeLevel> levelCards = new ArrayList<>();
    int[] levelImages = {R.drawable.chat2 , R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptogramme_levels);
        RecyclerView recyclerView = findViewById(R.id.Levels);
        setUpLevels();
        CryptogrammeLevelsAdapter adapter =new CryptogrammeLevelsAdapter(this, levelCards);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpLevels(){
        String[] levelNames = getResources().getStringArray(R.array.easylevels);
        for(int i=0 ; i< levelNames.length; i++){
            levelCards.add(new CryptogrammeLevel(levelNames[i] , levelImages[i]));

        }

    }
}