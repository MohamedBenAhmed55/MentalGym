package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class CryptogrammeWin extends AppCompatActivity {
    public static int result=0;
    int points;
    int difficulty;
    Animation smalltobig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        result=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptogramme_win);
        setPoints();
        setStars();
    }

    private void setStars() {
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        ImageView firstStar = findViewById(R.id.firstStar);
        ImageView secondStar = findViewById(R.id.secondStar);
        ImageView thirdStar = findViewById(R.id.thirdStar);
        ImageView youwin = findViewById(R.id.youwin);
        youwin.startAnimation(smalltobig);
        int widthFull2 =(int) getResources().getDimension(R.dimen.fullstar2width);
        int hightFull2 =(int) getResources().getDimension(R.dimen.fullstar2hight);
        int hightAndWidthFull3 =(int) getResources().getDimension(R.dimen.emptyStarHightAndWidth);
        switch (points){
            case 3:
                makeFullSecondStar(secondStar , widthFull2 , hightFull2);
                thirdStar.setImageResource(R.drawable.cryptogramme_star);
                ViewGroup.LayoutParams layoutParams1 = thirdStar.getLayoutParams();
                layoutParams1.width = hightAndWidthFull3;
                layoutParams1.height = hightAndWidthFull3;
                thirdStar.setLayoutParams(layoutParams1);
                break;
            case 2:
                makeFullSecondStar(secondStar , widthFull2 , hightFull2);
                break;
            default:
                break;
        }
//       firstStar.startAnimation(smalltobig);
//       if (firstStar.getAnimation().hasEnded()) secondStar.startAnimation(smalltobig);
//       if (secondStar.getAnimation().hasEnded()) thirdStar.startAnimation(smalltobig);

    }



    private void makeFullSecondStar(ImageView secondStar, int widthFull2 , int hightFull2 ) {
        secondStar.setImageResource(R.drawable.cryptogramme_star);
        ViewGroup.LayoutParams layoutParams2 = secondStar.getLayoutParams();
        layoutParams2.width = widthFull2;
        layoutParams2.height = hightFull2;
        secondStar.setLayoutParams(layoutParams2);
    }

    private void setPoints() {
        SharedPreferences sharedPref = getSharedPreferences(CryptogrammeLevels.PREFERENCES_FILENAME, MODE_PRIVATE);
        difficulty =  sharedPref.getInt("difficulty" , 0);
        points = getIntent().getIntExtra("points" , 0);
        int addScore= points*(difficulty+1);
        TextView scoreText = findViewById(R.id.score);
        scoreText.setText("Score : +"+addScore);
    }

    public void back(View view) {
        result=0;
        this.finish();
    }

    public void backMenu(View view) {
        result=2;
        this.finish();
    }


}