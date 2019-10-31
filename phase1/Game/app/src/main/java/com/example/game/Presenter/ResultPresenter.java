package com.example.game.Presenter;

import com.example.game.Contract.IGameManager;
import com.example.game.Contract.IResult;
import com.example.game.Model.GameManager;

public class ResultPresenter implements IResult.IResultPresenter {
    private IResult.IResultView view;
    private GameManager gameManager;

    public ResultPresenter(IResult.IResultView view, String username){
        this.view = view;
        this.gameManager = new GameManager(username);
    }

    public void validateLevelCompletion() {
        // TODO!
        // (1) Get current level
        // (2) Display current level:
        view.displayLevel(level);
        // (3) Get and display grade:
        view.displayGrade(grade);
        // if completed:
        //      view.displayCompletionMessage("Congrats")
        // else:
        //      view.displayCompletionMessage("Sorry")

    }

//    @Override
//    public void againBtnClicked() {
//
//    }
//
//    @Override
//    public void nextBtnClicked() {
//
//    }
}
