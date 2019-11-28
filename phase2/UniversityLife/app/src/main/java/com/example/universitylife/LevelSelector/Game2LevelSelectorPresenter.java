package com.example.universitylife.LevelSelector;

import com.example.universitylife.GameManager;
import com.example.universitylife.IData;

class Game2LevelSelectorPresenter extends LevelSelectorPresenter {

    private LevelSelectorActivity view;
    private GameManager gameManager;

    Game2LevelSelectorPresenter(LevelSelectorActivity view, IData dataHandler, String username) {
        super();
        this.view = view;
        this.gameManager = new GameManager(dataHandler, username);

    }

    @Override
    void validateLevel1() {
        view.navigateToGame2Level1();
    }

    @Override
    void validateLevel2() {
        view.navigateToGame2Level2();

    }

    @Override
    void validateLevel3() {
        view.navigateToGame2Level3();
    }

    @Override
    String getCourseName() {
        return "Course 2";
    }

    @Override
    String getCurrGPA() {
        return null;
    }
}
