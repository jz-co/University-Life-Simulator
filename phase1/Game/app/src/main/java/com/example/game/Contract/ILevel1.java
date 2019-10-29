package com.example.game.Contract;

public interface ILevel1 extends ILevel{
    interface ILevel1View extends ILevelView{
        void goToLevel2();
    }
    interface ILevel1Presenter{
        void goToNextLevel();
    }
}
