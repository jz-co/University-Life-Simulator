package com.example.universitylife.Game1;

import com.example.universitylife.Student.StudentFacade;

public class Level2 extends Level1 {
    private boolean hasCalculator;


    public Level2(StudentFacade student){
        super(student);
        setRandomNumberBoundary(25);
    }
}
