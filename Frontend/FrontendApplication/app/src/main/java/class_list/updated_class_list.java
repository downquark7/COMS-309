package class_list;


import static classController.ClassController.getByDepartment;

import androidx.appcompat.app.AppCompatActivity;
//import classController.ClassController;
//import departmentCodes.DepartmentCodes;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.classdifficultyfrontend.R;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import classController.ClassData;

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
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String t = choose.getSelectedItem().toString();

                List<ClassData> list = null;
                try {
                    list = getByDepartment(t);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                text.setText(Arrays.toString(list.toArray()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}