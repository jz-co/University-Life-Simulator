package com.example.universitylife.Game3;

import com.example.universitylife.ILevel;

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
