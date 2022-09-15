package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MCWin extends AppCompatActivity implements  View.OnClickListener{
    TextView txtBack, txtWin, btnNext;
    ImageView imageViewTrophy, imageViewClose;
    Animation smalltobig;


    SharedPreferences myPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcwin);

        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        imageViewClose = findViewById(R.id.imageViewClose);
        imageViewTrophy = findViewById(R.id.imageViewTrophy);
        imageViewTrophy.startAnimation(smalltobig);
        txtBack = findViewById(R.id.txtBack);
        txtWin = findViewById(R.id.txtLose);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(this);

        // back to home
        Intent i = new Intent(this, MemoryCardsLevels.class);
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                finish();
            }
        });





    }

    //next level based on difficulty
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnNext) {
            int n = myPref.getInt("level", 1);
            n++;
            if(n<9) {

                myPref.edit().putInt("level", n).commit();
                Intent i;
                if (myPref.getString("dif", "easy").equals("easy")) {
                    i = new Intent(this, MemoryCardsLevelE.class);
                }
                else if (myPref.getString("dif", "easy").equals("mid")) {
                    i = new Intent(this, MemoryCardsLevelM.class);
                }
                else {
                    i = new Intent(this, MemoryCardsLevelH.class);
                }
                startActivity(i);
                this.finish();
            }
            else {
                Intent i = new Intent(this, MemoryCards.class);
            }
        }
    }
}



