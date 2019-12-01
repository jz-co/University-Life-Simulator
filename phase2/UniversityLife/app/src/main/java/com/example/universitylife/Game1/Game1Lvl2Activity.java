package com.example.universitylife.Game1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.universitylife.R;
import com.example.universitylife.Result.Game1ResultActivity;

public class Game1Lvl2Activity extends AppCompatActivity implements ILevel1.ILevel1View {
    private Game1Lvl2Presenter level2Presenter;

    private String username;
    private boolean pauseGame = false;
    private CountDownTimer countDownTimer;
    private boolean running;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main_lvl1_lvl2);

        this.username = (String) getIntent().getSerializableExtra("Username");
        this.level2Presenter = new Game1Lvl2Presenter(this, username);

        level2Presenter.initDisplay(this);
    }

    /**
     * Calls Level 3 Start page
     */
    public void goToNextLevel() {
        Intent intent = new Intent(this, Game1Lvl3Activity.class);
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
            level2Presenter.resumeGame();
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
                level2Presenter.tick(millisUntilFinished);
                running = true;
            }

            @Override
            public void onFinish() {
                level2Presenter.levelComplete();
                running = false;
            }

        }.start();
    }

    /**
     * Method called when the Next Level button is clicked on the screen.
     *
     * @param view the view that this method is called from.
     */
    public void onClickNextLevel(View view) {
        level2Presenter.validateLevel3();
    }
}
