package com.example.mp_5;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private int score;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        LinearLayout tiles = findViewById(R.id.tiles);
        tiles.removeAllViews();
        for (int i = 0; i < 7; i++) {
            View messageChunk = getLayoutInflater().inflate(R.layout.layout, tiles, false);
//            int random = (int) ((Math.random() * (3)) + 1);
//            if (random == 1) {
//                Button
//            }
            Button button1 = messageChunk.findViewById(R.id.button1);
//            final MediaPlayer mp = MediaPlayer.create(this, R.raw.sample);
            button1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            Button button2 = messageChunk.findViewById(R.id.button2);
            Button button3 = messageChunk.findViewById(R.id.button3);
            Button button4 = messageChunk.findViewById(R.id.button4);

            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);



        button1.setOnClickListener(unused -> {
                messageChunk.setVisibility(View.GONE);
                score++;
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

            tiles.addView(messageChunk);
        }
    }
    public void endGame() {
        Intent intent = new Intent(this, EndGameActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }
}
