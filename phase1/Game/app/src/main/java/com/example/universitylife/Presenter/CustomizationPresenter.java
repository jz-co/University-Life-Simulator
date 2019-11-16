package com.example.universitylife.Presenter;

import com.example.universitylife.Contract.ICustomization;
import com.example.universitylife.Contract.IData;
import com.example.universitylife.Model.CustomizationManager;
import com.example.universitylife.Model.GameManager;

public class CustomizationPresenter implements ICustomization.ICustomizationPresenter {
    private ICustomization.ICustomizationView view;
    private CustomizationManager customizationManager;
    private GameManager gameManager;

    public CustomizationPresenter(ICustomization.ICustomizationView view, IData dataHandler, String username) {
        this.view = view;
        this.gameManager = new GameManager(dataHandler, username);
        this.customizationManager = new CustomizationManager(this.gameManager.getCurrentStudent());
    }


    /**
     * Customize the student, then go to the next page.
     */
    public void setCustomizations(String customName, int picIndex, String lang) {
        if (customName.length() == 0) {
            customName = gameManager.getCurrentStudent().getUsername();
        }
        if (lang.length() == 0) {
            lang = "English";
        }
        customizationManager.customize(picIndex, customName, lang);
        gameManager.saveBeforeExit();
        view.navigateToCourseSelector(gameManager.getCurrentUsername());
    }
}
