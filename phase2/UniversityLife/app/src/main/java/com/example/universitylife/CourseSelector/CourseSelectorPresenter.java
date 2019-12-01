package com.example.universitylife.CourseSelector;

import com.example.universitylife.IData;
import com.example.universitylife.GameManager;

public class CourseSelectorPresenter {
    private ICourseSelector.ICourseSelectorView view;
    private GameManager gameManager;

    CourseSelectorPresenter(ICourseSelector.ICourseSelectorView view, String username, IData dataHandler) {
        this.view = view;
        gameManager = new GameManager(username, dataHandler);
    }

    int getPicIndex() {
        return gameManager.getCurrentStudent().getAppearance();
    }

    /**
     * return the current student name.
     *
     * @return the current student name.
     */
    public String getUsername() {
        return gameManager.getCurrentUsername();
    }

}
