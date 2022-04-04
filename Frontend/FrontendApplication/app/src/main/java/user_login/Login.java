package user_login;

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
import com.example.classdifficultyfrontend.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    private TextView TextResult;
    private RequestQueue queue;
    private String text;

    private EditText user;
    private EditText pass;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextResult = findViewById(R.id.textUser);
        Button button = findViewById(R.id.button);
        user = findViewById(R.id.Username_input);
        pass = findViewById(R.id.Pass_input);


        queue = Volley.newRequestQueue(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Userstr = user.getText().toString().trim();
                String Userpass = pass.getText().toString().trim();

                if (!Userstr.isEmpty() || !Userpass.isEmpty()) {
                    login(Userstr, Userpass);
                }
            }
        });
    }

        private void login(String User_passed, String Pass_passed) {
            RequestQueue queue = Volley.newRequestQueue(this);

            String url = "http://coms-309-032.class.las.iastate.edu:8080/user/create";

            String Userstr = user.getText().toString().trim();
            String Userpass = pass.getText().toString().trim();


            }
        }


