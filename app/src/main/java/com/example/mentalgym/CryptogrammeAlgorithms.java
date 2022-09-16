package com.example.mentalgym;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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


    public void Algorithm2() {
        String newString = "";
        char c;
        for (int i = 0; i < phrase.length(); i++) {
            c = (char) phrase.charAt(i);
            if (c == ' ') {
                newString += ' ';
                continue;
            }
            newString += --c;
        }
        phrasecrypt = newString;

    }

    public void Algorithm3(){
        String newString = "";
        int c;
        for (int i =0 ; i<phrase.length() ; i++){
            c= phrase.charAt(i);
            if(c == ' '){
                newString+=' ';
                continue;
            }
            int First_Two_Digit_Finder,last_digit_finder = 0,Middle_digit_finder = 0,First_Digit_Finder = 0;
            if(Integer.toString(c).length()==3){
                First_Two_Digit_Finder = c/10;
                last_digit_finder = c%10;
                Middle_digit_finder = First_Two_Digit_Finder%10;
                First_Digit_Finder = First_Two_Digit_Finder/10;
            }
            else if(Integer.toString(c).length()==2){
                First_Digit_Finder = c/10;
                last_digit_finder = c%10;
            }
            int sum = First_Digit_Finder + Middle_digit_finder + last_digit_finder;
            System.out.println("code : "+Integer.toString(c) + '\n');
            System.out.println("sum : "+Integer.toString(sum) + '\n');
            newString+=Integer.toString(sum).charAt(0);
        }
        phrasecrypt=newString;
    }

    public void Algorithm4(){
        String newString = "";
        char c;
        for (int i =0 ; i<phrase.length() ; i++){
            c =(char)phrase.charAt(i);
            if(c == ' '){
                newString+=' ';
                continue;
            }
            c++;
            c++;
            newString+=++c;
        }
        phrasecrypt=newString;
    }
    public void Algorithm5(){
        String newString = "";
        char c;
        for (int i =0 ; i<phrase.length() ; i++){
            c =(char)phrase.charAt(i);
            if(c == ' '){
                newString+=' ';
                continue;
            }
            c--;
            c--;
            newString+=--c;
        }
        phrasecrypt=newString;
    }



}
