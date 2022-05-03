package com.example.classdifficultyfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import userController.User;
import userController.Schedule;
import userController.UserController;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Main class for profile
 */
public class profile_screen extends AppCompatActivity {
   private EditText email;
   private EditText phone;
   private TextView TextResult;
   private RequestQueue queue;

    /**
     * create objects specified in the XML, and on click of button, try to send data to database
     * @param savedInstanceState on click basically
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        Button button = findViewById(R.id.button);
        Spinner spin = findViewById(R.id.spinner);
        TextResult = findViewById(R.id.textUser);


        email = findViewById(R.id.Email);
        phone = findViewById(R.id.Phone);




        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
        R.array.Classes, R.layout.spinner_xml_layout);

        adapter.setDropDownViewResource(R.layout.spinner_xml_layout);
        spin.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
    }

    /**
     * Send data to the server via the url (email and phone number)
     * uses queue and Requestqueue object to send data (email and phone number)
     */
    private void sendData() {

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://coms-309-032.class.las.iastate.edu:8080/user/manage";

        String UserEmail = email.getText().toString().trim();
        String UserPhone = phone.getText().toString().trim();

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("Email", email);
            jsonBody.put("Phone Number", phone);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String requestBody = jsonBody.toString();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            /**
             * append number and email to textview object to send to database
             * adds to a queue (using the request object) to send ot database.
             * @param response string response
             */
            @Override
            public void onResponse(String response) {
                try {
                    TextResult.setText(response);
                    JSONObject jsonObject = new JSONObject(response);

                    TextResult.setText("Email: " + jsonObject.getString("Email"));
                    TextResult.append("\n");
                    TextResult.append("Phone number: " + jsonObject.getString("Phone Number"));

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
            /**
             * make sure correct object is sent
             * @return json object
             */
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