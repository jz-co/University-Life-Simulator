package com.example.game.Model.Level1;

import com.example.game.Contract.ILevel1;
import com.example.game.Model.GameLevel;

public class GameLevel1 extends com.example.game.Model.GameLevel {
    private ILevel1.ILevel1Presenter presenter;
    public GameLevel1(){

    }

    public void setPresenter(ILevel1.ILevel1Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void progressGameResults() {

    }

    @Override
    public GameLevel makeCopy() {
        return null;
    }
    // NOT IMPLEMENTED
}
