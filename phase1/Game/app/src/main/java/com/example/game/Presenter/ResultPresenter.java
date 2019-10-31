package com.example.game.Presenter;

import com.example.game.Contract.IData;
import com.example.game.Contract.IGameManager;
import com.example.game.Contract.IResult;
import com.example.game.Model.GameManager;

public class ResultPresenter {
    private IResult.IResultView view;
    private GameManager gameManager;

    public ResultPresenter(IResult.IResultView view, IData.IDataSaver saver,
                           IData.IDataLoader loader, String username) {
        this.view = view;
        this.gameManager = new GameManager(saver, loader, username);
    }

}
