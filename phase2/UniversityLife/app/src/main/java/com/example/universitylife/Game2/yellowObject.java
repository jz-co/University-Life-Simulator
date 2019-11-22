package com.example.universitylife.Game2;

import com.example.universitylife.R;

public class yellowObject extends FallingObject {
    private static String type = "yellow";
    private int appearence = R.drawable.yellow;
    private int imageView = R.id.yellow;

    public yellowObject(int x, int y){
        super(x, y, type, -2);
        this.setAppearence(appearence);
        this.setFrontEndImageID(imageView);
    }

    @Override
    void fall(int frameHeight, int frameWidth) {
        int new_y = this.getY_coordinate() + 10;
        this.setY_coordinate(new_y);
        if (this.getY_coordinate() >= frameHeight){
            this.restoreHeight(frameWidth);
        }
    }

}
