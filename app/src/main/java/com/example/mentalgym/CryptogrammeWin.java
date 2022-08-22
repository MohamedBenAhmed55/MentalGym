package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class CryptogrammeWin extends AppCompatActivity {
    public static int result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        result=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptogramme_win);
    }

    public void back(View view) {
        result=0;
        this.finish();
    }

    public void backMenu(View view) {
        result=2;
        this.finish();

    }


}