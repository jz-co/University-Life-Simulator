package com.example.game.Model.Level3;

import com.example.game.Contract.ILevel3;

/**
 * An arrow object of the game.
 */
public class Arrow extends GameContents implements TouchEvent {

    /**
     * Check for whether a touch was made by the player.
     */
    private boolean touch;

    /**
     * Check for whether the arrow is at the end of the grid.
     */
    private boolean reachEnd;

    /**
     * Constructs an arrow.
     *
     * @param view of game
     * @param width of game grid
     * @param height of game grid
     */
    public Arrow(ILevel3.ILevel3GameView view, int width, int height) {
        super(view, width, height);
        super.setX(width - 570);
        super.setY(height - 550);
        touch = false;
        reachEnd = false;
    }

    /**
     * A getter for the touch variable.
     *
     * @return touch identified in the game.
     */
    public boolean getTouch() {
        return touch;
    }

    /**
     * A setter for the touch variable.
     *
     * @param touch identified in the game.
     */
    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    /**
     * Getter for reachEnd
     *
     * @return reachEnd checks whether the arrow is at the end of the grid.
     */
    public boolean getReach() {
        return reachEnd;
    }

    /**
     * Updates the movement of the arrows in the game.
     */
    public void update() {
        if (y > 20) {
            y -= 20;
        } else {
            reachEnd = true;
        }

    }
}
