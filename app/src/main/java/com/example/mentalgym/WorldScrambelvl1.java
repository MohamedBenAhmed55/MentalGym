package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
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
    private String[] keys ;
    private String textAnswer ;
    private ImageButton resetbtn;
    private int number;

//    Shared preference
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_scrambelvl1);
        textQuestion = (TextView) findViewById(R.id.textQuestion);
        //        Initializing shared preferences
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
//       number =  myPref.getInt("level",1);
        switch(myPref.getInt("level",1)){
            case 1:
                keys = new String[]{"R", "I", "B", "D", "X"};
                textAnswer = "BIRD";
                textQuestion.setText("Animal With Wings");
                break;
            case 2:
                keys = new String[]{"C", "D", "O","L","S"};
                textAnswer="COLD";
                textQuestion.setText("Temperature State");
                break;
            case 3:
                keys = new String[]{"H", "P", "O","W","E"};
                textAnswer="HOPE";
                textQuestion.setText("Desire for a particular thing to happen");
                break;
            case 4:
                keys = new String[]{"C", "D", "O","G","O"};
                textAnswer="GOOD";
                textQuestion.setText("Opposite of bad");
                break;
            case 5:
                 keys = new String[]{"U", "F", "O","L","R"};
                textAnswer="FOUR";
                textQuestion.setText("The number of our limbs");
                break;
            case 6:
                this.keys = new String[]{"T", "A", "O","Y","S"};
                this.textAnswer="STAY";
                textQuestion.setText("Opposite of Go");
                break;
            case 7:
                keys = new String[]{"A", "K", "O","N","B"};
                textAnswer="BANK";
                textQuestion.setText("A facility that deals in money");
                break;
            case 8:
                keys = new String[]{"I", "F", "O","H","S"};
                this.textAnswer="FISH";
                textQuestion.setText("Lives in the sea");
                break;
            case 9:
                keys = new String[]{"S", "N", "O","L","E"};
                textAnswer="NOSE";
                textQuestion.setText("Is in the center of the face");
            default:
                break;
        }


        keys = shuffleArray(keys);

        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        for (String key : keys) {
            addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
        }

        maxPresCounter = 4;
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

        textQuestion.setTypeface(typeface);
        textScreen.setTypeface(typeface);
        textTitle.setTypeface(typeface);
        editText.setTypeface(typeface);
        textView.setTypeface(typeface);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presCounter < maxPresCounter) {
                    if (presCounter == 0)
                        editText.setText("");

                    editText.setText(editText.getText().toString() + text);
                    textView.startAnimation(smallbigforth);
                    textView.animate().alpha(0).setDuration(300);
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
                editText.setText("");
                keys = shuffleArray(keys);
                linearLayout.removeAllViews();
                for (String key : keys) {
                    addView(linearLayout, key, editText);
                }

            }
        });
    }

    private void doValidate() {
        presCounter = 0;

        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);

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
        for (String key : keys) {
            addView(linearLayout, key, editText);
        }

    }
}