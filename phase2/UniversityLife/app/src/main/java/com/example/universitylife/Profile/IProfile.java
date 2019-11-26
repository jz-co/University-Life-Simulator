package com.example.universitylife.Profile;

public interface IProfile {
    interface IProfileView {
        public void logOut();
    }

    interface IProfilePresenter {
        String getName();
        String getGPA();
        String getCredits();
        String getMoney();

        void validateGraduation();

    }
}
