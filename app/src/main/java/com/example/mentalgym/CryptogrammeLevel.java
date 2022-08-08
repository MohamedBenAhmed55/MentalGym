package com.example.mentalgym;

public class CryptogrammeLevel {
    String Name;
    String algorithm;
    String phrase;
    int image;


    public String getAlgorithm() {
        return algorithm;
    }

    public String getPhrase() {
        return phrase;
    }

    public CryptogrammeLevel(String name, int image , String algorithm , String phrase) {
        Name = name;
        this.image = image;
        this.algorithm = algorithm;
        this.phrase=phrase;
    }

    public String getName() {
        return Name;
    }

    public int getImage() {
        return image;
    }
}
