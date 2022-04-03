package com.example.classdifficultyfrontend;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdifficultyfrontend.databinding.ActivityScheduleBinding;

import java.time.LocalTime;
import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {
    private TextView hourDayText;
    private RecyclerView hourRecyclerView;
   // private LocalTime selectedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        initWidgets();
        //selectedTime = LocalTime.now();
    }
    private void initWidgets(){
        hourRecyclerView = findViewById(R.id.schedule_hourRecyclerView);

    }
    private void setHourDayView(){
       ArrayList<String> hoursInDay = new ArrayList<>();
       for(int i = 7; i < 12; i++){
           hoursInDay.add(i + ":00");
       }
    }

   // private ArrayList<String>


}