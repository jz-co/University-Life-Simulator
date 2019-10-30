package com.example.game.Presenter;

import com.example.game.Contract.ICourseSelector;
import com.example.game.Contract.IData;
import com.example.game.Model.GameManager;

public class CourseSelectorPresenter {
    private ICourseSelector.ICourseSelectorView view;
    private GameManager gameManager;

    CourseSelectorPresenter(ICourseSelector.ICourseSelectorView view, IData.IDataSaver saver,
                            IData.IDataLoader loader, String username){
        this.view = view;
        gameManager = new GameManager(saver, loader, username);
    }

    public void level1Clicked(){
        view.goToLevel1(gameManager.getCurrentUsername());
    }

    public void level2Clicked(){
        if (gameManager.getCurrentLevel() >= 2){
            view.goToLevel2(gameManager.getCurrentUsername());
        } else{
            warning();
        }
    }

    public void level3Clicked(){
        if (gameManager.getCurrentLevel() >= 3){
            view.goToLevel3(gameManager.getCurrentUsername());
        } else{
            warning();
        }
    }

    private void warning(){
        view.displayWarning("You have not unlocked this level!");
    }

}
