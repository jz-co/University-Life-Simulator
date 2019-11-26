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

    void buyCalculator(int n){
        currentStudent.addItem(1, n);
        currentStudent.spendGiftcards(n);
    }

    void buyUmbrella(int n){
        currentStudent.addItem(2,n);
        currentStudent.spendGiftcards(n);
    }

    void buyLv3Booster(int n){
        currentStudent.addItem(3,n);
        currentStudent.spendGiftcards(n);
    }
}
