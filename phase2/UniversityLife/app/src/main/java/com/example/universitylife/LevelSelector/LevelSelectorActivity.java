package com.example.universitylife.LevelSelector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.universitylife.Game1.Game1Lvl1Activity;
import com.example.universitylife.Game1.Game1Lvl2Activity;
import com.example.universitylife.Game1.Game1Lvl3Activity;
import com.example.universitylife.Game2.Game2Lvl1Activity;
import com.example.universitylife.Game2.Game2Lvl2Activity;
import com.example.universitylife.Game2.Game2Lvl3Activity;
import com.example.universitylife.Game2.Game2Lvl4Activity;
import com.example.universitylife.R;

public class LevelSelectorActivity extends AppCompatActivity implements ILevelSelector.ILevelSelectorView {

    LevelSelectorPresenter presenter;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selector);

        TextView courseName = findViewById(R.id.courseNameView);
        TextView currGPA = findViewById(R.id.courseGPAView);

        //String presenterType = "Insert Type Here";

        // username and game index will be passed in from the previous activity.
        String username = "Insert username";
        int game = Integer.parseInt("1");
        //presenter = (new LevelSelectorPresenterFactory()).createLevelSelectorPresenter(presenterType, this, new DataHandler(this), username);
        presenter = new LevelSelectorPresenter(this, game, username);

        courseName.setText(presenter.getCourseName());
        currGPA.setText(presenter.getCurrGPA());

    }

    @Override
    public void displayWarning() {
        //TODO
    }

    @Override
    public void goToGameLevel(int game, int level) {
        switch (game) {
            case 1:
                navigateToGame1(level);
                break;
            case 2:
                navigateToGame2(level);
                break;
            case 3:
                navigateToGame3(level);
        }
    }
    /**
     * Executes when user clicks Level1Button.
     */
    public void onClickLevel1(View view) {
        presenter.validateLevel(1);
    }

    /**
     * Executes when user clicks Level2Button.
     */
    public void onClickLevel2(View view) {
        presenter.validateLevel(2);
    }

    /**
     * Executes when user clicks Level3Button.
     */
    public void onClickLevel3(View view) {
        presenter.validateLevel(3);
    }

    private void navigateToGame1(int level) {
        Class activity;
        switch (level) {
            case 2:
                activity = Game1Lvl2Activity.class;
                break;
            case 3:
                activity = Game1Lvl3Activity.class;
                break;
            case 4:
                activity = Game1Lvl3Activity.class;
                //TODO: link to lvl 4.
                break;
            default:
                activity = Game1Lvl1Activity.class;

        }
        Intent intent = new Intent(this, activity);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    private void navigateToGame2(int level) {
        Class activity;
        switch (level) {
            case 2:
                activity = Game2Lvl2Activity.class;
                break;
            case 3:
                activity = Game2Lvl3Activity.class;
                break;
            case 4:
                activity = Game2Lvl4Activity.class;
                break;
            default:
                activity = Game2Lvl1Activity.class;

        }
        Intent intent = new Intent(this, activity);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    private void navigateToGame3(int level) {
        Class activity;
        //TODO: link to game 3 levels.
        switch (level) {
            case 2:
                activity = Game2Lvl2Activity.class;
                break;
            case 3:
                activity = Game2Lvl3Activity.class;
                break;
            case 4:
                activity = Game2Lvl4Activity.class;
                break;
            default:
                activity = Game2Lvl1Activity.class;

        }
        Intent intent = new Intent(this, activity);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
//
//    /**
//     * Starts Game1Level1 Activity
//     */
//    void navigateToGame1Level1() {
//        Intent intent = new Intent(this, Game1Lvl1Activity.class);
//        intent.putExtra("Username", username);
//        startActivity(intent);
//    }
//
//    void navigateToGame1Level2() {
//        Intent intent = new Intent(this, Game1Lvl2Activity.class);
//        intent.putExtra("Username", username);
//        startActivity(intent);
//    }
//
//    void navigateToGame1Level3() {
//        Intent intent = new Intent(this, Game1Lvl2Activity.class);
//        intent.putExtra("Username", username);
//        startActivity(intent);
//    }
//
//    void navigateToGame2Level1() {
//        Intent intent = new Intent(this, Game1Lvl1Activity.class);
//        intent.putExtra("Username", username);
//        startActivity(intent);
//    }
//
//    void navigateToGame2Level2() {
//        Intent intent = new Intent(this, Game1Lvl2Activity.class);
//        intent.putExtra("Username", username);
//        startActivity(intent);
//    }
//
//    void navigateToGame2Level3() {
//        Intent intent = new Intent(this, Game1Lvl2Activity.class);
//        intent.putExtra("Username", username);
//        startActivity(intent);
//    }
//
//    void navigateToGame3Level1() {
//        Intent intent = new Intent(this, Game1Lvl1Activity.class);
//        intent.putExtra("Username", username);
//        startActivity(intent);
//    }
//
//    void navigateToGame3Level2() {
//        Intent intent = new Intent(this, Game1Lvl2Activity.class);
//        intent.putExtra("Username", username);
//        startActivity(intent);
//    }
//
//    void navigateToGame3Level3() {
//        Intent intent = new Intent(this, Game1Lvl2Activity.class);
//        intent.putExtra("Username", username);
//        startActivity(intent);
//    }
}
