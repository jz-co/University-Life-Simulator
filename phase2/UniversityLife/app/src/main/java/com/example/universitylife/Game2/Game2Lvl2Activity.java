package com.example.universitylife.Game2;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.universitylife.CharacterIcons;
import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.LevelSelector.Game2LevelSelectorActivity;
import com.example.universitylife.R;

import java.util.Timer;
import java.util.TimerTask;

import static android.view.View.INVISIBLE;

public class Game2Lvl2Activity extends AppCompatActivity implements ILevel2.ILevel2View{
    private Game2Lvl2Presenter game2Presenter;
    private ImageView red, blue, yellow, whatyoushoulddo, whatyoushouldnotdo, umbrella;
    private LinearLayout resultBox;
    private boolean pauseGame = false;
    private String username;
    private boolean start = false;
    private Handler handler;
    private long secondsRemaining;
    private Timer timer;
    private CountDownTimer countDownTimer;
    private CharacterIcons characterIcons;
    private boolean useUmbrella = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lvl2_lvl2);
        username = (String) getIntent().getSerializableExtra("Username");
        red = findViewById(R.id.red_2);
        blue = findViewById(R.id.blue_2);
        yellow = findViewById(R.id.yellow_2);
        umbrella = findViewById(R.id.umbrella_2);
        whatyoushoulddo = findViewById(R.id.thingsYouShouldDo);
        whatyoushouldnotdo = findViewById(R.id.thingsYouShouldNotDo);
        this.game2Presenter = new Game2Lvl2Presenter(this, username, new DataHandler(this));
        characterIcons = new CharacterIcons(this);
        initiateImageView();
        resultBox = findViewById(R.id.resultBox_2);
        red.setVisibility(INVISIBLE);
        blue.setVisibility(INVISIBLE);
        yellow.setVisibility(INVISIBLE);
        whatyoushouldnotdo.setVisibility(INVISIBLE);
        whatyoushoulddo.setVisibility(INVISIBLE);
        game2Presenter.initDisplay(this);
        this.handler = new Handler();
    }

    private void initiateImageView() {
        red.setImageResource(game2Presenter.getRedAppearence());
        blue.setImageResource(game2Presenter.getBlueAppearence());
        yellow.setImageResource(game2Presenter.getYellowAppearence());
        whatyoushouldnotdo.setImageResource(game2Presenter.getWhatYouShouldNotDoAppearance());
        whatyoushoulddo.setImageResource(game2Presenter.getWhatYouShouldDoAppearance());
        ImageView basket = findViewById(R.id.character_2);
        int id = characterIcons.getIconByIndex(game2Presenter.getBasketAppearence());
        basket.setImageResource(id);
    }

    @Override
    public void goToNextLevel() {
        Intent intent = new Intent(this, Game2Lvl3Activity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }

    @Override
    public void updateViewPosById(int id) {
        ImageView image = findViewById(id);
        switch (id) {
            case R.id.red_2:
                image.setX(this.game2Presenter.getRedX());
                image.setY(this.game2Presenter.getRedY());
                break;
            case R.id.blue_2:
                image.setX(this.game2Presenter.getBlueX());
                image.setY(this.game2Presenter.getBlueY());
                break;
            case R.id.yellow_2:
                image.setX(this.game2Presenter.getYellowX());
                image.setY(this.game2Presenter.getYellowY());
                break;
            case R.id.thingsYouShouldDo:
                image.setX(this.game2Presenter.getWhatYouShouldDoX());
                image.setY(this.game2Presenter.getWhatYouShouldDoY());
                break;
            case R.id.thingsYouShouldNotDo:
                image.setX(this.game2Presenter.getWhatYouShouldNotDoX());
                image.setY(this.game2Presenter.getWhatYouShouldNotDoY());
                break;
            case R.id.character_2:
                image.setX(this.game2Presenter.getBasketX());
                image.setY(this.game2Presenter.getBasketY());
        }
    }

    @Override
    public void quitGame() {
        start = false;
        setScore();
        TextView textView = findViewById(R.id.final_score_2);
        textView.setText(Integer.toString(game2Presenter.getScore()));
        resultBox.setVisibility(View.VISIBLE);
    }

    @Override
    public void setScore() {
        TextView textView = findViewById(R.id.score_2);
        textView.setText("Score:"+ game2Presenter.getScore());
    }

    @Override
    public void setSecondRemaining() {
        TextView seconds = findViewById(R.id.secondRemaining_2);
        seconds.setText("Secs Left:"+ secondsRemaining);
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void stopTimer() {
        timer.cancel();
        countDownTimer.cancel();
    }

    @Override
    public void displayName(String name) {
        TextView tv_userName = findViewById(R.id.userName_2);
        tv_userName.setText(name);
    }

    @Override
    public void displayScore(double score) {
        setScore();
    }


    /**
     * moves the basket(the character) to the right
     *
     * @param view: the character imageview in the xml file
     */
    public void move_right(View view) {
        game2Presenter.move_right();
        updateViewPosById(R.id.character_2);
    }

    /**
     * moves the basket(the character) to the left
     *
     * @param view: the characater imageview in the xml file
     */
    public void move_left(View view) {
        game2Presenter.move_left();
        updateViewPosById(R.id.character_2);
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
        whatyoushoulddo.setVisibility(View.VISIBLE);
        whatyoushouldnotdo.setVisibility(View.VISIBLE);
        game2Presenter.initializeGame();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        game2Presenter.play();
                        whatyoushoulddo.setImageResource(game2Presenter.getWhatYouShouldDoAppearance());
                        whatyoushouldnotdo.setImageResource(game2Presenter.getWhatYouShouldNotDoAppearance());
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
                                whatyoushoulddo.setImageResource(game2Presenter.getWhatYouShouldDoAppearance());
                                whatyoushouldnotdo.setImageResource(game2Presenter.getWhatYouShouldNotDoAppearance());
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
                        game2Presenter.quitGame();
                    }

                }.start();

            } else {
                stopTimer();
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


    /** track umbrella status
     *
     */
    public void umbrellaTracker(View view){
        // umbrella is opened now
        if (!useUmbrella && game2Presenter.isBoughtUmbrella() && start) {
            game2Presenter.setUmbrellaOpen();
            CountDownTimer countDownTimer_umbrella = new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    displayMessage("Umbrella is now closed");
                    umbrella.setVisibility(INVISIBLE);
                    game2Presenter.setUmbrellaClose();
                }
            }.start();
            useUmbrella = true;
        }else if(!start){
            displayMessage("You can't use an umbrella when the game has not started");
        } else if(useUmbrella){
            displayMessage("Umbrella can only be used once");
        }else if (!game2Presenter.isBoughtUmbrella()){
            displayMessage("You don't have an umbrella");
        }
    }
    public void back(View view){
        Intent intent = new Intent(this, Game2LevelSelectorActivity.class);
        intent.putExtra("Username", username);
        startActivity(intent);
    }


}
