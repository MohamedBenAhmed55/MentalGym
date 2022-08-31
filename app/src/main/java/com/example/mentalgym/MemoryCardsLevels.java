package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MemoryCardsLevels extends AppCompatActivity implements View.OnClickListener {
    ImageView lvl1,lvl2,lvl3,lvl4,lvl5,lvl6,lvl7,lvl8,lvl9;
    TextView txtView1,txtView2,txtView3,txtView4,txtView5,txtView6,txtView7,txtView8,txtView9;
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_cards_levels);

        lvl1 = findViewById(R.id.lvl1);
        lvl2 = findViewById(R.id.lvl2);
        lvl3 = findViewById(R.id.lvl3);
        lvl4 = findViewById(R.id.lvl4);
        lvl5 = findViewById(R.id.lvl5);
        lvl6 = findViewById(R.id.lvl6);
        lvl7 = findViewById(R.id.lvl7);
        lvl8 = findViewById(R.id.lvl8);
        lvl9 = findViewById(R.id.lvl9);

        txtView1 = findViewById(R.id.txtView1);
        txtView2 = findViewById(R.id.txtView2);
        txtView3 = findViewById(R.id.txtView3);
        txtView4 = findViewById(R.id.txtView4);
        txtView5 = findViewById(R.id.txtView5);
        txtView6 = findViewById(R.id.txtView6);
        txtView7 = findViewById(R.id.txtView7);
        txtView8= findViewById(R.id.txtView8);
        txtView9 = findViewById(R.id.txtView9);


        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
    }
    @Override
    public void onClick(View v) {



        switch (v.getId()) {
            case (R.id.lvl1):
                myPref.edit().putInt("level", 1).apply();
                break;
            case (R.id.lvl2):
                myPref.edit().putInt("level", 2).apply();
                break;
            case (R.id.lvl3):
                myPref.edit().putInt("level", 3).apply();
                break;
            case (R.id.lvl4):
                myPref.edit().putInt("level", 4).apply();
                break;
            case (R.id.lvl5):
                myPref.edit().putInt("level", 5).apply();
                break;
            case (R.id.lvl6):
                myPref.edit().putInt("level", 6).apply();
                break;
            case (R.id.lvl7):
                myPref.edit().putInt("level", 7).apply();
                break;
            case (R.id.lvl8):
                myPref.edit().putInt("level", 8).apply();
                break;
            case (R.id.lvl9):
                myPref.edit().putInt("level", 9).apply();
                break;
            default:
                break;
        }

        Intent i;

        if (myPref.getString("dif", "easy").equals("mid")) {
            i = new Intent(this,MemoryCardsLevelM.class);
        } else if(myPref.getString("dif","easy").equals("easy")) {
            i = new Intent(this, MemoryCardsLevelE.class);
        } else {
            i = new Intent(this,MemoryCardsLevelH.class);
        }
        startActivity(i);
    }

}


