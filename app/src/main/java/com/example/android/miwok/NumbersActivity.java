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
        enNumbers.add(0, new Word("Zero", "Nol"));
        enNumbers.add(1, new Word("One", "Satu"));
        enNumbers.add(2, new Word("Two", "Dua"));
        enNumbers.add(3, new Word("Three", "Tiga"));
        enNumbers.add(4, new Word("Four", "Empat"));
        enNumbers.add(5, new Word("Five", "Lima"));
        enNumbers.add(6, new Word("Six", "Enam"));
        enNumbers.add(7, new Word("Seven", "Tujuh"));
        enNumbers.add(8, new Word("Eight", "Delapan"));
        enNumbers.add(9, new Word("Nine", "Sembilan"));
        enNumbers.add(10, new Word("Ten", "Sepuluh"));

        WordAdapter rootNumberView = new WordAdapter(this, R.layout.list_item, enNumbers);
        ListView listView = (ListView) findViewById(R.id.wordListView);
        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
    }
}
