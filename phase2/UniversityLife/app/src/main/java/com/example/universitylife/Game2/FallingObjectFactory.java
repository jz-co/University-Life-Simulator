package com.example.universitylife.Game2;

import com.example.universitylife.R;

public interface FallingObjectFactory {
    /**
     * get falling objects and initialize imageviews correspondingly in each level
     * @param shapeType: String the type of the falling object
     * @return FallingObject
     */
    FallingObject getFallingObject(String shapeType);

}
