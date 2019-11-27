package com.example.universitylife.Bookstore;

import com.example.universitylife.Student.StudentFacade;

class Bookstore {
    private StudentFacade currentStudent;

    Bookstore(StudentFacade s) {
        this.currentStudent = s;
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
}
