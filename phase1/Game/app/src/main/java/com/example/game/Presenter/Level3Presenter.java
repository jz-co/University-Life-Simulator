package com.example.game.Presenter;

import com.example.game.Contract.ILevel3;
import Model.Level3.GameLevel3;
import com.example.game.Model.GameManager;

public class Level3Presenter extends com.example.game.Presenter.LevelPresenter {
    private ILevel3.ILevel3View view;
    private GameLevel3 gameLevel;
    private GameManager gameManager; // need to pass this in somehow..!!!!!

    Level3Presenter(ILevel3.ILevel3View view){
        this.view = view;
        this.gameLevel = (GameLevel3) gameManager.getCurrentGameLevel();
    }
}
