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
        enWarna.add(0, new Word("Red", "Merah", R.drawable.color_red));
        enWarna.add(1, new Word("Green", "Hijau", R.drawable.color_green));
        enWarna.add(2, new Word("Brown", "Cokelat", R.drawable.color_black));
        enWarna.add(3, new Word("Orange", "Jingga", R.drawable.color_dusty_yellow));
        enWarna.add(4, new Word("Black", "Hitam", R.drawable.color_black));
        enWarna.add(5, new Word("White", "Putih", R.drawable.color_white));
        enWarna.add(6, new Word("Purple", "Unggu", R.drawable.color_white));
        enWarna.add(7, new Word("Yellow", "Kuning", R.drawable.color_mustard_yellow));
        enWarna.add(8, new Word("Grey", "Abu-abu", R.drawable.color_gray));
        enWarna.add(9, new Word("Dark blue", "Biru tua", R.drawable.color_red));
        enWarna.add(10, new Word("Reddish", "Kemerahan", R.drawable.color_red));

        WordAdapter rootNumberView = new WordAdapter(this, R.layout.list_item, enWarna, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.wordListView);

        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
    }
}
