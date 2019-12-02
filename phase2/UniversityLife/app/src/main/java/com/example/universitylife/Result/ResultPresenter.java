package com.example.universitylife.Result;

import com.example.universitylife.GameManager;
import com.example.universitylife.DataHandler.IData;

class ResultPresenter {

    private int game;
    private String username;
    private GameManager gameManager;

    ResultPresenter(int game, String username, IData dataHandler) {
        gameManager = new GameManager(username, dataHandler);
        this.game = game;
    }

    String getFinalGPA(int course) {
        return Double.toString(gameManager.getCourseGpa(course));
    }
}
