package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        ArrayList<Word> enFamily = new ArrayList<>();
        enFamily.add(0, new Word("Father", "Bapak"));
        enFamily.add(1, new Word("Mother", "Ibu"));
        enFamily.add(2, new Word("Uncle", "Paman"));
        enFamily.add(3, new Word("Aunt", "Bibi"));
        enFamily.add(4, new Word("Son", "Anak lelaki"));
        enFamily.add(5, new Word("Daughter", "Anak perempuan"));
        enFamily.add(6, new Word("Grandfather", "Kakek"));
        enFamily.add(7, new Word("Grandmother", "Nenek"));
        enFamily.add(8, new Word("Children", "Anak-anak"));
        enFamily.add(9, new Word("Grandchildren", "Cucu-cucu"));
        enFamily.add(10, new Word("Cousin", "Sepupu"));

        WordAdapter rootNumberView = new WordAdapter(this, R.layout.list_item, enFamily);
        ListView listView = (ListView) findViewById(R.id.wordListView);
        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
    }
}
