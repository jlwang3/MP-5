package com.example.mp_5;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creates a new game.
 */
public class GameActivity extends AppCompatActivity {
    /** The player's score */
    private int score;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        LinearLayout tiles = findViewById(R.id.tiles);
        tiles.removeAllViews();
        for (int i = 0; i < 5; i++) {
            // Inflate chunks
            View messageChunk = getLayoutInflater().inflate(R.layout.layout, tiles, false);

            // Find buttons and set their colors
            Button button2 = messageChunk.findViewById(R.id.button2);
            Button button3 = messageChunk.findViewById(R.id.button3);
            Button button4 = messageChunk.findViewById(R.id.button4);
            Button button1 = messageChunk.findViewById(R.id.button1);

            button1.setBackgroundColor(Color.WHITE);
            button2.setBackgroundColor(Color.WHITE);
            button3.setBackgroundColor(Color.WHITE);
            button4.setBackgroundColor(Color.WHITE);

            // Make one random tile black and implement click listeners
            int random = (int) ((Math.random() * (3)) + 1);
            if (random == 1) {
                button1.setBackgroundColor(Color.BLACK);
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
            } else if (random == 2) {
                button2.setBackgroundColor(Color.BLACK);
                button2.setOnClickListener(unused -> {
                    messageChunk.setVisibility(View.GONE);
                    score++;
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
                button3.setBackgroundColor(Color.BLACK);
                button3.setOnClickListener(unused -> {
                    messageChunk.setVisibility(View.GONE);
                    score++;
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
                button4.setBackgroundColor(Color.BLACK);
                button4.setOnClickListener(unused -> {
                    messageChunk.setVisibility(View.GONE);
                    score++;
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

            // Make sure everything is visible
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);

            // Finally, add the view
            tiles.addView(messageChunk);
        }

    }

    /**
     * Ends the game when a white tile is clicked.
     */
    public void endGame() {
        Intent intent = new Intent(this, EndGameActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }
}
