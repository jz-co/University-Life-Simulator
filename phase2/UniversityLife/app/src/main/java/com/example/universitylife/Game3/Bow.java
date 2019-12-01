package com.example.universitylife.Game3;

/**
 * A bow object of the game.
 */
public class Bow extends GameContents {

    /**
     * Constructs a bow object.
     *
     * @param view of game
     * @param width of game grid
     * @param height of game grid
     */
    public Bow(int level, int width, int height) {
        super(level, width, height);
        super.setX(21 * (width) / 100);
        super.setY(81 * (height) / 100);
    }

    /**
     * A bow does not move in the game.
     */
    public void update() {}
}
