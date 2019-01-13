package com.example.priyankamadhavan.motivateme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Level extends AppCompatActivity {
    public static int level;
    public static int points;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreen();
            }
        });
    }

    public void openStartScreen(){
        Intent intent = new Intent (this,StartScreen.class);
        startActivity(intent);
    }

}
