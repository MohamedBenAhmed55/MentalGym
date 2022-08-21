package com.example.mentalgym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class MemoryCardsLevelM extends AppCompatActivity {
    TextView textView;

    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34;
    //array for the images
    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};
    // actual images
    int image101, image102, image103, image104, image105 , image106 ,
            image201, image202, image203, image204, image205 , image206;
    int firstCard, secondCard;
    int clickedFirst , clickedSecond;
    int cardNumber = 1 ;
    //    Shared preference
    SharedPreferences myPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_cards_level_m);

        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        myPref.edit().putString("diff", "mid");

        textView = findViewById(R.id.textView4);
        // intialize timer duration
        long duration = TimeUnit.MINUTES.toMillis(1);
        // intialize countdown timer
        new CountDownTimer(duration,1000){

            @Override
            public void onTick(long l) {
                //when tick convert millisecond to minut and second
                String sDuration = String.format(Locale.ENGLISH,"%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                // set converted string on text view
                textView.setText(sDuration);
            }

            @Override
            public void onFinish() {
              /*  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MemoryCardsLevelM.this);
                alertDialogBuilder
                        .setMessage("TIME IS OVER")
                        .setCancelable(false)
                        .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show(); */
            }
        }.start();

        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);
        iv_13 = findViewById(R.id.iv_13);
        iv_14 = findViewById(R.id.iv_14);
        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);
        iv_23 = findViewById(R.id.iv_23);
        iv_24 = findViewById(R.id.iv_24);
        iv_31 = findViewById(R.id.iv_31);
        iv_32 = findViewById(R.id.iv_32);
        iv_33 = findViewById(R.id.iv_33);
        iv_34 = findViewById(R.id.iv_34);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");

        //load the card images
        switch(myPref.getInt("level",1)){
            case 1:
                image101 =R.drawable.animal10;
                image102 =R.drawable.animal3;
                image103 =R.drawable.animal20;
                image104 =R.drawable.animal16;
                image105 =R.drawable.animal5;
                image106 =R.drawable.animal13;
                image201 =R.drawable.animal10;
                image202 =R.drawable.animal3;
                image203 =R.drawable.animal20;
                image204 =R.drawable.animal16;
                image205 =R.drawable.animal5;
                image206 =R.drawable.animal13;
                break;
            case 2:
                image101 =R.drawable.animal10;
                image102 =R.drawable.animal9;
                image103 =R.drawable.animal8;
                image104 =R.drawable.animal7;
                image105 =R.drawable.animal5;
                image106 =R.drawable.animal6;
                image201 =R.drawable.animal10;
                image202 =R.drawable.animal9;
                image203 =R.drawable.animal8;
                image204 =R.drawable.animal7;
                image205 =R.drawable.animal5;
                image206 =R.drawable.animal6;
                break;
            case 3:
                image101 =R.drawable.animal1;
                image102 =R.drawable.animal2;
                image103 =R.drawable.animal3;
                image104 =R.drawable.animal4;
                image105 =R.drawable.animal5;
                image106 =R.drawable.animal6;
                image201 =R.drawable.animal1;
                image202 =R.drawable.animal2;
                image203 =R.drawable.animal3;
                image204 =R.drawable.animal4;
                image205 =R.drawable.animal5;
                image206 =R.drawable.animal6;
                break;
            case 4:
                image101 =R.drawable.moster1;
                image102 =R.drawable.moster2;
                image103 =R.drawable.moster3;
                image104 =R.drawable.moster4;
                image105 =R.drawable.moster5;
                image106 =R.drawable.moster6;
                image201 =R.drawable.moster1;
                image202 =R.drawable.moster2;
                image203 =R.drawable.moster3;
                image204 =R.drawable.moster4;
                image205 =R.drawable.moster5;
                image206 =R.drawable.moster6;
                break;
            case 5:
                image101 =R.drawable.moster11;
                image102 =R.drawable.moster10;
                image103 =R.drawable.moster9;
                image104 =R.drawable.moster8;
                image105 =R.drawable.moster7;
                image106 =R.drawable.moster4;
                image201 =R.drawable.moster11;
                image202 =R.drawable.moster10;
                image203 =R.drawable.moster9;
                image204 =R.drawable.moster8;
                image205 =R.drawable.moster7;
                image206 =R.drawable.moster4;
                break;
            case 6:
                image101 =R.drawable.emoji3;
                image102 =R.drawable.emoji4;
                image103 =R.drawable.emoji7;
                image104 =R.drawable.emoji8;
                image105 =R.drawable.emoji10;
                image106 =R.drawable.emoji11;
                image201 =R.drawable.emoji3;
                image202 =R.drawable.emoji4;
                image203 =R.drawable.emoji7;
                image204 =R.drawable.emoji8;
                image205 =R.drawable.emoji10;
                image206 =R.drawable.emoji11;
                break;
            case 7:
                image101 =R.drawable.emoji3;
                image102 =R.drawable.emoji4;
                image103 =R.drawable.emoji7;
                image104 =R.drawable.emoji12;
                image105 =R.drawable.emoji9;
                image106 =R.drawable.emoji2;
                image201 =R.drawable.emoji3;
                image202 =R.drawable.emoji4;
                image203 =R.drawable.emoji7;
                image204 =R.drawable.emoji12;
                image205 =R.drawable.emoji9;
                image206 =R.drawable.emoji2;
                break;
            case 8:
                image101 =R.drawable.chat;
                image102 =R.drawable.chat2;
                image103 =R.drawable.chat3;
                image104 =R.drawable.chat4;
                image105 =R.drawable.chat5;
                image106 =R.drawable.chat6;
                image201 =R.drawable.chat;
                image202 =R.drawable.chat2;
                image203 =R.drawable.chat3;
                image204 =R.drawable.chat4;
                image205 =R.drawable.chat5;
                image206 =R.drawable.chat6;
                break;
            case 9:
                image101 =R.drawable.chat;
                image102 =R.drawable.chat2;
                image103 =R.drawable.chat3;
                image104 =R.drawable.chat4;
                image105 =R.drawable.chat5;
                image106 =R.drawable.chat6;
                image201 =R.drawable.chat;
                image202 =R.drawable.chat2;
                image203 =R.drawable.chat3;
                image204 =R.drawable.chat4;
                image205 =R.drawable.chat5;
                image206 =R.drawable.chat6;
            default:
                break;
        }



        //shuffle les images
        Collections.shuffle(Arrays.asList(cardsArray));


        iv_11.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_11,theCard);
        });
        iv_12.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_12,theCard);
        });
        iv_13.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_13,theCard);
        });
        iv_14.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_14,theCard);
        });
        iv_21.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_21,theCard);
        });
        iv_22.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_22,theCard);
        });
        iv_23.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_23,theCard);
        });
        iv_24.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_24,theCard);
        });
        iv_31.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_31,theCard);
        });
        iv_32.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_32,theCard);
        });
        iv_33.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_33,theCard);
        });
        iv_34.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_34,theCard);
        });


    }

    public void doStuff(ImageView iv, int card){
        //set the correct image on the imageview
        if (cardsArray[card] == 101){
            iv.setImageResource(image101);
        }
        else if (cardsArray[card]==102){
            iv.setImageResource(image102);
        }
        else if (cardsArray[card]==103){
            iv.setImageResource(image103);
        }
        else if (cardsArray[card]==104){
            iv.setImageResource(image104);
        }
        else if (cardsArray[card]==105) {
            iv.setImageResource(image105);
        }
        else if (cardsArray[card]==106) {
            iv.setImageResource(image106);
        }
        else if (cardsArray[card]==201){
            iv.setImageResource(image201);
        }
        else if (cardsArray[card]==202){
            iv.setImageResource(image202);
        }
        else if (cardsArray[card]==203){
            iv.setImageResource(image203);
        }
        else if (cardsArray[card]==204){
            iv.setImageResource(image204);
        }
        else if (cardsArray[card]==205){
            iv.setImageResource(image205);
        }
        else if (cardsArray[card]==206){
            iv.setImageResource(image206);
        }
        //check which image is selected and save it to temporary variable
        if (cardNumber == 1){
            firstCard = cardsArray[card];
            if (firstCard > 200){
                firstCard = firstCard -100 ;
            }
            cardNumber = 2 ;
            clickedFirst = card;
            iv.setEnabled(false);
        }

        else if (cardNumber == 2){
            secondCard = cardsArray[card];
            if (secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;
            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);
            Handler handler = new Handler();
            //check if the selected images are equal
            handler.postDelayed(this::calculate, 1000);
        }

    }

    public void calculate(){
        //if images are equal remove
        if (firstCard == secondCard){
            if (clickedFirst == 0){
                iv_11.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 1){
                iv_12.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 2){
                iv_13.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 3){
                iv_14.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 4){
                iv_21.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 5){
                iv_22.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 6){
                iv_23.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 7){
                iv_24.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 8){
                iv_31.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 9){
                iv_32.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 10){
                iv_33.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 11){
                iv_34.setVisibility(View.INVISIBLE);
            }
            if (clickedSecond == 0){
                iv_11.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 1){
                iv_12.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 2){
                iv_13.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 3){
                iv_14.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 4){
                iv_21.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 5){
                iv_22.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 6){
                iv_23.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 7){
                iv_24.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 8){
                iv_31.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 9){
                iv_32.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 10){
                iv_33.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 11){
                iv_34.setVisibility(View.INVISIBLE);
            }

        }
        else{
            iv_11.setImageResource(R.drawable.questions);
            iv_12.setImageResource(R.drawable.questions);
            iv_13.setImageResource(R.drawable.questions);
            iv_14.setImageResource(R.drawable.questions);
            iv_21.setImageResource(R.drawable.questions);
            iv_22.setImageResource(R.drawable.questions);
            iv_23.setImageResource(R.drawable.questions);
            iv_24.setImageResource(R.drawable.questions);
            iv_31.setImageResource(R.drawable.questions);
            iv_32.setImageResource(R.drawable.questions);
            iv_33.setImageResource(R.drawable.questions);
            iv_34.setImageResource(R.drawable.questions);

        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);

        //check if the game is over
        checkEnd();

    }

    public void checkEnd(){
        if(iv_11.getVisibility() ==View.INVISIBLE &&
                iv_12.getVisibility() ==View.INVISIBLE &&
                iv_13.getVisibility() ==View.INVISIBLE &&
                iv_14.getVisibility() ==View.INVISIBLE &&
                iv_21.getVisibility() ==View.INVISIBLE &&
                iv_22.getVisibility() ==View.INVISIBLE &&
                iv_23.getVisibility() ==View.INVISIBLE &&
                iv_24.getVisibility() ==View.INVISIBLE &&
                iv_31.getVisibility() ==View.INVISIBLE &&
                iv_32.getVisibility() ==View.INVISIBLE &&
                iv_33.getVisibility() ==View.INVISIBLE &&
                iv_34.getVisibility() ==View.INVISIBLE ){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MemoryCardsLevelM.this);
            alertDialogBuilder
                    .setMessage("YOU WIN ")
                    .setCancelable(false)
                    .setPositiveButton("NEW",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    }

    public void frontOfCardsRessources(){
        image101 =R.drawable.chat;
        image102 =R.drawable.chat2;
        image103 =R.drawable.chat3;
        image104 =R.drawable.chat4;
        image105 =R.drawable.chat5;
        image106 =R.drawable.chat6;
        image201 =R.drawable.chat;
        image202 =R.drawable.chat2;
        image203 =R.drawable.chat3;
        image204 =R.drawable.chat4;
        image205 =R.drawable.chat5;
        image206 =R.drawable.chat6;


    }
}