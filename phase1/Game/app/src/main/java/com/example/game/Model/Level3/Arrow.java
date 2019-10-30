package com.example.game.Model.Level3;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Arrow extends GameContents {
    Bitmap image;

    Arrow(Bitmap image, int width, int height) {
        super(image, width, height);
        this.image = image;
        super.setX(width - 570);
        super.setY(height - 550);
    }


    void draw(Canvas canvas) {
        canvas.drawBitmap(this.image, getX(), getY(), null);
    }

    public void update() {
        y -= 10;

    }
}
