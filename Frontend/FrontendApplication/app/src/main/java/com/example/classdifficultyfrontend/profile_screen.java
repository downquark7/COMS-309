package com.example.classdifficultyfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import userController.User;
import userController.Schedule;
import userController.UserController;

import androidx.appcompat.app.AppCompatActivity;

public class profile_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        Button button = findViewById(R.id.button);
        Spinner spin = findViewById(R.id.spinner);




        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.Classes, R.layout.spinner_xml_layout);

        adapter.setDropDownViewResource(R.layout.spinner_xml_layout);
        spin.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
    }

    private void sendData() {
        
    }
}