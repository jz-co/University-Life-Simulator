package com.example.game.Model.Level1;

import android.os.CountDownTimer;

import com.example.game.Contract.ILevel1;
import com.example.game.Model.GameLevel;
import com.example.game.Model.Student;

import java.util.Timer;

public class GameLevel1 extends com.example.game.Model.GameLevel {
    private Student student;
    private int correctAnswers, incorrectAnswers;
    private Timer timer;
    private long secondsRemaining;
    private CountDownTimer countDownTimer;
    private ILevel1.ILevel1Presenter presenter;

    public GameLevel1(Student student, ILevel1.ILevel1Presenter presenter){
        this.student = student;
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
        this.presenter = presenter;

    }

    public void pauseGame(){}
    public void resumeGame(){}
    public Student getStudent(){return this.student;}
    public int getCorrectAnswers(){return this.correctAnswers;}
    public int getIncorrectAnswers(){return this.incorrectAnswers;}

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
