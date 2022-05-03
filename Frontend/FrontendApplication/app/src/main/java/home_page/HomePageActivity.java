package home_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.classdifficultyfrontend.*;

public class HomePageActivity extends AppCompatActivity {
    private TextView testview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        SharedPreferences getUserData = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = getUserData.edit();
        String username = getUserData.getString("Username");
        testview = (TextView) findViewById(R.id.testbox);
        testview.setText("The saved username is: " + username);
    }
}