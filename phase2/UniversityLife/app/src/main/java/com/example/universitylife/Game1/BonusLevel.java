package com.example.universitylife.Game1;

import com.example.universitylife.Student.StudentFacade;

public class BonusLevel extends Level3 {
    public BonusLevel(StudentFacade student){
        super(student);
        setClearingScore(10);
    }
}
