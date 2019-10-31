package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.Contract.IResult;
import com.example.game.DataHandler.DataLoader;
import com.example.game.DataHandler.DataSaver;
import com.example.game.Presenter.CourseSelectorPresenter;
import com.example.game.Presenter.ResultPresenter;
import com.example.game.R;

public class GameResultActivity extends AppCompatActivity implements IResult.IResultView {

    private TextView resultMessage;
    private TextView levelView;
    private TextView gradeView;
    private ResultPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        resultMessage = (TextView) findViewById(R.id.resultMessageView);
        levelView = (TextView) findViewById(R.id.levelTextView);
        gradeView = (TextView) findViewById(R.id.gradeTextView);

        String username = (String) getIntent().getSerializableExtra("Username");

        presenter = new ResultPresenter(this, new DataSaver(), new DataLoader(), username); // TODO
        presenter.validateLevelCompletion();

    }

    @Override
    public void displayGrade(String grade) {
        String gradeString = "Your grade: " + grade;
        gradeView.setText(gradeString);

    }

    @Override
    public void displayLevel(int level) {
        String levelString = "Level: " + String.valueOf(level);
        levelView.setText(levelString);

    }

    @Override
    public void displayCompletionMessage(String message) {
        resultMessage.setText(message);
    }

    public void onClickPlayAgain(View view) {
        finish(); // TODO
    }

    public void onClickSelectAnother(View view) {
        Intent intent = new Intent(this, CourseSelectorActivity.class);
        startActivity(intent);  // TODO
    }

}
