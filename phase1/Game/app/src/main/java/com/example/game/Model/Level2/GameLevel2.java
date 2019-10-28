package Model.Level2;

import Contract.ILevel2;
import Model.GameLevel;

public class GameLevel2 extends GameLevel {
    // NOT IMPLEMENTED
    private ILevel2.ILevel2Presenter presenter;

    GameLevel2(ILevel2.ILevel2Presenter presenter){
        this.presenter = presenter;
    }
}
