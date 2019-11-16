package com.example.universitylife.Presenter;

import com.example.universitylife.Contract.IData;
import com.example.universitylife.Contract.IGameManager;
import com.example.universitylife.Contract.ILevel;
import com.example.universitylife.Model.GameManager;
import com.example.universitylife.Model.Student;

public abstract class LevelPresenter {
    GameManager gameManager;

    LevelPresenter(IData dataHandler, String username) {
        this.gameManager = new GameManager(dataHandler, username);
    }


    public void initDisplay(ILevel.ILevelView view){
        Student currStudent = gameManager.getCurrentStudent();
        view.displayName(currStudent.getName());
        updateDisplay(view);
    }

    public void updateDisplay(ILevel.ILevelView view){
        Student currStudent = gameManager.getCurrentStudent();
        view.displayCredit(currStudent.getCredit());
        view.displayGPA(currStudent.getGpa());
        view.displayHP(currStudent.getHp());
    }
}
