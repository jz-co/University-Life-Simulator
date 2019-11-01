package com.example.game.Model.Level3;

import com.example.game.Contract.ILevel3;

public abstract class GameContents {
    protected int x;
    protected int y;

    ILevel3.ILevel3GameView view;
    /**
     * The width of grid
     */
    protected int gridWidth;

    /**
     * The height of grid
     */
    protected int gridHeight;


    public GameContents(ILevel3.ILevel3GameView view, int gridWidth, int gridHeight) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.view = view;

    }

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
