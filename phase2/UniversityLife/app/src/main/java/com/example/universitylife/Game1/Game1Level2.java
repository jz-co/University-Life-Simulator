package com.example.universitylife.Game1;

import com.example.universitylife.Student.StudentFacade;

public class Game1Level2 extends Game1Level1 {
    //private boolean hasCalculator;


    Game1Level2(StudentFacade student) {
        super(student);
        setRandomNumberBoundary(25);
    }

    /**
     * Determines if a student has a calculator in their bag
     *
     * @return a boolean of whether the student has a calculator or not
     */
    boolean hasCalculator() {
        if (getStudent().getItem(1) > 0) {
            getStudent().useItem(1);
            return true;
        } else {
            return false;
        }
    }

    public void levelPass() {
        double points = calculateLevelGpaScore(1);
        getStudent().registerLevelResults(1, 2, points);
    }
}
