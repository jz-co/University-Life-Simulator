package com.example.universitylife.Game1;

import com.example.universitylife.Student.StudentFacade;

public class Game1BonusLevel extends Game1Level3 {
    public Game1BonusLevel(StudentFacade student) {
        super(student);
        setClearingScore(10);
        setRandomNumberBoundary(5);
    }

    @Override
    /**
     * Awards the student giftcards for completing the bonus level. The number of giftcards is
     * determined by the number of extra points they receive in the game. Passing the bonus level
     * earns you 5 giftcards and each additional point earns you 1 giftcard.
     */
    public void levelPass() {
        StudentFacade student = getStudent();
        int numGiftCards = (getTotalScore() - getClearingScore()) + 5;
        student.registerLevelResults(1, 1, numGiftCards);
        //if (student.getCurrentLevel() <= 1) {
        //    student.incrementLevel();
        //}
    }
}
