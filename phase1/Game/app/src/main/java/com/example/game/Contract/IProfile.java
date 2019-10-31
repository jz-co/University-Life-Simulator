package com.example.game.Contract;

public interface IProfile {
    interface IProfileView {
        public void logOut();
    }

    interface IProfilePresenter {
        String getName();
        String getGPA();
        String getCredits();

    }
}
