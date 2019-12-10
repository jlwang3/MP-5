package com.example.mp_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creates an end game screen.
 */
public class EndGameActivity extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game_activity);

        // Win Condition
        if (GameActivity.isWin()) {
            TextView gameOver = findViewById(R.id.title);
            gameOver.setText("You Win!");
        }

        // Final Score
        TextView endScore = findViewById(R.id.score);
        String finalScore = "Score: " + GameActivity.getScore();
        endScore.setText(finalScore);

        // Play Again button
        Button playAgain = findViewById(R.id.new_game);
        playAgain.setOnClickListener(u -> {
            startActivity(new Intent(this, GameActivity.class));
            GameActivity.setWin(false);
            finish();
        });

        // Main Menu button
        Button mainMenu = findViewById(R.id.main_menu);
        mainMenu.setOnClickListener(u -> {
            startActivity(new Intent(this, NewGameActivity.class));
            finish();
        });

        endScore.setVisibility(View.VISIBLE);
        playAgain.setVisibility(View.VISIBLE);
        mainMenu.setVisibility(View.VISIBLE);
    }
}
