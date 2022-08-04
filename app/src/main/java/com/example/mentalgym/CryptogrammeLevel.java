package com.example.mentalgym;

public class CryptogrammeLevel {
    String Name;
    int image;

    public CryptogrammeLevel(String name, int image) {
        Name = name;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public int getImage() {
        return image;
    }
}
