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
import com.example.universitylife.Game1.Game1Lvl1Activity;
import com.example.universitylife.Game2.Game2Lvl1Activity;
import com.example.universitylife.Game3.Game3StartActivity;
import com.example.universitylife.Profile.ProfileActivity;
import com.example.universitylife.R;
import com.example.universitylife.CharacterIcons;


public class CourseSelectorActivity extends AppCompatActivity implements ICourseSelectorView {

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


        // Set reference to the profileButton in layout
        // Set its image to the user's character icon
        ImageButton profileButton = findViewById(R.id.profileButton);

        CharacterIcons icons = new CharacterIcons(this);
        int picIndex = presenter.getPicIndex();
        int picIdentifier = icons.getIconByIndex(picIndex);
        profileButton.setImageResource(picIdentifier);
    }


    /**
     * Executes when levelButton1 is clicked.
     */
    public void onLevel1Click (View view) {
        presenter.validateLevel1();
    }

    /**
     * Executes when levelButton2 is clicked.
     */
    public void onLevel2Click (View view) {
        presenter.validateLevel2();
    }

    /**
     * Executes when levelButton3 is clicked.
     */
    public void onLevel3Click (View view) {
        presenter.validateLevel3();

    }

    /**
     * Executes when the profile button is clicked.
     */
    public void onProfileClick (View view) {
        navigateToProfile(presenter.getUsername());
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
    public void goToLevel1(String username) {
        Intent intent = new Intent(this, Game1Lvl1Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to Level 2 activity for user with "username".
     */
    @Override
    public void goToLevel2(String username) {
        Intent intent = new Intent(this, Game2Lvl1Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to Level 3 activity for user with "username".
     */
    @Override
    public void goToLevel3(String username) {
        Intent intent = new Intent(this, Game3StartActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
}
