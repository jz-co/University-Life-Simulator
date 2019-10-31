package com.example.game.Model.Level3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class GameContents {
    protected int x;
    protected int y;

    Bitmap image;

    /**
     * The width of grid
     */
    protected int gridWidth;

    /**
     * The height of grid
     */
    protected int gridHeight;


    public GameContents(Bitmap image, int gridWidth, int gridHeight) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.image = image;

    }

    public abstract void draw(Canvas canvas);

    public abstract void update();

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

}
