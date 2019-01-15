package com.example.ic.motivateme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Trophies extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophies);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreen();
            }
        });

        TextView one  = (TextView) findViewById(R.id.trophy1Label);
        one.setVisibility(View.INVISIBLE);

        TextView ten  = (TextView) findViewById(R.id.trophy10Label);
        ten.setVisibility(View.INVISIBLE);

        TextView two_five  = (TextView) findViewById(R.id.trophy25Label);
        two_five.setVisibility(View.INVISIBLE);

        TextView fifty  = (TextView) findViewById(R.id.trophy50Label);
        fifty.setVisibility(View.INVISIBLE);

        TextView seven_five  = (TextView) findViewById(R.id.trophy75Label);
        seven_five.setVisibility(View.INVISIBLE);

        TextView hundred  = (TextView) findViewById(R.id.trophy100Label);
        hundred.setVisibility(View.INVISIBLE);

        ImageView tOne = (ImageView) findViewById(R.id.trophy1);
        ImageView tTwo = (ImageView) findViewById(R.id.trophy2);
        ImageView tThree = (ImageView) findViewById(R.id.trophy3);
        ImageView tFour = (ImageView) findViewById(R.id.trophy4);
        ImageView tFive = (ImageView) findViewById(R.id.trophy5);
        ImageView tSix = (ImageView) findViewById(R.id.trophy6);

        if (Level.getLevel() == 1){
            one.setVisibility(View.VISIBLE);
            tOne.setImageResource(R.drawable.yellow_smiley_face);
        }
        else if (Level.getLevel() == 10){
            ten.setVisibility(View.VISIBLE);
            tTwo.setImageResource(R.drawable.yellow_smiley_face);
        }
        else if (Level.getLevel() == 25){
            two_five.setVisibility(View.VISIBLE);
            tThree.setImageResource(R.drawable.yellow_smiley_face);
        }
        else if (Level.getLevel() == 50){
            fifty.setVisibility(View.VISIBLE);
            tFour.setImageResource(R.drawable.yellow_smiley_face);
        }
        else if (Level.getLevel() == 75){
            seven_five.setVisibility(View.VISIBLE);
            tFive.setImageResource(R.drawable.yellow_smiley_face);
        }
        else if (Level.getLevel() == 100){
            hundred.setVisibility(View.VISIBLE);
            tSix.setImageResource(R.drawable.yellow_smiley_face);
        }

    }

    public void openStartScreen(){
        Intent intent = new Intent(this,StartScreen.class);
        startActivity(intent);
    }
}
