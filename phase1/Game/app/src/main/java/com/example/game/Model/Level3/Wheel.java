package com.example.game.Model.Level3;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Wheel extends GameContents {

    Bitmap image;
    private String direction = "->";
    private int speed;

    public Wheel(Bitmap image, int width, int height) {
        super(image, width, height);
        this.image = image;
        super.setX((25 * width) / 100);
        super.setY((15 * height) / 100);
        speed = 5;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, getX(), getY(), null);
    }

    public void update() {
        if (!(x < gridWidth - image.getWidth() & x > 0)) {
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
