package com.example.game.Presenter;

import com.example.game.Contract.ILevel2;
import com.example.game.Model.GameManager;
import Model.Level2.GameLevel2;

public class Level2Presenter extends com.example.game.Presenter.LevelPresenter {
    private ILevel2.ILevel2View view;
    private GameLevel2 gameLevel;
    private GameManager gameManager; // need to pass this in somehow..!!!!!

    Level2Presenter(ILevel2.ILevel2View view){
        this.view = view;
        this.gameLevel = (GameLevel2) gameManager.getCurrentGameLevel();
    }
}
