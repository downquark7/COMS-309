package com.example.classdifficultyfrontend;

import androidx.appcompat.app.AppCompatActivity;


//import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import home_page.HomePageActivity;
import schedule.ScheduleActivity;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabsLayout;
    private ViewPager2 pager;
    private TabsAdapter adapter;
    private Button scheduleButton, loginButton, classListButton, usercreate, profile, homePageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //setContentView(R.layout.tabsorganizer);

        scheduleButton = (Button) findViewById(R.id.button_go_to_scheduler);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScheduleActivity.class));
            }
        });
        loginButton = (Button) findViewById(R.id.button_go_to_login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
        classListButton = (Button) findViewById(R.id.button_go_to_classlist);
        classListButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, updated_class_list.class));
            }
        });
        usercreate = (Button) findViewById(R.id.button_go_to_user_create);
        usercreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, User_Create.class));
            }
        });
        profile = (Button) findViewById(R.id.button_go_to_profile);
        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, profile_screen.class));
            }
        });
        homePageButton = (Button) findViewById(R.id.button_go_to_home_page);
        homePageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, HomePageActivity.class));
            }
        });
//        tabsLayout = findViewById(R.id.globalTabsLayout);
//        pager = findViewById(R.id.pager);
//        adapter = new TabsAdapter(this);
//        pager.setAdapter(adapter);
//
//        new TabLayoutMediator(tabsLayout, pager, (tab, position) -> {
//            if (position == 0) tab.setText("Classes");
//            else if (position == 1) tab.setText("Favourites");
////            else tab.setText("Settings");
//        }).attach();
    }
}