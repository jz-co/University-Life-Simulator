package Presenter;

import Contract.IMain;
import Model.GameManager;
import Model.LogInManager;

public class MainPresenter implements IMain.IMainPresenter {
    private IMain.IMainView view;
    private GameManager gameManager;
    private LogInManager logInManager;

    MainPresenter(IMain.IMainView view){
        this.view = view;
        this.gameManager = new GameManager();
        this.logInManager = new LogInManager(gameManager);
    }

    @Override
    public void signUpBtnClicked() {
        String username = view.getUsername();
        if (username.length()==0){
            sendWarning("Please enter a username");
            return;
        }
        String password = view.getPassword();
        if (password.length()==0){
            sendWarning("Please enter a password");
            return;
        }
        boolean success = logInManager.signUp(username, password);
        if (success){
            view.goToCustomization();
        } else{
            sendWarning("Username already exists!");
        }
    }

    @Override
    public void logInBtnClicked() {
        String username = view.getUsername();
        if (username.length()==0){
            sendWarning("Please enter a username");
            return;
        }
        String password = view.getPassword();
        if (password.length()==0){
            sendWarning("Please enter a password");
            return;
        }
        boolean success = logInManager.logIn(username,password);
        if (success) {
            int currLevel = gameManager.getCurrentLevel();
            goToLevel(currLevel);
        } else{
            sendWarning("Username doesn't exist or doesn't match password.");
        }
    }

    private void sendWarning(String message){
        view.displayWarning(message);
    }

    private void goToLevel(int level){
        if (level == 1){
            view.goToLevel1();
        } else if (level == 2){
            view.goToLevel2();
        } else if (level == 3){
            view.goToLevel3();
        }
    }

}
