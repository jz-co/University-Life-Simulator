package com.example.universitylife.Result;

import com.example.universitylife.GameManager;

class ResultPresenter {

    private int game;
    private String username;
    private GameManager gameManager;

    ResultPresenter(int game, String username) {
        gameManager = new GameManager(username);
        this.game = game;
    }

    String getFinalGPA() {
        // TODO: Ensure this returns the final/most recent GPA of this course/game
        return Double.toString(gameManager.getGpa());
    }
}
