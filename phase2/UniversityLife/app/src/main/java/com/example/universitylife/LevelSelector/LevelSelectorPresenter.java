package com.example.universitylife.LevelSelector;

import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.GameManager;
import com.example.universitylife.IData;

class LevelSelectorPresenter {

    private GameManager gameManager;
    private int game;
    private ILevelSelector.ILevelSelectorView view;

    LevelSelectorPresenter(ILevelSelector.ILevelSelectorView view, int game, String username, IData dataHandler) {
        gameManager = new GameManager(dataHandler, username);
        this.game = game;
        this.view = view;
    }
    /**
     * Verifies if user able to proceed to Level 1 of a game.
     */
    void validateLevel(int level) {
        if (gameManager.getHighestLevel(game) >= level) {
            view.goToGameLevel(game, level);
        } else {
            view.displayWarning();
        }
    }

    String getCourseName() {
        switch (game) {
            case 1:
                return "Math";
            case 2:
                return "Catching";
            case 3:
                return "Arrow";
            default:
                return Integer.toString(game);
        }
    }

    String getCurrGPA() {
        //TODO: cumulative GPA or..?
        return Double.toString(gameManager.getGpa());
    }

}
