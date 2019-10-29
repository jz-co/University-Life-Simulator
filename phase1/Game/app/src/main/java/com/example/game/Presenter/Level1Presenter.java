package com.example.game.Presenter;

import com.example.game.Contract.IGameManager;
import com.example.game.Contract.ILevel1;
import com.example.game.Model.GameManager;
import com.example.game.Model.Level1.GameLevel1;

public class Level1Presenter extends com.example.game.Presenter.LevelPresenter implements ILevel1.ILevel1Presenter {
    private ILevel1.ILevel1View view;
    private GameLevel1 gameLevel;

    public Level1Presenter(ILevel1.ILevel1View view, IGameManager gameManager){
        super(gameManager);
        this.view = view;
        this.gameLevel = new GameLevel1();
    }

    public void goToNextLevel(){
        view.goToLevel2();
    }
}
