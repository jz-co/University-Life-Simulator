package com.example.universitylife.Contract;

public interface IResult {
    interface IResultView{
        void displayGrade(String grade);
        void displayLevel(String level);
        void displayCompletionMessage(String message);
    }
}
