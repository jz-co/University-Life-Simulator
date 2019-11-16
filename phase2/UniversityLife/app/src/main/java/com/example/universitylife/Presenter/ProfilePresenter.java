package com.example.universitylife.Presenter;

import com.example.universitylife.Contract.IData;
import com.example.universitylife.Contract.IProfile.*;
import com.example.universitylife.Model.GameManager;

public class ProfilePresenter implements IProfilePresenter {

    private IProfileView view;
    private GameManager gameManager;

    /**
     * Constructor for ProfilePresenter.
     */
    public ProfilePresenter(IProfileView view, IData dataHandler, String username) {

        this.view = view;
        gameManager = new GameManager(dataHandler, username);

    }

    @Override
    public String getName() {
        return gameManager.getCurrentStudent().getName();
    }

    @Override
    public String getGPA() {
        return String.valueOf(gameManager.getCurrentStudent().getGpa());
    }

    @Override
    public String getCredits() {
        return String.valueOf(gameManager.getCurrentStudent().getCredit());
    }

    public int getPicIndex() {
        return gameManager.getCurrentStudent().getAppearance();
    }

}
