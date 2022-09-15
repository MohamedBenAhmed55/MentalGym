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

public class MCLose extends AppCompatActivity implements  View.OnClickListener {
    TextView txtBack, txtLose, btnReplay;
    ImageView imageViewLose;
    Animation smalltobig;

    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mclose);

        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        imageViewLose = findViewById(R.id.imageViewLose);
        imageViewLose.startAnimation(smalltobig);
        txtBack = findViewById(R.id.txtBack);
        txtLose = findViewById(R.id.txtLose);
        btnReplay = findViewById(R.id.btnReplay);

        btnReplay.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnReplay){
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
            finish();
        }

    }
}