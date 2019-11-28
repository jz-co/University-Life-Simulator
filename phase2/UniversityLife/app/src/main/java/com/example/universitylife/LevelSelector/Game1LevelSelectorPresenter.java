package com.example.universitylife.LevelSelector;

import com.example.universitylife.GameManager;
import com.example.universitylife.IData;
import com.example.universitylife.LevelSelector.LevelSelectorPresenter;

class Game1LevelSelectorPresenter extends LevelSelectorPresenter {

    private LevelSelectorActivity view;
    private GameManager gameManager;

    Game1LevelSelectorPresenter(LevelSelectorActivity view, IData dataHandler, String username) {
        super();
        this.view = view;
        this.gameManager = new GameManager(dataHandler, username);

    }

    @Override
    void validateLevel1() {
        view.navigateToGame1Level1();

    }

    @Override
    void validateLevel2() {
        view.navigateToGame1Level2();

    }

    @Override
    void validateLevel3() {
        view.navigateToGame1Level3();
    }

    @Override
    String getCourseName() {
        return "Course 1";
    }

    @Override
    String getCurrGPA() {
        return null;
    }
}
