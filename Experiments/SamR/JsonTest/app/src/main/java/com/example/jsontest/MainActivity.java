package com.example.jsontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
private TextView TextResult;
private RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextResult = findViewById(R.id.text_view_result);
        Button button = findViewById(R.id.button_parse);

        queue = Volley.newRequestQueue(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
            }
        });
    }


    private void jsonParse(){
        String url = "https://myjson.dit.upm.es/api/bins/5jn9";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("Login");
                        for(int i =0; i< jsonArray.length(); i++){
                            JSONObject User = jsonArray.getJSONObject(i);

                            String username = User.getString("Username");
                            String password = User.getString("password");
                            int id = User.getInt("id");

                            TextResult.append(username + ", " + password + ", " + String.valueOf(id) + "\n\n");
                        }
                    } catch(JSONException e){
                        e.printStackTrace();
                    }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
        error.printStackTrace();
            }

        });
        queue.add(request);
    }
}