package com.example.game.Presenter;

import com.example.game.Model.Level3.Arrow;
import com.example.game.Model.Level3.GameContents;
import com.example.game.Model.Level3.Wheel;

import java.util.ArrayList;
import java.util.List;

/**
 * Inspired by the code from A1.
 */
public class Lvl3GameItemManager {

    /**
     * Collection of all items in the game.
     */
    private List<GameContents> gameItems;

    /**
     * Wheel object.
     */
    private Wheel gameWheel;

    /**
     * high score in the game.
     */
    private int highScore = 0;

    /**
     * lives remaining in the game.
     */
    private int lives = 3;

    /**
     * The width of game grid
     */
    private int gridWidth;

    /**
     * The height of game grid
     */
    private int gridHeight;

    public Lvl3GameItemManager(int width, int height) {
        this.gridWidth = width;
        this.gridHeight = height;
        gameItems = new ArrayList<>();
    }

    /**
     * Getter for the gridWidth
     *
     * @return gridWidth
     */
    public int getGridWidth() {
        return this.gridWidth;
    }

    /**
     * Getter for the gridHeight
     *
     * @return gridHeight
     */
    public int getGridHeight() {
        return this.gridHeight;
    }

    /**
     * Getter for gameItems
     *
     * @return gameItems
     */
    public List<GameContents> getGameItems() {
        return gameItems;
    }

    /**
     * Updating items in the game.
     */
    void update() {
        gameWheel.update();
        Arrow moving_arrow = (Arrow) gameItems.get(2);
        moving_arrow.update();
    }

    /**
     * Create the Game items.
     */
    public void createGameItems(GameContents item) {
        gameItems.add(item);
        if (item instanceof Wheel) {
            gameWheel = (Wheel) item;
        }
    }

    /**
     * Getter for highScore
     *
     * @return highScore
     */
    public int getHighScore() {
        return this.highScore;
    }

    /**
     * Getter for lives
     *
     * @return lives
     */
    public int getLives() {
        return this.lives;
    }

}
