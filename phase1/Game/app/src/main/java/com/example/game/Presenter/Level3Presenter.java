package com.example.game.Presenter;

import com.example.game.Contract.IData;
import com.example.game.Contract.IGameManager;
import com.example.game.Contract.ILevel3;
import com.example.game.Model.GameManager;
import com.example.game.Model.Level3.Lvl3GameItemManager;

public class Level3Presenter extends com.example.game.Presenter.LevelPresenter implements ILevel3.ILevel3Presenter {
    private ILevel3.ILevel3View view;
    private GameManager gameManager;

    public Level3Presenter(ILevel3.ILevel3View view, IData datahandler, String username) {
        super(datahandler, username);
        this.view = view;

    }

}
