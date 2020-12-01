package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer media;
    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener listener =  new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                media.pause();
                media.seekTo(0);
            } else if (i == AudioManager.AUDIOFOCUS_GAIN) {
                media.start();
            } else if (i == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("әpә","father",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("әṭa","mother",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("angsi","son",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("taachi","old brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("chalitti","young brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("teṭe","old sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("kolliti","young sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("ama","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("paapa","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter itemAdapter = new WordAdapter(this,words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                int result = audioManager.requestAudioFocus(listener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    media = MediaPlayer.create(FamilyActivity.this,word.getAudioResourceID());
                    media.start();
                    media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }
                    });
                }}
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (media != null) {
            media.release();
            media = null;
            audioManager.abandonAudioFocus(listener);
        }
    }
}
