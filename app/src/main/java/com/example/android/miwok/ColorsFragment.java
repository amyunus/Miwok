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
public class ColorsFragment extends Fragment {
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


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_word_list, container, false);

        final ArrayList<Word> enWarna = new ArrayList<>();
        enWarna.add(0, new Word("Red", "Merah", R.drawable.color_red, R.raw.color_red));
        enWarna.add(1, new Word("Green", "Hijau", R.drawable.color_green, R.raw.color_green));
        enWarna.add(2, new Word("Brown", "Cokelat", R.drawable.color_black, R.raw.color_black));
        enWarna.add(3, new Word("Orange", "Jingga", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        enWarna.add(4, new Word("Black", "Hitam", R.drawable.color_black, R.raw.color_black));
        enWarna.add(5, new Word("White", "Putih", R.drawable.color_white, R.raw.color_white));
        enWarna.add(6, new Word("Purple", "Unggu", R.drawable.color_white, R.raw.color_white));
        enWarna.add(7, new Word("Yellow", "Kuning", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        enWarna.add(8, new Word("Grey", "Abu-abu", R.drawable.color_gray, R.raw.color_gray));
        enWarna.add(9, new Word("Dark blue", "Biru tua", R.drawable.color_red, R.raw.color_red));
        enWarna.add(10, new Word("Reddish", "Kemerahan", R.drawable.color_red, R.raw.color_red));

        WordAdapter rootNumberView = new WordAdapter(getActivity(), R.layout.list_item, enWarna, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.wordListView);

        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = enWarna.get(i);
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
