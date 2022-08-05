package com.example.mentalgym;

public class CryptogrammeAlgorithms {
    String phrase = "Hello world";
    String phrasecrypt ;
    public void Algorithm1(){
        String newString = "";
        char c;
        for (int i =0 ; i<phrase.length() ; i++){
            c =(char)phrase.charAt(i);
            newString+=++c;
        }

        phrasecrypt=newString;

    }

}
