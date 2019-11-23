package com.example.universitylife.Game2;

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

import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.Game3.Game3StartActivity;
import com.example.universitylife.R;
import com.example.universitylife.CharacterIcons;

import java.util.Timer;
import java.util.TimerTask;

public class Game2Lvl1Activity extends AppCompatActivity implements ILevel2.ILevel2View {
    private Game2Lvl1Presenter game2Presenter;
    private TextView credit_tv, gpa_tv, hp_tv;
    private ImageView red, blue, yellow;
    private LinearLayout resultBox;
    private boolean pauseGame = false;
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
        game2Presenter = new Game2Lvl1Presenter(this, new DataHandler(this), username);
        resultBox = findViewById(R.id.resultBox);
        red.setVisibility(View.INVISIBLE);
        blue.setVisibility(View.INVISIBLE);
        yellow.setVisibility(View.INVISIBLE);
        this.handler = new Handler();
        game2Presenter.initDisplay(this);
        characterIcons = new CharacterIcons(this);
        initiateImageView();
    }

    /** set image resources for all the imageview in the xml file
     *
     */
    private void initiateImageView() {
        red.setImageResource(game2Presenter.getRedAppearence());
        blue.setImageResource(game2Presenter.getBlueAppearence());
        yellow.setImageResource(game2Presenter.getYellowAppearence());
        ImageView basket = findViewById(R.id.character);
        int Imageindex = game2Presenter.getBasketAppearence();
        int id = characterIcons.getIconByIndex(Imageindex);
        basket.setImageResource(id);
    }


    @Override
    public void goToLevel3() {
        Intent intent = new Intent(this, Game3StartActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    @Override
    public void updateViewPosById(int id) {
        ImageView image = findViewById(id);
        //TODO: similarly, instead of asking presenter for the object, consider adding a method
        // getRedCoordinate() in presenter that returns a list of two integers?
        switch (id) {
            case R.id.red:
                image.setX(game2Presenter.getRedX());
                image.setY(game2Presenter.getRedY());
                break;
            case R.id.blue:
                image.setX(game2Presenter.getBlueX());
                image.setY(game2Presenter.getBlueY());
                break;
            case R.id.yellow:
                image.setX(game2Presenter.getYellowX());
                image.setY(game2Presenter.getYellowY());
                break;
            case R.id.character:
                image.setX(game2Presenter.getBasketX());
                image.setY(game2Presenter.getBasketY());
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void quitGame() {
        start = false;
        setScore();
        TextView textView = findViewById(R.id.final_score);
        textView.setText(Integer.toString(game2Presenter.getScore()));
        resultBox.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setScore() {
        TextView textView = findViewById(R.id.score);
        textView.setText("Score:"+ game2Presenter.getScore());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setSecondRemaining() {
        TextView seconds = findViewById(R.id.secondRemaining);
        seconds.setText("Secs Left:"+ secondsRemaining);
    }


    @Override
    public void displayName(String name) {
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
        gpa_tv.setText("gpa: "+ gpa);
    }


    /**
     * displays the hp of the player
     *
     * @param hp: the hp of the player
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void displayHP(double hp) {
        hp_tv.setText("hp: "+ hp);
    }

    /**
     * displays the credit of the player
     *
     * @param credit: the credit of the player
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void displayCredit(int credit) {
        credit_tv.setText("credit: "+ credit);
    }

    /**
     * moves the basket(the character) to the right
     *
     * @param view: the character imageview in the xml file
     */
    public void move_right(View view) {
        game2Presenter.move_right();
        updateViewPosById(R.id.character);
    }

    /**
     * moves the basket(the character) to the left
     *
     * @param view: the characater imageview in the xml file
     */
    public void move_left(View view) {
        game2Presenter.move_left();
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
        game2Presenter.initializeGame();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        game2Presenter.play();
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
                game2Presenter.quitGame();
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
                                game2Presenter.play();
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

            } else {
                timer.cancel();
                countDownTimer.cancel();
            }
            pauseGame = !pauseGame;
        } else{
            displayMessage("Please press the start button to start the game");
        }
    }

    /** proceed to next level button
     *
     * @param view: the next level button
     */
    public void proceedNext(View view){
        game2Presenter.goToNextLevel();
    }

    @Override
    public void displayMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
