package com.example.game.Model.Level1;

import com.example.game.Contract.ILevel1;
import com.example.game.Model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameLevel1 extends com.example.game.Model.GameLevel {
    private Student student;
    private int correctAnswers, incorrectAnswers;

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

    public int evaluateAnswer(String answer) {
        try {
            Integer.parseInt(answer);
            boolean rightAnswer = Integer.parseInt(answer) == correctAnswer;
            System.out.println(rightAnswer);
            presenter.newQuestion();
            if (rightAnswer) {
                correctAnswers+=1;
                return 1;
            } else {
                incorrectAnswers+=1;
                return 0;
            }
        } catch (NumberFormatException e) {
            presenter.setInvalidInputMessage();
            return -1;
        }
    }


}

