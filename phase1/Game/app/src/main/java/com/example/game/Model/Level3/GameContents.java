package com.example.game.Model.Level3;

import com.example.game.Contract.ILevel3;

/**
 * A game object.
 */
public abstract class GameContents {

    /**
     * x coordinate of the object in the grid.
     */
    protected int x;

    /**
     * y coordinate of the object in the grid.
     */
    protected int y;

    /**
     * A ILevel3.ILevel3GameView instance.
     */
    ILevel3.ILevel3GameView view;

    /**
     * The width of grid.
     */
    private int gridWidth;

    /**
     * The height of grid.
     */
    private int gridHeight;

    /**
     * Constructs a game object.
     *
     * @param view of game
     * @param gridWidth of game grid
     * @param gridHeight of game grid
     */
    GameContents(ILevel3.ILevel3GameView view, int gridWidth, int gridHeight) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.view = view;

    }

    /**
     * Updates the movements of the objects in the game.
     */
    public abstract void update();

    /**
     * Getter for the x coordinate of the object.
     *
     * @return x coordinate.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter for the y coordinate of the object.
     *
     * @return y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setter for the x coordinate of the object.
     * @param x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter for the y coordinate of the object.
     *
     * @param y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter for the gridWidth
     *
     * @return gridWidth of the grid
     */
    public int getGridWidth() {
        return this.gridWidth;
    }

    /**
     * Getter for the gridHeight
     *
     * @return gridHeight of the grid
     */
    public int getGridHeight() {
        return this.gridHeight;
    }
}
