package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.game.Contract.ICourseSelector.*;
import com.example.game.DataHandler.DataLoader;
import com.example.game.DataHandler.DataSaver;
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
        presenter = new CourseSelectorPresenter(this, new DataSaver(), new DataLoader(), username);

        // Set reference to the profileButton in layout
        // Set its image to the user's character icon
        ImageButton profileButton = (ImageButton) findViewById(R.id.profileButton);
        profileButton.setImageResource(characterIcons.get(presenter.getPicIndex()));
    }


    private void populateCharacterIcons() {
        characterIcons.add(getResources().getIdentifier("@drawable/boy1", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/gir1", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/boy2", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/girl2", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/boy3", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/girl3", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/pikachu", null, this.getPackageName()));
        characterIcons.add(getResources().getIdentifier("@drawable/cactus", null, this.getPackageName()));
    }

    /**
     * Executes when levelButton1 is clicked.
     * @param view
     */
    public void onLevel1Click (View view) {
        presenter.validateLevel1();
    }

    /**
     * Executes when levelButton2 is clicked.
     * @param view
     */
    public void onLevel2Click (View view) {
        presenter.validateLevel2();
    }

    /**
     * Executes when levelButton3 is clicked.
     * @param view
     */
    public void onLevel3Click (View view) {
        presenter.validateLevel3();

    }

    public void onProfileClick (View view) {
        navigateToProfile(presenter.getUsername());
    }


    public void navigateToProfile (String username) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    @Override
    public void displayWarning(String message) {
        Toast warning = Toast.makeText(this, message, Toast.LENGTH_LONG);
        warning.show();
    }

    @Override
    public void goToLevel1(String username) {
        Intent intent = new Intent(this, FirstGameActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    @Override
    public void goToLevel2(String username) {
        Intent intent = new Intent(this, Lvl2GameActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    @Override
    public void goToLevel3(String username) {
        Intent intent = new Intent(this, Lvl3StartActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
}
