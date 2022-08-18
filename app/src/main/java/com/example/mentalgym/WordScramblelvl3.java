package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class WordScramblelvl3 extends AppCompatActivity {

    //Views
    private int presCounter = 0;
    private int maxPresCounter = 7;
    private String[] keys;
    private String textAnswer;
    private ImageButton resetbtn;
    TextView textScreen, textQuestion, textTitle;
    Animation smallbigforth;
    //Preference
    SharedPreferences myPref;

    //    Timer
    private CountDownTimer countDownTimer;
    private long timeLeftinMilliseconds = 61000; //1 min
    private TextView countdownText;

    //Score
    private int score = 50;
    private int nbattempt = 0;
    private boolean time = true;

    //Sounds
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaSuccess;
    private MediaPlayer mediaFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_scramblelvl3);

        textQuestion = (TextView) findViewById(R.id.textQuestion);

        //Initializing shared preferences
        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        myPref.edit().putString("diff", "hard");

        //init of variables special to each level
        switch (myPref.getInt("level", 1)) {
            case 1:
                keys = new String[]{"A", "U", "C", "T", "O", "N", "O", "P", "F", "I"};
                textAnswer = "AUCTION";
                textQuestion.setText("An assembly in which you bid on objects.");
                break;
            case 2:
                keys = new String[]{"C", "O", "E", "X", "M", "P", "L", "O", "L", "D"};
                textAnswer = "COMPLEX";
                textQuestion.setText("Not simple");
                break;
            case 3:
                keys = new String[]{"A", "N", "X", "S", "U", "O", "I", "P", "D", "V"};
                textAnswer = "ANXIOUS";
                textQuestion.setText("Not feeling calm");
                break;
            case 4:
                keys = new String[]{"L", "A", "E", "Y", "L", "F", "G", "E", "D", "B"};
                textAnswer = "ALLEGED";
                textQuestion.setText("Not Certain");
                break;
            case 5:
                keys = new String[]{"I", "L", "G", "L", "A", "L", "E", "T", "G", "S"};
                textAnswer = "ILLEGAL";
                textQuestion.setText("Prohibited by the law");
                break;
            case 6:
                this.keys = new String[]{"O", "V", "B", "I", "U", "Y", "U", "S", "O", "B"};
                this.textAnswer = "OBVIOUS";
                textQuestion.setText("clear");
                break;
            case 7:
                keys = new String[]{"O", "I", "P", "N", "N", "O", "I", "T", "G", "S"};
                textAnswer = "OPINION";
                textQuestion.setText("Something we express");
                break;
            case 8:
                keys = new String[]{"P", "H", "O", "N", "X", "L", "I", "E", "S", "B"};
                this.textAnswer = "PHOENIX";
                textQuestion.setText("Rises from its ashes");
                break;
            case 9:
                keys = new String[]{"R", "A", "L", "I", "Y", "W", "A", "G", "D", "M"};
                textAnswer = "RAILWAY";
                textQuestion.setText("the road of a train");
            default:
                break;
        }

        keys = shuffleArray(keys);

        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        int x = 0;

        //adds clickable letters to the interface
        for (String key : keys) {
            if (x < 5) {
                addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
                x++;
            } else {
                addView(((LinearLayout) findViewById(R.id.layoutParent2)), key, ((EditText) findViewById(R.id.editText)));
            }
        }

        maxPresCounter = 7;

        //        Timer
        countdownText = findViewById(R.id.countdown_text);
        startTimer();

        //Sounds
        mediaPlayer = MediaPlayer.create(this,R.raw.click);
        mediaFail = MediaPlayer.create(this,R.raw.fail);
        mediaSuccess = MediaPlayer.create(this,R.raw.success);
    }

    //shuffles the letters in order to display a different order of letters each time
    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }

        return ar;
    }

    //creates the clickable letters buttons
    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        linearLayoutParams.rightMargin = 30;


        final TextView textView = new TextView(this);
        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.bgpink));
        textView.setTextColor(this.getResources().getColor(R.color.colorPurple));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");
        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textScreen = (TextView) findViewById(R.id.textScreen);
        textTitle = (TextView) findViewById(R.id.textTitle);
        resetbtn = (ImageButton) findViewById(R.id.resetbtn);

        textQuestion.setTypeface(typeface);
        textScreen.setTypeface(typeface);
        textTitle.setTypeface(typeface);
        editText.setTypeface(typeface);
        textView.setTypeface(typeface);


        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.click);

        //makes sure the answer is validated when the corresponding number of letters is reached / submit
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presCounter < maxPresCounter) {
                    if (presCounter == 0)
                        editText.setText("");

                    editText.setText(editText.getText().toString() + text);
                    textView.startAnimation(smallbigforth);
                    textView.animate().alpha(0).setDuration(300);
                    textView.setClickable(false);
                    presCounter++;
                    mediaPlayer.start();

                    if (presCounter == maxPresCounter)
                        doValidate();
                }
            }
        });

        viewParent.addView(textView);

        //resets letters in case of a mistake
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                presCounter = 0;
                EditText editText = findViewById(R.id.editText);
                LinearLayout linearLayout = findViewById(R.id.layoutParent);
                LinearLayout linearLayout2 = findViewById(R.id.layoutParent2);
                editText.setText("");
                keys = shuffleArray(keys);
                linearLayout.removeAllViews();
                linearLayout2.removeAllViews();
                int x = 0;
                for (String key : keys) {
                    if (x < 5) {
                        addView(linearLayout, key, editText);
                        x++;
                    } else {
                        addView(linearLayout2, key, editText);
                    }
                }
            }
        });
    }

    //method that checks if the answer is valid or not
    private void doValidate() {
        presCounter = 0;

        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);
        LinearLayout linearLayout2 = findViewById(R.id.layoutParent2);

        if (editText.getText().toString().equals(textAnswer)) {
//            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            mediaSuccess.start();
            Intent a = new Intent(this, WSSlvl1.class);
            score -= nbattempt * 10;
            a.putExtra("sc",score);
            startActivity(a);

            editText.setText("");
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("");
            nbattempt++;
            if (nbattempt > 2) {
                Toast.makeText(WordScramblelvl3.this, "Too many attempts", Toast.LENGTH_SHORT).show();
                mediaFail.start();
                finish();
                startActivity(getIntent());
            }
        }

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        linearLayout2.removeAllViews();
        int x = 0;
        for (String key : keys) {
            if (x < 5) {
                addView(linearLayout, key, editText);
                x++;
            } else {
                addView(linearLayout2, key, editText);
            }
        }

    }

    //Timer
    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftinMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftinMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                mediaFail.start();
                Toast.makeText(WordScramblelvl3.this, "You failed this level", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            }
        }.start();

    }

    //Used to update time left on view
    public void updateTimer() {
        int minutes = (int) timeLeftinMilliseconds / 60000;
        int seconds = (int) timeLeftinMilliseconds % 60000 / 1000;
        String timeLeftText;

        if (minutes < 1 && time) {
            score -= 10;
            time = false;
        }

        timeLeftText = " " + minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;
        countdownText.setText(timeLeftText);

    }

    //Hint used == decrease the score
    public void HintClicked(View view) {
        mediaPlayer.start();
        textQuestion.setVisibility(View.VISIBLE);
        view.setVisibility(View.GONE);
        score-=5;
    }

    //Preventing the timer from working in the background after exiting the game
    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    protected void onStop(){
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onResume(){
        super.onResume();
        countDownTimer.start();
    }
}