package com.example.game.Model.Level3;

import com.example.game.Contract.ILevel3;
import com.example.game.Model.GameLevel;

public class GameLevel3 extends GameLevel {
    // NOT IMPLEMENTED
    private ILevel3.ILevel3Presenter presenter;

    public GameLevel3(){

    }

    public void setPresenter(ILevel3.ILevel3Presenter presenter){
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
