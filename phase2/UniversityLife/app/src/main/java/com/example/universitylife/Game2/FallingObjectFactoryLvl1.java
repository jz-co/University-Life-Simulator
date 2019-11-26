package com.example.universitylife.Game2;

import com.example.universitylife.R;

public class FallingObjectFactoryLvl1 implements FallingObjectFactory {
    private int usual_height = -100;
    private int frameWidth = 980;

    @Override
    public FallingObject getFallingObject(String shapeType) {
        switch (shapeType) {
                case "red":
                        return new redObject((int) (Math.random() * frameWidth), usual_height, R.id.red);
                case "blue":
                        return new blueObject(((int) (Math.random() * frameWidth)), usual_height, R.id.blue);
                    case "yellow":
                        return new yellowObject(((int) (Math.random() * frameWidth)), usual_height, R.id.yellow);
        }
                return null;
    }
}
