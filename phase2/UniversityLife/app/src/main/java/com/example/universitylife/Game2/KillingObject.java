package com.example.universitylife.Game2;

import com.example.universitylife.R;

public class KillingObject extends FallingObject {
    private static String type = "killing object";
    private int image = R.drawable.cheatexam;

    public KillingObject(int x, int y, int imageView){
        super(x, y, type, 0, 8);
        this.setAppearence(image);
        this.setFrontEndImageID(imageView);
    }

    @Override
    void fall(int FrameHeight, int frameWidth) {
        int new_y = this.getY_coordinate() + getSpeed();
        this.setY_coordinate(new_y);
        if (this.getY_coordinate() >= FrameHeight){
            this.restoreHeight(frameWidth);
        }
    }
}
