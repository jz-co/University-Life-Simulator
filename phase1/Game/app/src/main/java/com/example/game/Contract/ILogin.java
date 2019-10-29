package com.example.game.Contract;

public interface ILogin {
    interface ILoginView {
        public void displayWarning(String message);
//        public String getUsername();
//        public String getPassword();
        public void navigateToCustomization();
        public void navigateToCourseSelector();
//        public void goToLevel1();
//        public void goToLevel2();
//        public void goToLevel3();
    }

    interface ILoginPresenter {
//        public void signUpBtnClicked();
//        public void logInBtnClicked();
        public void validateSignUp(String username, String password);
        public void validateLogin(String username, String password);
    }
}
