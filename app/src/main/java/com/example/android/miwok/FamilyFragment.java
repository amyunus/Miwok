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
public class FamilyFragment extends Fragment {

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

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_word_list, container, false);


        final ArrayList<Word> enFamily = new ArrayList<>();
        enFamily.add(0, new Word("Father", "Bapak", R.drawable.family_father, R.raw.family_father));
        enFamily.add(1, new Word("Mother", "Ibu", R.drawable.family_mother, R.raw.family_mother));
        enFamily.add(2, new Word("Uncle", "Paman", R.drawable.family_older_brother, R.raw.family_older_brother));
        enFamily.add(3, new Word("Aunt", "Bibi", R.drawable.family_older_sister, R.raw.family_older_sister));
        enFamily.add(4, new Word("Son", "Anak lelaki", R.drawable.family_son, R.raw.family_son));
        enFamily.add(5, new Word("Daughter", "Anak perempuan", R.drawable.family_daughter, R.raw.family_daughter));
        enFamily.add(6, new Word("Grandfather", "Kakek", R.drawable.family_grandfather, R.raw.family_grandfather));
        enFamily.add(7, new Word("Grandmother", "Nenek", R.drawable.family_grandmother, R.raw.family_grandmother));
        enFamily.add(8, new Word("Children", "Anak-anak", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        enFamily.add(9, new Word("Grandchildren", "Cucu-cucu", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        enFamily.add(10, new Word("Cousin", "Sepupu", R.drawable.family_younger_brother, R.raw.family_younger_brother));

        WordAdapter rootNumberView = new WordAdapter(getActivity(), R.layout.list_item, enFamily, R.color.category_family);
        ListView listView = (ListView) rootView.findViewById(R.id.wordListView);
        listView.setPadding(16, 16, 16, 16);
        listView.setAdapter(rootNumberView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = enFamily.get(i);
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
