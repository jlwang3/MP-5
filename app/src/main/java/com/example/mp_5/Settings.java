package com.example.mp_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    private int rows = 10;
    private int time = 10;

    protected void OnCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        // Clear view
        LinearLayout settings = findViewById(R.id.allSettings);
        settings.removeAllViews();

        // Get buttons and text
        Button rowsPlus = findViewById(R.id.rowsPlus);
        Button rowsMinus = findViewById(R.id.rowsMinus);
        TextView rowsText = findViewById(R.id.numRows);
        Button timePlus = findViewById(R.id.timePlus);
        Button timeMinus = findViewById(R.id.timeMinus);
        TextView timeText = findViewById(R.id.timeSet);
        Button done = findViewById(R.id.done);

        // Get previous settings
        Intent intent = getIntent();
        rows = intent.getIntExtra("rows", 10);
        time = intent.getIntExtra("time", 10);

        // Set time and rows
        rowsText.setText(rows);
        String setTime = time + "s";
        timeText.setText(setTime);

        // Set click listeners
        rowsPlus.setOnClickListener(v -> {
            changeRows(1);
            rowsText.setText(rows);
        });
        rowsMinus.setOnClickListener(v -> {
            changeRows(-1);
            rowsText.setText(rows);
        });
        timePlus.setOnClickListener(v -> {
            changeTime(5);
            timeText.setText(time + "s");
        });
        timeMinus.setOnClickListener(v -> {
            changeTime(-5);
            timeText.setText(time + "s");
        });
        done.setOnClickListener(v -> {
            saveSettings();
        });

        // Make all visible
        rowsPlus.setVisibility(View.VISIBLE);
        rowsMinus.setVisibility(View.VISIBLE);
        rowsText.setVisibility(View.VISIBLE);
        timePlus.setVisibility(View.VISIBLE);
        timeMinus.setVisibility(View.VISIBLE);
        timeText.setVisibility(View.VISIBLE);
        done.setVisibility(View.VISIBLE);
    }

    private void changeRows(int change) {
        rows += change;
    }

    private void changeTime(int change) {
        time += change;
    }

    public void saveSettings() {
        // Set and pass intent
        Intent intent = new Intent(this, NewGameActivity.class);
        intent.putExtra("rows", rows);
        intent.putExtra("time", time);
        startActivity(intent);
        finish();
    }
}