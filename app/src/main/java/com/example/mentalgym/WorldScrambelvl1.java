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

public class WorldScrambelvl1 extends AppCompatActivity {

    //    Views
    TextView textScreen, textQuestion, textTitle;
    Animation smallbigforth;
    private int presCounter = 0;
    private int maxPresCounter = 4;
    private String[] keys;
    private String textAnswer;
    private ImageButton resetbtn;
    private int number;

    //Timer
    private CountDownTimer countDownTimer;
    private long timeLeftinMilliseconds = 121000; //1 min
    private TextView countdownText;

    //Shared preference
    SharedPreferences myPref;

    //Score
    private int score = 50;
    private int nbattempt = 0;
    private boolean time = true;
    private String Level;

    //Sounds
    private MediaPlayer mediaPlayer ;
    private MediaPlayer mediaSuccess;
    private MediaPlayer mediaFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_scrambelvl1);

        textQuestion = (TextView) findViewById(R.id.textQuestion);
        //        Initializing shared preferences
        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
//       number =  myPref.getInt("level",1);

        //Selecting appropriate values based on the picked level
        switch (myPref.getInt("level", 1)) {
            case 1:
                keys = new String[]{"R", "I", "B", "D", "X"};
                textAnswer = "BIRD";
                textQuestion.setText("Animal With Wings");
                Level = "EasyLevel 1";
                break;
            case 2:
                keys = new String[]{"C", "D", "O", "L", "S"};
                textAnswer = "COLD";
                textQuestion.setText("Temperature State");
                Level = "EasyLevel 2";
                break;
            case 3:
                keys = new String[]{"H", "P", "O", "W", "E"};
                textAnswer = "HOPE";
                textQuestion.setText("Desire for a particular thing to happen");
                Level = "EasyLevel 3";
                break;
            case 4:
                keys = new String[]{"C", "D", "O", "G", "O"};
                textAnswer = "GOOD";
                textQuestion.setText("Opposite of bad");
                Level = "EasyLevel 4";
                break;
            case 5:
                keys = new String[]{"U", "F", "O", "L", "R"};
                textAnswer = "FOUR";
                textQuestion.setText("The number of our limbs");
                Level = "EasyLevel 5";
                break;
            case 6:
                this.keys = new String[]{"T", "A", "O", "Y", "S"};
                this.textAnswer = "STAY";
                textQuestion.setText("Opposite of Go");
                Level = "EasyLevel 6";
                break;
            case 7:
                keys = new String[]{"A", "K", "O", "N", "B"};
                textAnswer = "BANK";
                textQuestion.setText("A facility that deals in money");
                Level = "EasyLevel 7";
                break;
            case 8:
                keys = new String[]{"I", "F", "O", "H", "S"};
                this.textAnswer = "FISH";
                textQuestion.setText("Lives in the sea");
                Level = "EasyLevel 8";
                break;
            case 9:
                keys = new String[]{"S", "N", "O", "L", "E"};
                textAnswer = "NOSE";
                textQuestion.setText("Is in the center of the face");
                Level = "EasyLevel 9";
            default:
                break;
        }


        keys = shuffleArray(keys);

        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        for (String key : keys) {
            addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
        }

        maxPresCounter = 4;

        //Timer
        countdownText = findViewById(R.id.countdown_text);
        startTimer();

        //Sounds
        mediaPlayer = MediaPlayer.create(this, R.raw.click);
        mediaFail = MediaPlayer.create(this,R.raw.fail);
        mediaSuccess = MediaPlayer.create(this,R.raw.success);

    }

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
        countdownText = (TextView) findViewById(R.id.countdown_text);

        textQuestion.setTypeface(typeface);
        textScreen.setTypeface(typeface);
        textTitle.setTypeface(typeface);
        editText.setTypeface(typeface);
        textView.setTypeface(typeface);
        countdownText.setTypeface(typeface);



        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.click);

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

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                presCounter = 0;
                EditText editText = findViewById(R.id.editText);
                LinearLayout linearLayout = findViewById(R.id.layoutParent);
                editText.setText("");
                keys = shuffleArray(keys);
                linearLayout.removeAllViews();
                for (String key : keys) {
                    addView(linearLayout, key, editText);
                }

            }
        });
    }

    //Checks if the answer is correct and adds the level's score to the total one
    private void doValidate() {
        presCounter = 0;
        int currentSc;
        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);

        if (editText.getText().toString().equals(textAnswer)) {
            //Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            mediaSuccess.start();
            Intent a = new Intent(this, WSSlvl1.class);
            score -= nbattempt * 10;
            currentSc = myPref.getInt(Level,0);

            //Making sure the score isn't infinitely added each time the same level is played
            if(score >= currentSc){
                myPref.edit().putInt(Level,score);
                score=score - currentSc;
            }

            a.putExtra("sc", score);
            startActivity(a);
            editText.setText("");

        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("");
            nbattempt++;
            if (nbattempt > 5) {
                Toast.makeText(WorldScrambelvl1.this, "Too many attempts", Toast.LENGTH_SHORT).show();
                mediaFail.start();
                finish();
                startActivity(getIntent());
            }
        }

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        for (String key : keys) {
            addView(linearLayout, key, editText);
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
                Toast.makeText(WorldScrambelvl1.this, "You failed this level", Toast.LENGTH_SHORT).show();
                mediaFail.start();
                finish();
                startActivity(getIntent());
            }
        }.start();

    }

    //Updates the timer text
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


    //Shows the hint and subtracts points from the final score
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