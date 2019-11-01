package com.example.game.Model.Level3;

import com.example.game.Contract.ILevel3;

public class Wheel extends GameContents {

    private String direction = "->";
    private int speed;
    private int width;
    private int height;

    public Wheel(ILevel3.ILevel3GameView view, int width, int height) {
        super(view, width, height);
        super.setX((25 * width) / 100);
        super.setY((15 * height) / 100);
        speed = 5;
        this.width = view.getWheelWidth();
        this.height = view.getWheelHeight();
    }

    public int getWidth() {
        return view.getWheelWidth();
    }

    public int getHeight() {
        return view.getWheelHeight();
    }

    public void update() {
        if (!(x < gridWidth - width & x > 0)) {
            reverse();
        }
        if (direction.equals("->")) {
            x += speed;
        } else {
            x -= speed;
        }
    }

    public void setSpeed() {
        speed += 2;
    }

    public void reverse() {
        if (direction.equals("->")) {
            direction = "<-";
        } else {
            direction = "->";
        }
    }
}
