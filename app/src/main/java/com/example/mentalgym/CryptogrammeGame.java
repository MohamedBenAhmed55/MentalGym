package com.example.mentalgym;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class CryptogrammeGame extends AppCompatActivity {
    String phrase;
    String phrasecry;
    String phraseHelp;
    String hintPhrase;
    Timer timer;
    TimerTask timerTask;
    Double time=0.0;
    Dialog dialog;
    boolean isHintClicked=false;
    boolean isHintLetterClicked=false;
    int points=3;
    int difficulty;
    int positon;
    int hintNumber;
    TextView timerTextView;
    List<View> letters= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptogramme_game);
        dialog= new Dialog(this);
        difficulty =  getIntent().getIntExtra("difficulty" , 0);
        positon =  getIntent().getIntExtra("position" , 1);
        DisplayPhrase();
        timerDispaly();
    }

    private void timerDispaly() {
        timerTextView = findViewById(R.id.timer);
        timer = new Timer();
        startTimer();
    }

    private void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerTextView.setText(getTimerText());
                    }
                });

            }
        };
        timer.scheduleAtFixedRate(timerTask , 0 , 1000);

    }

    private String getTimerText() {
        int rounded = (int) Math.round(time);
        int s = ((rounded % 86400) % 3600)%60;
        int m = ((rounded % 86400) % 3600)/60;
        return String.format("%02d",m)+":"+String.format("%02d",s);
    }


    public void HelpLetter(View view) {

        if ( ! isHintLetterClicked) points--;
        isHintLetterClicked=true;
        int size = phraseHelp.length();
        int ind =0;
        if (phraseHelp.length() > 0 && hintNumber>0) {
            if(size>1) ind = new Random().nextInt(size - 1);
            String l = Character.toString(phraseHelp.charAt(ind));
            phraseHelp = phraseHelp.replace(l, "");
            if(phraseHelp.equals("")){
                win();
            }
            hintNumber--;

            for (int i = 0; i < letters.size(); i++) {
                View letterView = letters.get(i);
                String c = ((TextView) letterView.findViewById(R.id.truechar)).getText().toString();
                if (l.equals(c)) {
                    TextView char1 = ((TextView) letterView.findViewById(R.id.char1));
                    char1.setText(l);
                    char1.setEnabled(false);
                }
            }


        }
    }

    public void DisplayPhrase (){
        String algo = getIntent().getStringExtra("algorithm");
        hintPhrase = getIntent().getStringExtra("hint");
        phrase = getIntent().getStringExtra("phrase");
        hintNumber =  getIntent().getIntExtra("hintnumber" , 0);
        phraseHelp=phrase.replace(" ","");
        java.lang.reflect.Method method = null;
        CryptogrammeAlgorithms cryptogrammeAlgorithms = new CryptogrammeAlgorithms(phrase);
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
        phrasecry= cryptogrammeAlgorithms.phrasecrypt;
        String[] list = phrasecry.split(" ");
        String[] truelist = phrase.split(" ");
        LinearLayout phraseView;

        phraseView = findViewById(R.id.phrase);
        int ligneSize =0;
        for(int i=0; i<list.length ; i++){
            String ch=list[i];
            String truech=truelist[i];
            LinearLayout ligne;
            LinearLayout  word = (LinearLayout) getLayoutInflater().inflate(R.layout.word , null , false);
            for (int j=0 ; j<ch.length() ; j++){
                View card = getLayoutInflater().inflate(R.layout.card , null , false);
                TextView char2 =(TextView) card.findViewById(R.id.char2);
                TextView truechar =(TextView)card.findViewById(R.id.truechar);
                EditText char1 =(EditText) card.findViewById(R.id.char1);
                char c =ch.charAt(j);
                char truec = truech.charAt(j);
                String s = Character.toString(c);
                String trues = Character.toString(truec);
                char2.setText(s);
                truechar.setText(trues);
                word.addView(card);
                char1.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        boolean is_win = true;
                        for (int l=0 ; l< letters.size() ; l++){
                            View letter = letters.get(l);
                            EditText e = (EditText) letter.findViewById(R.id.char1);
                            TextView r = (TextView) letter.findViewById(R.id.char2);
                            String trueChar = (String) ((TextView)letter.findViewById(R.id.truechar)).getText();
                            if (char1.getText().length() > 0  && truechar.getText().toString().equals(trueChar ) &&  !(char1.getText().toString().equals(e.getText().toString() ))  ) {
                                String x = Character.toString(char1.getText().charAt(0));
                                e.setText(x ,TextView.BufferType.EDITABLE);
                            }
                            else if (char1.getText().length() == 0  && truechar.getText().toString().equals(trueChar ) &&  !(char1.getText().toString().equals(e.getText().toString() ))  ) {
                                e.setText("" ,TextView.BufferType.EDITABLE);
                            }
                            if ( ! trueChar.equals(e.getText().toString()) ) {
                                is_win = false;
                            }
                        }
                        if(is_win){
                            win();
                        }
                    }
                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

            }
            if ((ch.length() + ligneSize) <= 10 ){
                ligne = (LinearLayout) phraseView.getChildAt(phraseView.getChildCount()-1);
                ligne.addView(word);
                ligneSize+=ch.length();
            }
            else {
                ligneSize=ch.length();
                ligne = (LinearLayout) getLayoutInflater().inflate(R.layout.word , null , false);
                ligne.addView(word);
                phraseView.addView(ligne);
            }
        }
        for (int l=0 ; l< phraseView.getChildCount() ; l++){
            LinearLayout li = (LinearLayout) phraseView.getChildAt(l);
            for(int w=0 ; w< li.getChildCount() ; w++){
                LinearLayout mot=(LinearLayout) li.getChildAt(w);
                for(int t =0 ; t< mot.getChildCount() ; t++){
                    View letter = mot.getChildAt(t);
                    letters.add(letter);
                }
            }
        }
    }

    private void win(){
        SharedPreferences sharedPref = getSharedPreferences(CryptogrammeLevels.PREFERENCES_FILENAME, MODE_PRIVATE);
        int winwsilna ;
        int addScore= points*(difficulty+1);
        int score =  sharedPref.getInt("score" , 0);
        switch (difficulty){
            case  1:
                winwsilna = sharedPref.getInt(CryptogrammeLevels.WINWSOLNA2 , 1) ;
                if (positon>=winwsilna) {
                    sharedPref.edit().putInt(CryptogrammeLevels.WINWSOLNA2, winwsilna + 1).apply();
                }
                break;
            case 2:
                winwsilna = sharedPref.getInt(CryptogrammeLevels.WINWSOLNA3 , 1) ;
                if (positon>=winwsilna)
                    sharedPref.edit().putInt(CryptogrammeLevels.WINWSOLNA3  , winwsilna +1 ).apply();
                break;
            default:
                winwsilna = sharedPref.getInt(CryptogrammeLevels.WINWSOLNA1 , 1) ;
                System.out.println(positon);
                System.out.println(winwsilna);
                if (positon>=winwsilna)
                    sharedPref.edit().putInt(CryptogrammeLevels.WINWSOLNA1  , winwsilna + 1).apply();
        }
        if(positon>=winwsilna){
            sharedPref.edit().putInt("score" , score+addScore).apply();
        }
        Intent i = new Intent(CryptogrammeGame.this,CryptogrammeWin.class);
        i.putExtra("points" , points);
        startActivity(i);
        finish();
    }



    public void back(View view) {
       this.finish();
    }


    public void hintPopup(View view) {
        if (! isHintClicked) points--;
        isHintClicked=true;
        dialog.setContentView(R.layout.cryptogramme_hint_popup);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        TextView hintView = dialog.findViewById(R.id.hint);
        hintView.setText(hintPhrase);
    }

    public void refresh(View view) {
        recreate();
    }
}