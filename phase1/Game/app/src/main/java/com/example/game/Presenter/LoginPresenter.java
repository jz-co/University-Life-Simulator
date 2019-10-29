package com.example.game.Presenter;

import com.example.game.Contract.ILogin;
import com.example.game.Model.GameManager;
import com.example.game.Model.LogInManager;

public class LoginPresenter implements ILogin.ILoginPresenter {
    private ILogin.ILoginView view;
    private GameManager gameManager;
    private LogInManager logInManager;

    public LoginPresenter(ILogin.ILoginView view){
        this.view = view;
        this.gameManager = new GameManager();
        this.logInManager = new LogInManager(gameManager);
    }

    @Override
//    public void signUpBtnClicked() {
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
            view.navigateToCustomization();
        } else{
            sendWarning("Username already exists!");
        }
    }

    @Override
//    public void logInBtnClicked() {
    public void validateLogin(String username, String password) {
//        String username = view.getUsername();
        if (username.length()==0){
            sendWarning("Please enter a username");
            return;
        }
//        String password = view.getPassword();
        if (password.length()==0){
            sendWarning("Please enter a password");
            return;
        }
        boolean success = logInManager.logIn(username,password);
        if (success) {
//            int currLevel = gameManager.getCurrentLevel();
//            goToLevel(currLevel);
            view.navigateToCourseSelector();
        } else{
            sendWarning("Username doesn't exist or doesn't match password.");
        }
    }

    private void sendWarning(String message){
        view.displayWarning(message);
    }

//    private void goToLevel(int level){
//        if (level == 1){
//            view.goToLevel1();
//        } else if (level == 2){
//            view.goToLevel2();
//        } else if (level == 3){
//            view.goToLevel3();
//        }
//    }

}
