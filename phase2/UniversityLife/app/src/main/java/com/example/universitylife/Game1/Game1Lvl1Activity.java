package com.example.universitylife.Game1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.universitylife.Game2.Game2Lvl1Activity;
import com.example.universitylife.R;
import com.example.universitylife.Result.Game1ResultActivity;

public class Game1Lvl1Activity extends AppCompatActivity implements ILevel1.ILevel1View {

    private Game1Lvl1Presenter level1Presenter;
    private TextView questionTV, correctTV, incorrectTV, hpTV, creditTV, gpaTV, resultTV;
    private EditText answerTV;
    private Button start, nextLevel, enter;
    private ImageView pause;
    private boolean pauseGame = false;
    private String username;
    private CountDownTimer countDownTimer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main_lvl1_lvl1);

        this.username = (String) getIntent().getSerializableExtra("Username");

        this.level1Presenter = new Game1Lvl1Presenter(this, username);

        this.questionTV = findViewById(R.id.question);
        this.correctTV = findViewById(R.id.correct);
        this.incorrectTV = findViewById(R.id.incorrect);

        this.creditTV = findViewById(R.id.creditLvl1);
        this.gpaTV = findViewById(R.id.gpaLvl1);
        this.hpTV = findViewById(R.id.textView14);

        this.answerTV = findViewById(R.id.answer);
        this.resultTV = findViewById(R.id.resultLvl1);

        this.start = findViewById(R.id.startLv1);
        this.enter = findViewById(R.id.enterLv1);
        this.nextLevel = findViewById(R.id.nextLevelLvl1);

        this.pause = findViewById(R.id.pauseLvl1);

        //set the game screen features invisible
        this.questionTV.setVisibility(View.INVISIBLE);
        this.correctTV.setVisibility(View.INVISIBLE);
        this.incorrectTV.setVisibility(View.INVISIBLE);
        this.answerTV.setVisibility(View.INVISIBLE);
        this.resultTV.setVisibility(View.INVISIBLE);
        this.enter.setVisibility(View.INVISIBLE);
        this.pause.setVisibility(View.INVISIBLE);

        level1Presenter.initDisplay(this);

    }

    /**
     * Method called when the user clicks the start button
     *
     * @param view
     */
    public void startGame(View view) {

        //make game screen features visible
        this.start.setVisibility(View.INVISIBLE);
        this.nextLevel.setVisibility(View.INVISIBLE);
        this.questionTV.setVisibility(View.VISIBLE);
        this.correctTV.setVisibility(View.VISIBLE);
        this.incorrectTV.setVisibility(View.VISIBLE);
        this.answerTV.setVisibility(View.VISIBLE);
        this.enter.setVisibility(View.VISIBLE);
        this.pause.setVisibility(View.VISIBLE);

        this.level1Presenter.startGame();
    }

    /**
     * Calls Level 2 Start page
     */
    public void goToLevel2() {
        Intent intent = new Intent(this, Game2Lvl1Activity.class);
        intent.putExtra("Username", this.username);
        startActivity(intent);
    }

    /**
     * Displays the warning message on the screen when the user enters an invalid entry
     *
     * @param message the warning message to be displayed
     */
    public void displayWarning(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToResults(String displayMessage, int score) {
        Intent intent = new Intent(this, Game1ResultActivity.class);
        intent.putExtra("Completion", displayMessage);
        intent.putExtra("Level", 1);
        intent.putExtra("Score", score);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    /**
     * Method called when the user presses the pause button
     *
     * @param view the view that this method is called from
     */
    public void pauseOrResumeGame(View view) {
        if (pauseGame) {
            level1Presenter.resumeGame();
        } else {
            countDownTimer.cancel();
        }
        this.pauseGame = !this.pauseGame;
    }

    /**
     * Timer for the game
     *
     * @param totalTime time for the game in milliseconds
     */
    public void startTimer(long totalTime) {
        countDownTimer = new CountDownTimer(totalTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                level1Presenter.tick(millisUntilFinished);
                running = true;
            }

            @Override
            public void onFinish() {
                level1Presenter.levelComplete();
                running = false;
            }

        }.start();
    }

    /**
     * Displays the remaining seconds on the screen
     *
     * @param secondsRemaining seconds remaining in the game.
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void setSecondsRemaining(long secondsRemaining) {
        TextView seconds = findViewById(R.id.countdown);
        seconds.setText("Secs Left:" + secondsRemaining);
    }

    /**
     * Displays the score for correct answers on the screen
     *
     * @param score the number of questions the student has correctly answered.
     */
    @SuppressLint("SetTextI18n")
    public void displayCorrectScore(int score) {
        this.correctTV.setText("Correct: " + score);
    }

    /**
     * Displays the score for incorrect answers on the screen.
     *
     * @param score the number of questions the student has incorrectly answered.
     */
    @SuppressLint("SetTextI18n")
    public void displayIncorrectScore(int score) {
        this.incorrectTV.setText("Incorrect: " + score);
    }

    /**
     * Displays the question on the screen.
     *
     * @param question the question to be displayed
     */
    public void displayQuestion(String question) {
        this.questionTV.setText(question);
    }

    /**
     * Method called when the "Submit" button is clicked on the scree. The answer entered in the
     * field is sent to the backend to be evaluated.
     *
     * @param view the view that calls this method
     */
    public void evaluateAnswer(View view) {
        if (running) {
            String answerReceived = this.answerTV.getText().toString();
            this.answerTV.getText().clear();
            level1Presenter.evaluateAnswer(answerReceived);
        }
    }


    /**
     * Sets the name of the player on the screen
     *
     * @param name name of the player
     */
    @Override
    public void displayName(String name) {
        TextView tv_name = findViewById(R.id.Name);
        tv_name.setText(name);
    }

    /**
     * Sets the GPA of the player on the screen
     *
     * @param gpa GPA of the player
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void displayGPA(double gpa) {
        this.gpaTV.setText("GPA: " + gpa);
    }

    /**
     * Displays the HP of the player on the screen
     *
     * @param hp HP of the player
     */
    @Override
    public void displayHP(double hp) {
        String hpString = "HP: " + hp;
        this.hpTV.setText(hpString);
    }

    /**
     * Displays the number of credits of the player on the screen
     *
     * @param credit the credits of the player
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void displayCredit(int credit) {
        this.creditTV.setText("credit: " + credit);

    }

    /**
     * Displays the final score at the end of the game.
     */
    @SuppressLint("SetTextI18n")
    public void endGame() {
        this.resultTV.setText("Score:" + Integer.toString(level1Presenter.getCorrectScore()));
        this.resultTV.setVisibility(View.VISIBLE);
        this.nextLevel.setVisibility(View.VISIBLE);

        //set the question, answer views and the enter button invisible
        this.questionTV.setVisibility(View.INVISIBLE);
        this.answerTV.setVisibility(View.INVISIBLE);
        this.enter.setVisibility(View.INVISIBLE);
    }

    /**
     * Method called when the Next Level button is clicked on the screen.
     *
     * @param view the view that this method is called from.
     */
    public void onClickNextLevel(View view) {
        level1Presenter.validateLevel2();
    }

    public void displayScore(double score){
        System.out.println("1");
    }
}