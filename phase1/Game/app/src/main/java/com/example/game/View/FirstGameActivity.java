package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
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
    private boolean nextLevelUnlocked = false;
    private boolean pauseGame = false;
    private String username;
    private int clearingScore = 5;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_game);

        this.username = (String) getIntent().getSerializableExtra("Username");
        this.level1Presenter = new Level1Presenter(this, new DataHandler(this), username);
        this.questionTV = findViewById(R.id.question);
        this.correctTV = findViewById(R.id.correct);
        this.incorrectTV = findViewById(R.id.incorrect);
        this.hpTV = findViewById(R.id.hpLvl1);
        this.creditTV = findViewById(R.id.creditLvl1);
        this.gpaTV = findViewById(R.id.gpaLvl1);
        this.answerTV = findViewById(R.id.answer);
        this.resultTV = findViewById(R.id.resultLvl1);
        this.start = findViewById(R.id.startLv1);
        this.enter = findViewById(R.id.enterLv1);
        this.nextLevel = findViewById(R.id.nextLevelLvl1);
        this.hpTV = findViewById(R.id.hpLvl1);
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


    public void goToLevel2() {
        Intent intent = new Intent(this, Lvl2GameActivity.class);
        intent.putExtra("Username", this.username);
        startActivity(intent);
    }


    public void displayWarning(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
            //on every tick, display the seconds remaining
            public void onTick(long millisUntilFinished) {
                level1Presenter.tick(millisUntilFinished);
            }

            @Override
            //when time is up, quit game in the view
            public void onFinish() {
                level1Presenter.quitGame();
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

    public void displayInvalidInputMessage() {
        System.out.println("Wrong");
        Toast toast = Toast.makeText(this, "Invalid entry, please enter a new answer", Toast.LENGTH_SHORT);
        toast.show();
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
        this.hpTV.setText("hp: "+ hp);
    }

    @Override
    public void displayCredit(int credit) {
        this.creditTV.setText("credit" + credit);

    }

    public void quitGame() {
        this.resultTV.setText("Score:" + Integer.toString(level1Presenter.getCorrectScore()));
        this.resultTV.setVisibility(View.VISIBLE);
        this.nextLevel.setVisibility(View.VISIBLE);
        if (level1Presenter.getCorrectScore() >= clearingScore) {
            Toast.makeText(this, "Congratulations, you have cleared this level!",
                    Toast.LENGTH_SHORT).show();
            nextLevelUnlocked = true;
            level1Presenter.incrementStudentLevel();

        }else{Toast.makeText(this, "Play again to unlock the next level!",
                Toast.LENGTH_SHORT).show();
            level1Presenter.decrementStudentGpa();
        }
    }
    public void onClickNextLevel(View view){
        level1Presenter.validateLevel2();
    }
}
