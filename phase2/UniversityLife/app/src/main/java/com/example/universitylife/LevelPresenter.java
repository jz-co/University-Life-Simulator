package com.example.universitylife;


import com.example.universitylife.Student.StudentFacade;

public abstract class LevelPresenter {
    public GameManager gameManager;

    public LevelPresenter(IData dataHandler, String username) {
        this.gameManager = new GameManager(dataHandler, username);
    }


    public void initDisplay(ILevel.ILevelView view){
        StudentFacade currStudent = gameManager.getCurrentStudent();
        view.displayName(currStudent.getName());
        updateDisplay(view);
    }

    public void updateDisplay(ILevel.ILevelView view){
        StudentFacade currStudent = gameManager.getCurrentStudent();
        view.displayScore(currStudent.getGpa());
    }
}
