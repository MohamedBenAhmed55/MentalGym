package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;

public class CryptogrammeLevels extends AppCompatActivity implements CryptogrammeLevelsInterface {
    ArrayList<CryptogrammeLevel> levelCards = new ArrayList<>();
    int[] levelImages = {R.drawable.chat2 , R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 };
    int difficulty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptogramme_levels);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                difficulty= 0;
            } else {
                difficulty= extras.getInt("difficulty");
            }
        } else {
            difficulty= (int) savedInstanceState.getSerializable("difficulty");
        }
        RecyclerView recyclerView = findViewById(R.id.Levels);
        setUpLevels();
        CryptogrammeLevelsAdapter adapter =new CryptogrammeLevelsAdapter(this, this, levelCards);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpLevels(){
        String[] levelNames;
        switch (difficulty){
            case 1 :
                levelNames = getResources().getStringArray(R.array.mediumlevels);
                break;
            case 2:
                levelNames = getResources().getStringArray(R.array.hardlevels);
                break;
            default:
                levelNames= getResources().getStringArray(R.array.easylevels);
        }
        String[] levelAlgorithm =getResources().getStringArray(R.array.algorithms);
        String[] levelPhrase =getResources().getStringArray(R.array.phrases);


        for(int i=0 ; i< levelNames.length; i++){
            levelCards.add(new CryptogrammeLevel(levelNames[i] , levelImages[i] , levelAlgorithm[i] , levelPhrase[i] ));
        }

    }

    @Override
    public void onItemClick(int position) {
        Intent intent =new Intent(CryptogrammeLevels.this , CryptogrammeGame.class);
        intent.putExtra("algorithm" , levelCards.get(position).getAlgorithm() );
        intent.putExtra("phrase" , levelCards.get(position).getPhrase() );
        startActivity(intent);

    }
}