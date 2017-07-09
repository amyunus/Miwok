package com.example.android.miwok;

/**
 * Created by amyunus on 6/30/17.
 */

public class Word {

    private String mEnWord;

    private String mMiwokWord;

    private int mImageWord;

    public Word(String enWord, String miwokWord){
        mEnWord = enWord;
        mMiwokWord = miwokWord;
    }

    public Word(String enWord, String miwokWord, int imageWord){
        mEnWord = enWord;
        mMiwokWord = miwokWord;
        mImageWord = imageWord;
    }

    public String getEnglishTranslation(){
        return mEnWord;
    }

    public String getMiwokTranslation(){
        return mMiwokWord;
    }

    public int getMiwokImage(){
        return mImageWord;
    }

}
