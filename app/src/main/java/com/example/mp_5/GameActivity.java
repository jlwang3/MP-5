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
            Button button1 = messageChunk.findViewById(R.id.button1);
            Button button2 = messageChunk.findViewById(R.id.button2);
            Button button3 = messageChunk.findViewById(R.id.button3);
            Button button4 = messageChunk.findViewById(R.id.button4);
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.sample);
            button1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            button1.setOnClickListener(unused -> {
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
