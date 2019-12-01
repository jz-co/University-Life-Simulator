package com.example.universitylife.Game1;

import com.example.universitylife.Student.StudentFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Level1 {
    private StudentFacade student;
    private int numCorrectAnswers, numIncorrectAnswers, totalScore;
    private int clearingScore;

    private String question;
    private int correctAnswer;
    private List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*"));
    private int numberBoundary;

    //initialize the game
    public Level1(StudentFacade student) {
        this.student = student;
        this.numCorrectAnswers = 0;
        this.numIncorrectAnswers = 0;
        setClearingScore(5);
        setRandomNumberBoundary(10);
    }

    public void setRandomNumberBoundary(int num) {
        this.numberBoundary = num;
    }

    /**
     * Getter for the student stored in this level.
     *
     * @return the student stored in this level.
     */
    public StudentFacade getStudent() {
        return this.student;
    }

    public int getCorrectAnswer(){return this.correctAnswer;}

    /**
     * Getter for the number of questions correctly answered by the student.
     *
     * @return number of correct answers.
     */
    public int getNumCorrectAnswers() {
        return this.numCorrectAnswers;
    }

    /**
     * Getter for the number of questions incorrectly answered by the student.
     *
     * @return number of incorrect answers
     */
    public int getNumIncorrectAnswers() {
        return this.numIncorrectAnswers;
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
     * Setter for the number of points a student must earn to pass this level.
     *
     * @return number of incorrect answers
     */
    public void setClearingScore(int clearScore) {
        this.clearingScore = clearScore;
    }

    /**
     * Getter for the total score of the student.
     *
     * @return total score of the student
     */
    public int getTotalScore() {
        return this.totalScore;
    }

    /**
     * Setter for the total score of the student.
     *
     * @param score the new score to update the instance attribute with.
     */
    public void updateScore(int score) {
        this.totalScore = score;
    }

    /**
     * Creates a new question.
     *
     * @return a new question.
     */
    public String createQuestion() {
        int a = (int) (Math.random() * numberBoundary);
        int b = (int) (Math.random() * numberBoundary);

        int randomNum = (int) (Math.random() * (operators.size() - 1));
        String operation = operators.get(randomNum);

        switch (operation) {

            case "+":
                this.correctAnswer = a + b;
                break;
            case "-":
                this.correctAnswer = a - b;
                break;
            case "*":
                this.correctAnswer = a * b;
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
        if (answer == this.correctAnswer) {
            this.numCorrectAnswers++;
        } else {
            this.numIncorrectAnswers++;
        }
        return answer == this.correctAnswer;
    }


    /**
     * Calculates the GPA score earned for this level
     *
     * @param factor the total score this level is out of. For Level 1 and 2, it is out of
     *               1.0 and for Level 3, it is out of 2.0.
     * @return a double representing the total GPA score earned for this level
     */
    public double calculateLevelGpaScore(int factor) {
        double points;
        if (numCorrectAnswers >= clearingScore) {
            points = factor;
        } else {
            points = (numCorrectAnswers / clearingScore) * factor;
        }
        return points;
    }

    /**
     * Updates the student statistics if the level is passed.
     */
    public void levelPass() {
        double points = calculateLevelGpaScore(1);
        student.registerLevelResults(1, 1, points);
        //if (student.getCurrentLevel() <= 1) {
        //    student.incrementLevel();
        //}
    }

}