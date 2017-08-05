package com.example.android.miwok;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PhrasesFragment())
                .commit();
    }
}
/*
package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    AudioManager audioManager;

    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    AudioManager.OnAudioFocusChangeListener mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {

                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
                    break;

                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    break;

                case AudioManager.AUDIOFOCUS_GAIN:
                    mediaPlayer.start();
                    break;

                default:
                    releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        final ArrayList<Word> enPhrase = new ArrayList<>();
        enPhrase.add(0, new Word("Good morning!", "Selamat pagi!", R.raw.phrase_are_you_coming));
        enPhrase.add(1, new Word("Good afternoon!", "Selamat siang!", R.raw.phrase_come_here));
        enPhrase.add(2, new Word("Good evening!", "Selamat sore!", R.raw.phrase_how_are_you_feeling));
        enPhrase.add(3, new Word("Good night!", "Selamat malam!", R.raw.phrase_im_coming));
        enPhrase.add(4, new Word("How are you?", "Bagaimana kabarmu?", R.raw.phrase_im_feeling_good));
        enPhrase.add(5, new Word("See you later", "Sampai jumpa", R.raw.phrase_lets_go));
        enPhrase.add(6, new Word("Goodbye", "Selamat tinggal", R.raw.phrase_my_name_is));
        enPhrase.add(7, new Word("Nice to meet you", "Senang bertemu denganmu", R.raw.phrase_what_is_your_name));
        enPhrase.add(8, new Word("Let's go!", "Ayo berangkat!", R.raw.phrase_where_are_you_going));
        enPhrase.add(9, new Word("I am hungry", "Saya lapar", R.raw.phrase_yes_im_coming));
        enPhrase.add(10, new Word("I order fried rice, please", "Tolong, saya pesan nasi goreng", R.raw.phrase_are_you_coming));

        WordAdapter rootNumberView = new WordAdapter(this, R.layout.list_item, enPhrase, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.wordListView);
        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = enPhrase.get(i);
                releaseMediaPlayer();
                audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                int requestAudioFocus = audioManager.requestAudioFocus(mAudioFocusListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (requestAudioFocus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getMiwokSound());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    */
/**
     * Clean up the media player by releasing its resources.
     *//*

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            audioManager.abandonAudioFocus(mAudioFocusListener);
        }
    }
}
*/
