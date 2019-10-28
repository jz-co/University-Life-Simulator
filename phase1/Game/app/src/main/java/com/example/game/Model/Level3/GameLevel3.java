package Model.Level3;

import Contract.ILevel3;
import Model.GameLevel;

public class GameLevel3 extends GameLevel {
    // NOT IMPLEMENTED
    private ILevel3.ILevel3Presenter presenter;

    GameLevel3(ILevel3.ILevel3Presenter presenter){
        this.presenter = presenter;
    }
}
