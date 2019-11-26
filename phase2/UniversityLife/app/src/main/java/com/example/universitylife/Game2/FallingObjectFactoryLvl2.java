package com.example.universitylife.Game2;

import com.example.universitylife.R;

public class FallingObjectFactoryLvl2 implements FallingObjectFactory {
    private int usual_height = -100;
    private int frameWidth = 980;
    @Override
    public FallingObject getFallingObject(String shapeType) {
        switch (shapeType) {
                    case "red":
                        return new redObject((int) (Math.random() * frameWidth), usual_height, R.id.red_2);
                    case "blue":
                        return new blueObject(((int) (Math.random() * frameWidth)), usual_height, R.id.blue_2);
                    case "yellow":
                        return new yellowObject(((int) (Math.random() * frameWidth)), usual_height, R.id.yellow_2);
                    case "what you should do":
                        return new WhatYouShouldDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldDo);
                    case "what you should not do":
                        return new WhatYouShouldNotDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldNotDo);
                }
            return null;
    }
}
