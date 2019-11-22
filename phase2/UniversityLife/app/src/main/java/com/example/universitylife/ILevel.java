package com.example.universitylife;

public interface ILevel {
    interface ILevelView{
        void displayName(String name);
        void displayGPA(double gpa);
        void displayHP(double hp);
        void displayCredit(int credit);
    }
}
