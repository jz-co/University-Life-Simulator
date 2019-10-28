package com.example.game.Contract;

public interface IMain {
    public interface IMainView{
        public void displayWarning(String message);
        public String getUsername();
        public String getPassword();
        public void goToCustomization();
        public void goToLevel1();
        public void goToLevel2();
        public void goToLevel3();
    }

    public interface IMainPresenter{
        public void signUpBtnClicked();
        public void logInBtnClicked();
    }
}
