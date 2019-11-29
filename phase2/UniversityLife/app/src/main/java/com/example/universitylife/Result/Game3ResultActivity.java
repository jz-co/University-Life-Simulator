package com.example.universitylife.Result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.universitylife.CourseSelector.CourseSelectorActivity;
import com.example.universitylife.LevelSelector.Game3LevelSelectorActivity;
import com.example.universitylife.R;

public class Game3ResultActivity extends AppCompatActivity {

    static final int GAME_TAG = 3;
    static final String GAME_NAME = "Extreme Archery";

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_result);

        TextView levelView = findViewById(R.id.courseDisplay);
        TextView gradeView = findViewById(R.id.courseGradeView);

        username = (String) getIntent().getSerializableExtra("Username");

        ResultPresenter presenter = new ResultPresenter(GAME_TAG, username);

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
        Intent intent = new Intent(this, Game3LevelSelectorActivity.class);
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
