package com.example.universitylife.Game2;

import com.example.universitylife.R;

public class FallingObjectFactoryLvl4 implements FallingObjectFactory {
    private int usual_height = -100;
    private int frameWidth = 980;
    @Override
    public FallingObject getFallingObject(String shapeType) {
        switch (shapeType) {
                    case "red":
                        FallingObject r = new redObject((int) (Math.random() * frameWidth), usual_height, R.id.red_4);
                        r.increaseSpeed();
                        return r;
                    case "blue":
                        FallingObject b = new blueObject(((int) (Math.random() * frameWidth)), usual_height, R.id.blue_4);
                        b.increaseSpeed();
                        return b;
                    case "yellow":
                        FallingObject y =  new yellowObject(((int) (Math.random() * frameWidth)), usual_height, R.id.yellow_4);
                        y.increaseSpeed();
                        return y;
                    case "what you should do":
                        FallingObject wd =  new WhatYouShouldDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldDo_3);
                        wd.increaseSpeed();
                        return wd;
                    case "what you should not do":
                        FallingObject wnd =  new WhatYouShouldNotDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldNotDo_3);
                        wnd.increaseSpeed();
                        return wnd;
                    case "killing object":
                        FallingObject k = new KillingObject(((int) (Math.random() * frameWidth)), usual_height, R.id.killingObject_2);
                        k.increaseSpeed();
                        return k;
                }
        return null;
    }
}
