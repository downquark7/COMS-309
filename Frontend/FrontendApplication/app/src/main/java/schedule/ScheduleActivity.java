package schedule;
//import static classController.ClassController.ClassData;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdifficultyfrontend.*;

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
                if(((i + 1) / 8) + 7 > 12){
                    hoursInDayArray.add((((i+56) / 8) - 12) + ":00");//PM, putting pm in the
                }
                else
                    hoursInDayArray.add(((i+56) / 8) + ":00");//AM

            }
            else
            hoursInDayArray.add("-");
        }
        return hoursInDayArray;
    }
    private ArrayList<String> classlist(String scheduleID){//TODO temporary, for sake of testing
        ArrayList<String> classlist = new ArrayList<>();
        String classes[][] = {{"LEARNING TEAM", "S112"}, {"METEOROLOGY", "498"}, {"AEROSPACE ENGINEERING", "192"}};
        for(int i = 0; i < 3; i++){

        }
        return classlist;
    }


}