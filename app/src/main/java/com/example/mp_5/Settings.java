package com.example.mp_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    int rows;
    int time;

    protected void onCreate(final Bundle savedInstanceState) {
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

        // Get previous settings
        rows = GameActivity.getRows();
        time = GameActivity.getTime();

        // Set time and rows
        System.out.println(rowsText == null);
        rowsText.setText(String.format("%s", rows));
        String setTime = time + "s";
        timeText.setText(setTime);

        // Set click listeners
        rowsPlus.setOnClickListener(v -> {
            changeRows(1);
            rowsText.setText(rows + "");
        });
        rowsMinus.setOnClickListener(v -> {
            changeRows(-1);
            rowsText.setText(rows + "");
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
        if (rows + change > 0) {
            rows += change;
        }
        GameActivity.setRows(rows);
    }

    private void changeTime(int change) {
        if (time + change > 0) {
            time += change;
        }
        GameActivity.setTime(time);
    }

    public void saveSettings() {
        // Set and pass intent
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);
        finish();
    }
}