package com.example.ic.motivateme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Level extends AppCompatActivity {
    public static int level = 0;
    public static int points = 0;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        int currentLevel = getLevel();
        TextView lLabel = (TextView) findViewById(R.id.levelVar);
        lLabel.setText(currentLevel +"");

        int currentPoints = getPoints();
        TextView pLabel1 = (TextView) findViewById(R.id.currentPointsVar);
        pLabel1.setText(currentPoints+"");

        int pointsLeft = 100 - (currentPoints % 100);
        TextView pLabel2 = (TextView) findViewById(R.id.leftPointsVar);
        pLabel2.setText(pointsLeft +"");

        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setProgress(currentPoints % 100);

        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreen();
            }
        });



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

    public static void setPoints(int p) {
        points = points + p;
    }


    public void openStartScreen(){
        Intent intent = new Intent (this,StartScreen.class);
        startActivity(intent);
    }
}

