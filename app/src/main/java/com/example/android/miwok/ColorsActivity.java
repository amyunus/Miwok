package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        ArrayList<Word> enWarna = new ArrayList<>();
        enWarna.add(0, new Word("Red", "Merah"));
        enWarna.add(1, new Word("Green", "Hijau"));
        enWarna.add(2, new Word("Blue", "Biru"));
        enWarna.add(3, new Word("Orange", "Jingga"));
        enWarna.add(4, new Word("Black", "Hitam"));
        enWarna.add(5, new Word("White", "Putih"));
        enWarna.add(6, new Word("Purple", "Unggu"));
        enWarna.add(7, new Word("Yellow", "Kuning"));
        enWarna.add(8, new Word("Grey", "Abu-abu"));
        enWarna.add(9, new Word("Dark blue", "Biru tua"));
        enWarna.add(10, new Word("Reddish", "Kemerahan"));

        WordAdapter rootNumberView = new WordAdapter(this, R.layout.list_item, enWarna);
        ListView listView = (ListView) findViewById(R.id.wordListView);
        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
    }
}
