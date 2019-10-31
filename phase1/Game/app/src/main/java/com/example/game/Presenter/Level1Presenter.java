package com.example.game.Presenter;

import com.example.game.Contract.IData;
import com.example.game.Contract.IGameManager;
import com.example.game.Contract.ILevel1;
import com.example.game.Model.GameManager;
import com.example.game.Model.Level1.GameLevel1;
import com.example.game.Model.Student;

public class Level1Presenter extends com.example.game.Presenter.LevelPresenter implements ILevel1.ILevel1Presenter {
    private ILevel1.ILevel1View view;
    private GameLevel1 gameLevel;
    private GameManager gameManager;

    public Level1Presenter(ILevel1.ILevel1View view, IData .IDataSaver saver,
                           IData.IDataLoader loader, String username){
        super(saver, loader, username);
        this.view = view;
        this.gameManager = new GameManager(saver, loader, username);
        this.gameLevel = new GameLevel1(this.gameManager.getCurrentStudent());
    }

    public void goToNextLevel(){
        this.view.goToLevel2();
    }

    public void startGame(){ this.gameLevel.play();}

    public void resumeGame(){this.gameLevel.resumeGame();}

    public void pauseGame(){this.gameLevel.pauseGame();}

    Student getStudent(){return this.gameLevel.getStudent();}

    public int getCorrectScore(){return this.gameLevel.getCorrectAnswers();}
    public void setCorrectScore(){this.view.displayCorrectScore();}

    public int getIncorrectScore(){return this.gameLevel.getIncorrectScore();}
    public void setIncorrectScore(){this.view.displayIncorrectScore();}
}
