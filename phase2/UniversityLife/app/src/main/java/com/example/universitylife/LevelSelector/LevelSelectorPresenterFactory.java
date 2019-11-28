package com.example.universitylife.LevelSelector;

import com.example.universitylife.IData;

class LevelSelectorPresenterFactory {

    LevelSelectorPresenter createLevelSelectorPresenter(String presenterType, LevelSelectorActivity view, IData dataHandler, String username) {
        if (presenterType.equalsIgnoreCase("GAME1")) {
            return new Game1LevelSelectorPresenter(view, dataHandler, username);
        } else if (presenterType.equalsIgnoreCase("GAME2")) {
            return new Game2LevelSelectorPresenter(view, dataHandler, username);
        } else if (presenterType.equalsIgnoreCase("GAME3")) {
            return new Game3LevelSelectorPresenter(view, dataHandler, username);
        } else {
            return null;
        }
    }
}
