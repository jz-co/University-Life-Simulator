package com.example.game.Contract;

public interface IResult {
    interface IResultView{
        void displayGrade(String grade);
        void displayLevel(int level);
    }
    interface IResultPresenter{
        void againBtnClicked();
        void nextBtnClicked();
    }
}
