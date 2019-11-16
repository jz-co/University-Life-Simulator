package com.example.universitylife.Model.Level2;

import com.example.universitylife.R;

public class redObject extends FallingObject {
    private static String type = "red";
    private int appearence = R.drawable.red;
    private int imageView = R.id.red;

    public redObject(int x, int y){
        super(x, y, type, 1);
        this.setAppearence(appearence);
        this.setFrontEndImageID(imageView);
    }


    @Override
    void fall(int frameHeight, int frameWidth) {
        int new_y = this.getY_coordinate() + 20;
        this.setY_coordinate(new_y);
        if (this.getY_coordinate() >= frameHeight){
            this.restoreHeight(frameWidth);
        }
    }
}
