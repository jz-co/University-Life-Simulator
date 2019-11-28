package com.example.universitylife.CourseSelector;

import com.example.universitylife.IData;
import com.example.universitylife.GameManager;

public class CourseSelectorPresenter {
    private ICourseSelector.ICourseSelectorView view;
    private GameManager gameManager;

    CourseSelectorPresenter(ICourseSelector.ICourseSelectorView view, IData dataHandler, String username) {
        this.view = view;
        gameManager = new GameManager(dataHandler, username);
    }

    /**
     * Direct user to lv1
     */
    void validateCourse1() {
        view.navigateToCourse1(gameManager.getCurrentUsername());
    }

    /**
     * check if student has unlocked lv2. If so, go to lv2. If not, show warning message.
     */
    void validateCourse2() {
            view.navigateToCourse2(gameManager.getCurrentUsername());
    }

    /**
     * check if student has unlocked lv3. If so, go to lv3. If not, show warning.
     */
    void validateCourse3() {
            view.navigateToCourse3(gameManager.getCurrentUsername());
    }

    int getPicIndex() {
        return gameManager.getCurrentStudent().getAppearance();
    }

    /**
     * Display a warning message.
     */
    private void warning() {
        view.displayWarning("You have not unlocked this level!");
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
