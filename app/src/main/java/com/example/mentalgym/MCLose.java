package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MCLose extends AppCompatActivity implements  View.OnClickListener {
    TextView txtBack, txtLose, btnReplay;
    ImageView imageViewLose, imageViewClose;
    Animation smalltobig;

    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mclose);

        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        imageViewClose = findViewById(R.id.imageViewClose);
        imageViewLose = findViewById(R.id.imageViewLose);
        imageViewLose.startAnimation(smalltobig);
        txtBack = findViewById(R.id.txtBack);
        txtLose = findViewById(R.id.txtLose);
        btnReplay = findViewById(R.id.btnReplay);

        btnReplay.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}