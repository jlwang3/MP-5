package com.example.mp_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndGameActivity extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.end_game_activity);
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        // Final Score
        TextView endScore = findViewById(R.id.score);
        String finalScore = "Score: " + score;
        endScore.setText(finalScore);

        // Play Again button
        Button playAgain = findViewById(R.id.new_game);
        playAgain.setOnClickListener(u -> {
            startActivity(new Intent(this, GameActivity.class));
        });

        // Main Menu button
        Button mainMenu = findViewById(R.id.main_menu);
        mainMenu.setOnClickListener(u -> {
            startActivity(new Intent(this, NewGameActivity.class));
        });
    }
}
