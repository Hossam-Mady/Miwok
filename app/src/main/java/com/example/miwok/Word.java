package com.example.miwok;

public class Word {
    private String miwokWord;
    private String englishWord;
    private int imageID = 0;
    private int audioResourceID;

    public Word(String miwokWord, String englishWord, int audioResourceID) {
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
        this.audioResourceID = audioResourceID;
    }

    public Word(String miwokWord, String englishWord, int imageID, int audioResourceID) {
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
        this.imageID = imageID;
        this.audioResourceID = audioResourceID;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public int getImageID() {
        return imageID;
    }

    public int getAudioResourceID() {
        return audioResourceID;
    }
}