package com.example.ic.motivateme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Dropdown extends AppCompatActivity implements TaskDialog.TaskDialogListener {
    private Button home;
    private Button start;
    private Button task;
    static String text;
    private ArrayList<String> list;
    static Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown);

        dropdown = (Spinner) findViewById(R.id.spinner);
        list = new ArrayList<>();
        list.add("table");
        list.add("window");
        list.add("water fountain");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text = dropdown.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        task = (Button) findViewById(R.id.newtask);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreen();
            }
        });

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimer();
            }
        });


    }

    public void openTimer() {
        Intent intent = new Intent(this, Timer.class);
        startActivity(intent);
    }

    public void openStartScreen() {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }

    public void openDialog() {
        TaskDialog taskDialog = new TaskDialog();
        taskDialog.show(getSupportFragmentManager(), "task dialog");
    }

    @Override
    public void applyTexts(String task) {
        list.add(task);
    }

    public static String getTask() {
        return text;
    }
}
