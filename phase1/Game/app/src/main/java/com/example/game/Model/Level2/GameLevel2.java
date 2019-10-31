package com.example.game.Model.Level2;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.os.Handler;

import com.example.game.Contract.ILevel2;
import com.example.game.Model.GameLevel;
import com.example.game.Model.Student;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameLevel2 extends GameLevel {
    private Student student;
    private Basket basket;
    private Handler handler;
    private Timer timer;
    private int score, framewidth, frameHeight;
    private ArrayList<FallingObject> fallingObjects;
    private long secondsRemaining;
    private CountDownTimer countDownTimer;
    private ILevel2.ILevel2Presenter presenter;

    public GameLevel2(Student student, Basket basket, int FrameWidth, int FrameHeight, ArrayList<FallingObject> fallingObjects, ILevel2.ILevel2Presenter presenter) {
        this.basket = basket;
        this.basket.setAppearence(student.getAppearance());
        this.handler = new Handler();
        this.score = 0;
        frameHeight = FrameHeight;
        framewidth = FrameWidth;
        this.fallingObjects = fallingObjects;
        this.presenter = presenter;
        this.student = student;
    }


    /** start playing the game
     *
     */
    @Override
    public void play() {
        for (FallingObject o: fallingObjects){
            o.setX_coordinate((int)(Math.random()*framewidth));
            o.setY_coordinate(-100);
            this.presenter.updateViewPosById(o.getFrontEndImageID());
        }
        this.presenter.updateViewPosById(basket.getImageId());
        timer = new Timer();
        score = 0;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int element = (int) (Math.random() * fallingObjects.size());
                        score += game(element);
                        // setting the score in the frontend
                        presenter.setScore();
                    }
                });
            }
        }, 0, 5);
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsRemaining = millisUntilFinished / 1000;
                // setting the seconds remaining in the frontend
                presenter.setSecondsRemaining();
            }

            @Override
            public void onFinish() {
                quitGame();
                // setting the final score in the end and make the start layout box visible
                presenter.quitGame();
            }


        }.start();

    }

    /** helper method for the game
     *
     * @param element: the random element from the arraylist of fallen object
     * @return the number of points gained by eating the ball
     */
    private int game(int element) {
        int result;
        FallingObject item = fallingObjects.get(element);
        item.fall(frameHeight, framewidth);
        presenter.updateViewPosById(item.getFrontEndImageID());
        boolean eat = basket.eatBall(item, frameHeight, framewidth);
        if (eat) {
            result = item.getScore_worth();
            presenter.updateViewPosById(item.getFrontEndImageID());
        }else{
            result = 0;
        }
        return result;
    }


    /** game over
     *
     */
    @SuppressLint("CommitPrefEdits")
    private void quitGame() {
        timer.cancel();
        timer = null;
        presenter.quitGame();
    }

    /** pause the game
     *
     */
    public void pauseGame() {
        timer.cancel();
        countDownTimer.cancel();
    }

    /** resume the game
     *
     */
    public void resumeGame() {
        this.timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int element = (int) (Math.random() * fallingObjects.size());
                        score += game(element);
                        presenter.setScore();
                    }
                });
            }
        }, 0, 5);
        long seconds = secondsRemaining * 1000;
        countDownTimer = new CountDownTimer(seconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsRemaining = millisUntilFinished / 1000;
                presenter.setSecondsRemaining();
            }

            @Override
            public void onFinish() {
                quitGame();
                presenter.quitGame();
            }

        }.start();

    }

    /** return the score of the player in this game
     *
     * @return int score
     */
    public int getScore() {
        return score;
    }

    /** return the number of seconds remaining before the game ends
     *
     * @return long secondsRemaining
     */
    public long getSecondsRemaining() {
        return secondsRemaining;
    }

    /** get the basket of the game
     *
     * @return Basket basket
     */
    public Basket getBasket() {
        return basket;
    }

    /** get the Student(player) of the game
     *
     * @return Student student
     */
    public Student getStudent(){
        return student;
    }
}
