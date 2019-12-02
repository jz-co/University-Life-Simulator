package com.example.universitylife.Game2;

import android.content.Intent;

import com.example.universitylife.GameManager;
import com.example.universitylife.IData;
import com.example.universitylife.LevelPresenter;
import com.example.universitylife.R;
import com.example.universitylife.Student.StudentFacade;

import java.util.ArrayList;

public class Game2Lvl2Presenter extends LevelPresenter implements ILevel2.ILevel2PresenterLvl2 {
    private ILevel2.ILevel2View view;
    private GameLevel2Lvl2 gameLevel;
    private FallingObject redObject, yellowObject, blueObject, whatYouShouldDo, whatYouShouldNotdo;;
    private int frameWidth = 1000;
    private int frameHeight = 1500;
    private int basketInt = 1455;
    private int clearingScore = 30;
    private boolean nextLevelUnlocked;
    private boolean boughtUmbrella = false;

    public Game2Lvl2Presenter(ILevel2.ILevel2View view, String username, IData dataHandler) {
        super(username, dataHandler);
        this.view = view;
        this.gameManager = new GameManager(username, dataHandler);
        if (gameManager.getHighestLevel(2) > 2){
            nextLevelUnlocked = true;
        }
        ArrayList<FallingObject> fallingObjects = new ArrayList<>();
        FallingObjectFactory factory = new FallingObjectFactoryLvl2();
        redObject = factory.getFallingObject("red");
        yellowObject = factory.getFallingObject("yellow");
        blueObject = factory.getFallingObject("blue");
        whatYouShouldDo = factory.getFallingObject("what you should do");
        whatYouShouldNotdo = factory.getFallingObject("what you should not do");
        fallingObjects.add(redObject);
        fallingObjects.add(blueObject);
        fallingObjects.add(yellowObject);
        fallingObjects.add(whatYouShouldDo);
        fallingObjects.add(whatYouShouldNotdo);
        Basket basket = new Basket(R.id.character_2, 0, basketInt);
        StudentFacade student = this.gameManager.getCurrentStudent();
        boughtUmbrella = student.getItem(2) > 0;
        this.gameLevel = new GameLevel2Lvl2(student, basket, frameWidth, frameHeight, fallingObjects, this);
    }

    @Override
    public void goToNextLevel() {
        if (nextLevelUnlocked) {
            view.goToNextLevel();
        } else{
            view.displayMessage("Sorry, the current level has not been unlocked. You need to score at " +
                    "least 10 points to clear the level.");
        }
    }

    @Override
    public void updateViewPosById(int id) {
        view.updateViewPosById(id);
    }

    @Override
    public void setScore() {
        view.setScore();
    }

    public void quitGame() {
        // adding the score of the player to their hp
        if (gameLevel.getScore() >= clearingScore){
            view.displayMessage("Congratulation, you have cleared this level!");
            gameLevel.levelClear();
            this.nextLevelUnlocked = true;
        } else {
            view.displayMessage("Sorry, you did not clear this level!");
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
        gameLevel.getBasket().move_left(20, 0);
    }

    /** Move the basket to the right by 20 units
     *
     */
    public void move_right(){
        gameLevel.getBasket().move_right(20, frameWidth);
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

    /**  get the id of the image for the yellow ball
     *
     * @return int yellowObject appearence
     */
    public int getYellowAppearence(){
        return yellowObject.getAppearence();
    }

    /** get the  id of the image of the whatYouShouldDo
     * @return int whatYouShouldDo appearance
     *
     */
    public int getWhatYouShouldDoAppearance(){
        return whatYouShouldDo.getAppearence();
    }

    /** get the  id of the image of the whatYouShouldNotDo
     * @return int whatYouShouldDo appearance
     *
     */
    public int getWhatYouShouldNotDoAppearance(){
        return whatYouShouldNotdo.getAppearence();
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

    /** get the x coordinate of the whatYouShouldDo object
     *
     * @return the x coordinate of the whatYouShouldDo
     */
    public int getWhatYouShouldDoX(){
        return whatYouShouldDo.getX_coordinate();
    }

    /** get the y coordinate of the whatYouShouldDo object
     *
     * @return the y coordinate of the whatYouShouldDo
     */
    public int getWhatYouShouldDoY(){
        return whatYouShouldDo.getY_coordinate();
    }

    /** get the x coordinate of the whatYouShouldNotDo object
     *
     * @return the x coordinate of the whatYouShouldDo
     */
    public int getWhatYouShouldNotDoX(){
        return whatYouShouldNotdo.getX_coordinate();
    }

    /** get the y coordinate of the whatYouShouldNotDo object
     *
     * @return the y coordinate of the whatYouShouldDo
     */
    public int getWhatYouShouldNotDoY(){
        return whatYouShouldNotdo.getY_coordinate();
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

    /** set umbrella open
     *
     */
    public void setUmbrellaOpen(){
        gameLevel.setUmbrellaOpen();
    }

    /** set umbrella close
     *
     */
    public void setUmbrellaClose(){
        gameLevel.setUmbrellaClose();
    }

    public boolean isBoughtUmbrella() {
        return boughtUmbrella;
    }

}
