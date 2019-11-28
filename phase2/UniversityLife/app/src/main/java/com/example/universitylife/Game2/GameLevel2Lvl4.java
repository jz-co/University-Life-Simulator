package com.example.universitylife.Game2;

import com.example.universitylife.Student.StudentFacade;

import java.util.ArrayList;

 class GameLevel2Lvl4 extends GameLevel2Lvl3{
     GameLevel2Lvl4(StudentFacade student, Basket basket, int FrameWidth, int FrameHeight, ArrayList<FallingObject> fallingObjects, ILevel2.ILevel2PresenterLvl3 presenter) {
        super(student, basket, FrameWidth, FrameHeight, fallingObjects, presenter);
    }
}
