package com.example.universitylife.Game2;

import com.example.universitylife.R;

public class FallingObjectFactory {
    private int usual_height = -100;
    private int frameWidth = 980;
    private int frameHeight = 1500;

    /**
     * get falling objects and initialize imageviews correspondingly in each level
     * @param shapeType: String the type of the falling object
     * @param level: the level of the game
     * @return FallingObject
     */
    public FallingObject getFallingObject(String shapeType, int level) {
        switch (level) {
            case 1:
                switch (shapeType) {
                    case "red":
                        return new redObject((int) (Math.random() * frameWidth), usual_height, R.id.red);
                    case "blue":
                        return new blueObject(((int) (Math.random() * frameWidth)), usual_height, R.id.blue);
                    case "yellow":
                        return new yellowObject(((int) (Math.random() * frameWidth)), usual_height, R.id.yellow);
                }
                break;
//            case 2:
//                switch (shapeType) {
//                    case "red":
//                        return new redObject((int) (Math.random() * frameWidth), usual_height, R.id.red_2);
//                    case "blue":
//                        return new blueObject(((int) (Math.random() * frameWidth)), usual_height, R.id.blue_2);
//                    case "yellow":
//                        return new yellowObject(((int) (Math.random() * frameWidth)), usual_height, R.id.yellow_2);
//                    case "what you should do":
//                        return new WhatYouShouldDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldDo);
//                    case "what you should not do":
//                        return new WhatYouShouldNotDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldNotDo);
//                }
//            case 3:
//                switch (shapeType) {
//                    case "red":
//                        return new redObject((int) (Math.random() * frameWidth), usual_height, R.id.red_3);
//                    case "blue":
//                        return new blueObject(((int) (Math.random() * frameWidth)), usual_height, R.id.blue_3);
//                    case "yellow":
//                        return new yellowObject(((int) (Math.random() * frameWidth)), usual_height, R.id.yellow_3);
//                    case "what you should do":
//                        return new WhatYouShouldDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldDo_2);
//                    case "what you should not do":
//                        return new WhatYouShouldNotDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldNotDo_2);
//                    case "killing object":
//                        return new KillingObject(((int) (Math.random() * frameWidth)), usual_height, R.id.killingObject);
//
//                }
//            case 4:
//                switch (shapeType) {
//                    case "red":
//                        FallingObject r = new redObject((int) (Math.random() * frameWidth), usual_height, R.id.red_4);
//                        r.increaseSpeed();
//                        return r;
//                    case "blue":
//                        FallingObject b = new blueObject(((int) (Math.random() * frameWidth)), usual_height, R.id.blue_4);
//                        b.increaseSpeed();
//                        return b;
//                    case "yellow":
//                        FallingObject y =  new yellowObject(((int) (Math.random() * frameWidth)), usual_height, R.id.yellow_4);
//                        y.increaseSpeed();
//                        return y;
//                    case "what you should do":
//                        FallingObject wd =  new WhatYouShouldDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldDo_3);
//                        wd.increaseSpeed();
//                        return wd;
//                    case "what you should not do":
//                        FallingObject wnd =  new WhatYouShouldNotDo(((int) (Math.random() * frameWidth)), usual_height, R.id.thingsYouShouldNotDo_3);
//                        wnd.increaseSpeed();
//                        return wnd;
//                    case "killing object":
//                        FallingObject k = new KillingObject(((int) (Math.random() * frameWidth)), usual_height, R.id.killingObject_2);
//                        k.increaseSpeed();
//                        return k;
//                }
//
//
        }

        return null;
    }

}
