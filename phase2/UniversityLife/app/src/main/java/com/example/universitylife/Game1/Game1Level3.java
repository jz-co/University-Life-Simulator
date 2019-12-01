package com.example.universitylife.Game1;

import com.example.universitylife.Student.StudentFacade;

public class Game1Level3 extends Game1Level2 {
    public Game1Level3(StudentFacade student) {
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
