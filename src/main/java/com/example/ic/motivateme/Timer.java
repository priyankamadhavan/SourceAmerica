package com.example.ic.motivateme;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;

public class Timer extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    public double baseline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
    }

    public void startChronometer(View v){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running=true;
        }
    }

    public void pauseChronometer(View v){
        if(running){
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running=false;
        }
    }

    public void stopChronometer(View v){
        chronometer.stop();
        long time = SystemClock.elapsedRealtime() - chronometer.getBase();
        baseline = 10;
        if (time < baseline) {
            Intent intent = new Intent(this, Success.class);
            startActivity(intent);
            baseline = time;
            Level.setPoints(50);
            if (Level.getPoints() % 100 == 0){
                Level.setLevel(Level.getLevel() + 1);

            }
        }
        else if (time >= baseline) {
            Intent intent = new Intent(this, Failure.class);
            startActivity(intent);
        }

    }

}
