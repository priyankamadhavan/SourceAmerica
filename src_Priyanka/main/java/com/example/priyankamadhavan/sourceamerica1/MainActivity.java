package com.example.priyankamadhavan.sourceamerica1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent (MainActivity.this, Dropdown.class);
                startActivity(homeIntent);
                finish();
            }

        },SPLASH_TIME_OUT);
    }

    /* <TextView
        android:layout_width="match_parent"
        android:text="Second / Loading Screen Started"
        android:textSize="30sp"
        android:gravity="center"
        android:layout_height="match_parent" />

        for activity_main if adding loading screen -- must integrate

     */

}
