package com.example.game.Model.Level3;

import com.example.game.Contract.ILevel3;

public class Bow extends GameContents {

    public Bow(ILevel3.ILevel3GameView view, int width, int height) {
        super(view, width, height);
        super.setX(21 * (width) / 100);
        super.setY(81 * (height) / 100);
    }


    public void update() {
    }
}
