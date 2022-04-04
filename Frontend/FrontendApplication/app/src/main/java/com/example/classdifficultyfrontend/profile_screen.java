package com.example.classdifficultyfrontend;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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

        Spinner spin = findViewById(R.id.spinner);



        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.Classes, R.layout.spinner_xml_layout);

        adapter.setDropDownViewResource(R.layout.spinner_xml_layout);
        spin.setAdapter(adapter);



    }
}