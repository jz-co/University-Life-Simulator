package com.example.universitylife.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.universitylife.Contract.IResult;
import com.example.universitylife.R;

public class GameResultActivity extends AppCompatActivity implements IResult.IResultView {

    private TextView resultMessage;
    private TextView levelView;
    private TextView gradeView;

    private int level;
    private String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        resultMessage = (TextView) findViewById(R.id.resultMessageView);
        levelView = (TextView) findViewById(R.id.levelTextView);
        gradeView = (TextView) findViewById(R.id.gradeTextView);

        username = (String) getIntent().getSerializableExtra("Username");
        level = (int) getIntent().getSerializableExtra("Level");
        int score = (int) getIntent().getSerializableExtra("Score");
        String completion = (String) getIntent().getSerializableExtra("Completion");

        displayGrade(String.valueOf(score));
        displayCompletionMessage(completion);
        displayLevel(String.valueOf(level));

    }

    @Override
    public void displayGrade(String grade) {
        String gradeString = "Your grade: " + grade;
        gradeView.setText(gradeString);

    }

    @Override
    public void displayLevel(String level) {
        String levelString = "Level: " + level;
        levelView.setText(levelString);

    }

    @Override
    public void displayCompletionMessage(String message) {
        resultMessage.setText(message);
    }

    public void onClickPlayAgain(View view) {
        if (level == 1) {
            goToLevel1(username);
        } else if (level == 2) {
            goToLevel2(username);
        } else {
            goToLevel3(username);
        }
    }

    public void onClickSelectAnother(View view) {
        Intent intent = new Intent(this, CourseSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to Level 1 activity for user with "username".
     */
    public void goToLevel1(String username) {
        Intent intent = new Intent(this, FirstGameActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to Level 2 activity for user with "username".
     */
    public void goToLevel2(String username) {
        Intent intent = new Intent(this, Lvl2GameActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Navigate to Level 3 activity for user with "username".
     */
    public void goToLevel3(String username) {
        Intent intent = new Intent(this, Lvl3StartActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

}
