package com.example.game.Presenter;

import com.example.game.Contract.IData;
import com.example.game.Contract.IGameManager;
import com.example.game.Contract.ILevel1;
import com.example.game.Model.GameManager;
import com.example.game.Model.Level1.GameLevel1;
import com.example.game.Model.Student;
import com.example.game.Presenter.LevelPresenter;

public class Level1Presenter extends LevelPresenter implements ILevel1.ILevel1Presenter {
    private ILevel1.ILevel1View view;
    private GameLevel1 gameLevel;
    private GameManager gameManager;
    private long secondsRemaining;

    public Level1Presenter(ILevel1.ILevel1View view, IData dataHandler, String username) {
        super(dataHandler, username);
        this.view = view;
        this.gameManager = new GameManager(dataHandler, username);
        this.gameLevel = new GameLevel1(this.gameManager.getCurrentStudent(), this);
    }

    public void goToNextLevel() {
        this.view.goToLevel2();
    }


    public void startGame() {
        this.view.startTimer(6000);
        newQuestion();
    }

    public void resumeGame() {
        view.startTimer(secondsRemaining*6000);
    }

    public int getCorrectScore() {
        return this.gameLevel.getCorrectAnswers();
    }
    //TODO remove

    public void newQuestion() {
        this.view.displayQuestion(gameLevel.createQuestion());
    }

    public void setInvalidInputMessage() {
        this.view.displayInvalidInputMessage();
    }


    public void evaluateAnswer(String answerReceived) {
        int i = this.gameLevel.evaluateAnswer(answerReceived);
        if (i==-1){
            view.displayWarning("Invalid");
        } else if (i==0){
            view.displayWarning("Wrong Answer!");
        }
        view.displayCorrectScore(gameLevel.getCorrectAnswers());
        view.displayIncorrectScore(gameLevel.getIncorrectAnswers());
        newQuestion();
    }

    public void quitGame() {
        // adding the score of the player to their hp
        this.gameLevel.getStudent().incrementHp(gameLevel.getCorrectAnswers());
        gameLevel.getStudent().incrementCredit(5);
        gameLevel.getStudent().incrementGpa(1);
        this.updateDisplay(view);
        this.gameManager.saveBeforeExit();
        this.view.quitGame();
    }

    public void incrementStudentLevel(){
        if (gameLevel.getStudent().getCurrentLevel()<=1) {
            gameLevel.getStudent().incrementLevel();
        }
    }

    /** decrease the gpa of the student
     *
     */
    public void decrementStudentGpa(){
        if (gameLevel.getStudent().getGpa() >= 0){
            gameLevel.getStudent().incrementGpa(-1);
        }
    }

    public void tick(long millisUntilFinished){
        secondsRemaining = millisUntilFinished / 1000;
        view.setSecondsRemaining(secondsRemaining);
    }


    public void validateLevel2(){
        if (this.gameLevel.getCorrectAnswers() >= 5){
            view.goToLevel2();
        } else {
            view.displayWarning("Sorry, the current level has not been unlocked");
        }
    }
}
