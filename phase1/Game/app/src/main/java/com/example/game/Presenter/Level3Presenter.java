package com.example.game.Presenter;

import com.example.game.Contract.IGameManager;
import com.example.game.Contract.ILevel3;
import com.example.game.Model.Level3.GameLevel3;
import com.example.game.Model.GameManager;

public class Level3Presenter extends com.example.game.Presenter.LevelPresenter implements ILevel3.ILevel3Presenter {
    private ILevel3.ILevel3View view;
    private GameLevel3 gameLevel;

    public Level3Presenter(ILevel3.ILevel3View view, IGameManager gameManager){
        super(gameManager);
        this.view = view;
        this.gameLevel = new GameLevel3();
    }
}
