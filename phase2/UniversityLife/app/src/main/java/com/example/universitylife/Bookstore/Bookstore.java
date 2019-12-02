package com.example.universitylife.Bookstore;

import com.example.universitylife.Student.StudentFacade;

import java.util.List;

class Bookstore {
    private StudentFacade currentStudent;
    private List<BonusItem> bonusItemList;

    Bookstore(StudentFacade s) {
        this.currentStudent = s;
        BonusItemsBuilder builder = new BonusItemsBuilder();
        builder.buildBonusItemsList();
        bonusItemList = builder.getBonusItemsList();
    }

    /**
     * Returns whether or not the current student has one or more gift cards.
     */
    boolean studentHasGiftcards() {
        return currentStudent.hasGiftcards();
    }

    /**
     * Allow the bonus item with id itemIndex to be bought.
     */
    void buyItem(int itemIndex){
        currentStudent.addItem(itemIndex);
        currentStudent.spendGiftcard();
    }

    /**
     * Return the number of gift cards that this student has.
     */
    int getStudentGiftcards(){
        return currentStudent.getGiftcards();
    }

    /**
     * Return a list of bonus items that are available for purchase.
     */
    List<BonusItem> getBonusItemList() {
        return bonusItemList;
    }
}
