package com.example.classdifficultyfrontend;
//import static classController.ClassController.ClassData;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import schedule.ScheduleAdapter;

public class ScheduleActivity extends AppCompatActivity implements ScheduleAdapter.OnItemListener{ // a lot of this code is based on the example given in this youtube tutorial: https://www.youtube.com/watch?v=Ba0Q-cK1fJo&ab_channel=CodeWithCal
    private TextView hourDayText;
    private RecyclerView hourRecyclerView;
   // private LocalTime selectedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        initWidgets();
        //selectedTime = LocalTime.now();
        setHourDayView();
    }
    private void initWidgets(){
        hourRecyclerView = findViewById(R.id.schedule_hourRecyclerView);
        //hourDayText = findViewById(R.id.)
    }
    private void setHourDayView(){
        ArrayList<String> hoursInDay = hoursInDayArray();
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(hoursInDay, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 8);
        hourRecyclerView.setLayoutManager(layoutManager);
        hourRecyclerView.setAdapter(scheduleAdapter);
    }


    @Override
    public void onItemClick(int position, String hourText) {
        if(!hourText.equals("")){
            String message = "Selected Time " + hourText + " ";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
    private ArrayList<String> hoursInDayArray(){
        ArrayList<String> hoursInDayArray = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            if(i % 8 == 0){
                if(i == 40)
                    hoursInDayArray.add("1:00");
                else
                hoursInDayArray.add(((((i+1)/8)+ 8)% 13)+":00");//TODO There is a bug here, it is showing 1:00 twice
            }
            else
            hoursInDayArray.add("-");
        }
        return hoursInDayArray;
    }
    private ArrayList<String> classlist(String scheduleID){//TODO temporary, for sake of demo
        ArrayList<String> classlist = new ArrayList<>();
        String classes[][] = {{"L TM", "S112"}, {"MTEOR", "498"}, {"AER E", "192"}};
        for(int i = 0; i < 3; i++){

        }
        return classlist;
    }


}