package com.example.game.Model.Level2;

import com.example.game.R;

public class blueObject extends FallingObject {
    private static String type =" blue";
    private int appearence = R.drawable.blue;
    private int imageView = R.id.blue;

    public blueObject(int x, int y){
        super(x, y, type, 2);
        this.setAppearence(appearence);
        this.setFrontEndImageID(imageView);
    }

    @Override
    void fall(int frameHeight, int frameWidth) {
        int new_y = this.getY_coordinate() + 15;
        this.setY_coordinate(new_y);
        if (this.getY_coordinate() >= frameHeight){
            this.restoreHeight(frameWidth);
        }
    }

}
