package com.example.universitylife.Model.Level2;


import com.example.universitylife.Contract.ILevel2;
import com.example.universitylife.Model.Student;

import java.util.ArrayList;

public class GameLevel2 {
    private Student student;
    private Basket basket;
    private int score, framewidth, frameHeight;
    private ArrayList<FallingObject> fallingObjects;
    private ILevel2.ILevel2Presenter presenter;

    public GameLevel2(Student student, Basket basket, int FrameWidth, int FrameHeight, ArrayList<FallingObject> fallingObjects, ILevel2.ILevel2Presenter presenter) {
        this.basket = basket;
        this.basket.setAppearence(student.getAppearance());
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
    public void play() {
        int element = (int) (Math.random() * fallingObjects.size());
        score += game(element);
        // setting the score in the frontend
        presenter.setScore();
    }

    public void initializeGame() {
        for (FallingObject o: fallingObjects){
            o.setX_coordinate((int)(Math.random()*framewidth));
            o.setY_coordinate(-100);
            this.presenter.updateViewPosById(o.getFrontEndImageID());
        }
        this.presenter.updateViewPosById(basket.getImageId());
        score = 0;
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


    /** return the score of the player in this game
     *
     * @return int score
     */
    public int getScore() {
        return score;
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

    public void levelClear(){
        if (student.getCurrentLevel() == 2){
            student.incrementLevel();
        }
        student.incrementGpa(1);
        student.incrementCredit(5);
        student.incrementHp(score);
    }

    public void levelFail(){
        student.decrementGpa(1);
    }

}
