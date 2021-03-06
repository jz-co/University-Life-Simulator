package com.example.universitylife.Presenter;

import com.example.universitylife.Contract.IData;
import com.example.universitylife.Contract.ILogin;
import com.example.universitylife.Model.GameManager;
import com.example.universitylife.Model.LogInManager;

public class LoginPresenter implements ILogin.ILoginPresenter {
    private ILogin.ILoginView view;
    private GameManager gameManager;
    private LogInManager logInManager;

    public LoginPresenter(ILogin.ILoginView view, IData dataHandler) {
        this.view = view;
        this.gameManager = new GameManager(dataHandler);
        this.logInManager = new LogInManager(gameManager);
    }


    /**
     * Validates whether "username" and "password" are valid entries for signing up.
     */
    @Override
    public void validateSignUp(String username, String password) {
        if (username.length() == 0) {
            sendWarning("Please enter a username");
            return;
        }
        if (password.length() == 0) {
            sendWarning("Please enter a password");
            return;
        }
        boolean success = logInManager.signUp(username, password);
        if (success) {
            prepareToLeavePage();
            view.navigateToCustomization(username);
        } else {
            sendWarning("Username already exists!");
        }
    }

    /**
     * Validates whether "username" and "password" are valid entries for logging in.
     */
    @Override
    public void validateLogin(String username, String password) {
        if (username.length() == 0) {
            sendWarning("Please enter a username");
            return;
        }
        if (password.length() == 0) {
            sendWarning("Please enter a password");
            return;
        }
        boolean success = logInManager.logIn(username, password);
        if (success) {
            prepareToLeavePage();
            view.navigateToCourseSelector(username);
        } else {
            sendWarning("Username doesn't exist or doesn't match password.");
        }
    }

    /**
     * Instruct that "message" be displayed.
     */
    private void sendWarning(String message) {
        view.displayWarning(message);
    }

    private void prepareToLeavePage() {
        gameManager.saveBeforeExit();
    }
}
