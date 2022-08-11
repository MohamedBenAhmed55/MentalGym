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

public class WordScramblelvl2 extends AppCompatActivity {

    //    Views
    private int presCounter = 0;
    private int maxPresCounter = 6;
    private String[] keys;
    private String textAnswer;
    private ImageButton resetbtn;
    TextView textScreen, textQuestion, textTitle;
    Animation smallbigforth;

    //    Preference
    SharedPreferences myPref;

    //    Timer
    private CountDownTimer countDownTimer;
    private long timeLeftinMilliseconds = 120000; //1 min
    private TextView countdownText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_scramblelvl2);

        textQuestion = (TextView) findViewById(R.id.textQuestion);

        //        Initializing shared preferences
        myPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        myPref.edit().putString("diff", "mid");
//       number =  myPref.getInt("level",1);

        switch (myPref.getInt("level", 1)) {
            case 1:
                keys = new String[]{"R", "I", "B", "D", "X", "A", "A", "O"};
                textAnswer = "ABROAD";
                textQuestion.setText("Outside your country");
                break;
            case 2:
                keys = new String[]{"N", "N", "A", "L", "A", "B", "H", "U"};
                textAnswer = "ANNUAL";
                textQuestion.setText("Each year");
                break;
            case 3:
                keys = new String[]{"A", "N", "G", "E", "R", "G", "D", "P"};
                textAnswer = "DANGER";
                textQuestion.setText("Not safe");
                break;
            case 4:
                keys = new String[]{"I", "A", "M", "Y", "L", "F", "G", "S"};
                textAnswer = "FAMILY";
                textQuestion.setText("Related by blood");
                break;
            case 5:
                keys = new String[]{"A", "F", "D", "L", "N", "H", "E", "T"};
                textAnswer = "HANDLE";
                textQuestion.setText("we open a door with a door...");
                break;
            case 6:
                this.keys = new String[]{"I", "L", "A", "N", "S", "Y", "D", "S"};
                this.textAnswer = "ISLAND";
                textQuestion.setText("Land surrounded by water");
                break;
            case 7:
                keys = new String[]{"R", "Y", "E", "A", "W", "L", "M", "T"};
                textAnswer = "LAWYER";
                textQuestion.setText("Defends you in court");
                break;
            case 8:
                keys = new String[]{"D", "F", "D", "H", "M", "L", "I", "E"};
                this.textAnswer = "MIDDLE";
                textQuestion.setText("In-between");
                break;
            case 9:
                keys = new String[]{"D", "M", "O", "R", "E", "P", "N", "G"};
                textAnswer = "MODERN";
                textQuestion.setText("Not ancient");
            default:
                break;
        }

        keys = shuffleArray(keys);

        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        int x = 0;
        for (String key : keys) {
            if (x < 4) {
                addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
                x++;
            } else {
                addView(((LinearLayout) findViewById(R.id.layoutParent2)), key, ((EditText) findViewById(R.id.editText)));
            }
        }

        maxPresCounter = 6;

//        Timer
        countdownText = findViewById(R.id.countdown_text);
        startTimer();

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

        //TODO : REMOVE FOR HARD DIFF
        linearLayoutParams.leftMargin = 40;


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

//        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.click);


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

                    if (presCounter == maxPresCounter)
                        doValidate();
                }
            }
        });

        viewParent.addView(textView);

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    if (x < 4) {
                        addView(linearLayout, key, editText);
                        x++;
                    } else {
                        addView(linearLayout2, key, editText);
                    }
                }

            }
        });
    }

    private void doValidate() {
        presCounter = 0;

        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);
        LinearLayout linearLayout2 = findViewById(R.id.layoutParent2);

        if (editText.getText().toString().equals(textAnswer)) {
//            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

            Intent a = new Intent(this, WSSlvl1.class);
            startActivity(a);

            editText.setText("");
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("");
        }

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        linearLayout2.removeAllViews();
        int x = 0;
        for (String key : keys) {
            if (x < 4) {
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
                Toast.makeText(WordScramblelvl2.this, "You failed this level", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());

            }
        }.start();

    }

    public void updateTimer() {
        int minutes = (int) timeLeftinMilliseconds / 60000;
        int seconds = (int) timeLeftinMilliseconds % 60000 / 1000;
        String timeLeftText;

        timeLeftText = " " + minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;
        countdownText.setText(timeLeftText);

    }
}