package com.example.classdifficultyfrontend;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import userController.User;
import userController.Schedule;
import userController.UserController;

import androidx.appcompat.app.AppCompatActivity;

public class profile_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.profile_screen, R.layout.spinner_item);
//        spinner.setAdapter(adapter);


    }
}