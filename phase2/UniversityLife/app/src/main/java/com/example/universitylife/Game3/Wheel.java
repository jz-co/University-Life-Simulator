package com.example.universitylife.Game3;

/**
 * A wheel object in the game.
 */
public class Wheel extends GameContents {

    /**
     * Determines the direction of movement of the wheel.
     */
    private String direction_x;

    private String direction_y = "|";

    /**
     * The speed of movement of the wheel.
     */
    private int x_speed = 5;

    private int y_speed = 0;

    /**
     * The width of the wheel object.
     */
    private int width;

    /**
     * The height of the wheel object.
     */
    private int height;

    private int score = 0;

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
        this.width = view.getWheelWidth();
        this.height = view.getWheelHeight();
        setDirection();
    }

    /**
     * Getter for the width of the wheel.
     *
     * @return width of the wheel
     */
    public int getWidth() {
        return view.getWheelWidth();
    }

    private void setDirection() {
        if (Math.random() < 0.5) {
            direction_x = "->";
        } else {
            direction_x = "<-";
        }
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
        if (getLevel() == 1) {
            setLevel1Speed(1);
        } else if (getLevel() == 2) {
            setLevel1Speed(2);
            if (score >= 1) {
                setLevel2Speed();
            }
        } else {
            setLevel1Speed(3);
            if (score <= 1) {
                setLevel2Speed();
            } else {
                setLevel3Speed();
            }
        }
        score++;
    }

    private void setLevel1Speed(int val) {
        if (Math.random() <= 0.3 & x_speed >= 24) {
            x_speed -= val;
        } else {
            x_speed += val;
        }
    }

    private void setLevel2Speed() {
        double val = Math.random();
        if (val <= 0.3) {
            y = (int) (150 * val);
        } else if (val <= 0.65) {
            y = (int) (300 * val);
        } else {
            y = (int) (600 * val);
        }
    }

    private void setLevel3Speed() {
        double val = Math.random();
        if (val < 0.5 & y_speed > 2) {
            y_speed--;
        } else {
            y_speed++;
        }
    }

    /**
     * Reverses the direction of movement of the wheel in the grid.
     */
    private void reverse_x() {
        if (direction_x.equals("->")) {
            direction_x = "<-";
        } else {
            direction_x = "->";
        }
    }

    private void reverse_y() {
        if (direction_y.equals("^")) {
            direction_y = "|";
        } else {
            direction_y = "^";
        }
    }

    /**
     * Updates the movement of the wheel in the game.
     */
    public void update() {
        if (!(x < getGridWidth() - width & x > 0)) {
            reverse_x();
        }
        if (!(y < getGridHeight() - height - 500 & y > 200)) {
            reverse_y();
        }
        if (direction_x.equals("->")) {
            x += x_speed;
        } else {
            x -= x_speed;
        }
        if (getLevel() == 3) {
            if (direction_y.equals("|")) {
                y += y_speed;
            } else {
                y -= y_speed;
            }
        }
    }
}
