package com.example.jsontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView TextResult;
    private RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String authenticationMethod;

        TextResult = findViewById(R.id.text_view_result);
        Button button = findViewById(R.id.button_parse);

        queue = Volley.newRequestQueue(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
//            public void onClick(View view) {
//                jsonParse();
//            }
            public void onClick(View view) {
                send_data(this);
            }
        });
    }

    private void send_data(Context context, final username, final authenticationMethod, final authenticationData) {
        username;
        Send_DataResponse().requestStarted();
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.POST, "http://api.someservice.com/post/comment", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Send_DataResponse.requestCompleted();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Send_DataResponse.requestEndedWithError(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> param = new Hashmap<String, String>();
                param.put("username", username);
                param.put("authenticationMethod", authenticationMethod);
                param.put("authenticationData", authenticationData);
                return param;


            }

            @Override
            public Map<String, String> getHeader() throws AuthFailureError {
                Map<String, String> param = new Hashmap<String, String>();
                param.put("Content-Type", "application/x-www-form-urlencoded");
                return param;
            }
        };
        queue.add(sr);

    }

    public interface Send_DataListener{
        public void requestStarted();
        public void requestCompleted();
        public void requestEndedWithError(VolleyError error);


    }


//    private void jsonParse(){
//        String url = "http://myjson.dit.upm.es/api/bins/j1r9";
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("Login");
//                            for(int i =0; i< jsonArray.length(); i++){
//                                JSONObject User = jsonArray.getJSONObject(i);
//
//                                String username = User.getString("Username");
//                                String password = User.getString("password");
//                                int id = User.getInt("id");
//
//                                TextResult.append(username + ", " + password + ", " + String.valueOf(id) + "\n\n");
//                            }
//                        } catch(JSONException e){
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error){
//                error.printStackTrace();
//            }
//
//        });
//        queue.add(request);
//    }


}
