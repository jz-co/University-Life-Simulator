package com.example.universitylife.Game1;

import com.example.universitylife.LevelPresenter;

public class Game1BonusLvlPresenter extends LevelPresenter implements ILevel1.ILevel1PresenterCalculator{
    private ILevel1.ILevel1ViewBonusLvl view;
    private Game1BonusLevel gameLevel;
    private long secondsRemaining;

    public Game1BonusLvlPresenter(ILevel1.ILevel1ViewBonusLvl view, String username){
        super(username);
        this.view = view;
        this.gameLevel = new Game1BonusLevel(gameManager.getCurrentStudent());
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
     * Gets the final score from the game level
     *
     * @return an integer referring to final score
     */
    public int getFinalScore() {
        return this.gameLevel.getTotalScore();
    }

    /**
     * Asks the view to display the new question
     */
    public void newQuestion() {
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
            view.displayCorrectScore(gameLevel.getNumCorrectAnswers());
            view.displayIncorrectScore(gameLevel.getNumIncorrectAnswers());
            gameLevel.updateScore(gameLevel.calculateScore());
            view.displayScore(gameLevel.getTotalScore());
            view.resetHintDisplay();
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
        if (gameLevel.getNumCorrectAnswers() < clearingScore) {
            view.displayWarning("Play again to unlock the next level!");
        } else {
            view.displayWarning("Congratulations, you have cleared this level!");
            //nextLevelUnlocked = true;
            gameLevel.levelPass();
        }
        gameManager.saveBeforeExit();
        updateDisplay(view);
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
     * Checks if the student has a calculator and if yes, display the hint on the screen.
     */
    public void getHint(){
        //need to first check if the student has a calculator.
        if (gameLevel.hasCalculator()) {
            int correctAnswer = gameLevel.getCorrectAnswer();
            int lowerBound = correctAnswer - (int) (Math.random() * 6);
            int upperBound = correctAnswer + (int) (Math.random() * 6);
            view.displayHint(lowerBound, upperBound);
        } else{
            view.displayWarning("Sorry, you don't have any calculators in your bag");
        }
    }


}
