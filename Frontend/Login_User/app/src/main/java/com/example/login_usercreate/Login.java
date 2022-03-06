package com.example.login_usercreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView TextResult;
    private RequestQueue queue;
    private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  TextResult = findViewById(R.id.text_view_result);
        Button button = findViewById(R.id.button_parse);

        //Button get_request_button=findViewById(R.id.button_parse);
        TextResult = findViewById(R.id.text_view_result);

        // queue = Volley.newRequestQueue(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRequest();
            }
        });
    }


    private void getRequest() {
        RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
        String url="http://coms-309-032.class.las.iastate.edu:8080/classes/MUSIC";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                TextResult.setText(response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject =(jsonArray.getJSONObject(0));
                    TextResult.setText("ID :"+jsonObject.getString("id"));
                    TextResult.append("\n");
                    TextResult.append("Semester Code :"+jsonObject.getString("semesterCode"));
                    TextResult.append("\n");
                    TextResult.append("Semester Year :"+jsonObject.getString("semesterYear"));
                    TextResult.append("\n");
                    TextResult.append("Department Code :"+jsonObject.getString("deptCode"));
                    TextResult.append("\n");
                    TextResult.append("Class Number :"+jsonObject.getString("classNumber"));

                    text = jsonObject.toString();
                    Intent intent = new Intent(getApplicationContext(), Second.class);
                    intent.putExtra("message_key", text);
                    startActivity(intent);
                }
                catch (Exception e){
                    e.printStackTrace();
                    TextResult.setText("Failed to get Data");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TextResult.setText(error.toString());
            }
        });

        queue.add(stringRequest);
    }
}
