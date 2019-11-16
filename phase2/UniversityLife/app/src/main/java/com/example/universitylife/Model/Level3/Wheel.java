package com.example.universitylife.Model.Level3;

import com.example.universitylife.Contract.ILevel3;

/**
 * A wheel object in the game.
 */
public class Wheel extends GameContents {

    /**
     * Determines the direction of movement of the wheel.
     */
    private String direction = "->";

    /**
     * The speed of movement of the wheel.
     */
    private int speed;

    /**
     * The width of the wheel object.
     */
    private int width;

    /**
     * The height of the wheel object.
     */
    private int height;

    /**
     * Constructs a wheel object.
     *
     * @param view of game
     * @param width of game grid
     * @param height of game grid
     */
    public Wheel(ILevel3.ILevel3GameView view, int width, int height) {
        super(view, width, height);
        super.setX((25 * width) / 100);
        super.setY((15 * height) / 100);
        speed = 5;
        this.width = view.getWheelWidth();
        this.height = view.getWheelHeight();
    }

    /**
     * Getter for the width of the wheel.
     *
     * @return width of the wheel
     */
    public int getWidth() {
        return view.getWheelWidth();
    }

    /**
     * Getter for the height of the wheel.
     *
     * @return height of the wheel
     */
    public int getHeight() {
        return view.getWheelHeight();
    }

    /**
     * Sets the speed of the wheel in the game.
     */
    void setSpeed() {
        if (Math.random() <= 0.3 & speed >= 9){speed -= 2;}
        else{speed += 2;}
    }

    /**
     * Reverses the direction of movement of the wheel in the grid.
     */
    void reverse() {
        if (direction.equals("->")) {
            direction = "<-";
        } else {
            direction = "->";
        }
    }

    /**
     * Updates the movement of the wheel in the game.
     */
    public void update() {
        if (!(x < getGridWidth() - width & x > 0)) {
            reverse();
        }
        if (direction.equals("->")) {
            x += speed;
        } else {
            x -= speed;
        }
    }
}
