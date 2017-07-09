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
        enFamily.add(0, new Word("Father", "Bapak", R.drawable.family_father));
        enFamily.add(1, new Word("Mother", "Ibu", R.drawable.family_mother));
        enFamily.add(2, new Word("Uncle", "Paman", R.drawable.family_older_brother));
        enFamily.add(3, new Word("Aunt", "Bibi", R.drawable.family_older_sister));
        enFamily.add(4, new Word("Son", "Anak lelaki", R.drawable.family_son));
        enFamily.add(5, new Word("Daughter", "Anak perempuan", R.drawable.family_daughter));
        enFamily.add(6, new Word("Grandfather", "Kakek", R.drawable.family_grandfather));
        enFamily.add(7, new Word("Grandmother", "Nenek", R.drawable.family_grandmother));
        enFamily.add(8, new Word("Children", "Anak-anak", R.drawable.family_younger_brother));
        enFamily.add(9, new Word("Grandchildren", "Cucu-cucu", R.drawable.family_younger_sister));
        enFamily.add(10, new Word("Cousin", "Sepupu", R.drawable.family_younger_brother));

        WordAdapter rootNumberView = new WordAdapter(this, R.layout.list_item, enFamily, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.wordListView);
        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
    }
}
