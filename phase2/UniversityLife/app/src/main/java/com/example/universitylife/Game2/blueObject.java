package com.example.universitylife.Game2;

import com.example.universitylife.R;

public class blueObject extends FallingObject {
    private static String type =" blue";
    private int appearence = R.drawable.blueb;

    public blueObject(int x, int y, int imageView){
        super(x, y, type, 3, 15);
        this.setAppearence(appearence);
        this.setFrontEndImageID(imageView);
    }


    /** blue object falling  within the boundaries of teh frame
     *
     * @param frameHeight: the height of the frame
     * @param frameWidth the width of the framelayout of the screen
     */
    @Override
    void fall(int frameHeight, int frameWidth) {
        int new_y = this.getY_coordinate() + getSpeed();
        this.setY_coordinate(new_y);
        if (this.getY_coordinate() >= frameHeight){
            this.restoreHeight(frameWidth);
        }
    }

}
