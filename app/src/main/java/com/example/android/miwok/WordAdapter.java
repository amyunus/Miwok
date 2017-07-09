package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amyunus on 6/30/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;

    public WordAdapter(Activity context, int resource, ArrayList<Word> words, int backgroundColor) {
        super(context, resource, words);
        mBackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView enWord = (TextView) listItemView.findViewById(R.id.english_text_view);
        enWord.setText(currentWord.getEnglishTranslation());
        enWord.setBackgroundResource(mBackgroundColor);

        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokWord.setText(currentWord.getMiwokTranslation());
        miwokWord.setBackgroundResource(mBackgroundColor);

        ImageView miwokImage = (ImageView) listItemView.findViewById(R.id.miwok_image_view);
        miwokImage.setImageResource(currentWord.getMiwokImage());

        ImageView playWord = (ImageView) listItemView.findViewById(R.id.play_text_view);
        playWord.setImageResource(R.drawable.ic_play_arrow_white_36dp);

/*
        final MediaPlayer mp = MediaPlayer.create(listItemView.getContext(), currentWord.getMiwokSound());
        playWord.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mp.start();
            }
        });
*/

        return listItemView;

    }
}
