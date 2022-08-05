package com.example.mentalgym;

public class CryptogrammeLevel {
    String Name;
    String algorithm;
    int image;

    public String getAlgorithm() {
        return algorithm;
    }

    public CryptogrammeLevel(String name, int image , String algorithm) {
        Name = name;
        this.image = image;
        this.algorithm = algorithm;
    }

    public String getName() {
        return Name;
    }

    public int getImage() {
        return image;
    }
}
