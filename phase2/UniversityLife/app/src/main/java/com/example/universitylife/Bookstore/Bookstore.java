package com.example.universitylife.Bookstore;

import com.example.universitylife.Student;

class Bookstore {
    private Student currentStudent;

    Bookstore(Student s){
        this.currentStudent = s;
    }

    boolean studentCanAfford (int price){
        return currentStudent.getGiftcards() >= price;
    }

    void buyItem(int itemIndex){
        currentStudent.addItem(itemIndex, 1);
        currentStudent.spendGiftcards(1);
    }

    int getStudentGiftcards(){
        return currentStudent.getGiftcards();
    }
}
