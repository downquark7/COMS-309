package com.example.create_user;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText User,Password;
    String url = "https://b2a7038d-a1ae-474c-acfc-166e6379474e.mock.pstmn.io/user";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        User = (EditText)findViewById(R.id.user_input);
        Password = (EditText)findViewById(R.id.password_input);

        builder = new AlertDialog.Builder(MainActivity.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String user,pass;
                user = User.getText().toString();
                pass = Password.getText().toString();
                StringRequest request = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                            builder.setTitle("Server Response");
                            builder.setMessage("Response : " + response);
                            builder.setPositiveButton("Good", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    User.setText("");
                                    Password.setText("");
                                }
                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String,String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("user", user);
                        params.put("pass", pass);
                        return params;
                    }

                };
                Other.getInstance(MainActivity.this).add_request(request);
            }
        });


    }
}