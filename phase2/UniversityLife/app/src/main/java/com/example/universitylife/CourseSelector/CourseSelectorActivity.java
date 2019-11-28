package com.example.universitylife.CourseSelector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.universitylife.CourseSelector.ICourseSelector.*;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.LevelSelector.LevelSelectorActivity;
import com.example.universitylife.Profile.ProfileActivity;
import com.example.universitylife.R;
import com.example.universitylife.CharacterIcons;


public class CourseSelectorActivity extends AppCompatActivity implements ICourseSelectorView {

    static final String GAME1 = "GAME1";
    static final String GAME2 = "GAME2";
    static final String GAME3 = "GAME3";

    private CourseSelectorPresenter presenter;

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
        String username = (String) getIntent().getSerializableExtra("Username");

        // Create an instance of the CourseSelectorPresenter
        presenter = new CourseSelectorPresenter(this, new DataHandler(this), username);


    }


    /**
     * Executes when levelButton1 is clicked.
     */
    public void onClickCourse1 (View view) {
        presenter.validateCourse1();
    }

    /**
     * Executes when levelButton2 is clicked.
     */
    public void onClickCourse2(View view) {
        presenter.validateCourse2();
    }

    /**
     * Executes when levelButton3 is clicked.
     */
    public void onClickCourse3(View view) {
        presenter.validateCourse3();

    }

    /**
     * Executes when the profile button is clicked.
     */
    public void onProfileClick (View view) {
        navigateToProfile(presenter.getUsername());
    }

    public void onBackClick(View view) {
        finish();
    }


    /**
     * Navigate to the profile page of the user (with username "username")
     */
    public void navigateToProfile (String username) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Display "message" as a toast.
     */
    @Override
    public void displayWarning(String message) {
        Toast warning = Toast.makeText(this, message, Toast.LENGTH_LONG);
        warning.show();
    }

    /**
     * Navigate to Level 1 activity for user with "username".
     */
    @Override
    public void navigateToCourse1(String username) {
        Intent intent = new Intent(this, LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        intent.putExtra("GAME_NAME", GAME1);
        startActivity(intent);
    }

    /**
     * Navigate to Level 2 activity for user with "username".
     */
    @Override
    public void navigateToCourse2(String username) {
        Intent intent = new Intent(this, LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        intent.putExtra("GAME_NAME", GAME2);
        startActivity(intent);
    }

    /**
     * Navigate to Level 3 activity for user with "username".
     */
    @Override
    public void navigateToCourse3(String username) {
        Intent intent = new Intent(this, LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        intent.putExtra("GAME_NAME", GAME3);
        startActivity(intent);
    }
}
