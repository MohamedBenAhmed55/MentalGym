package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WSSlvl1 extends AppCompatActivity implements View.OnClickListener {

    TextView textScreen, textQuestion, textTitle, textBtn;
    ImageView bigboss;
    Animation smalltobig;

    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wsslvl1);

        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textScreen = (TextView) findViewById(R.id.textScreen);
        textTitle = findViewById(R.id.textTitle);
        textBtn = (TextView) findViewById(R.id.textBtn);

        bigboss = (ImageView) findViewById(R.id.bigboss);
        bigboss.startAnimation(smalltobig);


        textQuestion.setTypeface(typeface);
        textScreen.setTypeface(typeface);
        textTitle.setTypeface(typeface);
        textBtn.setTypeface(typeface);

        textTitle.setOnClickListener(this);

        // back to home
        Intent i = new Intent(this,MainActivity.class);
        textBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(i);
            }
        });


    }

    //next level
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.textTitle) {
            int n = myPref.getInt("level", 1);
            n++;
            Intent i;
            if (n > 9) {
                i = new Intent(this, WorScrambleLevels.class);
            }
            else {
                myPref.edit().putInt("level", n).commit();

                if (myPref.getString("dif","easy").equals("easy")) {
                     i = new Intent(this, WorldScrambelvl1.class);

                }
                else if (myPref.getString("dif","easy").equals("mid")) {
                     i = new Intent(this,WordScramblelvl2.class);

                } else{
                    i = new Intent(this,WordScramblelvl3.class);
                }

            }

            startActivity(i);

        }
    }


}