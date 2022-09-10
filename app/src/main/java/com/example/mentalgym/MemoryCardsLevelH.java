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

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MemoryCardsLevelH extends AppCompatActivity {

    TextView textView;
    boolean timeRunning = true ;

    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24,
    iv_31, iv_32, iv_33, iv_34,iv_41,iv_42, iv_43, iv_44;
    //array for the images
    Integer[] cardsArray = {101, 102, 103, 104, 105, 106,107,108, 201, 202, 203, 204, 205, 206,207,208};
    // actual images
    int image101, image102, image103, image104, image105 , image106 ,image107 , image108 ,
            image201, image202, image203, image204, image205 , image206 , image207 , image208;
    int firstCard, secondCard;
    int clickedFirst , clickedSecond;
    int cardNumber = 1 ;
    //    Shared preference
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_cards_level_h);

        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        myPref.edit().putString("diff", "mid");

        textView = findViewById(R.id.textView4);
        // intialize timer duration
        long duration = TimeUnit.SECONDS.toMillis(45);
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
                    Intent i = new Intent(MemoryCardsLevelH.this, MCLose.class);
                    startActivity(i);
                    finish();
                }
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
        iv_41 = findViewById(R.id.iv_41);
        iv_42 = findViewById(R.id.iv_42);
        iv_43 = findViewById(R.id.iv_43);
        iv_44 = findViewById(R.id.iv_44);

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
        iv_41.setTag("12");
        iv_42.setTag("13");
        iv_43.setTag("14");
        iv_44.setTag("15");

        //load the card images
        switch(myPref.getInt("level",1)){
            case 1:
                image101 =R.drawable.moster1;
                image102 =R.drawable.moster10;
                image103 =R.drawable.moster12;
                image104 =R.drawable.moster15;
                image105 =R.drawable.moster5;
                image106 =R.drawable.moster17;
                image107 =R.drawable.moster18;
                image108 =R.drawable.moster19;

                image201 =R.drawable.moster1;
                image202 =R.drawable.moster10;
                image203 =R.drawable.moster12;
                image204 =R.drawable.moster15;
                image205 =R.drawable.moster5;
                image206 =R.drawable.moster17;
                image207 =R.drawable.moster18;
                image208 =R.drawable.moster19;
                break;
            case 2:
                image101 =R.drawable.moster17;
                image102 =R.drawable.moster16;
                image103 =R.drawable.moster3;
                image104 =R.drawable.moster14;
                image105 =R.drawable.moster5;
                image106 =R.drawable.moster7;
                image107 =R.drawable.moster13;
                image108 =R.drawable.moster8;

                image201 =R.drawable.moster17;
                image202 =R.drawable.moster16;
                image203 =R.drawable.moster3;
                image204 =R.drawable.moster14;
                image205 =R.drawable.moster5;
                image206 =R.drawable.moster7;
                image207 =R.drawable.moster13;
                image208 =R.drawable.moster8;
                break;
            case 3:
                image101 =R.drawable.moster20;
                image102 =R.drawable.moster21;
                image103 =R.drawable.moster22;
                image104 =R.drawable.moster23;
                image105 =R.drawable.moster24;
                image106 =R.drawable.moster25;
                image107 =R.drawable.moster26;
                image108 =R.drawable.moster27;

                image201 =R.drawable.moster20;
                image202 =R.drawable.moster21;
                image203 =R.drawable.moster22;
                image204 =R.drawable.moster23;
                image205 =R.drawable.moster24;
                image206 =R.drawable.moster25;
                image207 =R.drawable.moster26;
                image208 =R.drawable.moster27;
                break;
            case 4:
                image101 =R.drawable.animal1;
                image102 =R.drawable.animal7;
                image103 =R.drawable.animal11;
                image104 =R.drawable.animal12;
                image105 =R.drawable.animal18;
                image106 =R.drawable.animal13;
                image107 =R.drawable.animal2;
                image108 =R.drawable.animal15;

                image201 =R.drawable.animal1;
                image202 =R.drawable.animal7;
                image203 =R.drawable.animal11;
                image204 =R.drawable.animal12;
                image205 =R.drawable.animal18;
                image206 =R.drawable.animal13;
                image207 =R.drawable.animal2;
                image208 =R.drawable.animal15;
                break;
            case 5:
                image101 =R.drawable.animal13;
                image102 =R.drawable.animal6;
                image103 =R.drawable.animal14;
                image104 =R.drawable.animal17;
                image105 =R.drawable.animal19;
                image106 =R.drawable.animal20;
                image107 =R.drawable.animal21;
                image108 =R.drawable.animal16;

                image201 =R.drawable.animal13;
                image202 =R.drawable.animal6;
                image203 =R.drawable.animal14;
                image204 =R.drawable.animal17;
                image205 =R.drawable.animal19;
                image206 =R.drawable.animal20;
                image207 =R.drawable.animal21;
                image208 =R.drawable.animal16;
                break;
            case 6:
                image101 =R.drawable.animal7;
                image102 =R.drawable.animal6;
                image103 =R.drawable.animal18;
                image104 =R.drawable.animal2;
                image105 =R.drawable.animal19;
                image106 =R.drawable.animal15;
                image107 =R.drawable.animal14;
                image108 =R.drawable.animal16;

                image201 =R.drawable.animal7;
                image202 =R.drawable.animal6;
                image203 =R.drawable.animal18;
                image204 =R.drawable.animal2;
                image205 =R.drawable.animal19;
                image206 =R.drawable.animal15;
                image207 =R.drawable.animal14;
                image208 =R.drawable.animal16;
                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

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
        iv_41.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_41,theCard);
        });
        iv_42.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_42,theCard);
        });
        iv_43.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_43,theCard);
        });
        iv_44.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_44,theCard);
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
        else if (cardsArray[card]==107) {
            iv.setImageResource(image107);
        }
        else if (cardsArray[card]==108) {
            iv.setImageResource(image108);
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
        else if (cardsArray[card]==207){
            iv.setImageResource(image207);
        }
        else if (cardsArray[card]==208){
            iv.setImageResource(image208);
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
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);
            iv_44.setEnabled(false);
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
            else if (clickedFirst == 12){
                iv_41.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 13){
                iv_42.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 14){
                iv_43.setVisibility(View.INVISIBLE);
            }
            else if (clickedFirst == 15){
                iv_44.setVisibility(View.INVISIBLE);
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
            else if (clickedSecond == 12){
                iv_41.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 13){
                iv_42.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 14){
                iv_43.setVisibility(View.INVISIBLE);
            }
            else if (clickedSecond == 15){
                iv_44.setVisibility(View.INVISIBLE);
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
            iv_41.setImageResource(R.drawable.questions);
            iv_42.setImageResource(R.drawable.questions);
            iv_43.setImageResource(R.drawable.questions);
            iv_44.setImageResource(R.drawable.questions);

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
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        iv_44.setEnabled(true);

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
                iv_34.getVisibility() ==View.INVISIBLE &&
                iv_41.getVisibility() ==View.INVISIBLE &&
                iv_42.getVisibility() ==View.INVISIBLE &&
                iv_43.getVisibility() ==View.INVISIBLE &&
                iv_44.getVisibility() ==View.INVISIBLE ){
            timeRunning = false;
            //open win dialog
            Intent i = new Intent(MemoryCardsLevelH.this,MCWin.class);
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