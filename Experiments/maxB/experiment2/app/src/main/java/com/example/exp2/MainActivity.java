package com.example.exp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button countButton = findViewById(R.id.button1);

        countButton.setOnClickListener(new view.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(v.getContext(), Counter.class));
            }
        });
    }
}