package com.example.game.Model.Level1;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.game.Contract.ILevel1;
import com.example.game.Model.GameLevel;
import com.example.game.Model.Student;
import com.example.game.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameLevel1 extends com.example.game.Model.GameLevel {
    private Student student;
    private int correctAnswers, incorrectAnswers;

    //seconds left in the game
    private long secondsRemaining;
    CountDownTimer countDownTimer;

    private String question;
    private int correctAnswer;
    private List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*"));
    private ILevel1.ILevel1Presenter presenter;

    //initialize the game
    public GameLevel1(Student student, ILevel1.ILevel1Presenter presenter) {
        this.student = student;
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
        this.presenter = presenter;
    }

    public void play() {
        //60 seconds countdown timer TODO: move to front end
        countDownTimer = new CountDownTimer(600000, 1000) {
            @Override
            //on every tick, display the seconds remaining
            public void onTick(long millisUntilFinished) {
                secondsRemaining = millisUntilFinished / 1000;
                // setting the seconds remaining in the frontend
                presenter.setSecondsRemaining();
            }

            @Override
            //when time is up, quit game in the view
            public void onFinish() {
                presenter.quitGame();
            }

        }.start();

    }


    public void pauseGame() {
        countDownTimer.cancel();
    }

    public void resumeGame() {
        long seconds = secondsRemaining * 1000;
        //TODO: duplicate code... also, move to activity
        countDownTimer = new CountDownTimer(seconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsRemaining = millisUntilFinished / 1000;
                presenter.setSecondsRemaining();
            }

            @Override
            public void onFinish() {
                presenter.quitGame();
            }

        }.start();
    }


    public Student getStudent() {
        return this.student;
    }

    public int getCorrectAnswers() {
        return this.correctAnswers;
    }

    public int getIncorrectAnswers() {
        return this.incorrectAnswers;
    }

    public long getSecondsRemaining() {
        return secondsRemaining;
    }


    public void setPresenter(ILevel1.ILevel1Presenter presenter) {
        this.presenter = presenter;
    }


    public String createQuestion() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);

        int randomNum = (int) (Math.random() * (operators.size() - 1));
        String operation = operators.get(randomNum);

        switch (operation) {

            case "+":
                correctAnswer = a + b;
                break;
            case "-":
                correctAnswer = a - b;
                break;
            case "*":
                correctAnswer = a * b;
                break;
        }

        question = a + operation + b;
        return question;

    }

    public void evaluateAnswer(String answer) {
        try {
            Integer.parseInt(answer);
            boolean rightAnswer = Integer.parseInt(answer) == correctAnswer;
            System.out.println(rightAnswer);

            if (rightAnswer) {
                presenter.setCorrectScore();
            } else {
                presenter.setIncorrectScore();
            }

            presenter.setQuestion();
        } catch (NumberFormatException e) {
            presenter.setInvalidInputMessage();

        }


    }
}
