package com.example.mp_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewGameActivity extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game_activity);
        Button createGame = findViewById(R.id.createGame);
        createGame.setOnClickListener(v -> {
            createGameClicked();
        });
    }
    public void createGameClicked() {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }
}
