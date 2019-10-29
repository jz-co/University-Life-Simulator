package com.example.game.Contract;


public interface ILevel2 extends ILevel {
    interface ILevel2View extends ILevelView{
        void goToLevel3();
    }
    interface ILevel2Presenter{
        void goToNextLevel();
    }
}
