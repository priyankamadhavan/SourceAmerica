package com.example.priyankamadhavan.motivateme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {
    private Button start;
    private Button trophies;
    private Button instructions;
    private Button level;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        // Capture button clicks

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(StartScreen.this, Dropdown.class);
                startActivity(myIntent);
            }
        });

        trophies = (Button) findViewById(R.id.trophies);
        trophies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(StartScreen.this, Trophies.class);
                startActivity(myIntent);
            }
        });

        instructions = (Button) findViewById(R.id.instructions);
        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(StartScreen.this, Instructions.class);
                startActivity(myIntent);
            }
        });

        level = (Button) findViewById(R.id.level);
        level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(StartScreen.this, Level.class);
                startActivity(myIntent);
            }
        });


    }
}
