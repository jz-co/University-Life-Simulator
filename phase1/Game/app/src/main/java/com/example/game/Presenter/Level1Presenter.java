package com.example.game.Presenter;

import com.example.game.Contract.ILevel1;
import com.example.game.Model.GameManager;
import com.example.game.Model.Level1.GameLevel1;

public class Level1Presenter extends com.example.game.Presenter.LevelPresenter {
    private ILevel1.ILevel1View view;
    private GameLevel1 gameLevel;
    private GameManager gameManager; // need to pass this in somehow..!!!!!

    Level1Presenter(ILevel1.ILevel1View view){
        this.view = view;
        this.gameLevel = (GameLevel1) gameManager.getCurrentGameLevel();
    }
}
