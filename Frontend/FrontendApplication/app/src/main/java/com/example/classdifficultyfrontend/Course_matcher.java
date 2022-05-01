package com.example.classdifficultyfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Course_matcher extends AppCompatActivity {

    Spinner Spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_matcher);

        Spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.Classes_2, R.layout.spinner);

        adapter.setDropDownViewResource(R.layout.spinner);
        Spinner.setAdapter(adapter);
    }
}