package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.game.Contract.ILevel1;
import com.example.game.DataHandler.DataHandler;
import com.example.game.DataHandler.DataLoader;
import com.example.game.DataHandler.DataSaver;
import com.example.game.Presenter.Level1Presenter;
import com.example.game.R;

public class FirstGameActivity extends AppCompatActivity implements ILevel1.ILevel1View {

    private Level1Presenter level1Presenter;
    private TextView questionTV, correctTV, incorrectTV, hpTV, creditTV, gpaTV, resultTV;
    private EditText answerTV;
    private Button start, nextLevel;
    private boolean nextLevelUnlocked = false;
    private boolean pauseGame = false;
    private String username;
    private int clearingScore = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_game);
        this.username = (String) getIntent().getSerializableExtra("UserName");
        this.questionTV = findViewById(R.id.question);
        this.correctTV = findViewById(R.id.correct);
        this.incorrectTV = findViewById(R.id.incorrect);
        this.hpTV = findViewById(R.id.hpLvl1);
        this.creditTV = findViewById(R.id.creditLvl1);
        this.gpaTV = findViewById(R.id.gpaLvl1);
        this.answerTV = findViewById(R.id.answer);
        this.resultTV = findViewById(R.id.resultLvl1);
        this.start = findViewById(R.id.startLv1);
        this.nextLevel = findViewById(R.id.nextLevelLvl1);
        this.hpTV = findViewById(R.id.hpLvl1);
        this.creditTV = findViewById(R.id.creditLvl1);
        this.gpaTV = findViewById(R.id.gpaLvl1);

        this.questionTV.setVisibility(View.INVISIBLE);
        this.correctTV.setVisibility(View.INVISIBLE);
        this.incorrectTV.setVisibility(View.INVISIBLE);
        this.answerTV.setVisibility(View.INVISIBLE);
        this.resultTV.setVisibility(View.INVISIBLE);

        displayCredit(level1Presenter.getGameManager().getCurrentStudent().getCredit());
        displayGPA(level1Presenter.getGameManager().getCurrentStudent().getGpa());
        displayHP(level1Presenter.getGameManager().getCurrentStudent().getHp());

        this.level1Presenter = new Level1Presenter(this, new DataHandler(this), username);
    }

    public void goToLevel2() {
        if (!this.nextLevelUnlocked) {
            Toast.makeText(this,
                    "Sorry, the current level has not been unlocked", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, Lvl2GameActivity.class);
            intent.putExtra("UserName", this.username);
            startActivity(intent);
        }
    }

    public void startGame(View view) {
        this.start.setVisibility(View.INVISIBLE);
        this.nextLevel.setVisibility(View.INVISIBLE);

        this.questionTV.setVisibility(View.VISIBLE);
        this.correctTV.setVisibility(View.VISIBLE);
        this.incorrectTV.setVisibility(View.VISIBLE);
        this.answerTV.setVisibility(View.VISIBLE);
        this.level1Presenter.startGame();
    }

    public void pauseOrResumeGame(View view) {
        if (pauseGame) {
            this.level1Presenter.resumeGame();
        } else {
            this.level1Presenter.pauseGame();
        }
        this.pauseGame = !this.pauseGame;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setSecondsRemaining() {
        TextView seconds = findViewById(R.id.countdown);
        seconds.setText("Secs Left:" + level1Presenter.getSecondsRemaining());
    }

    @SuppressLint("SetTextI18n")
    public void displayCorrectScore() {
        this.correctTV.setText("Correct: " + level1Presenter.getCorrectScore());
    }

    @SuppressLint("SetTextI18n")
    public void displayIncorrectScore() {
        this.incorrectTV.setText("Incorrect: " + level1Presenter.getIncorrectScore());
        Toast toast = Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void displayQuestion() {
        this.questionTV.setText(level1Presenter.getCreatedQuestion());
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

    }

    @Override
    public void displayGPA(double gpa) {
        this.gpaTV.setText(Double.toString(gpa));
    }

    @Override
    public void displayHP(double hp) {
        this.hpTV.setText(Double.toString(hp));
    }

    @Override
    public void displayCredit(int credit) {
        this.creditTV.setText(credit);

    }

    public void quitGame() {
        this.resultTV.setText(level1Presenter.getCorrectScore());
        this.resultTV.setVisibility(View.VISIBLE);
        this.nextLevel.setVisibility(View.VISIBLE);
        if (level1Presenter.getCorrectScore() >= clearingScore) {
            Toast.makeText(this, "Congratulations, you have cleared this level!",
                    Toast.LENGTH_SHORT).show();
            nextLevelUnlocked = true;

        }else{Toast.makeText(this, "Play again to unlock the next level!",
                Toast.LENGTH_SHORT).show();}
    }
    public void proceedNext(View view){
        goToLevel2();
    }
}
