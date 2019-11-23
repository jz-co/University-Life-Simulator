package com.example.universitylife.Game2;

import com.example.universitylife.R;

public class WhatYouShouldNotDo extends FallingObject {
    private static String type = "what you should not do";
    private int[] images = {R.drawable.copy_online, R.drawable.copy_frds, R.drawable.getprivtutors};

    WhatYouShouldNotDo(int x, int y, int imageView){
        super(x, y , type, -1, 10);
        setAppearence();
        this.setFrontEndImageID(imageView);

    }

    @Override
    void fall(int FrameHeight, int frameWidth) {
        int new_y = this.getY_coordinate() + getSpeed();
        this.setY_coordinate(new_y);
        if (this.getY_coordinate() >= FrameHeight){
            this.restoreHeight(frameWidth);
            setAppearence();
        }
    }

    private void setAppearence(){
        int index = (int)(images.length * Math.random());
        this.setAppearence(images[index]);
    }
}
