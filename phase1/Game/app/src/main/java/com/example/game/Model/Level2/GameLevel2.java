package com.example.game.Model.Level2;

import com.example.game.Contract.ILevel2;
import com.example.game.Model.GameLevel;

public class GameLevel2 extends GameLevel {
    // NOT IMPLEMENTED
    private ILevel2.ILevel2Presenter presenter;
    public GameLevel2(){

    }

    public void setPresenter(ILevel2.ILevel2Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void progressGameResults() {

    }

    @Override
    public GameLevel makeCopy() {
        return null;
    }
}
