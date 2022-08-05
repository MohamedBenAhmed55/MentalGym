package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.lang.reflect.InvocationTargetException;


public class CryptogrammeGame extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptogramme_game);
        String algo = getIntent().getStringExtra("algorithm");
        TextView textView = findViewById(R.id.textcrypt);
        java.lang.reflect.Method method = null;
        CryptogrammeAlgorithms cryptogrammeAlgorithms = new CryptogrammeAlgorithms();
        try {
            method = cryptogrammeAlgorithms.getClass().getMethod(algo );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(cryptogrammeAlgorithms);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        textView.setText(cryptogrammeAlgorithms.phrasecrypt);

    }



}