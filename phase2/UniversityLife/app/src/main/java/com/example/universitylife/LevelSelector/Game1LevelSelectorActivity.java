package com.example.universitylife.LevelSelector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.Game1.Game1BonusLvlActivity;
import com.example.universitylife.Game1.Game1Lvl1Activity;
import com.example.universitylife.Game1.Game1Lvl2Activity;
import com.example.universitylife.Game1.Game1Lvl3Activity;
import com.example.universitylife.R;

public class Game1LevelSelectorActivity extends AppCompatActivity implements ILevelSelector.ILevelSelectorView {

    static final int GAME_TAG = 1;
    static final String GAME_NAME = "Math Mania";

    private String username;
    private LevelSelectorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_level_selector);

        TextView courseName = findViewById(R.id.courseNameView);
        TextView currGPA = findViewById(R.id.courseGPAView);

        username = (String) getIntent().getSerializableExtra("Username");
        presenter = new LevelSelectorPresenter(this, GAME_TAG, username, new DataHandler(this));

        courseName.setText(GAME_NAME);
        currGPA.setText(presenter.getCurrGPA(1));

        configureLevelButtons();

    }

    private void configureLevelButtons() {

        Button level1Button = findViewById(R.id.level1Button);
        level1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateLevel(1);
            }
        });

        Button level2Button = findViewById(R.id.level2Button);
        level2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateLevel(2);
            }
        });

        Button level3Button = findViewById(R.id.level3button);
        level3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateLevel(3);
            }
        });

        Button bonusButton = findViewById(R.id.bonus_level_btn);
        bonusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateBonus();
            }
        });

        Button backButton = findViewById(R.id.back_btn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
     * Starts Game1 Game1Level1 Activity
     */
    @Override
    public void navigateToLevel1() {
        navigateTo(Game1Lvl1Activity.class);
    }


    /**
     * Starts Game1 Game1Level2 Activity
     */
    @Override
    public void navigateToLevel2() {
        navigateTo(Game1Lvl2Activity.class);
    }

    /**
     * Starts Game1 Game1Level3 Activity
     */
    @Override
    public void navigateToLevel3() {
        navigateTo(Game1Lvl3Activity.class);
    }

    @Override
    public void navigateToBonus() {
        navigateTo(Game1BonusLvlActivity.class);
    }

    private void navigateTo(Class nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
}
