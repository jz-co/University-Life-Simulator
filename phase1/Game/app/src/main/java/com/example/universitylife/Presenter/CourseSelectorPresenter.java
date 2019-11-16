package com.example.universitylife.Presenter;

import com.example.universitylife.Contract.ICourseSelector;
import com.example.universitylife.Contract.IData;
import com.example.universitylife.Model.GameManager;

public class CourseSelectorPresenter {
    private ICourseSelector.ICourseSelectorView view;
    private GameManager gameManager;

    public CourseSelectorPresenter(ICourseSelector.ICourseSelectorView view, IData dataHandler, String username) {
        this.view = view;
        gameManager = new GameManager(dataHandler, username);
    }

    /**
     * Direct user to lv1
     */
    public void validateLevel1() {
        view.goToLevel1(gameManager.getCurrentUsername());
    }

    /**
     * check if student has unlocked lv2. If so, go to lv2. If not, show warning message.
     */
    public void validateLevel2() {
        if (gameManager.getCurrentLevel() >= 2) {
            view.goToLevel2(gameManager.getCurrentUsername());
        } else {
            warning();
        }
    }

    /**
     * check if student has unlocked lv3. If so, go to lv3. If not, show warning.
     */
    public void validateLevel3() {
        if (gameManager.getCurrentLevel() >= 3) {
            view.goToLevel3(gameManager.getCurrentUsername());
        } else {
            warning();
        }
    }

    public int getPicIndex() {
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
