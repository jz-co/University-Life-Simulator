package com.example.game.Presenter;

import com.example.game.Contract.IData;
import com.example.game.Contract.IGameManager;
import com.example.game.Contract.ILevel2;
import com.example.game.Model.GameManager;
import com.example.game.Model.Level2.Basket;
import com.example.game.Model.Level2.FallingObject;
import com.example.game.Model.Level2.GameLevel2;
import com.example.game.Model.Level2.blueObject;
import com.example.game.Model.Level2.redObject;
import com.example.game.Model.Level2.yellowObject;
import com.example.game.Model.Student;
import com.example.game.R;

import java.util.ArrayList;

public class Level2Presenter extends com.example.game.Presenter.LevelPresenter implements ILevel2.ILevel2Presenter {
    private ILevel2.ILevel2View view;
    private GameLevel2 gameLevel;
    private ArrayList<FallingObject> fallingObjects;
    private com.example.game.Model.Level2.redObject redObject;
    private com.example.game.Model.Level2.blueObject blueObject;
    private com.example.game.Model.Level2.yellowObject yellowObject;
    private int frameWidth = 1000;
    private int frameHeight = 1500;
    private int basketInt = 1455;
    private GameManager gameManager;

    public Level2Presenter(ILevel2.ILevel2View view, IData datahandler, String username){
        super(datahandler, username);
        this.view = view;
        this.gameManager = new GameManager(datahandler, username);
        ArrayList<FallingObject> fallingObjects = new ArrayList<>();
        redObject = new redObject((int)(Math.random()*frameWidth), -100);
        yellowObject = new yellowObject(((int)(Math.random()*frameWidth)) , -100);
        blueObject = new blueObject(((int)(Math.random() *frameWidth)), -100);
        fallingObjects.add(redObject);
        fallingObjects.add(blueObject);
        fallingObjects.add(yellowObject);
        Basket basket = new Basket(R.id.character, 0, basketInt);
        this.gameLevel = new GameLevel2(this.gameManager.getCurrentStudent(), basket, frameWidth, frameHeight, fallingObjects, this);
    }

    /** proceed to the next level
     *
     */
    @Override
    public void goToNextLevel(){
        view.goToLevel3();
    }

    @Override
    public void updateViewPosById(int id) {
        view.updateViewPosById(id);
    }

    @Override
    public void quitGame() {
        // adding the score of the player to their hp
        gameLevel.getStudent().incrementHp(gameLevel.getScore());
        gameLevel.getStudent().incrementCredit(5);
        gameLevel.getStudent().incrementGpa(1);
        this.updateDisplay(view);
        gameManager.saveBeforeExit();
    }

    /** play the catching ball game
     *
     */
    public void play(){
        gameLevel.play();
    }

    /** get the score of the game
     *
     * @return int score (the score of the catching game
     */
    public int getScore(){
        return gameLevel.getScore();
    }


    /** Move the basket to the left by 20 units
     *
     */
    public void move_left(){
        gameLevel.getBasket().move_left(20, 0);
    }

    /** Move the basket to the right by 20 units
     *
     */
    public void move_right(){
        gameLevel.getBasket().move_right(20, frameWidth);
    }

    /** return student in the catching ball game
     *
     * @return student
     */
    Student getStudent(){
        return gameLevel.getStudent();
    }

    /** return the basket of the game
     *
     * @return Basket
     */
    public Basket getBasket(){
        return gameLevel.getBasket();
    }

    /** set the score of the game in the frontend
     *
     */
    @Override
    public void setScore() {
        view.setScore();
    }


    /** set the amounts of seconds left in the frontend
     *
     */
    @Override
    public void setSecondsRemaining() {
        view.setSecondRemaining();
    }

    /** get the id of the image for the red ball
     *
     * @return int redObject appearence
     */
    public int getRedAppearence(){
        return redObject.getAppearence();
    }

    /** get the id of the image for the blue ball
     *
     * @return int blueObject appearence
     */
    public int getBlueAppearence(){
        return blueObject.getAppearence();
    }

    /**  get te id of the image for the yellow ball
     *
     * @return int yellowObject appearence
     */
    public int getYellowAppearence(){
        return yellowObject.getAppearence();
    }

    /** get the id of the image for the basket
     *
     * @return int basket appearance
     */
    public int getBasketAppearence(){
        return gameLevel.getBasket().getAppearence();
    }

    /** get the x coordinate of the red object
     *
     * @return the x coordinate of the red object
     */
    public int getRedX(){
        return redObject.getX_coordinate();
    }

    /** get the y coordinate of the red object
     *
     * @return the y coordinate of the red object
     */
    public int getRedY(){
        return redObject.getY_coordinate();
    }

    /** get the x coordinate of the blue object
     *
     * @return the x coordinate of the blue object
     */
    public int getBlueX(){
        return blueObject.getX_coordinate();
    }

    /** get the y coordinate of the blue object
     *
     * @return the y coordinate of the blue object
     */
    public int getBlueY(){
        return blueObject.getY_coordinate();
    }

    /** get the x coordinate of the yellow object
     *
     * @return the x coordinate of the yellow object
     */
    public int getYellowX(){
        return yellowObject.getX_coordinate();
    }

    /** get the y coordinate of the yellow object
     *
     * @return the y coordinate of the yellow object
     */
    public int getYellowY(){
        return yellowObject.getY_coordinate();
    }

    /** get the x coordinate of the basket object
     *
     * @return the x coordinate of the basket object
     */
    public int getBasketX(){
        return gameLevel.getBasket().getX();
    }

    /** get the y coordinate of the basket object
     *
     * @return the y coordinate of the bakset object
     */
    public int getBasketY(){
        return gameLevel.getBasket().getY();
    }

    /** initialize the position of objects at the start of the game
     *
     */
    public void initializeGame(){
        gameLevel.initializeGame();
    }

    /** return whether level2 is cleared or not
     *
     * @return boolean whether the level2 is cleared
     */
    public boolean thisLevelUnlocked(){
        int level = gameLevel.getStudent().getCurrentLevel();
        return level > 2;
    }

    /** increment level of the student
     *
     */
    public void incrementStudentLevel(){
        if (gameLevel.getStudent().getCurrentLevel() <= 2){
            gameLevel.getStudent().incrementLevel();
        }
    }
}
