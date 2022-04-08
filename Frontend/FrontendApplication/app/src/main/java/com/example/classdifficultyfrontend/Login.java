package com.example.classdifficultyfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    private TextView TextResult;
    private RequestQueue queue;
    private String text;

    private EditText user;
    private EditText pass;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);


        TextResult = findViewById(R.id.textUser);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.User_create_button);
        user = findViewById(R.id.Username_input);
        pass = findViewById(R.id.Pass_input);


        queue = Volley.newRequestQueue(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Userstr = user.getText().toString().trim();
                String Userpass = pass.getText().toString().trim();

                if (!Userstr.isEmpty() || !Userpass.isEmpty()) {
                    login();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, User_Create.class));
            }
        });
    }

    private void login() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://coms-309-032.class.las.iastate.edu:8080/user/login";

        String Userstr = user.getText().toString().trim();
        String Userpass = pass.getText().toString().trim();

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("username", Userstr);
            jsonBody.put("authenticationMethod", Userpass);
            jsonBody.put("authenticationData", Userpass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String requestBody = jsonBody.toString();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    TextResult.setText(response);
                    JSONObject jsonObject = new JSONObject(response);

                    TextResult.setText("Username: " + jsonObject.getString("username"));
                    TextResult.append("\n");
                    TextResult.append("Authentication Method: " + jsonObject.getString("authenticationMethod"));
                    TextResult.append("\n");
                    TextResult.append("Authentication Data: " + jsonObject.getString("authenticationData"));

                    text = jsonObject.toString();
                    // Intent intent = new Intent(getApplicationContext(), Default_Screen.class);
                    // intent.putExtra("message_key", text);
                    // startActivity(intent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TextResult.setText(error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return requestBody.getBytes();
            }
        };
        queue.add(request);

    }
}
