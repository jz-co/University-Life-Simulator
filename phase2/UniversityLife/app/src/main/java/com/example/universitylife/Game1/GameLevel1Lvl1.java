package com.example.universitylife.Game1;

import com.example.universitylife.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameLevel1Lvl1 {
    private Student student;
    private int correctAnswers, incorrectAnswers;
    private int clearingScore = 5;

    private String question;
    private int correctAnswer;
    private List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*"));

    //initialize the game
    public GameLevel1Lvl1(Student student) {
        this.student = student;
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
    }

    /**
     * Getter for the student stored in this level.
     *
     * @return the student stored in this level.
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * Getter for the number of questions correctly answered by the student.
     *
     * @return number of correct answers.
     */
    public int getCorrectAnswers() {
        return this.correctAnswers;
    }

    /**
     * Getter for the number of questions incorrectly answered by the student.
     *
     * @return number of incorrect answers
     */
    public int getIncorrectAnswers() {
        return this.incorrectAnswers;
    }


    /**
     * Creates a new question.
     *
     * @return a new question.
     */
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

    /**
     * Evaluates if the input answer if correct.
     *
     * @param answer the input answer.
     * @return a boolean determining if the answer is correct or not.
     */
    public boolean evaluateAnswer(int answer) {
        if (answer == correctAnswer) {
            correctAnswers++;
        } else {
            incorrectAnswers++;
        }
        return answer == correctAnswer;
    }

    /**
     * Getter for the clearing score of the game.
     *
     * @return an int representing the clearing score of the game.
     */
    public int getClearingScore() {
        return clearingScore;
    }

    /**
     * Updates the student statistics if the level is passed.
     */
    public void levelPass() {
        student.incrementGpa(1);
        student.incrementHp(correctAnswers);
        student.incrementCredit(5);
        if (student.getCurrentLevel() <= 1) {
            student.incrementLevel();
        }
    }

    /**
     * Updates the student statistics if the level is failed.
     */
    public void levelFail() {
        student.decrementGpa(1);
        student.decrementHp(incorrectAnswers);
    }
}

