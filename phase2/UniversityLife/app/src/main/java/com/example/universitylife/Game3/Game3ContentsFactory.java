package com.example.universitylife.Game3;

import java.util.ArrayList;
import java.util.List;

/**
 * Inspired by the code from A1.
 *
 * A factory class for interacting with all the objects in the game.
 *
 */
public class  Game3ContentsFactory{

    /**
     * Collection of all items in the game.
     */
    private List<GameContents> gameItems;

    /**
     * Wheel object in the game.
     */
    private Wheel gameWheel;

    /**
     * The score in the game.
     */
    private int score = 0;

    /**
     * The lives remaining in the game.
     */
    private int lives = 3;

    /**
     * The width of game grid.
     */
    protected int gridWidth;

    /**
     * The height of game grid.
     */
    private int gridHeight;

    public Game3ContentsFactory(int width, int height) {
        this.gridWidth = width;
        this.gridHeight = height;
        gameItems = new ArrayList<>();
    }

    /**
     * Getter for the gridWidth.
     *
     * @return gridWidth
     */
    public int getGridWidth() {
        return this.gridWidth;
    }

    /**
     * Getter for the gridHeight.
     *
     * @return gridHeight
     */
    public int getGridHeight() {
        return this.gridHeight;
    }

    /**
     * Getter for gameItems.
     *
     * @return gameItems
     */
    public List<GameContents> getGameItems() {
        return gameItems;
    }

    /**
     * Getter for score.
     *
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Getter for lives.
     *
     * @return lives
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * Updating items in the game.
     */
    public void update() {
        gameWheel.update();
        Arrow moving_arrow = (Arrow) gameItems.get(0);

        if (moving_arrow.getTouch()) {
            moving_arrow.update();
            if ((gameWheel.getX() <= moving_arrow.getX() & moving_arrow.getX() <= gameWheel.getX() + gameWheel.getWidth()) &
                    (gameWheel.getY() <= moving_arrow.getY() & moving_arrow.getY() <= gameWheel.getY() + gameWheel.getHeight())) {

                // player earns a score when the arrow touches the wheel.
                score += 1;
                gameWheel.setSpeed();
                gameItems.remove(moving_arrow);
            }
            if (moving_arrow.getReach()) {
                gameItems.remove(moving_arrow);

                // player loses a life when they miss the wheel.
                lives -= 1;
            }

        }
    }

    /**
     * Creates the game items collection.
     */
    public void createGameItems(GameContents item) {
        gameItems.add(item);
        if (item instanceof Wheel) {
            gameWheel = (Wheel) item;
        }
    }
}
