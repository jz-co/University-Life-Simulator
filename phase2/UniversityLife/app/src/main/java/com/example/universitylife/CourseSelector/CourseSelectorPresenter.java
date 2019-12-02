package com.example.universitylife.CourseSelector;

import com.example.universitylife.IData;
import com.example.universitylife.GameManager;

class CourseSelectorPresenter {
    private GameManager gameManager;

    CourseSelectorPresenter(String username, IData dataHandler) {
        gameManager = new GameManager(username, dataHandler);
    }

    /**
     * return the current student name.
     */
    public String getUsername() {
        return gameManager.getCurrentUsername();
    }

}
