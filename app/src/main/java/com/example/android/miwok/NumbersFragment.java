package com.example.android.miwok;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.Context.AUDIO_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {


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

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_word_list, container, false);

        final ArrayList<Word> enNumbers = new ArrayList<>();

        enNumbers.add(0, new Word("Zero", "Nol", R.drawable.color_gray, R.raw.number_ten));
        enNumbers.add(1, new Word("One", "Satu", R.drawable.number_one, R.raw.number_one));
        enNumbers.add(2, new Word("Two", "Dua", R.drawable.number_two, R.raw.number_two));
        enNumbers.add(3, new Word("Three", "Tiga", R.drawable.number_three, R.raw.number_three));
        enNumbers.add(4, new Word("Four", "Empat", R.drawable.number_four, R.raw.number_four));
        enNumbers.add(5, new Word("Five", "Lima", R.drawable.number_five, R.raw.number_five));
        enNumbers.add(6, new Word("Six", "Enam", R.drawable.number_six, R.raw.number_six));
        enNumbers.add(7, new Word("Seven", "Tujuh", R.drawable.number_seven, R.raw.number_seven));
        enNumbers.add(8, new Word("Eight", "Delapan", R.drawable.number_eight, R.raw.number_eight));
        enNumbers.add(9, new Word("Nine", "Sembilan", R.drawable.number_nine, R.raw.number_nine));
        enNumbers.add(10, new Word("Ten", "Sepuluh", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter rootNumberView = new WordAdapter(getActivity(), R.layout.list_item, enNumbers, R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.wordListView);
        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = enNumbers.get(i);
                releaseMediaPlayer();

                audioManager = (AudioManager) getActivity().getSystemService(AUDIO_SERVICE);
                int requestAudioFocus = audioManager.requestAudioFocus(mAudioFocusListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (requestAudioFocus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), word.getMiwokSound());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            }

        });

        return rootView;

    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
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
