package com.example.game.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.game.Contract.ILevel2;
import com.example.game.DataHandler.DataHandler;
import com.example.game.Presenter.Level2Presenter;
import com.example.game.R;

import java.util.Timer;
import java.util.TimerTask;

public class Lvl2GameActivity extends AppCompatActivity implements ILevel2.ILevel2View {
    private Level2Presenter level2Presenter;
    private TextView credit_tv, gpa_tv, hp_tv;
    private ImageView red, blue, yellow;
    private LinearLayout resultBox;
    private boolean nextLevelUnlocked;
    private boolean pauseGame = false;
    private int clearingScore = 10;
    private String username;
    private boolean start = false;
    private Handler handler;
    private long secondsRemaining;
    private Timer timer;
    private CountDownTimer countDownTimer;
    private CharacterIcons characterIcons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main_lvl_2);
        username = (String) getIntent().getSerializableExtra("Username");
        // finding textviews, imageviews and buttons in from the xml file
        credit_tv = findViewById(R.id.credit);
        gpa_tv = findViewById(R.id.gpa);
        hp_tv = findViewById(R.id.hp);
        red = findViewById(R.id.red);
        blue = findViewById(R.id.blue);
        yellow = findViewById(R.id.yellow);
        level2Presenter = new Level2Presenter(this, new DataHandler(this), username);
        resultBox = findViewById(R.id.resultBox);
        red.setVisibility(View.INVISIBLE);
        blue.setVisibility(View.INVISIBLE);
        yellow.setVisibility(View.INVISIBLE);
        nextLevelUnlocked = level2Presenter.thisLevelUnlocked();
        this.handler = new Handler();
        level2Presenter.initDisplay(this);
        characterIcons = new CharacterIcons(this);
        initiateImageView();
    }

    /** set image resources for all the imageview in the xml file
     *
     */
    private void initiateImageView() {
        //TODO: instead of letting presenter return the object and calling its getAppearance()
        // method, maybe add a method in presenter called getRedAppearence(), which only
        // returns the appearance of the object? Same for the other objects. : )
        red.setImageResource(level2Presenter.getRedAppearence());
        blue.setImageResource(level2Presenter.getBlueAppearence());
        yellow.setImageResource(level2Presenter.getYellowAppearence());
        ImageView basket = findViewById(R.id.character);
        int Imageindex = level2Presenter.getBasketAppearence();
        int id = characterIcons.getIconByIndex(Imageindex);
        basket.setImageResource(id);
    }


    @Override
    public void goToLevel3() {
        if (!nextLevelUnlocked){
            Toast.makeText(this,
                    "Sorry, the current level has not been unlocked. You need to score at least 20 points to " +
                            "clear the level.", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, Lvl3StartActivity.class);
            intent.putExtra("Username", username);
            startActivity(intent);
        }
    }

    @Override
    public void updateViewPosById(int id) {
        ImageView image = findViewById(id);
        //TODO: similarly, instead of asking presenter for the object, consider adding a method
        // getRedCoordinate() in presenter that returns a list of two integers?
        switch (id) {
            case R.id.red:
                image.setX(level2Presenter.getRedX());
                image.setY(level2Presenter.getRedY());
                break;
            case R.id.blue:
                image.setX(level2Presenter.getBlueX());
                image.setY(level2Presenter.getBlueY());
                break;
            case R.id.yellow:
                image.setX(level2Presenter.getYellowX());
                image.setY(level2Presenter.getYellowY());
                break;
            case R.id.character:
                image.setX(level2Presenter.getBasketX());
                image.setY(level2Presenter.getBasketY());
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void quitGame() {
        start = false;
        setScore();
        TextView textView = findViewById(R.id.final_score);
        textView.setText(Integer.toString(level2Presenter.getScore()));
        resultBox.setVisibility(View.VISIBLE);
        if (level2Presenter.getScore() >= clearingScore){
            Toast.makeText(this, "Congratulation, you have cleared this level!",
                    Toast.LENGTH_SHORT).show();
            nextLevelUnlocked = true;
            level2Presenter.incrementStudentLevel();
        }else{
            level2Presenter.decrementStudentGpa();
        }
        level2Presenter.quitGame();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setScore() {
        TextView textView = findViewById(R.id.score);
        textView.setText("Score:"+ level2Presenter.getScore());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setSecondRemaining() {
        TextView seconds = findViewById(R.id.secondRemaining);
        seconds.setText("Secs Left:"+ secondsRemaining);
    }


    @Override
    public void displayName(String name) {
//TODO: display the user's preferred name?
        TextView tv_userName = findViewById(R.id.userName);
        tv_userName.setText(name);
    }

    /**
     * displays the gpa of the student
     *
     * @param gpa: how well the player
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void displayGPA(double gpa) {
        gpa_tv.setText("gpa: "+ Double.toString(gpa));
    }


    /**
     * displays the hp of the player
     *
     * @param hp: the hp of the player
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void displayHP(double hp) {
        hp_tv.setText("hp: "+ Double.toString(hp));
    }

    /**
     * displays the credit of the player
     *
     * @param credit: the credit of the player
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void displayCredit(int credit) {
        credit_tv.setText("credit: "+ Double.toString(credit));
    }

    /**
     * moves the basket(the character) to the right
     *
     * @param view: the character imageview in the xml file
     */
    public void move_right(View view) {
        level2Presenter.move_right();
        updateViewPosById(R.id.character);
    }

    /**
     * moves the basket(the character) to the left
     *
     * @param view: the characater imageview in the xml file
     */
    public void move_left(View view) {
        level2Presenter.move_left();
        updateViewPosById(R.id.character);
    }

    /**
     * starts the catching ball game
     *
     * @param view the start button in the linear layout
     */
    public void start_game(View view) {
        start = true;
        resultBox.setVisibility(View.INVISIBLE);
        red.setVisibility(View.VISIBLE);
        blue.setVisibility(View.VISIBLE);
        yellow.setVisibility(View.VISIBLE);
        level2Presenter.initializeGame();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        level2Presenter.play();
                    }
                });
            }
        }, 0 , 5);
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsRemaining = millisUntilFinished / 1000;
                // setting the seconds remaining in the frontend
                setSecondRemaining();
            }

            @Override
            public void onFinish() {
                timer.cancel();
                timer = null;
                quitGame();
            }


        }.start();
    }

    /**
     * pause or resume the game
     *
     * @param view: the pause button in the xml file
     */
    public void pauseOrResume_game(View view) {
        if (start) {
            if (pauseGame) {
                this.timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                level2Presenter.play();
                            }
                        });
                    }
                }, 0, 5);
                long seconds = secondsRemaining * 1000;
                countDownTimer = new CountDownTimer(seconds, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        secondsRemaining = millisUntilFinished / 1000;
                        setSecondRemaining();
                    }

                    @Override
                    public void onFinish() {
                        timer.cancel();
                        timer = null;
                        quitGame();
                    }

                }.start();
                ;
            } else {
                timer.cancel();
                countDownTimer.cancel();
            }
            pauseGame = !pauseGame;
        } else{
            Toast.makeText(this, "Please press the start button to start the game", Toast.LENGTH_SHORT).show();
        }
    }

    /** proceed to next level button
     *
     * @param view: the next level button
     */
    public void proceedNext(View view){
        goToLevel3();
    }

}
