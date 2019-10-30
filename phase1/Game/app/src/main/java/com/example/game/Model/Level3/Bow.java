package com.example.game.Model.Level3;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Bow extends GameContents {
    Bitmap image;

    public Bow(Bitmap image, int width, int height) {
        super(image, width, height);
        this.image = image;
        super.setX(21 * (width) / 100);
        super.setY(81 * (height) / 100);
    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, getX(), getY(), null);
    }

    public void update() {
    }
}
