package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Button Play;
    ImageButton play2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Play = findViewById(R.id.button);
       /* Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });*/
        play2 = findViewById(R.id.playimg);
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

    }
    public void openMenu(){
        Intent intent = new Intent(this, GameSelect.class);
        startActivity(intent);
    }



}
