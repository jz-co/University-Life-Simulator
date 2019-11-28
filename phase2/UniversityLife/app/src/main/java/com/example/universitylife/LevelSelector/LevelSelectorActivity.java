package com.example.universitylife.LevelSelector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.Game1.Game1Lvl1Activity;
import com.example.universitylife.Game1.Game1Lvl2Activity;
import com.example.universitylife.R;

public class LevelSelectorActivity extends AppCompatActivity {

    LevelSelectorPresenter presenter;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selector);

        TextView courseName = findViewById(R.id.courseNameView);
        TextView currGPA = findViewById(R.id.courseGPAView);

        String presenterType = "Insert Type Here";
        String username = "Insert username";
        presenter = (new LevelSelectorPresenterFactory()).createLevelSelectorPresenter(presenterType, this, new DataHandler(this), username);

        courseName.setText(presenter.getCourseName());
        currGPA.setText(presenter.getCurrGPA());

    }

    /**
     * Executes when user clicks Level1Button.
     */
    public void onClickLevel1(View view) {
        presenter.validateLevel1();
    }

    /**
     * Executes when user clicks Level2Button.
     */
    public void onClickLevel2(View view) {
        presenter.validateLevel2();
    }

    /**
     * Executes when user clicks Level3Button.
     */
    public void onClickLevel3(View view) {
        presenter.validateLevel3();
    }


    /**
     * Starts Game1Level1 Activity
     */
    void navigateToGame1Level1() {
        Intent intent = new Intent(this, Game1Lvl1Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    void navigateToGame1Level2() {
        Intent intent = new Intent(this, Game1Lvl2Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    void navigateToGame1Level3() {
        Intent intent = new Intent(this, Game1Lvl2Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    void navigateToGame2Level1() {
        Intent intent = new Intent(this, Game1Lvl1Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    void navigateToGame2Level2() {
        Intent intent = new Intent(this, Game1Lvl2Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    void navigateToGame2Level3() {
        Intent intent = new Intent(this, Game1Lvl2Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    void navigateToGame3Level1() {
        Intent intent = new Intent(this, Game1Lvl1Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    void navigateToGame3Level2() {
        Intent intent = new Intent(this, Game1Lvl2Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    void navigateToGame3Level3() {
        Intent intent = new Intent(this, Game1Lvl2Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
}
