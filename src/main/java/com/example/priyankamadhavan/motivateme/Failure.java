package com.example.priyankamadhavan.motivateme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Failure extends AppCompatActivity {
    private Button home;
    private Button back;
    private TextView textViewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure);

        textViewTask = (TextView) findViewById(R.id.task);

        textViewTask.setText(Dropdown.getTask().toString());

        TextView time = (TextView) findViewById(R.id.time);
        double currentTime = Timer.getBaseline() / 1000;
        if (currentTime > 60){
            time.setText("under " + (int) currentTime / 60 + " minutes and " + currentTime % 60 + " seconds");
        }
        else{
            time.setText("under " + currentTime + " seconds" );
        }




        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreen();
            }
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDropdown();
            }
        });
    }

    public void openStartScreen(){
        Intent intent = new Intent(this,StartScreen.class);
        startActivity(intent);
    }

    public void openDropdown(){
        Intent intent = new Intent(this,Dropdown.class);
        startActivity(intent);
    }
}