package com.example.universitylife.Game1;

import com.example.universitylife.ILevel;

public interface ILevel1 extends ILevel {
    interface ILevel1View extends ILevelView{


        void displayCorrectScore(int score);
        void displayIncorrectScore(int score);
        void setSecondsRemaining(long secondsRemaining);
        void displayQuestion(String question);

        void endGame();
        void startTimer(long totalTime);
        void displayWarning(String message);

        void navigateToResults(String displayMessage, int score);
    }
    interface ILevel1ViewLvl1 extends ILevel1View{
        void goToNextLevel();

    }

    interface ILevel1ViewLvl23 extends ILevel1View{
        void goToNextLevel();
        void displayHint(int lowerBound, int upperBound);
        void resetHintDisplay();
    }

    interface ILevel1ViewBonusLvl extends ILevel1View{
        void displayHint(int lowerBound, int upperBound);
        void resetHintDisplay();
    }
    interface ILevel1Presenter{
        void startGame();
        void resumeGame();
        int getFinalScore();
        void newQuestion();
        void evaluateAnswer(String answerReceived);
        void levelComplete();
        void tick(long millisUntilFinished);
    }

    interface ILevel1PresenterCalculator extends ILevel1Presenter{
        void getHint();
    }
}
