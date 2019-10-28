package Presenter;

import Contract.ILevel3;
import Model.Level3.GameLevel3;
import Model.GameManager;

public class Level3Presenter extends LevelPresenter {
    private ILevel3.ILevel3View view;
    private GameLevel3 gameLevel;
    private GameManager gameManager; // need to pass this in somehow..!!!!!

    Level3Presenter(ILevel3.ILevel3View view){
        this.view = view;
        this.gameLevel = (GameLevel3) gameManager.getCurrentGameLevel();
    }
}
