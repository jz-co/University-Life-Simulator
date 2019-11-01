package com.example.game.Model.Level3;

import com.example.game.Contract.ILevel3;

public class Arrow extends GameContents implements TouchEvent {

    private boolean touch, reach_end;

    public Arrow(ILevel3.ILevel3GameView view, int width, int height) {
        super(view, width, height);
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


    public void update() {
        if (y > 20) {
            y -= 20;
        } else {
            reach_end = true;
        }

    }
}
