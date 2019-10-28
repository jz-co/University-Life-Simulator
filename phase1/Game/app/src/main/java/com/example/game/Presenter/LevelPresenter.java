package com.example.game.Presenter;

import com.example.game.Contract.ILevel;
import com.example.game.Model.GameManager;
import com.example.game.Model.Student;

public abstract class LevelPresenter {
    GameManager gameManager; // this has to be passed in somehow or made static!

    public void initDisplay(ILevel.ILevelView view){
        Student currStudent = gameManager.getCurrentStudent();
        view.displayName(currStudent.getPreferredName());
        view.displayProfilePic(currStudent.getProfilePic());
        updateDisplay(view);
    }

    public void updateDisplay(ILevel.ILevelView view){
        Student currStudent = gameManager.getCurrentStudent();
        view.displayCredit(currStudent.getCredit());
        view.displayGPA(currStudent.getGpa());
        view.displayHP(currStudent.getHp());
    }
}
