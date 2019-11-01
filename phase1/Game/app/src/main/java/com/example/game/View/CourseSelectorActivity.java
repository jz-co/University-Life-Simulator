package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.game.Contract.ICourseSelector.*;
import com.example.game.DataHandler.DataHandler;
import com.example.game.Presenter.CourseSelectorPresenter;
import com.example.game.R;

import java.util.ArrayList;


public class CourseSelectorActivity extends AppCompatActivity implements ICourseSelectorView {

    private CourseSelectorPresenter presenter;
    private ArrayList<Integer> characterIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_selector);

        // Get the username passed through from the last Activity
        String username = (String) getIntent().getSerializableExtra("Username");

        // Create the list of character icons
        characterIcons = new ArrayList<Integer>();
        populateCharacterIcons();

        // Create an instance of the CourseSelectorPresenter
        presenter = new CourseSelectorPresenter(this, new DataHandler(this), username);

        // Set reference to the profileButton in layout
        // Set its image to the user's character icon
        ImageButton profileButton = (ImageButton) findViewById(R.id.profileButton);
        int index = presenter.getPicIndex();
        profileButton.setImageResource(characterIcons.get(index));
    }


    /**
     * Add identifiers for all character icon files to the characterIcons list.
     */
    private void populateCharacterIcons() {
        characterIcons.add(getResources().getIdentifier("@drawable/boy1", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/girl1", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/boy2", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/girl2", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/boy3", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/girl3", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/pikachu", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/cactus", null, this.getPackageName()));
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
        Intent intent = new Intent(this, FirstGameActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to Level 2 activity for user with "username".
     */
    @Override
    public void goToLevel2(String username) {
        Intent intent = new Intent(this, Lvl2GameActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to Level 3 activity for user with "username".
     */
    @Override
    public void goToLevel3(String username) {
        Intent intent = new Intent(this, Lvl3StartActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
}
