package com.example.universitylife.LevelSelector;

import com.example.universitylife.GameManager;
import com.example.universitylife.IData;

abstract class LevelSelectorPresenter {

    /**
     * Verifies if user able to proceed to Level 1 of a game.
     */
    abstract void validateLevel1();

    /**
     * Verifies if user able to proceed to Level 2 of a game.
     */
    abstract void validateLevel2();

    /**
     * Verifies if user able to proceed to Level 3 of a game.
     */
    abstract void validateLevel3();


    abstract String getCourseName();
    abstract String getCurrGPA();

}
