package com.example.universitylife.LevelSelector;

import com.example.universitylife.DataHandler.DataHandler;
import com.example.universitylife.GameManager;
import com.example.universitylife.IData;

class LevelSelectorPresenter {

    private GameManager gameManager;
    private int game;
    private ILevelSelector.ILevelSelectorView view;

    LevelSelectorPresenter(ILevelSelector.ILevelSelectorView view, int game, String username) {
        gameManager = new GameManager(username);
        this.game = game;
        this.view = view;
    }
    /**
     * Verifies if user able to proceed to Level 1 of a game.
     */
    void validateLevel(int level) {
        if (gameManager.getHighestLevel(game) >= level) {
            goToLevel(level);
        } else {
            String LOCKED_WARNING = "Sorry, you have not unlocked this level.";
            view.displayWarning(LOCKED_WARNING);
        }
    }

    private void goToLevel(int level) {
        switch (level) {
            case 1:
                view.navigateToLevel1();
                break;
            case 2:
                view.navigateToLevel2();
                break;
            case 3:
                view.navigateToLevel3();
        }
    }

    String getCurrGPA() {
        //TODO: cumulative GPA or..? (GPA for this course ONLY, not all courses)
        return Double.toString(gameManager.getGpa());
    }

    void validateBonus() {
        // TODO:
    }

}
