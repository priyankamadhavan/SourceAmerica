package com.example.ic.motivateme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Level extends AppCompatActivity {
    public static int level;
    public static int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        int currentLevel = getLevel();
        TextView lLabel = (TextView) findViewById(R.id.levelLabel);
        lLabel.setText(currentLevel);

        int currentPoints = getLevel();
        TextView pLabel = (TextView) findViewById(R.id.levelLabel);
        pLabel.setText(currentPoints);

        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setProgress(currentPoints % 100);

    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int l) {
        level = l;
    }

    public static int getPoints() {
        return points;
    }

    public static void setPoints(int p) {points = points + p;
    }
}
