package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        ArrayList<Word> enPhrase = new ArrayList<>();
        enPhrase.add(0, new Word("Good morning!", "Selamat pagi!"));
        enPhrase.add(1, new Word("Good afternoon!", "Selamat siang!"));
        enPhrase.add(2, new Word("Good evening!", "Selamat sore!"));
        enPhrase.add(3, new Word("Good night!", "Selamat malam!"));
        enPhrase.add(4, new Word("How are you?", "Bagaimana kabarmu?"));
        enPhrase.add(5, new Word("See you later", "Sampai jumpa"));
        enPhrase.add(6, new Word("Goodbye", "Selamat tinggal"));
        enPhrase.add(7, new Word("Nice to meet you", "Senang bertemu denganmu"));
        enPhrase.add(8, new Word("Let's go!", "Ayo berangkat!"));
        enPhrase.add(9, new Word("I am hungry", "Saya lapar"));
        enPhrase.add(10, new Word("I order fried rice, please", "Tolong, saya pesan nasi goreng"));

        WordAdapter rootNumberView = new WordAdapter(this, R.layout.list_item, enPhrase, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.wordListView);
        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
    }
}
