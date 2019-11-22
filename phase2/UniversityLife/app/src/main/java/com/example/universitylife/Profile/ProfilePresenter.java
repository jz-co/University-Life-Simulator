package com.example.universitylife.Profile;

import com.example.universitylife.IData;
import com.example.universitylife.Profile.IProfile.*;
import com.example.universitylife.GameManager;

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
