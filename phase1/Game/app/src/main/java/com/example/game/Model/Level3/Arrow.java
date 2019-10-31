package com.example.game.Model.Level3;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Arrow extends GameContents implements TouchEvent {
    Bitmap image;

    private boolean touch, reach_end;

    public Arrow(Bitmap image, int width, int height) {
        super(image, width, height);
        this.image = image;
        super.setX(width - 570);
        super.setY(height - 550);
        touch = false;
        reach_end = false;
    }

    public boolean getTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    public boolean getReach() {
        return reach_end;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.image, getX(), getY(), null);
    }

    public void update() {
        if (y > 20) {
            y -= 20;
        } else {
            reach_end = true;
        }

    }
}
