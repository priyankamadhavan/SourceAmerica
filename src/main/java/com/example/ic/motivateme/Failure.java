package com.example.ic.motivateme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Failure extends AppCompatActivity {
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure);

        TextView label = (TextView) findViewById(R.id.taskLabel);
        label.setText("You didn't complete ___ under" + Timer.getBaseline() / 100 + " seconds" );

        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreen();
            }
        });
    }

    public void openStartScreen(){
        Intent intent = new Intent(this,StartScreen.class);
        startActivity(intent);
    }
}
