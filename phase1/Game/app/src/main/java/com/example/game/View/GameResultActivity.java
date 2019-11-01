package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.game.Contract.IResult;
import com.example.game.Presenter.CourseSelectorPresenter;
import com.example.game.Presenter.ResultPresenter;
import com.example.game.R;

public class GameResultActivity extends AppCompatActivity implements IResult.IResultView {

    private TextView resultMessage;
    private TextView levelView;
    private TextView gradeView;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game_result);

        resultMessage = (TextView) findViewById(R.id.resultMessageView);
        levelView = (TextView) findViewById(R.id.levelTextView);
        gradeView = (TextView) findViewById(R.id.gradeTextView);

        username = (String) getIntent().getSerializableExtra("Username");
        int level = (int) getIntent().getSerializableExtra("Level");
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
        Intent intent = new Intent(this, Lvl3StartActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    public void onClickSelectAnother(View view) {
        Intent intent = new Intent(this, CourseSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

}
