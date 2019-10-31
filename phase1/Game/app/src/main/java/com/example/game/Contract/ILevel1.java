package com.example.game.Contract;

public interface ILevel1 extends ILevel{
    interface ILevel1View extends ILevelView{
        void goToLevel2();

        void displayCorrectScore();
        void displayIncorrectScore();
        void setSecondsRemaining();
        void displayQuestion();
        void displayInvalidInputMessage();
        void quitGame();
    }
    interface ILevel1Presenter{
        void goToNextLevel();
        void setCorrectScore();
        void setIncorrectScore();
        void setSecondsRemaining();
        void quitGame();
        void setQuestion();
        void setInvalidInputMessage();
    }
}
