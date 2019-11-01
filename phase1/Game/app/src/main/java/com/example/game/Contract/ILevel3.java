package com.example.game.Contract;

public interface ILevel3 extends ILevel {
    interface ILevel3View extends ILevelView{

    }
    interface ILevel3Presenter{

    }
    interface ILevel3GameView{
        int getWheelWidth();
        int getWheelHeight();
    }
}
