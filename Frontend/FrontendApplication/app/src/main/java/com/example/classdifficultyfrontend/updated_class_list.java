package com.example.classdifficultyfrontend;


import static classController.ClassController.getByDepartment;

import androidx.appcompat.app.AppCompatActivity;
//import classController.ClassController;
//import classController.DepartmentCodes;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import classController.ClassData;

/**
 * Main class for class list
 */
public class updated_class_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updated_class_list);

        TextView text = (TextView) findViewById(R.id.textView);
        Spinner choose = (Spinner) findViewById(R.id.spinner);

        choose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Thus method allows for the users to click on the department, then choose one, and display the data.
             * Receives class list object (by department). Outputs as text to screen
             * @param parent parent object
             * @param view view object
             * @param position  position
             * @param id id for class
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String t = choose.getSelectedItem().toString();

                List<ClassData> list = null;

                try {
                    list = getByDepartment(t);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        text.append("Class: " + list.get(i).toString().toLowerCase() + "\n");
                    }
                }
                else{
                    text.setText("stuff went wrong");
                }
               // text.setText(Arrays.toString(list.toArray()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}