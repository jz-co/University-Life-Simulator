package com.example.universitylife.Game3;

import com.example.universitylife.IData;
import com.example.universitylife.LevelPresenter;

public class Game3Presenter extends LevelPresenter implements ILevel3.ILevel3Presenter {
    private ILevel3.ILevel3View view;

    public Game3Presenter(ILevel3.ILevel3View view, IData datahandler, String username) {
        super(datahandler, username);
        this.view = view;

    }

}
