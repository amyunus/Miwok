package com.example.android.miwok;

/**
 * Created by amyunus on 6/30/17.
 */

public class Word {

    private String mEnWord;

    private String mMiwokWord;

    public Word(String enWord, String miwokWord){
        mEnWord = enWord;
        mMiwokWord = miwokWord;
    }

    public String getEnglishTranslation(){
        return mEnWord;
    }

    public String getMiwokTranslation(){
        return mMiwokWord;
    }

}
