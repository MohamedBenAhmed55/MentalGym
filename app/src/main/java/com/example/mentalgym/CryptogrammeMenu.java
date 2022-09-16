package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.logging.Handler;

public class CryptogrammeMenu extends AppCompatActivity {
    int difficultyButtonChecked =R.id.easy;
    int difficulty ;
    SharedPreferences sharedPreferences;
    Toast tst;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptogramme_menu);
        setscore();
        setMusic();
        sharedPreferences= getSharedPreferences(CryptogrammeLevels.PREFERENCES_FILENAME, MODE_PRIVATE);
        difficulty= sharedPreferences.getInt("difficulty" , 0);
        tst = Toast.makeText(this, "str", Toast.LENGTH_SHORT);
        MaterialButtonToggleGroup toggleButtonGroup = findViewById(R.id.toggleButtonGroup);
        if(difficulty ==1)  difficultyButtonChecked = R.id.medium;
        if(difficulty ==2)  difficultyButtonChecked = R.id.hard;
        toggleButtonGroup.check(difficultyButtonChecked);
        toggleButtonGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if(isChecked){
                    switch(checkedId){
                        case R.id.easy:
                            difficulty = 0;
                            showToast("Easy Mode" );
                            break;
                        case R.id.medium:
                            difficulty = 1;
                            showToast("Medium Mode" );
                            break;
                        case R.id.hard:
                            difficulty = 2;
                            showToast("Hard Mode" );
                            break;
                    }
                }
                else {
                    if (group.getCheckedButtonId() == View.NO_ID) {
                        difficulty=-1;
                        showToast("you must select a difficulty" );
                    }
                }
            }
        }
        );
    }

    private void setscore() {
        sharedPreferences= getSharedPreferences(CryptogrammeLevels.PREFERENCES_FILENAME, MODE_PRIVATE);
        int score = sharedPreferences.getInt("score" , 0);
        TextView Score = findViewById(R.id.score);
        Score.setText("Score : "+ score) ;
    }

    private void setMusic() {
        if (player == null)
        {
            player = MediaPlayer.create(this , R.raw.cryptogramme_music);
            player.setLooping(true);
        }
        player.start();
    }

    private  void stopPlayer(){
        if(player != null){
            player.release();
            player=null;
        }
    }

    private void showToast(String str ) {
        tst.setText(str);
        tst.show();
    }

    public void ShowLevels(View view){
//      Button kamal=(Button)findViewById(R.id.kamal);
//      if(kamal.getVisibility() == View.GONE) kamal.setVisibility(View.VISIBLE);
//      else kamal.setVisibility(View.GONE);
        if(difficulty>=0) {
            Intent intent = new Intent(this, CryptogrammeLevels.class);
            startActivity(intent);
            sharedPreferences.edit().putInt("difficulty" , difficulty).apply();
        }
        else{
            showToast("you must select a difficulty");
        }
    }


    public void howToPlay(View view) {
        Intent i = new Intent(CryptogrammeMenu.this,Cryptogramme.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onPause() {
        player.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        player.start();
        setscore();
        super.onResume();
    }
}