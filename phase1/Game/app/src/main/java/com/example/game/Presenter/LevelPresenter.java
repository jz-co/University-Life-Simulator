package Presenter;

import Contract.ILevel;
import Model.GameManager;
import Model.Student;

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
