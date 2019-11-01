package com.example.game.Contract;

public interface ILevel1 extends ILevel{
    interface ILevel1View extends ILevelView{
        void goToLevel2();

        void displayCorrectScore(int score);
        void displayIncorrectScore(int score);
        void setSecondsRemaining(long secondsRemaining);
        void displayQuestion(String question);

        void endGame();
        void startTimer(long totalTime);
        void displayWarning(String message);
    }
    interface ILevel1Presenter{

    }
}
