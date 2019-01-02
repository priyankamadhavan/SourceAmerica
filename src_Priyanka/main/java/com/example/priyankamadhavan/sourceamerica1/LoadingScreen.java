package com.example.priyankamadhavan.sourceamerica1;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class LoadingScreen extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

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
        /*add in the new screen to the success or failure like this
        public void run(){
                Intent homeIntent = new Intent (MainActivity.this, LoadingScreen.class);
                startActivity(homeIntent);
                finish();
            }
       */
    }
}
