package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class CryptogrammeMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptogramme_menu);
        MaterialButtonToggleGroup toggleButtonGroup = findViewById(R.id.toggleButtonGroup);
        toggleButtonGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if(isChecked){
                    switch(checkedId){
                        case R.id.easy:
                            showToast("Easy Mode");
                            break;
                        case R.id.medium:
                            showToast("Medium Mode");
                            break;
                        case R.id.hard:
                            showToast("Hard Mode");
                            break;
                    }
                }
            }
        }
        );
    }

    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void Delete(View view){
        Button kamal=(Button)findViewById(R.id.kamal);
        if(kamal.getVisibility() == View.GONE) kamal.setVisibility(View.VISIBLE);
      else kamal.setVisibility(View.GONE);
    }
}