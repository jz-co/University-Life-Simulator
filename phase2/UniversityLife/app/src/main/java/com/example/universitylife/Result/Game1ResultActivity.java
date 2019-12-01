package com.example.universitylife.Result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.LevelSelector.Game1LevelSelectorActivity;
import com.example.universitylife.R;
import com.example.universitylife.CourseSelector.CourseSelectorActivity;

public class Game1ResultActivity extends AppCompatActivity {

    static final int GAME_TAG = 1;
    static final String GAME_NAME = "Math Mania";

    private String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_result);

        TextView levelView = (TextView) findViewById(R.id.courseDisplay);
        TextView gradeView = (TextView) findViewById(R.id.courseGradeView);

        username = (String) getIntent().getSerializableExtra("Username");

        ResultPresenter presenter = new ResultPresenter(GAME_TAG, username, new DataHandler(this));

        gradeView.setText(presenter.getFinalGPA());
        levelView.setText(GAME_NAME);
        configureReturnButton();
        configureReplayButton();

    }

    private void configureReplayButton() {
        Button replayButton = findViewById(R.id.replayButton);

        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLevelSelection();
            }
        });
    }
    void navigateToLevelSelection() {
        Intent intent = new Intent(this, Game1LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    private void configureReturnButton() {
        Button returnButton = findViewById(R.id.returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCourseSelection();
            }
        });
    }

    void navigateToCourseSelection() {
        Intent intent = new Intent(this, CourseSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

}
