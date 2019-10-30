package com.example.game.Presenter;

import com.example.game.Contract.IData;
import com.example.game.Contract.ILogin;
import com.example.game.Model.GameManager;
import com.example.game.Model.LogInManager;

public class LoginPresenter implements ILogin.ILoginPresenter {
    private ILogin.ILoginView view;
    private GameManager gameManager;
    private LogInManager logInManager;

    public LoginPresenter(ILogin.ILoginView view, IData.IDataSaver saver, IData.IDataLoader loader){
        this.view = view;
        this.gameManager = new GameManager(saver, loader);
        this.logInManager = new LogInManager(gameManager);
    }

    @Override
    public void validateSignUp(String username, String password) {
        if (username.length()==0){
            sendWarning("Please enter a username");
            return;
        }
        if (password.length()==0){
            sendWarning("Please enter a password");
            return;
        }
        boolean success = logInManager.signUp(username, password);
        if (success){
            view.navigateToCustomization(username);
        } else{
            sendWarning("Username already exists!");
        }
    }

    @Override
    public void validateLogin(String username, String password) {
        if (username.length()==0){
            sendWarning("Please enter a username");
            return;
        }
        if (password.length()==0){
            sendWarning("Please enter a password");
            return;
        }
        boolean success = logInManager.logIn(username,password);
        if (success) {
            view.navigateToCourseSelector(username);
        } else{
            sendWarning("Username doesn't exist or doesn't match password.");
        }
    }

    private void sendWarning(String message){
        view.displayWarning(message);
    }

    public void prepareToLeavePage(){
        gameManager.saveBeforeExit();
    }
}
