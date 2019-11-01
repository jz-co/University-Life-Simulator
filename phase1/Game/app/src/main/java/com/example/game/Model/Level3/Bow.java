package com.example.game.Model.Level3;

import com.example.game.Contract.ILevel3;

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
    public Bow(ILevel3.ILevel3GameView view, int width, int height) {
        super(view, width, height);
        super.setX(21 * (width) / 100);
        super.setY(81 * (height) / 100);
    }

    /**
     * A bow does not move in the game.
     */
    public void update() {}
}
