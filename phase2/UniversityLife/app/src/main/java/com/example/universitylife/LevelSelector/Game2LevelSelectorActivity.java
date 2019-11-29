package com.example.universitylife.LevelSelector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.universitylife.Game2.Game2Lvl1Activity;
import com.example.universitylife.Game2.Game2Lvl2Activity;
import com.example.universitylife.Game2.Game2Lvl3Activity;
import com.example.universitylife.R;

public class Game2LevelSelectorActivity extends AppCompatActivity implements ILevelSelector.ILevelSelectorView {

    static final int GAME_TAG = 2;
    static final String GAME_NAME = "Catching Good Study Habits";

    private String username;
    private LevelSelectorPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_level_selector);

        TextView courseName = findViewById(R.id.courseNameView);
        TextView currGPA = findViewById(R.id.courseGPAView);

        username = (String) getIntent().getSerializableExtra("Username");
        presenter = new LevelSelectorPresenter(this, GAME_TAG, username);

        courseName.setText(GAME_NAME);
        currGPA.setText(presenter.getCurrGPA());

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
        level2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateLevel(3);
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
     * Starts Game2 Level1 Activity
     */
    @Override
    public void navigateToLevel1() {
        Intent intent = new Intent(this, Game2Lvl1Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }


    /**
     * Starts Game2 Level2 Activity
     */
    @Override
    public void navigateToLevel2() {
        Intent intent = new Intent(this, Game2Lvl2Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Starts Game2 Level3 Activity
     */
    @Override
    public void navigateToLevel3() {
        Intent intent = new Intent(this, Game2Lvl3Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }
}
