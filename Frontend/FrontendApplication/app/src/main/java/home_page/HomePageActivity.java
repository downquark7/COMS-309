package home_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.classdifficultyfrontend.*;

import user_data.UserPreferences;

public class HomePageActivity extends AppCompatActivity {
    private TextView testview;
    private UserPreferences userPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button button = findViewById(R.id.back);
//        SharedPreferences.Editor myEdit = getUserData.edit();
        SharedPreferences userSettings = getApplicationContext().getSharedPreferences("UserData", MODE_PRIVATE);
        String username = userSettings.getString("username", "oh no");

//        userPref = new UserPreferences(getApplicationContext());

        testview = (TextView) findViewById(R.id.testbox);
        testview.setText("The saved username is: " + username);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePageActivity.this, MainActivity.class));
            }
        });
    }
}