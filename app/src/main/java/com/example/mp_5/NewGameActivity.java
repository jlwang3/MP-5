package com.example.mp_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creates the title screen.
 */
public class NewGameActivity extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game_activity);

        // Create game button
        Button createGame = findViewById(R.id.createGame);
        createGame.setOnClickListener(v -> {
            createGameClicked();
        });
    }

    /**
     * Creates a new game through GameActivity class.
     */
    public void createGameClicked() {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }
}
