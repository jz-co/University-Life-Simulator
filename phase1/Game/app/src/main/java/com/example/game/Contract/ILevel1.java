package com.example.game.Contract;

public interface ILevel1 extends ILevel{
    interface ILevel1View extends ILevelView{
        void goToLevel2();

        void displayCorrectScore();
        void displayIncorrectScore();
    }
    interface ILevel1Presenter{
        void goToNextLevel();
        void setCorrectScore();
        void setIncorrectScore();
        void setSecondsRemaining();
        void quitGame();
    }
}
