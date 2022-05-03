package com.example.classdifficultyfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

import home_page.HomePageActivity;
import user_data.UserPreferences;

/**
 * Main class for Login
 */
public class Login extends AppCompatActivity {

    private TextView TextResult;
    private RequestQueue queue;
    private String text;

    private EditText user;
    private EditText pass;

    /**
     * create main objects specified in XML
     * @param savedInstanceState objects here
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);


        TextResult = findViewById(R.id.out);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.User_create_button);
        user = findViewById(R.id.Username_input);
        pass = findViewById(R.id.Pass_input);


        queue = Volley.newRequestQueue(this);


        button.setOnClickListener(new View.OnClickListener() {
            /**
             * on click of button, attempt to log in
             * @param view view object
             */
            @Override
            public void onClick(View view) {
                String Userstr = user.getText().toString().trim();
                String Userpass = pass.getText().toString().trim();

                if (!Userstr.isEmpty() || !Userpass.isEmpty()) {
                    login();
                }
            }
        });
/**
 *  on click of button, attempt to go to new screen
 *  Output is new screen
 * @param view view object
 */
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, User_Create.class));
            }
        });
    }

    /**
     * Send data to server, verify user, login if matching with data in the back end.
     * use queue and RequestQueue object to send data (username, authMethod, authData)
     */
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
            /**
             * append username and other data to textview object to send to database
             * Uses queue to send appropiate data in the form of a server request
             * @param response string response
             */
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

                    //text = jsonObject.toString();
                    SharedPreferences userSettings = getApplicationContext().getSharedPreferences("UserData", MODE_PRIVATE);
                    SharedPreferences.Editor userEdit = userSettings.edit();
                    userEdit.putString(Userstr, "");
                    userEdit.apply();


//                     UserPreferences userPref = new UserPreferences(getApplicationContext());
//                    userPref.saveBody(Userstr);
                     Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                    // intent.putExtra("message_key", text);
                     startActivity(intent);

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
