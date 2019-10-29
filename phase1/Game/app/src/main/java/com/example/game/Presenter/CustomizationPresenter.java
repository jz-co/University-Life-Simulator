package com.example.game.Presenter;

import com.example.game.Contract.ICustomization;
import com.example.game.Contract.IGameManager;
import com.example.game.Model.CustomizationManager;
import com.example.game.Model.GameManager;

public class CustomizationPresenter implements ICustomization.ICustomizationPresenter {
    private ICustomization.ICustomizationView view;
    private CustomizationManager manager;
    private GameManager gameManager;

    public CustomizationPresenter(ICustomization.ICustomizationView view, IGameManager gameManager){
        this.view = view;
        this.gameManager = (GameManager) gameManager;
        this.manager = new CustomizationManager(this.gameManager.getCurrentStudent());
    }


    /**
     * Go to the previous picture, if there is a previous picture.
     */
    @Override
    public void leftBtnClicked() {
        if (view.getPictureIndex() > 1){
            view.previousPicture();
        }
    }


    /**
     * Go to the next picture, if there is a next picture.
     */
    @Override
    public void rightBtnClicked() {
        if (view.getPictureIndex() < manager.getNumberOfPictures()){
            view.nextPicture();
        }
    }

    /**
     * Customize the student, then go to the next page.
     */
    @Override
    public void confirmBtnClicked() {
        int picIndex = view.getPictureIndex();
        String name = view.getName();
        if (name.length()==0){
            name = gameManager.getCurrentStudent().getUsername();
        }
        String lang = view.getLang();
        if (lang.length()==0){
            lang = "English";
        }
        manager.customize(picIndex, name, lang);
        view.goToLevel1(this.gameManager);
    }
}
