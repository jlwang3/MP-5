package com.example.mp_5;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private int score;
    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        sound1 = soundPool.load(this, R.raw.sound1, 1);
        sound2 = soundPool.load(this, R.raw.sound2, 1);
        sound3 = soundPool.load(this, R.raw.sound3, 1);
        sound4 = soundPool.load(this, R.raw.sound4, 1);

        LinearLayout tiles = findViewById(R.id.tiles);
        tiles.removeAllViews();
        for (int i = 0; i < 7; i++) {
            View messageChunk = getLayoutInflater().inflate(R.layout.layout, tiles, false);
            int random = (int) ((Math.random() * (3)) + 1);
            Button button2 = messageChunk.findViewById(R.id.button2);
            Button button3 = messageChunk.findViewById(R.id.button3);
            Button button4 = messageChunk.findViewById(R.id.button4);
            Button button1 = messageChunk.findViewById(R.id.button1);

            if (random == 1) {
                button1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                button1.setOnClickListener(unused -> {
                    messageChunk.setVisibility(View.GONE);
                    score++;
                    playSound(button1);
                });

                button2.setOnClickListener(unused -> {
                    endGame();
                });

                button3.setOnClickListener(unused -> {
                    endGame();
                });

                button4.setOnClickListener(unused -> {
                    endGame();
                });
            } else if (random == 2) {
                button2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                button2.setOnClickListener(unused -> {
                    messageChunk.setVisibility(View.GONE);
                    score++;
                    playSound(button2);
                });

                button1.setOnClickListener(unused -> {
                    endGame();
                });

                button3.setOnClickListener(unused -> {
                    endGame();
                });

                button4.setOnClickListener(unused -> {
                    endGame();
                });
            } else if (random == 3) {
                button3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                button3.setOnClickListener(unused -> {
                    messageChunk.setVisibility(View.GONE);
                    score++;
                    playSound(button3);
                });

                button2.setOnClickListener(unused -> {
                    endGame();
                });

                button1.setOnClickListener(unused -> {
                    endGame();
                });

                button4.setOnClickListener(unused -> {
                    endGame();
                });
            } else {
                button4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                button4.setOnClickListener(unused -> {
                    messageChunk.setVisibility(View.GONE);
                    score++;
                    playSound(button4);
                });

                button2.setOnClickListener(unused -> {
                    endGame();
                });

                button3.setOnClickListener(unused -> {
                    endGame();
                });

                button1.setOnClickListener(unused -> {
                    endGame();
                });
            }

            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);





            tiles.addView(messageChunk);
        }

    }

    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.button1:
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                break;
            case R.id.button2:
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
            case R.id.button3:
                soundPool.play(sound3, 1, 1, 0, 0, 1);
                break;
            case R.id.button4:
                soundPool.play(sound4, 1, 1, 0, 0, 1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }


    public void endGame() {
        Intent intent = new Intent(this, EndGameActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }
}