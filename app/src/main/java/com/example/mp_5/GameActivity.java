package com.example.mp_5;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        for (int i = 0; i < 10; i++) {
            LinearLayout tiles = findViewById(R.id.tiles);
            final View messageChunk = getLayoutInflater().inflate(R.layout.layout, tiles, false);
            String random = "button" + Integer.toString((int) ((Math.random() * (3)) + 1));
            Button button = messageChunk.findViewById(R.id.random);
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.sample);
            button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            button.setOnClickListener(unused -> {
                messageChunk.setVisibility(0);
                mp.start();
            });
        }
    }
    public void endGame() {
        startActivity(new Intent(this, NewGameActivity.class));
        finish();
    }
}
