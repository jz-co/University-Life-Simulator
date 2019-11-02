package com.example.game.Model.Level1;

import com.example.game.Contract.ILevel1;
import com.example.game.Model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameLevel1 {
    private Student student;
    private int correctAnswers, incorrectAnswers;
    private int clearingScore = 5;

    private String question;
    private int correctAnswer;
    private List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*"));

    //initialize the game
    public GameLevel1(Student student, ILevel1.ILevel1Presenter presenter) {
        this.student = student;
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
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

    public boolean evaluateAnswer(int answer) {
        if (answer == correctAnswer){
            correctAnswers++;
        } else {
            incorrectAnswers ++;
        }
        return answer == correctAnswer;
    }

    public int getClearingScore(){
        return clearingScore;
    }

    public void levelPass(){
        student.incrementGpa(1);
        student.incrementHp(correctAnswers);
        student.incrementCredit(5);
        if (student.getCurrentLevel()<=1){
            student.incrementLevel();
        }
    }

    public void levelFail(){
        student.decrementGpa(1);
        student.decrementHp(incorrectAnswers);
    }
}

