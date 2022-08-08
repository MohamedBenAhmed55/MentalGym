package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CryptogrammeAlgorithms {
    String phrase ;
    String phrasecrypt ;

    public CryptogrammeAlgorithms(String phrase) {
        this.phrase = phrase ;
    }

    public void Algorithm1(){
        String newString = "";
        char c;
        for (int i =0 ; i<phrase.length() ; i++){
            c =(char)phrase.charAt(i);
            if(c == ' '){
                newString+=' ';
                continue;
            }
            newString+=++c;
        }

        phrasecrypt=newString;

    }

}
