package com.example.game.Presenter;

import com.example.game.Contract.IGameManager;
import com.example.game.Contract.ILevel2;
import com.example.game.Model.GameManager;
import com.example.game.Model.Level2.GameLevel2;

public class Level2Presenter extends com.example.game.Presenter.LevelPresenter implements ILevel2.ILevel2Presenter {
    private ILevel2.ILevel2View view;
    private GameLevel2 gameLevel;

    public Level2Presenter(ILevel2.ILevel2View view, IGameManager gameManager){
        super(gameManager);
        this.view = view;
        this.gameLevel = new GameLevel2();
    }

    public void goToNextLevel(){
        view.goToLevel3();
    }
}
