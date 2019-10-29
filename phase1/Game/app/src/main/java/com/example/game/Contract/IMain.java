package com.example.game.Contract;

public interface IMain {
    interface IMainView{
        /**
         * Display a warning message containing the given message.
         * @param message
         */
        void displayWarning(String message);

        /**
         * Return the username from the "username" text box.
         * @return
         */
        String getUsername();

        /**
         * Return the password from the "password" text box.
         * @return
         */
        String getPassword();

        /**
         * Go to the customization activity, and pass the IGameManager to the next page. (via intent)
         * @param gameManager
         */
        void goToCustomization(IGameManager gameManager);

        /**
         * Go to the Level 1 page, and pass the IGameManager to the next page. (via intent)
         * @param gameManager
         */
        void goToLevel1(IGameManager gameManager);

        /**
         * Go to the Level 2 page, pass the IGameManager to the next page. (via intent)
         * @param gameManager
         */
        void goToLevel2(IGameManager gameManager);

        /**
         * Go to the Level 3 Page, pass the IGameManager to the next page. (via intent)
         * @param gameManager
         */
        void goToLevel3(IGameManager gameManager);
    }

    interface IMainPresenter{
        /**
         * Make sure the input is valid, and tell the model to deal with the sign up.
         */
        void signUpBtnClicked();

        /**
         * Make sure the input is valid, and tell the model to deal with the log in.
         */
        void logInBtnClicked();
    }
}
