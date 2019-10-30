package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.game.Contract.ICourseSelector.*;
import com.example.game.Presenter.CourseSelectorPresenter;
import com.example.game.R;



public class CourseSelectorActivity extends AppCompatActivity implements ICourseSelectorView {

    private CourseSelectorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_selector);

        // presenter = new CourseSelectorPresenter() TODO: what arguments to pass into constructor?

        ImageButton profileButton = (ImageButton) findViewById(R.id.profileButton);
        profileButton.setImageResource(getResources().getIdentifier("@drawable/pikachu", null, this.getPackageName())); // TODO
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
        navigateToProfile();  // TODO: somehow get the username?
    }


    public void navigateToProfile () {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public void displayWarning(String message) {
        Toast warning = Toast.makeText(this, message, Toast.LENGTH_LONG);
        warning.show();
    }

    @Override
    public void goToLevel1(String username) {
        Intent intent = new Intent(this, ); // TODO: insert level 1 Activity class
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
