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

    boolean studentHasGiftcards() {
        return currentStudent.hasGiftcards();
    }

    void buyItem(int itemIndex){
        currentStudent.addItem(itemIndex);
        currentStudent.spendGiftcard();
    }

    int getStudentGiftcards(){
        return currentStudent.getGiftcards();
    }

    List<BonusItem> getBonusItemList() {
        return bonusItemList;
    }
}
