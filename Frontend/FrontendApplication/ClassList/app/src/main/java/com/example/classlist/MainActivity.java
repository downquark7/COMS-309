package com.example.classlist;

import static com.example.classlist.ClassController.getByDepartment;
import static com.example.classlist.ClassController.getAClass;

import androidx.appcompat.app.AppCompatActivity;
//import classController.ClassController;
//import departmentCodes.DepartmentCodes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.textView);
        Spinner choose = (Spinner) findViewById(R.id.spinner);
        int i = 0;

        choose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String t = choose.getSelectedItem().toString();

                List<ClassData> list = null;
                try {
                    list = getByDepartment (t);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                text.setText(list.getAclass(list,0));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
