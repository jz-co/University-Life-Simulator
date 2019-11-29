package com.example.universitylife.LevelSelector;

interface ILevelSelector {
    interface ILevelSelectorView {
        void displayWarning(String message);

        void navigateToLevel1();
        void navigateToLevel2();
        void navigateToLevel3();
    }

}
