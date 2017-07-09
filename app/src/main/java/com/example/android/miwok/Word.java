package com.example.android.miwok;

/**
 * Created by amyunus on 6/30/17.
 */

public class Word {

    private String mEnWord;

    private String mMiwokWord;

    private int mImageWord;

    private int mVoice;

    public Word(String enWord, String miwokWord, int miwokVoice) {
        mEnWord = enWord;
        mMiwokWord = miwokWord;
        mVoice = miwokVoice;
    }

    public Word(String enWord, String miwokWord, int imageWord, int miwokVoice) {
        mEnWord = enWord;
        mMiwokWord = miwokWord;
        mImageWord = imageWord;
        mVoice = miwokVoice;
    }

    public String getEnglishTranslation() {
        return mEnWord;
    }

    public String getMiwokTranslation() {
        return mMiwokWord;
    }

    public int getMiwokImage() {
        return mImageWord;
    }

    public int getMiwokSound() {
        return mVoice;
    }

    /**
     * Returns the string representation of the {@link Word} object.
     */
    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mEnWord + '\'' +
                ", mMiwokTranslation='" + mMiwokWord + '\'' +
                ", mAudioResourceId=" + mImageWord +
                ", mImageResourceId=" + mVoice +
                '}';
    }
}
