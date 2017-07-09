package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        ArrayList<Word> enNumbers = new ArrayList<>();
        enNumbers.add(0, new Word("Zero", "Nol", R.drawable.color_gray));
        enNumbers.add(1, new Word("One", "Satu", R.drawable.number_one));
        enNumbers.add(2, new Word("Two", "Dua", R.drawable.number_two));
        enNumbers.add(3, new Word("Three", "Tiga", R.drawable.number_three));
        enNumbers.add(4, new Word("Four", "Empat", R.drawable.number_four));
        enNumbers.add(5, new Word("Five", "Lima", R.drawable.number_five));
        enNumbers.add(6, new Word("Six", "Enam", R.drawable.number_six));
        enNumbers.add(7, new Word("Seven", "Tujuh", R.drawable.number_seven));
        enNumbers.add(8, new Word("Eight", "Delapan", R.drawable.number_eight));
        enNumbers.add(9, new Word("Nine", "Sembilan", R.drawable.number_nine));
        enNumbers.add(10, new Word("Ten", "Sepuluh", R.drawable.number_ten));

        WordAdapter rootNumberView = new WordAdapter(this, R.layout.list_item, enNumbers, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.wordListView);
        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
    }
}
