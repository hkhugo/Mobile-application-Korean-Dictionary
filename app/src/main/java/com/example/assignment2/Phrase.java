package com.example.assignment2;

import android.content.Context;

public class Phrase {
    public String englishText, koreanText, romanization, audioFileName;
    public int listIndex, itemIndex;
    public Context context;

    public Phrase(Context current, int listIndex, int itemIndex, String englishText, String koreanText, String romanization, String audioFileName) {
        context = current;
        this.listIndex = listIndex;
        this.itemIndex = itemIndex;
        this.englishText = englishText;
        this.koreanText = koreanText;
        this.romanization = romanization;
        this.audioFileName = audioFileName;
    }
}
