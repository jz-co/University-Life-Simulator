package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.game.Contract.ILevel1;
import com.example.game.DataHandler.DataHandler;
import com.example.game.Presenter.Level1Presenter;
import com.example.game.R;

public class FirstGameActivity extends AppCompatActivity implements ILevel1.ILevel1View {

    private Level1Presenter level1Presenter;
    private TextView questionTV, correctTV, incorrectTV, hpTV, creditTV, gpaTV, resultTV;
    private EditText answerTV;
    private Button start, nextLevel, enter;
    private boolean pauseGame = false;
    private String username;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_first_game);

        this.username = (String) getIntent().getSerializableExtra("Username");
        this.level1Presenter = new Level1Presenter(this, new DataHandler(this), username);

        this.questionTV = findViewById(R.id.question);
        this.correctTV = findViewById(R.id.correct);
        this.incorrectTV = findViewById(R.id.incorrect);
        this.creditTV = findViewById(R.id.creditLvl1);
        this.gpaTV = findViewById(R.id.gpaLvl1);
        this.answerTV = findViewById(R.id.answer);
        this.resultTV = findViewById(R.id.resultLvl1);
        this.start = findViewById(R.id.startLv1);
        this.enter = findViewById(R.id.enterLv1);
        this.nextLevel = findViewById(R.id.nextLevelLvl1);
        this.hpTV = findViewById(R.id.textView14);
        this.creditTV = findViewById(R.id.creditLvl1);
        this.gpaTV = findViewById(R.id.gpaLvl1);

        this.questionTV.setVisibility(View.INVISIBLE);
        this.correctTV.setVisibility(View.INVISIBLE);
        this.incorrectTV.setVisibility(View.INVISIBLE);
        this.answerTV.setVisibility(View.INVISIBLE);
        this.resultTV.setVisibility(View.INVISIBLE);
        this.enter.setVisibility(View.INVISIBLE);

        level1Presenter.initDisplay(this);

    }

    public void startGame(View view) {
        this.start.setVisibility(View.INVISIBLE);
        this.nextLevel.setVisibility(View.INVISIBLE);
        this.questionTV.setVisibility(View.VISIBLE);
        this.correctTV.setVisibility(View.VISIBLE);
        this.incorrectTV.setVisibility(View.VISIBLE);
        this.answerTV.setVisibility(View.VISIBLE);
        this.enter.setVisibility(View.VISIBLE);

        this.level1Presenter.startGame();
    }

    public void goToLevel2() {
        Intent intent = new Intent(this, Lvl2GameActivity.class);
        intent.putExtra("Username", this.username);
        startActivity(intent);
    }


    public void displayWarning(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToResults(String displayMessage, int score) {
        Intent intent = new Intent(this, GameResultActivity.class);
        intent.putExtra("Completion", displayMessage);
        intent.putExtra("Level", 1);
        intent.putExtra("Score", score);
        intent.putExtra("Username", username);
        startActivity(intent);
    }


    public void pauseOrResumeGame(View view) {
        if (pauseGame) {
            level1Presenter.resumeGame();
        } else {
            countDownTimer.cancel();
        }
        this.pauseGame = !this.pauseGame;
    }

    public void startTimer(long totalTime){
        countDownTimer = new CountDownTimer(totalTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                level1Presenter.tick(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                level1Presenter.levelComplete();
            }

        }.start();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setSecondsRemaining(long secondsRemaining) {
        TextView seconds = findViewById(R.id.countdown);
        seconds.setText("Secs Left:" + secondsRemaining);
    }

    @SuppressLint("SetTextI18n")
    public void displayCorrectScore(int score) {
        this.correctTV.setText("Correct: " + score);
    }

    @SuppressLint("SetTextI18n")
    public void displayIncorrectScore(int score) {
        this.incorrectTV.setText("Incorrect: " + score);
    }

    public void displayQuestion(String question) {
        this.questionTV.setText(question);
    }

    public void evaluateAnswer(View view) {
        String answerReceived = this.answerTV.getText().toString();
        level1Presenter.evaluateAnswer(answerReceived);
    }

    @Override
    public void displayName(String name) {
        TextView tv_name = findViewById(R.id.Name);
        tv_name.setText(name);
    }

    @Override
    public void displayGPA(double gpa) {
        this.gpaTV.setText("gpa: "+ gpa);
    }

    @Override
    public void displayHP(double hp) {
        String hpString = "HP: " + hp;
        this.hpTV.setText(hpString);
    }

    @Override
    public void displayCredit(int credit) {
        this.creditTV.setText("credit: " + credit);

    }

    public void endGame() {
        this.resultTV.setText("Score:" + Integer.toString(level1Presenter.getCorrectScore()));
        this.resultTV.setVisibility(View.VISIBLE);
        this.nextLevel.setVisibility(View.VISIBLE);
    }

    public void onClickNextLevel(View view){
        level1Presenter.validateLevel2();
    }
}
