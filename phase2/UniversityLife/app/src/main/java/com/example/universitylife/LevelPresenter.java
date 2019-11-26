package com.example.universitylife;


public abstract class LevelPresenter {
    public GameManager gameManager;

    public LevelPresenter(IData dataHandler, String username) {
        this.gameManager = new GameManager(dataHandler, username);
    }


    public void initDisplay(ILevel.ILevelView view){
        StudentOld currStudent = gameManager.getCurrentStudent();
        view.displayName(currStudent.getName());
        updateDisplay(view);
    }

    public void updateDisplay(ILevel.ILevelView view){
        StudentOld currStudent = gameManager.getCurrentStudent();
        view.displayCredit(currStudent.getCredit());
        view.displayGPA(currStudent.getGpa());
        view.displayHP(currStudent.getHp());
    }
}
