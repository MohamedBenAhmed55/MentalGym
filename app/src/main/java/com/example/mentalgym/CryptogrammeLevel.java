package com.example.mentalgym;

public class CryptogrammeLevel {
    String Name;
    String algorithm;
    String hint;
    String phrase;
    Boolean canPlay;
    int image;

    public CryptogrammeLevel(String name, int image , String algorithm , String phrase , Boolean canPlay , String hint) {
        Name = name;
        this.image = image;
        this.algorithm = algorithm;
        this.phrase=phrase;
        this.canPlay= canPlay;
        this.hint= hint;
    }
    public Boolean getCanPlay() {
        return canPlay;
    }
    public String getName() {
        return Name;
    }
    public String getHint() {return hint;}
    public int getImage() {
        return image;
    }
    public String getAlgorithm() {
        return algorithm;
    }
    public String getPhrase() {
        return phrase;
    }
}
