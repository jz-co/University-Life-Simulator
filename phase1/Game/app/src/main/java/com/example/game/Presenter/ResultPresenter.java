package com.example.game.Presenter;

import com.example.game.Contract.IGameManager;
import com.example.game.Contract.IResult;
import com.example.game.Model.GameManager;

public class ResultPresenter implements IResult.IResultPresenter {
    private IResult.IResultView view;
    private GameManager gameManager;

    public ResultPresenter(IResult.IResultView view, IGameManager gameManager){
        this.view = view;
        this.gameManager = (GameManager) gameManager;
    }

    @Override
    public void againBtnClicked() {

    }

    @Override
    public void nextBtnClicked() {

    }
}
