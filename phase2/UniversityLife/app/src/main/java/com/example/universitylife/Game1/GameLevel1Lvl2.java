package com.example.universitylife.Game1;

import com.example.universitylife.Student.StudentFacade;

public class GameLevel1Lvl2 extends GameLevel1Lvl1{
    private boolean hasCalculator;


    public GameLevel1Lvl2(StudentFacade student){
        super(student);
        setRandomNumberBoundary(25);
    }
}
