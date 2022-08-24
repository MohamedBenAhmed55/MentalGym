package com.example.mentalgym;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MemoryCardsLevelE extends AppCompatActivity {
    TextView textView;
    // boolean for countdowntimer
    boolean timeRunning = true ;


    ImageView iv_11, iv_12, iv_13, iv_21, iv_22, iv_23;
    //array for the images
    Integer[] cardsArray = {101, 102, 103, 201, 202, 203};
    // actual images
    int image101, image102, image103, image201, image202, image203;
    int firstCard, secondCard;
    int clickedFirst , clickedSecond;
    int cardNumber = 1 ;

    //    Shared preference
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_cards_level_e);

        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        textView = findViewById(R.id.textView4);
        // intialize timer duration
        long duration = TimeUnit.SECONDS.toMillis(30);
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
                if (timeRunning) {
                    //open lose dialog
                    Intent i = new Intent(MemoryCardsLevelE.this, MCLose.class);
                    startActivity(i);
                    finish();
                }
            }
        }.start();

        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);
        iv_13 = findViewById(R.id.iv_13);
        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);
        iv_23 = findViewById(R.id.iv_23);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_21.setTag("3");
        iv_22.setTag("4");
        iv_23.setTag("5");

        //load the card images
        switch(myPref.getInt("level",1)){
            case 1:
                image101 =R.drawable.moster1;
                image102 =R.drawable.moster2;
                image103 =R.drawable.moster3;
                image201 =R.drawable.moster1;
                image202 =R.drawable.moster2;
                image203 =R.drawable.moster3;
                break;
            case 2:
                image101 =R.drawable.animal1;
                image102 =R.drawable.animal2;
                image103 =R.drawable.animal3;
                image201 =R.drawable.animal1;
                image202 =R.drawable.animal2;
                image203 =R.drawable.animal3;
                break;
            case 3:
                image101 =R.drawable.chat3;
                image102 =R.drawable.chat;
                image103 =R.drawable.chat6;
                image201 =R.drawable.chat3;
                image202 =R.drawable.chat;
                image203 =R.drawable.chat6;
                break;
            case 4:
                image101 =R.drawable.emoji3;
                image102 =R.drawable.emoji4;
                image103 =R.drawable.emoji7;
                image201 =R.drawable.emoji3;
                image202 =R.drawable.emoji4;
                image203 =R.drawable.emoji7;
                break;
            case 5:
                image101 =R.drawable.fruit1;
                image102 =R.drawable.fruit2;
                image103 =R.drawable.fruit3;
                image201 =R.drawable.fruit1;
                image202 =R.drawable.fruit2;
                image203 =R.drawable.fruit3;
                break;
            case 6:
                image101 =R.drawable.moster4;
                image102 =R.drawable.moster5;
                image103 =R.drawable.moster6;
                image201 =R.drawable.moster4;
                image202 =R.drawable.moster5;
                image203 =R.drawable.moster6;
                break;
            case 7:
                image101 =R.drawable.animal4;
                image102 =R.drawable.animal5;
                image103 =R.drawable.animal6;
                image201 =R.drawable.animal4;
                image202 =R.drawable.animal5;
                image203 =R.drawable.animal6;
                break;
            case 8:
                image101 =R.drawable.emoji8;
                image102 =R.drawable.emoji10;
                image103 =R.drawable.emoji11;
                image201 =R.drawable.emoji8;
                image202 =R.drawable.emoji10;
                image203 =R.drawable.emoji11;
                break;
            case 9:
                image101 =R.drawable.moster1;
                image102 =R.drawable.moster4;
                image103 =R.drawable.moster7;
                image201 =R.drawable.moster1;
                image202 =R.drawable.moster4;
                image203 =R.drawable.moster7;
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
        else if (cardsArray[card]==201){
            iv.setImageResource(image201);
        }
        else if (cardsArray[card]==202){
            iv.setImageResource(image202);
        }
        else if (cardsArray[card]==203){
            iv.setImageResource(image203);
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
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);

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
                iv_21.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 4){
                iv_22.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 5){
                iv_23.setVisibility(View.INVISIBLE);
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
                iv_21.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 4){
                iv_22.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 5){
                iv_23.setVisibility(View.INVISIBLE);
            }

        }
        else{
            iv_11.setImageResource(R.drawable.questions);
            iv_12.setImageResource(R.drawable.questions);
            iv_13.setImageResource(R.drawable.questions);
            iv_21.setImageResource(R.drawable.questions);
            iv_22.setImageResource(R.drawable.questions);
            iv_23.setImageResource(R.drawable.questions);


        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);

        //check if the game is over
        checkEnd();

    }

    public void checkEnd(){
        if(iv_11.getVisibility() ==View.INVISIBLE &&
                iv_12.getVisibility() ==View.INVISIBLE &&
                iv_13.getVisibility() ==View.INVISIBLE &&
                iv_21.getVisibility() ==View.INVISIBLE &&
                iv_22.getVisibility() ==View.INVISIBLE &&
                iv_23.getVisibility() ==View.INVISIBLE ){
            timeRunning = false;
            //open win dialog
            Intent i = new Intent(MemoryCardsLevelE.this,MCWin.class);
            startActivity(i);
            this.finish();
        }

    }

    public void onStart() {

        super.onStart();
        timeRunning = true;
    }

    public void onResume(){
        super.onResume();
        timeRunning = true;
    }

    public void onPause(){
        super.onPause();
        timeRunning = false;
    }

    public void onStop(){
        super.onStop();
        timeRunning = false;
    }


}