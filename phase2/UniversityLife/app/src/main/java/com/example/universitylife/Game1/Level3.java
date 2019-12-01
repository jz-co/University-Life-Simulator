package com.example.universitylife.Game1;

import com.example.universitylife.Student.StudentFacade;

public class Level3 extends Level2 {
    public Level3(StudentFacade student) {
        super(student);
        setClearingScore(8);
        setRandomNumberBoundary(50);
    }

    /**
     * Calculates the total score with negative marking for Level 3 and 4
     *
     * @return total score after accounting for negative marking
     */
    public int calculateScore() {
        return getNumCorrectAnswers() - getNumIncorrectAnswers();
    }
}
