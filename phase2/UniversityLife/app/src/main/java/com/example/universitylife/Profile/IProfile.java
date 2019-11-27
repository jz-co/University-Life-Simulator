package com.example.universitylife.Profile;

public interface IProfile {
    interface IProfileView {
        void logOut();
        void displayErrorMessage();

    }

    interface IProfilePresenter {
        String getName();
        String getGPA();
        String getCredits();
        String getMoney();

        void validateGraduation();

    }
}
