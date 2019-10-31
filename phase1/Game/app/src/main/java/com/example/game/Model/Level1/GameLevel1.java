package com.example.game.Model.Level1;

import android.os.CountDownTimer;
import android.os.Handler;

import com.example.game.Contract.ILevel1;
import com.example.game.Model.GameLevel;
import com.example.game.Model.Student;

import java.util.Timer;
import java.util.TimerTask;

public class GameLevel1 extends com.example.game.Model.GameLevel {
    private Student student;
    private int correctAnswers, incorrectAnswers;
    private long secondsRemaining;
    private Handler handler;
    private Timer timer;
    private CountDownTimer countDownTimer;
    private ILevel1.ILevel1Presenter presenter;

    public GameLevel1(Student student, ILevel1.ILevel1Presenter presenter){
        this.student = student;
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
        this.presenter = presenter;

    }

    public void play(){
        timer = new Timer();
        this.correctAnswers = 0;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //TODO THIS
                    }
                });
            }
        }, 0, 5);

        countDownTimer = new CountDownTimer(120000, 1000) {
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

    private void quitGame(){
        timer.cancel();
        timer = null;
        presenter.quitGame();
    }
    public void pauseGame(){}
    public void resumeGame(){}
    public Student getStudent(){return this.student;}
    public int getCorrectAnswers(){return this.correctAnswers;}
    public int getIncorrectAnswers(){return this.incorrectAnswers;}

    public long getSecondsRemaining() {
        return secondsRemaining;
    }


    public void setPresenter(ILevel1.ILevel1Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void progressGameResults() {

    }

    @Override
    public GameLevel makeCopy() {
        return null;
    }
    // NOT IMPLEMENTED
}
