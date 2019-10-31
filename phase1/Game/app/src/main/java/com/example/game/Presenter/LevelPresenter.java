package com.example.game.Presenter;

import com.example.game.Contract.IData;
import com.example.game.Contract.IGameManager;
import com.example.game.Contract.ILevel;
import com.example.game.Model.GameManager;
import com.example.game.Model.Student;

public abstract class LevelPresenter {
    GameManager gameManager;

    public LevelPresenter(IData dataHandler ,String username){
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
