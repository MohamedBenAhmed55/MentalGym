package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import java.util.ArrayList;

public class CryptogrammeLevels extends AppCompatActivity implements CryptogrammeLevelsInterface {
    ArrayList<CryptogrammeLevel> levelCards = new ArrayList<>();
    int[] levelImages = {R.drawable.chat2 , R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 ,R.drawable.chat2 };
    int difficulty , winwsilna ;
    int hintNumber;
    public static  final String PREFERENCES_FILENAME= "LevelsSave";
    public  static  final String WINWSOLNA1 = "winwsilna1";
    public  static  final String WINWSOLNA2 = "winwsilna2";
    public  static  final String WINWSOLNA3 = "winwsilna3";
    SharedPreferences sharedPref;
    //    public static final
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptogramme_levels);
        sharedPref = getSharedPreferences(PREFERENCES_FILENAME, MODE_PRIVATE);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                difficulty= 0;
            } else {
                difficulty= extras.getInt("difficulty");
            }
        } else {
            difficulty= 0;
        }

        RecyclerView recyclerView = findViewById(R.id.Levels);
        setUpLevels();
        CryptogrammeLevelsAdapter adapter =new CryptogrammeLevelsAdapter(this, this, levelCards);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpLevels(){
        String[] levelNames;
        String[] levelPhrase;
        switch (difficulty){
            case 1 :
                levelNames = getResources().getStringArray(R.array.mediumlevels);
                levelPhrase =getResources().getStringArray(R.array.phrasesmedium);
                hintNumber= 20;
                winwsilna = sharedPref.getInt(WINWSOLNA2  ,1);
                break;
            case 2:
                levelNames = getResources().getStringArray(R.array.hardlevels);
                levelPhrase =getResources().getStringArray(R.array.phraseshard);
                hintNumber=20;
                winwsilna = sharedPref.getInt(WINWSOLNA3 ,1);
                break;
            default:
                levelNames= getResources().getStringArray(R.array.easylevels);
                levelPhrase =getResources().getStringArray(R.array.phraseseasy);
                hintNumber = 20;
                winwsilna = sharedPref.getInt(WINWSOLNA1  ,1);
        }
        String[] levelAlgorithm =getResources().getStringArray(R.array.algorithms);



        for(int i=0 ; i< levelNames.length; i++){
            levelCards.add(new CryptogrammeLevel(levelNames[i] , levelImages[i] , levelAlgorithm[i] , levelPhrase[i] , i<winwsilna ));
        }

    }

    @Override
    public void onItemClick(int position) {
        if (levelCards.get(position).getCanPlay()) {
            Intent intent = new Intent(CryptogrammeLevels.this, CryptogrammeGame.class);
            intent.putExtra("algorithm", levelCards.get(position).getAlgorithm());
            intent.putExtra("phrase", levelCards.get(position).getPhrase());
            intent.putExtra("hintnumber", hintNumber);
            intent.putExtra("position", position + 1);
            intent.putExtra("difficulty", difficulty);
            startActivity(intent);
        }
    }


    public void reload(View view) {
        switch (difficulty){
            case 1 :
                sharedPref.edit().putInt(CryptogrammeLevels.WINWSOLNA2 , 1).apply();
                break;
            case 2:
                sharedPref.edit().putInt(CryptogrammeLevels.WINWSOLNA3 , 1).apply();
                break;
            default:
                sharedPref.edit().putInt(CryptogrammeLevels.WINWSOLNA1 , 1).apply();

        }
        this.recreate();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.recreate();
    }
}