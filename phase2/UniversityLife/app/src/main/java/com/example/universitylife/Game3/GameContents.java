package com.example.universitylife.Game3;

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
     * The level of the game
     */
    private int level;

    private int windSpeed = 0;

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
        if (view instanceof Lvl3GameView) {
            level = 1;
        } else if (view instanceof Lvl3GameView2) {
            level = 2;
        } else if (view instanceof Lvl3GameView3) {
            level = 3;
        } else {
            level = 4;
        }
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

    public int getLevel() {
        return level;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String direction) {
        windSpeed = (int) (5 * Math.random());
        if (!direction.equals("+")) {
            windSpeed = -windSpeed;
        }
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
