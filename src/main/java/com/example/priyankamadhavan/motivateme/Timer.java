package com.example.priyankamadhavan.motivateme;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class Timer extends AppCompatActivity implements TaskDialog.TaskDialogListener {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    public static long baseline = 600000;
    private String name;
    private static long time;
    private TextView textViewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");

        textViewTask = (TextView) findViewById(R.id.textViewTask);

        textViewTask.setText(Dropdown.getTask());
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
        time = SystemClock.elapsedRealtime() - chronometer.getBase();
        if (time < baseline) {
            Intent intent = new Intent(this, Success.class);
            startActivity(intent);

            Level.setPoints(10);
            if (Level.getPoints() % 100 == 0){
                Level.setLevel(Level.getLevel() + 1);
            }

            baseline = time;
        }
        else if (time >= baseline) {
            Intent intent = new Intent(this, Failure.class);
            startActivity(intent);
        }

    }

    public static long getTime() {
        return time;
    }

    public static double getBaseline() {
        return baseline;
    }



    @Override
    public void applyTexts(String task) {
        textViewTask.setText(task);
    }


}