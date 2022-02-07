package com.example.re_do;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dec_Inc extends AppCompatActivity {

    private Button button;
    TextView Number;
    Button Inc, Dec;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_inc);

        Number = (TextView) findViewById(R.id.NumText);
        Inc = (Button) findViewById(R.id.IncID);
        Dec = (Button) findViewById(R.id.DecID);

        Inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                Number.setText(String.valueOf(count));
            }
        });



        Dec.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                count--;
                Number.setText(String.valueOf(count));
            }
        });

        button = (Button) findViewById(R.id.prev);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMain();
            }

            private void openMain() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    }

