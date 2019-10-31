package com.example.game.Presenter;

import com.example.game.Contract.ICourseSelector;
import com.example.game.Contract.IData;
import com.example.game.Model.GameManager;

public class CourseSelectorPresenter {
    private ICourseSelector.ICourseSelectorView view;
    private GameManager gameManager;

    public CourseSelectorPresenter(ICourseSelector.ICourseSelectorView view, IData dataHandler, String username){
        this.view = view;
        gameManager = new GameManager(dataHandler, username);
    }

    public void validateLevel1(){
        view.goToLevel1(gameManager.getCurrentUsername());
    }

    public void validateLevel2(){
        if (gameManager.getCurrentLevel() >= 2){
            view.goToLevel2(gameManager.getCurrentUsername());
        } else {
            warning();
        }
    }

    public void validateLevel3(){
        if (gameManager.getCurrentLevel() >= 3){
            view.goToLevel3(gameManager.getCurrentUsername());
        } else{
            warning();
        }
    }

    public int getPicIndex () {
        return gameManager.getCurrentStudent().getAppearance();
    }

    private void warning(){
        view.displayWarning("You have not unlocked this level!");
    }

    public String getUsername() {
        return gameManager.getCurrentUsername();
    }

}
