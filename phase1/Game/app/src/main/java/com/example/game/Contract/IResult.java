package com.example.game.Contract;

public interface IResult {
    interface IResultView{
        void displayGrade(String grade);
        void displayLevel(int level);
        void displayCompletionMessage(String message);
    }
    interface IResultPresenter{
//        void againBtnClicked();
//        void nextBtnClicked();
    }
}
