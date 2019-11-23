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

    }

    void buyUmbrella(int n){

    }

    void buyLv3Booster(int n){

    }
}
