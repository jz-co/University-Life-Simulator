package com.example.game.Presenter;

import com.example.game.Contract.IData;
import com.example.game.Contract.ILevel1;
import com.example.game.Model.GameManager;
import com.example.game.Model.Level1.GameLevel1;

public class Level1Presenter extends LevelPresenter implements ILevel1.ILevel1Presenter {
    private ILevel1.ILevel1View view;
    private GameLevel1 gameLevel;
    private long secondsRemaining;
    private boolean nextLevelUnlocked = false;
    private GameManager gameManager;

    public Level1Presenter(ILevel1.ILevel1View view, IData dataHandler, String username) {
        super(dataHandler, username);
        this.view = view;
        gameManager = new GameManager(dataHandler, username);
        this.gameLevel = new GameLevel1(gameManager.getCurrentStudent(), this);
        if (gameManager.getCurrentLevel() > 1) {
            nextLevelUnlocked = true;
        }
    }

    /**
     * Starts the math game
     */
    public void startGame() {
        this.view.startTimer(60000);
        newQuestion();
    }

    /**
     * Resumes the game and timer
     */
    public void resumeGame() {
        view.startTimer(secondsRemaining * 1000);
    }

    /**
     * Gets the number of questions correctly answered from the game level
     *
     * @return an integer referring to the number of correct answers
     */
    public int getCorrectScore() {
        return this.gameLevel.getCorrectAnswers();
    }

    /**
     * Asks the view to display the new question
     */
    private void newQuestion() {
        this.view.displayQuestion(gameLevel.createQuestion());
    }

    /**
     * Evaluates the user's answer to the question. If it is correct, update the correct answer score
     * and if it is incorrect, update the incorrect answer score. If the input is invalid, display
     * a warning
     *
     * @param answerReceived the answer input from the user
     */
    public void evaluateAnswer(String answerReceived) {
        try {
            int ans = Integer.parseInt(answerReceived);
            boolean correct = this.gameLevel.evaluateAnswer(ans);
            if (!correct) {
                view.displayWarning("Wrong Answer!");
            }
            view.displayCorrectScore(gameLevel.getCorrectAnswers());
            view.displayIncorrectScore(gameLevel.getIncorrectAnswers());
            newQuestion();
        } catch (NumberFormatException e) {
            view.displayWarning("Invalid!");
        }
    }

    /**
     * Checks if the user has successfully completed the level or not. If successful, unlock the
     * next level.
     */
    public void levelComplete() {

        int clearingScore = gameLevel.getClearingScore();
        if (gameLevel.getCorrectAnswers() < clearingScore) {
            view.displayWarning("Play again to unlock the next level!");
            gameLevel.levelFail();
        } else {
            view.displayWarning("Congratulations, you have cleared this level!");
            nextLevelUnlocked = true;
            gameLevel.levelPass();
        }
        gameManager.saveBeforeExit();
        view.endGame();
    }

    /**
     * Ask the view to display the number of seconds left in the game.
     *
     * @param millisUntilFinished number of milliseconds left in the game.
     */
    public void tick(long millisUntilFinished) {
        secondsRemaining = millisUntilFinished / 1000;
        view.setSecondsRemaining(secondsRemaining);
    }

    /**
     * Check if the Level 2 is unlocked or not. If unlocked, go to Level 2. Else, display a warning.
     */
    public void validateLevel2() {
        if (nextLevelUnlocked) {
            view.goToLevel2();
        } else {
            view.displayWarning("Sorry, the next level has not been unlocked");
        }
    }
}
