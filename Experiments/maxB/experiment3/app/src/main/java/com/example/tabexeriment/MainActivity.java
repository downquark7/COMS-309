package com.example.tabexeriment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabslayout;
    private ViewPager2 pager;
    private TabsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabsorganizer);

        tabsLayout = findViewById(R.id.globalTabsLayout);
        pager = findViewById(R.id.pager);
        adapter = new TabsAdapter(this);
        pager.setAdapter(adapter);
    }
}