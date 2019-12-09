package com.example.mp_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    private int rows = 10;
    private int time = 10;

    public void OnCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        // Get buttons and text
        Button rowsPlus = findViewById(R.id.rowsPlus);
        Button rowsMinus = findViewById(R.id.rowsMinus);
        TextView rowsText = findViewById(R.id.numRows);
        Button timePlus = findViewById(R.id.timePlus);
        Button timeMinus = findViewById(R.id.timeMinus);
        TextView timeText = findViewById(R.id.timeSet);
        Button done = findViewById(R.id.done);

        // Set default time and rows
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
            // Set and pass intent
            Intent intent = new Intent(this, NewGameActivity.class);
            intent.putExtra("rows", rows);
            intent.putExtra("time", time);
            startActivity(intent);
            finish();
        });
    }

    private void changeRows(int change) {
        rows += change;
    }

    private void changeTime(int change) {
        time += change;
    }
}