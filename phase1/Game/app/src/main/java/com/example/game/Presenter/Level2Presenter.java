package Presenter;

import Contract.ILevel2;
import Model.GameManager;
import Model.Level2.GameLevel2;

public class Level2Presenter extends LevelPresenter {
    private ILevel2.ILevel2View view;
    private GameLevel2 gameLevel;
    private GameManager gameManager; // need to pass this in somehow..!!!!!

    Level2Presenter(ILevel2.ILevel2View view){
        this.view = view;
        this.gameLevel = (GameLevel2) gameManager.getCurrentGameLevel();
    }
}
