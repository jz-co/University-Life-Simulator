package com.example.universitylife.Game2;

import com.example.universitylife.IData;
import com.example.universitylife.GameManager;
import com.example.universitylife.LevelPresenter;
import com.example.universitylife.R;

import java.util.ArrayList;

public class Game2Presenter extends LevelPresenter implements ILevel2.ILevel2Presenter {
    private ILevel2.ILevel2View view;
    private GameLevel2 gameLevel;
    private com.example.universitylife.Game2.redObject redObject;
    private com.example.universitylife.Game2.blueObject blueObject;
    private com.example.universitylife.Game2.yellowObject yellowObject;
    private int frameWidth = 1000;
    private int clearingScore = 10;
    private boolean nextLevelUnlocked = false;

    public Game2Presenter(ILevel2.ILevel2View view, IData datahandler, String username){
        super(datahandler, username);
        this.view = view;
        this.gameManager = new GameManager(datahandler, username);
        if (gameManager.getCurrentLevel()>2){
            nextLevelUnlocked = true;
        }
        ArrayList<FallingObject> fallingObjects = new ArrayList<>();
        redObject = new redObject((int)(Math.random()*frameWidth), -100);
        yellowObject = new yellowObject(((int)(Math.random()*frameWidth)) , -100);
        blueObject = new blueObject(((int)(Math.random() *frameWidth)), -100);
        fallingObjects.add(redObject);
        fallingObjects.add(blueObject);
        fallingObjects.add(yellowObject);
        int basketInt = 1455;
        Basket basket = new Basket(R.id.character, 0, basketInt);
        int frameHeight = 1500;
        this.gameLevel = new GameLevel2(this.gameManager.getCurrentStudent(), basket, frameWidth, frameHeight, fallingObjects, this);
    }

    /** proceed to the next level
     *
     */
    @Override
    public void goToNextLevel(){
        if (nextLevelUnlocked) {
            view.goToLevel3();
        } else{
            view.displayMessage("Sorry, the current level has not been unlocked. You need to score at " +
                    "least 10 points to clear the level.");
        }
    }

    @Override
    public void updateViewPosById(int id) {
        view.updateViewPosById(id);
    }

    public void quitGame() {
        // adding the score of the player to their hp
        if (gameLevel.getScore() >= clearingScore){
            view.displayMessage("Congratulation, you have cleared this level!");
            gameLevel.levelClear();
            this.nextLevelUnlocked = true;
        } else {
            view.displayMessage("Sorry, you did not clear this level!");
            gameLevel.levelFail();
        }
        this.updateDisplay(view);
        gameManager.saveBeforeExit();
        view.quitGame();
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
        gameLevel.getBasket().move_left(40, 0);
    }

    /** Move the basket to the right by 20 units
     *
     */
    public void move_right(){
        gameLevel.getBasket().move_right(40, frameWidth);
    }


    /** set the score of the game in the frontend
     *
     */
    @Override
    public void setScore() {
        view.setScore();
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

}
