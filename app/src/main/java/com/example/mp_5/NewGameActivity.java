package com.example.mp_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creates the title screen.
 */
public class NewGameActivity extends AppCompatActivity {
    int rows = 10;
    int time = 10;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game_activity);

        Intent intent = getIntent();
        rows = intent.getIntExtra("rows", 0);
        time = intent.getIntExtra("time", 0);

        // Create game button
        Button createGame = findViewById(R.id.createGame);
        createGame.setOnClickListener(v -> {
            createGameClicked();
        });

        // Go to settings page
        Button settings = findViewById(R.id.settings);
        settings.setOnClickListener(v -> {
            settings();
        });
    }

    /**
     * Creates a new game through GameActivity class.
     */
    public void createGameClicked() {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("rows", rows);
        intent.putExtra("time", time);
        startActivity(intent);
        finish();
    }

    /**
     * Goes to settings page.
     */
    public void settings() {
        Intent intent = new Intent(this, Settings.class);
        intent.putExtra("rows", rows);
        intent.putExtra("time", time);
        startActivity(intent);
        finish();
    }
}
