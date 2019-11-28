package com.example.universitylife.LevelSelector;

interface ILevelSelector {
    interface ILevelSelectorView {
        void displayWarning();

        void goToGameLevel(int game, int level);
    }

    interface IGame1LevelSelector {

    }
}
