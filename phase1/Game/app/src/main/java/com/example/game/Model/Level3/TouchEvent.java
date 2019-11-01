package com.example.game.Model.Level3;

/**
 * An interface for any class that requires a touch event.
 */
public interface TouchEvent {
    boolean getTouch();

    /**
     * Sets the touch when identified.
     *
     * @param touch identified
     */
    void setTouch(boolean touch);
}
