package com.example.android.miwokapp;

public class Word {
    private String defaultTranslation , miwokTranslation;
    public String getDefaultTranslation(){
        return defaultTranslation;
    }
    public String getMiwokTranslation(){
        return miwokTranslation;
    }
    public Word(String defaultWord ,String miwokWord){
        this.defaultTranslation=defaultWord;
        this.miwokTranslation=miwokWord;
    }
}
