package com.example.priyankamadhavan.motivateme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Dropdown extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button home;
    private Button start;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tasks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

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

       /* ignore this omg showDialog = (Button) findViewById(R.id.newtask);
        showDialog.setOnClickListener(new View.OnClickListener(){
            public void onClick(View vv){
                final EditText input = new EditText(Dropdown.this);
                AlertDialog.Builder builder = new AlertDialog.Builder(Dropdown.this);
                View v = getLayoutInflater().inflate(R.layout.user_input, null);
                final EditText item = (EditText) v.findViewById(R.id.input);
                Button ok = (Button) v.findViewById(R.id.okay);

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.getText().toString().isEmpty()) {
                            Toast.makeText(Dropdown.this, "Please Fill in Field", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Dropdown.this, "Thank you", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

                builder.setView(v);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        */


    }

    public void openTimer(){
        Intent intent = new Intent (this,Timer.class);
        startActivity(intent);
    }

    public void openStartScreen(){
        Intent intent = new Intent (this,StartScreen.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}
