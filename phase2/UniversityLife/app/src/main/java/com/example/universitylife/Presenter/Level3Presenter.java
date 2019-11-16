package com.example.universitylife.Presenter;

import com.example.universitylife.Contract.IData;
import com.example.universitylife.Contract.IGameManager;
import com.example.universitylife.Contract.ILevel3;
import com.example.universitylife.Model.GameManager;
import com.example.universitylife.Model.Level3.Lvl3GameItemManager;

public class Level3Presenter extends com.example.universitylife.Presenter.LevelPresenter implements ILevel3.ILevel3Presenter {
    private ILevel3.ILevel3View view;

    public Level3Presenter(ILevel3.ILevel3View view, IData datahandler, String username) {
        super(datahandler, username);
        this.view = view;

    }

}
