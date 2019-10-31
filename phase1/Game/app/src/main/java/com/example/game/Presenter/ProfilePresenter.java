package com.example.game.Presenter;

import com.example.game.Contract.IData;
import com.example.game.Contract.IProfile.*;
import com.example.game.Model.GameManager;

public class ProfilePresenter implements IProfilePresenter {

    private IProfileView view;
    private GameManager gameManager;

    /**
     * Constructor for ProfilePresenter.
     */
    public ProfilePresenter(IProfileView view, IData.IDataSaver saver,
                            IData.IDataLoader loader, String username) {

        this.view = view;
        gameManager = new GameManager(saver, loader, username);

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
