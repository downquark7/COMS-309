package com.example.item_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
String classname;
String review;
Integer difficulty;

EditText classident;
EditText reviewident;
EditText diffident;


Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classident = (EditText) findViewById(R.id.classname);
        reviewident = (EditText) findViewById(R.id.review);
        diffident = (EditText) findViewById(R.id.difficulty);

        submitButton = (Button) findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classname = classident.getText().toString();
                review = classident.getText().toString();
                difficulty = Integer.valueOf(diffident.getText().toString());
            }
        });

    }
}