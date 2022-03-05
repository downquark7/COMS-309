package com.example.classdifficultyfrontend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private RecyclerView classList;
    //JSONPlaceholder jsonPlaceholder;
    private TabLayout tabsLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_item_list);

        //classList = findViewById(R.id.recy)
    }
}