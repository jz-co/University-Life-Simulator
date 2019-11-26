package com.example.universitylife.Game2;

import com.example.universitylife.IData;
import com.example.universitylife.LevelPresenter;
import com.example.universitylife.R;
import com.example.universitylife.Student;

import java.util.ArrayList;

public class Game2Lvl3Presenter extends LevelPresenter implements ILevel2.ILevel2PresenterLvl3{
    private ILevel2.ILevel2View view;
    private GameLevel2Lvl3 gameLevel;
    private FallingObject redObject, yellowObject, blueObject, whatYouShouldDo, whatYouShouldNotdo, killingObject;
    private int frameWidth = 1000;
    private int frameHeight = 1500;
    private int basketInt = 1455;
    private int clearingScore = 40;
    private boolean nextLevelUnlocked;
    private boolean boughtUmbrella = false;

    Game2Lvl3Presenter (ILevel2.ILevel2View view, IData dataHandler, String username){
        super(dataHandler, username);
        this.view = view;
        if (gameManager.getCurrentLevel()>2){
            nextLevelUnlocked = true;
        }
        ArrayList<FallingObject> fallingObjects = new ArrayList<>();
        FallingObjectFactory factory = new FallingObjectFactoryLvl3();
        redObject = factory.getFallingObject("red");
        yellowObject = factory.getFallingObject("yellow");
        blueObject = factory.getFallingObject("blue");
        whatYouShouldDo = factory.getFallingObject("what you should do");
        whatYouShouldNotdo = factory.getFallingObject("what you should not do");
        killingObject = factory.getFallingObject("killing object");
        fallingObjects.add(redObject);
        fallingObjects.add(blueObject);
        fallingObjects.add(yellowObject);
        fallingObjects.add(whatYouShouldDo);
        fallingObjects.add(whatYouShouldDo);
        fallingObjects.add(killingObject);
        Basket basket = new Basket(R.id.character_3, 0, basketInt);
        Student student = this.gameManager.getCurrentStudent();
        // boughtUmbrella = student.getItems()[1] > 0;
        this.gameLevel = new GameLevel2Lvl3(student, basket, frameWidth, frameHeight, fallingObjects, this);
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

    @Override
    public void quitGameByKilling() {
        view.quitGame();
        quitGame();
        view.stopTimer();
    }

    /** set umbrella open
     *
     */
    @Override
    public void setUmbrellaOpen(){
        gameLevel.setUmbrellaOpen();
    }

    /** set umbrella close
     *
     */
    @Override
    public void setUmbrellaClose(){
        gameLevel.setUmbrellaClose();
    }

    @Override
    public boolean isBoughtUmbrella() {
        return boughtUmbrella;
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
    @Override
    public void play(){
        gameLevel.play();
    }

    /** get the score of the game
     *
     * @return int score (the score of the catching game
     */
    @Override
    public int getScore(){
        return gameLevel.getScore();
    }

    /** Move the basket to the left by 20 units
     *
     */
    @Override
    public void move_left(){
        gameLevel.getBasket().move_left(20, 0);
    }

    /** Move the basket to the right by 20 units
     *
     */
    @Override
    public void move_right(){
        gameLevel.getBasket().move_right(20, frameWidth);
    }

    /** get the id of the image for the red ball
     *
     * @return int redObject appearence
     */
    @Override
    public int getRedAppearence(){
        return redObject.getAppearence();
    }

    /** get the id of the image for the blue ball
     *
     * @return int blueObject appearence
     */
    @Override
    public int getBlueAppearence(){
        return blueObject.getAppearence();
    }

    /**  get the id of the image for the yellow ball
     *
     * @return int yellowObject appearence
     */
    @Override
    public int getYellowAppearence(){
        return yellowObject.getAppearence();
    }

    /** get the  id of the image of the whatYouShouldDo
     * @return int whatYouShouldDo appearance
     *
     */
    @Override
    public int getWhatYouShouldDoAppearance(){
        return whatYouShouldDo.getAppearence();
    }

    /** get the  id of the image of the whatYouShouldNotDo
     * @return int whatYouShouldDo appearance
     *
     */
    @Override
    public int getWhatYouShouldNotDoAppearance(){
        return whatYouShouldNotdo.getAppearence();
    }

    /** get the appearance of the killing object
     * @return int appearance of the killing object
     */
    @Override
    public int getKillingAppearance(){
        return killingObject.getAppearence();
    }

    /** get the id of the image for the basket
     *
     * @return int basket appearance
     */
    @Override
    public int getBasketAppearence(){
        return gameLevel.getBasket().getAppearence();
    }

    /** get the x coordinate of the red object
     *
     * @return the x coordinate of the red object
     */
    @Override
    public int getRedX(){
        return redObject.getX_coordinate();
    }

    /** get the y coordinate of the red object
     *
     * @return the y coordinate of the red object
     */
    @Override
    public int getRedY(){
        return redObject.getY_coordinate();
    }

    /** get the x coordinate of the blue object
     *
     * @return the x coordinate of the blue object
     */
    @Override
    public int getBlueX(){
        return blueObject.getX_coordinate();
    }

    /** get the y coordinate of the blue object
     *
     * @return the y coordinate of the blue object
     */
    @Override
    public int getBlueY(){
        return blueObject.getY_coordinate();
    }

    /** get the x coordinate of the yellow object
     *
     * @return the x coordinate of the yellow object
     */
    @Override
    public int getYellowX(){
        return yellowObject.getX_coordinate();
    }

    /** get the y coordinate of the yellow object
     *
     * @return the y coordinate of the yellow object
     */
    @Override
    public int getYellowY(){
        return yellowObject.getY_coordinate();
    }

    /** get the x coordinate of the whatYouShouldDo object
     *
     * @return the x coordinate of the whatYouShouldDo
     */
    @Override
    public int getWhatYouShouldDoX(){
        return whatYouShouldDo.getX_coordinate();
    }

    /** get the y coordinate of the whatYouShouldDo object
     *
     * @return the y coordinate of the whatYouShouldDo
     */
    @Override
    public int getWhatYouShouldDoY(){
        return whatYouShouldDo.getY_coordinate();
    }

    /** get the x coordinate of the whatYouShouldNotDo object
     *
     * @return the x coordinate of the whatYouShouldDo
     */
    @Override
    public int getWhatYouShouldNotDoX(){
        return whatYouShouldNotdo.getX_coordinate();
    }

    /** get the y coordinate of the whatYouShouldNotDo object
     *
     * @return the y coordinate of the whatYouShouldDo
     */
    @Override
    public int getWhatYouShouldNotDoY(){
        return whatYouShouldNotdo.getY_coordinate();
    }

    /** get the x coordinate of the killing object
     * @return the x coordinate of the killng object
     */
    @Override
    public int getKillingX(){
        return killingObject.getX_coordinate();
    }

    /** get the x coordinate of the killing object
     * @return the x coordinate of the killng object
     */
    @Override
    public int getKillingY(){
        return killingObject.getY_coordinate();
    }

    /** get the x coordinate of the basket object
     *
     * @return the x coordinate of the basket object
     */
    @Override
    public int getBasketX(){
        return gameLevel.getBasket().getX();
    }

    /** get the y coordinate of the basket object
     *
     * @return the y coordinate of the bakset object
     */
    @Override
    public int getBasketY(){
        return gameLevel.getBasket().getY();
    }

    /** initialize the position of objects at the start of the game
     *
     */
    @Override
    public void initializeGame(){
        gameLevel.initializeGame();
    }

}
