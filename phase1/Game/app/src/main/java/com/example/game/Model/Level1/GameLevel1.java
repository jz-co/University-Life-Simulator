package Model.Level1;

import Contract.ILevel1;
import Model.GameLevel;

public class GameLevel1 extends GameLevel {
    private ILevel1.ILevel1Presenter presenter;
    GameLevel1(ILevel1.ILevel1Presenter presenter){
        this.presenter = presenter;
    }
    // NOT IMPLEMENTED
}
