package com.example.universitylife.Result;

class ResultPresenterFactory {

    ResultPresenter createResultPresenter(String presenterType, ResultActivity view, String username) {
        if (presenterType.equalsIgnoreCase("GAME1")) {
            return new Game1ResultPresenter(view, dataHandler, username);
        } else if (presenterType.equalsIgnoreCase("GAME2")) {
            return new Game2ResultPresenter(view, dataHandler, username);
        } else if (presenterType.equalsIgnoreCase("GAME3")) {
            return new Game3ResultPresenter(view, dataHandler, username);
        } else {
            return null;
        }
    }
}
