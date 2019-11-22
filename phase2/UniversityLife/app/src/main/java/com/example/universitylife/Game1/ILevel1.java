package com.example.universitylife.Game1;

import com.example.universitylife.ILevel;

public interface ILevel1 extends ILevel {
    interface ILevel1View extends ILevelView{
        void goToLevel2();

        void displayCorrectScore(int score);
        void displayIncorrectScore(int score);
        void setSecondsRemaining(long secondsRemaining);
        void displayQuestion(String question);

        void endGame();
        void startTimer(long totalTime);
        void displayWarning(String message);

        void navigateToResults(String displayMessage, int score);
    }
    interface ILevel1Presenter{

    }
}
