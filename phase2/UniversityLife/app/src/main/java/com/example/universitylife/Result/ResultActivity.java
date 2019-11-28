package com.example.universitylife.Result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.universitylife.LevelSelector.LevelSelectorActivity;
import com.example.universitylife.R;
import com.example.universitylife.CourseSelector.CourseSelectorActivity;

public class ResultActivity extends AppCompatActivity implements IResult {

    private TextView resultMessage;
    private TextView levelView;
    private TextView gradeView;

    private String game;
    private String username;

    private ResultPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        resultMessage = (TextView) findViewById(R.id.resultMessageView);
        levelView = (TextView) findViewById(R.id.courseDisplay);
        gradeView = (TextView) findViewById(R.id.courseGradeView);

        username = (String) getIntent().getSerializableExtra("Username");
        game = (String) getIntent().getSerializableExtra("GAME_NAME");
        int score = (int) getIntent().getSerializableExtra("Score");

        presenter = (new ResultPresenterFactory()).createResultPresenter(game, username);

        displayGrade(String.valueOf(score));
        displayGameName(String.valueOf(game));

    }

    @Override
    public void displayGrade(String grade) {
        String gradeString = "Your grade: " + grade;
        gradeView.setText(gradeString);

    }

    @Override
    public void displayGameName(String game) {
        levelView.setText(game);

    }

//    public void displayCompletionMessage(String message) {
//        resultMessage.setText(message);
//    }

    public void onClickRetakeCourse(View view) {
        presenter.retakeCourse();
    }

    public void onClickReturnToCourses(View view) {
        Intent intent = new Intent(this, CourseSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }


    /**
     * Navigate to Level Selection activity for the game "game" and user with username "username".
     */
    void goToLevelSelection(String username, String game) {
        Intent intent = new Intent(this, LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        intent.putExtra("GAME_NAME", game);
        startActivity(intent);
    }

}
