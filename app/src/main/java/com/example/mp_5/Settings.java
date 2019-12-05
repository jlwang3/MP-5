package com.example.mp_5;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    public void OnCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Intent intent = new Intent(this, NewGameActivity.class);

    }
}
