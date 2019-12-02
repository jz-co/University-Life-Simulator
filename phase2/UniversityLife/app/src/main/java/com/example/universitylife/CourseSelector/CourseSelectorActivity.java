package com.example.universitylife.CourseSelector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.universitylife.CourseSelector.ICourseSelector.*;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.LevelSelector.Game1LevelSelectorActivity;
import com.example.universitylife.LevelSelector.Game2LevelSelectorActivity;
import com.example.universitylife.LevelSelector.Game3LevelSelectorActivity;
import com.example.universitylife.R;


public class CourseSelectorActivity extends AppCompatActivity implements ICourseSelectorView {

    private CourseSelectorPresenter presenter;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_course_selector);


        // Get the username passed through from the last Activity
        username = (String) getIntent().getSerializableExtra("Username");

        // Create an instance of the CourseSelectorPresenter
        presenter = new CourseSelectorPresenter(username, new DataHandler(this));


    }

    public void onBackClick(View view) {
        finish();
    }


    /**
     * Display "message" as a toast.
     */
    public void displayWarning(String message) {
        Toast warning = Toast.makeText(this, message, Toast.LENGTH_LONG);
        warning.show();
    }

    /**
     * Navigate to Level 1 activity for user with "username".
     */
    public void navigateToCourse1(View view) {
        Intent intent = new Intent(this, Game1LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to Level 2 activity for user with "username".
     */
    public void navigateToCourse2(View view) {
        Intent intent = new Intent(this, Game2LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to Level 3 activity for user with "username".
     */
    public void navigateToCourse3(View view) {
        Intent intent = new Intent(this, Game3LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
}
